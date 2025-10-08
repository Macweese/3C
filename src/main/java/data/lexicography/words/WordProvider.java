/*
 *
 *     Copyright (C) 2025 Macweese <https://www.github.com/Macweese>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package data.lexicography.words;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 * @Created 15/09/2025, 12:00 Mon 15 September 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class WordProvider
{

	private final List<WordSource> sources;
	private final List<Word> allWords;
	private final Map<WordType, List<Word>> byType;
	private final Map<String, List<Word>> byLowercase; // could have multiple words differing by types
	private final EnumMap<Attribute, List<Word>> byAttribute;

	private WordProvider(List<WordSource> sources)
	{
		this.sources = List.copyOf(sources);
		this.allWords = sources.stream().flatMap(WordSource::stream).distinct().toList();

		// Index by types
		Map<WordType, List<Word>> tmpType = new EnumMap<>(WordType.class);
		Map<Attribute, List<Word>> tmpAttr = new EnumMap<>(Attribute.class);
		Map<String, List<Word>> tmpLower = new HashMap<>();

		for (Word w : allWords)
		{
			for (WordType wt : w.typesAsArray())
			{
				tmpType.computeIfAbsent(wt, k -> new ArrayList<>()).add(w);
			}
			tmpAttr.computeIfAbsent(w.attribute(), k -> new ArrayList<>()).add(w);
			tmpLower.computeIfAbsent(w.word().toLowerCase(Locale.ROOT), k -> new ArrayList<>()).add(w);
		}
		tmpType.replaceAll((k, v) -> List.copyOf(v));
		tmpAttr.replaceAll((k, v) -> List.copyOf(v));
		tmpLower.replaceAll((k, v) -> List.copyOf(v));

		this.byType = Collections.unmodifiableMap(tmpType);
		this.byAttribute = new EnumMap<>(tmpAttr);
		this.byLowercase = Collections.unmodifiableMap(tmpLower);
	}

	public static Builder builder()
	{
		return new Builder();
	}

	public int size()
	{
		return allWords.size();
	}

	public List<Word> allWords()
	{
		return allWords;
	}

	public List<Word> wordsOfTypes(Set<WordType> types)
	{
		if (types.isEmpty() || types.contains(WordType.ANY))
		{
			return allWords;
		}
		return types.stream().flatMap(t -> byType.getOrDefault(t, List.of()).stream()).distinct().collect(Collectors.toList());
	}

	public List<Word> wordsOfTypes(WordType... types)
	{
		return wordsOfTypes(new HashSet<>(List.of(types)));
	}

	public Optional<List<Word>> findAllVariants(String text)
	{
		if (text == null)
		{
			return Optional.empty();
		}
		return Optional.ofNullable(byLowercase.get(text.toLowerCase(Locale.ROOT)));
	}

	public Optional<Word> findFirst(String text)
	{
		return findAllVariants(text).flatMap(list -> list.stream().findFirst());
	}

	public WordQuery query()
	{
		return new WordQuery(this);
	}

	public static final class Builder
	{
		private final List<WordSource> sources = new ArrayList<>();

		public Builder addSource(WordSource source)
		{
			Objects.requireNonNull(source);
			sources.add(source);
			return this;
		}

		public WordProvider build()
		{
			if (sources.isEmpty())
			{
				throw new IllegalStateException("At least one WordSource required");
			}
			return new WordProvider(sources);
		}
	}

	public static final class WordQuery
	{
		private final WordProvider provider;
		private final Set<WordType> types = EnumSet.noneOf(WordType.class);
		private final EnumSet<Attribute> attributes = EnumSet.noneOf(Attribute.class);

		private String startsWith;
		private String endsWith;
		private Predicate<Word> predicate = w -> true;
		private boolean randomOrder = false;
		private Long seed;
		private String regex;
		private Integer limit;
		private Integer minLength;
		private Integer maxLength;

		private WordQuery(WordProvider provider)
		{
			this.provider = provider;
		}

		public WordQuery types(WordType... t)
		{
			types.addAll(Arrays.asList(t));
			return this;
		}

		public WordQuery attributes(Attribute... attrs)
		{
			attributes.addAll(Arrays.asList(attrs));
			return this;
		}

		public WordQuery startsWith(String prefix)
		{
			this.startsWith = (prefix == null || prefix.isBlank()) ? null : prefix.toLowerCase(Locale.ROOT);
			return this;
		}

		public WordQuery endsWith(String suffix)
		{
			this.endsWith = (suffix == null || suffix.isBlank()) ? null : suffix.toLowerCase(Locale.ROOT);
			return this;
		}

		public WordQuery lengthBetween(int min, int max)
		{
			this.minLength = min;
			this.maxLength = max;
			return this;
		}

		public WordQuery regex(String regex)
		{
			this.regex = regex;
			return this;
		}

		public WordQuery predicate(Predicate<Word> extra)
		{
			this.predicate = this.predicate.and(extra);
			return this;
		}

		public WordQuery random()
		{
			this.randomOrder = true;
			return this;
		}

		public WordQuery seed(long seed)
		{
			this.seed = seed;
			return this;
		}

		public WordQuery limit(int limit)
		{
			if (limit <= 0)
			{
				throw new IllegalArgumentException("limit must be > 0");
			}
			this.limit = limit;
			return this;
		}

		public List<Word> list()
		{
			Stream<Word> stream = baseStream();
			if (randomOrder && limit != null)
			{
				return reservoirSample(stream, limit, rng());
			}
			else
			{
				List<Word> collected = stream.collect(Collectors.toList());
				if (randomOrder)
				{
					Collections.shuffle(collected, rng());
				}
				if (limit != null && collected.size() > limit)
				{
					return collected.subList(0, limit);
				}
				return collected;
			}
		}

		public List<Word> list(int limit)
		{
			return limit(limit).list();
		}

		public Optional<Word> any()
		{
			limit(1);
			List<Word> l = list();
			return l.isEmpty() ? Optional.empty() : Optional.of(l.getFirst());
		}

		public String get()
		{
			limit(1);
			List<Word> l = list();
			Optional<Word> word = l.isEmpty() ? Optional.empty() : Optional.of(l.getFirst());
			if (word.isEmpty())
			{
				return "";
			}
			return word.get().word();
		}

		public Stream<Word> stream()
		{
			if (randomOrder)
			{
				return list().stream();
			}
			return baseStream().limit(limit == null ? Long.MAX_VALUE : limit);
		}

		private Stream<Word> baseStream()
		{
			List<Word> base = provider.wordsOfTypes(types);
			Stream<Word> s = base.stream();
			if (!attributes.isEmpty())
			{
				s = s.filter(w -> attributes.contains(w.attribute()) || attributes.contains(Attribute.ANY));
			}
			if (startsWith != null)
			{
				s = s.filter(w -> w.word().toLowerCase(Locale.ROOT).startsWith(startsWith));
			}
			if (endsWith != null)
			{
				s = s.filter(w -> w.word().toLowerCase(Locale.ROOT).endsWith(endsWith));
			}
			if (regex != null)
			{
				s = s.filter(w -> w.word().matches(regex));
			}
			if (minLength != null)
			{
				s = s.filter(w -> w.length() >= minLength);
			}
			if (maxLength != null)
			{
				s = s.filter(w -> w.length() <= maxLength);
			}
			s = s.filter(predicate);
			return s;
		}

		private Random rng()
		{
			if (seed != null)
			{
				return new Random(seed);
			}
			return new Random()
			{
				final ThreadLocalRandom tlr = ThreadLocalRandom.current();

				@Override
				public int nextInt(int bound)
				{
					return tlr.nextInt(bound);
				}
			};
		}

		private List<Word> reservoirSample(Stream<Word> stream, int k, RandomGenerator rng)
		{
			List<Word> reservoir = new ArrayList<>(k);
			Iterator<Word> it = stream.iterator();
			int i = 0;
			while (it.hasNext())
			{
				Word w = it.next();
				i++;
				if (reservoir.size() < k)
				{
					reservoir.add(w);
				}
				else
				{
					int r = rng.nextInt(i);
					if (r < k)
					{
						reservoir.set(r, w);
					}
				}
			}
			return reservoir;
		}
	}
}
