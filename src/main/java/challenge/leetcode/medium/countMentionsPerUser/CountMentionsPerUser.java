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

package challenge.leetcode.medium.countMentionsPerUser;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Administrator
 * @Created 06:17 Fri 12 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class CountMentionsPerUser
{
	private static int[] userMentions;
	private static int[] userStatus;

	private static final String EVENT_TYPE_MESSAGE = "MESSAGE";
	private static final String EVENT_TYPE_OFFLINE = "OFFLINE";

	enum Mention
	{
		ALL,
		HERE,
		ID,
	}

	private static Mention getMention(String usersMentioner)
	{
		return switch (usersMentioner.toLowerCase())
		{
			case "all" -> Mention.ALL;
			case "here" -> Mention.HERE;
			default -> Mention.ID;
		};
	}

	public static int[] countMentions(int numbersOfUsers, List<List<String>> events)
	{
		userMentions = new int[numbersOfUsers];
		userStatus = new int[numbersOfUsers];

		events.sort(Comparator
			.comparingInt((List<String> e) -> Integer.parseInt(e.get(1)))
			.thenComparing(e -> e.getFirst().equals(EVENT_TYPE_MESSAGE))
		);

		for (List<String> event : events)
		{
			if (event.getFirst().equalsIgnoreCase(EVENT_TYPE_MESSAGE))
			{
				messageHandler(event);
			}
			if (event.getFirst().equalsIgnoreCase(EVENT_TYPE_OFFLINE))
			{
				int user = Integer.parseInt(event.getLast());
				int timestamp = Integer.parseInt(event.get(1));
				userStatus[user] = timestamp + 60;
			}
		}

		return userMentions;
	}

	private static void messageHandler(List<String> event)
	{
		int[] users = null;
		int timestamp = Integer.parseInt(event.get(1));
		Mention mention = getMention(event.getLast().toLowerCase());

		if (mention == Mention.ID)
		{
			users = Arrays.stream(event.getLast()
					.split("\\D"))
				.filter(s -> !s.isBlank())
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		incrementMentionForUsers(mention, timestamp, users);
	}

	private static void incrementMentionForUsers(Mention mention, int timestamp, int[] users)
	{
		if (mention == Mention.ALL)
		{
			for (int user = 0; user < userMentions.length; user++)
			{
				userMentions[user] += 1;
			}
		}

		if (mention == Mention.HERE)
		{
			for (int user = 0; user < userMentions.length; user++)
			{
				userMentions[user] += userStatus[user] <= timestamp ? 1 : 0;
			}
		}

		if (mention == Mention.ID)
		{
			if (users == null)
			{
				return;
			}

			for (int user : users)
			{
				userMentions[user] += 1;
			}
		}
	}
}
