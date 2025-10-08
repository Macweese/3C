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

package challenge.medium.vowelsGameInAString;

/**
 * @author Administrator
 * @Created 12/09/2025, 12:39 Fri 12 September 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 3227
 * @Name Vowels Game in a String
 * @Difficulty Medium
 * @Tags math
 * string
 * brainteaser
 * game theory
 * weekly contest 407
 * @link <a href="https://leetcode.com/problems/vowels-game-in-a-string/">www.leetcode.com/3227</a>
 * @Description Alice and Bob are playing a game on a string.<br>
 * <br>
 * You are given a string <code>s</code>,
 * Alice and Bob will take turns playing the following game where Alice starts <b>first</b>:
 * <ul>
 * 		<li>On Alice's turn, she has to remove any <b>non-empty substring</b>
 * 			from <code>s</code> that contains an <b>odd</b> number of vowels.</li>
 * 		<li>On Bob's turn, he has to remove any <b>non-empty substring</b>
 * 			from <code>s</code> that contains an <b>even</b> number of vowels.</li>
 * </ul>
 * The first player who cannot make a move on their turn loses the game. We assume that both Alice and Bob play <b>optimally</b>.<br>
 * <br>
 * Return <code>true</code> if Alice wins the game, and <code>false</code> otherwise.<br>
 * <br>
 * The English vowels are: <code>a</code>, <code>e</code>, <code>i</code>, <code>o</code>, and <code>u</code>.
 *
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>s = "leetcoder"</code>
 * 			<br><b>Output:</b> {@code true}
 * 			<br><b>Explanation:</b> Alice can win the game as follows:
 * 				<br>&emsp; Alice plays first,
 * 					she can delete the underlined substring in <code>s = "<b><u>leetco</u></b>der"</code>
 * 					which contains 3 vowels.
 * 					The resulting string is <code>s = "der"</code>.
 * 				<br>&emsp; Bob plays second,
 * 					he can delete the underlined substring in <code>s = "<u><b>d</b></u>er"</code> or <code>s = "de<u><b>r</b></u>"</code>
 * 					which contains 0 vowels. The resulting string is <code>s = "er"</code> or <code>s = "de"</code>.
 * 				<br>&emsp; Alice plays third,
 * 					she can delete the whole string <code>s = "<u><b>er</b></u>"</code> or <code>s = "<u><b>de</b></u>"</code> which contains 1 vowel.
 * 				<br>&emsp; Bob plays fourth,
 * 					since the string is empty, there is no valid play for Bob.
 * 					So Alice wins the game.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>s = "bbcd"</code>
 * 			<br><b>Output:</b> {@code false}
 * 			<br><b>Explanation:</b> There is no valid play for Alice in her first turn, so Alice loses the game.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li>1 &le; s.length &le; 10<sup>5</sup></li>
 * 		<li><code>s</code> consists only of lowercase English letters.</li>
 * </ul>
 * </p>
 *
 * <br>
 * <hr>
 * @Similar <br>
 **/
public class VowelsGameInAString
{
	private static final String[] strings = new String[]{"a", "aboriginal", "absorption", "accept", "accessories", "accordance", "accurately", "acids", "acres", "actively", "ad", "added", "adds", "admin", "adolescent", "advancement", "advertiser", "adware", "affiliate", "afternoon", "agents", "agricultural", "aircraft", "ala", "albuquerque", "algorithms", "allan", "allowing", "also", "aluminum", "amber", "americans", "amy", "analyze", "andrew", "animal", "annotated", "another", "antibodies", "anymore", "apartments", "appear", "applicants", "appreciate", "approximate", "arabia", "archive", "argued", "armor", "arrest", "article", "ascii", "asn", "assessing", "assistant", "assuming", "ata", "atmosphere", "attempt", "attorney", "auction", "aus", "authorized", "autumn", "avoid", "awful", "bachelor", "badge", "balanced", "band", "banned", "bargain", "based", "basketball", "battery", "be", "beastality", "become", "been", "behavior", "beliefs", "below", "benjamin", "bestiality", "beverly", "bid", "billing", "biographies", "birthday", "black", "blanket", "blocks", "bloomberg", "bo", "bold", "boob", "boom", "borough", "boulder", "boxed", "brad", "bras", "breaks", "bride", "bringing", "broadcasting", "brooklyn", "bruce", "bubble", "bug", "bulgarian", "buried", "bush", "buttons", "byte", "cached", "calculation", "called", "camel", "campus", "candidate", "capabilities", "car", "careful", "carol", "cars", "casey", "cat", "catholic", "cb", "celebrate", "census", "ceo", "cf", "challenge", "chan", "chaos", "charge", "charlotte", "cheaper", "cheese", "chest", "childhood", "choices", "christianity", "chubby", "cindy", "circumstances", "city", "claire", "classification", "clear", "clients", "clock", "cloth", "cms", "coast", "coffee", "collaborative", "collection", "colonial", "columnists", "come", "commands", "commit", "commonwealth", "company", "compensation", "compiler", "compliance", "composition", "computer", "concerned", "condition", "conferences", "confirm", "conjunction", "conscious", "considerable", "consists", "constitutes", "consultants", "contained", "context", "contract", "contributions", "convenience", "converter", "cool", "cop", "cord", "corporation", "corresponding", "cottages", "counties", "courage", "covering", "crafts", "creating", "crest", "critics", "crude", "cuba", "cumulative", "cursor", "customs", "cycling", "daisy", "dana", "darkness", "dating", "db", "dealers", "deborah", "decimal", "decorative", "default", "defined", "delayed", "delivers", "democrat", "denmark", "departure", "dept", "describes", "designers", "destination", "detection", "deutschland", "develops", "di", "diana", "died", "differential", "dildos", "directed", "dis", "discipline", "discovered", "discussions", "dispatched", "distances", "district", "diving", "dns", "documentcreatetextnode", "dollar", "donald", "door", "dow", "dp", "draw", "drew", "drives", "dry", "duck", "duration", "dying", "earlier", "ease", "ebony", "economics", "edit", "edt", "effectively", "egypt", "election", "element", "elizabeth", "embassy", "emotional", "employers", "encoding", "ended", "eng", "english", "enormous", "enter", "entitled", "enzyme", "equal", "era", "escort", "est", "estonia", "eur", "evaluation", "every", "exact", "exams", "excessive", "exclusively", "exercises", "exit", "expects", "experiment", "explaining", "export", "extending", "extraordinary", "fabrics", "factor", "fair", "fame", "faqs", "fast", "favorite", "fda", "fed", "feels", "ferrari", "fiber", "fighters", "fill", "finally", "findlaw", "finland", "firms", "fitness", "flag", "flex", "flooring", "flowers", "fo", "folding", "foods", "forces", "forgot", "formerly", "forwarding", "founder", "framed", "fraser", "freight", "friendly", "fruits", "full", "funded", "furniture", "g", "gallery", "gaps", "gasoline", "gazette", "gel", "generating", "geneva", "geographical", "gets", "gif", "gives", "globe", "gnu", "golf", "got", "governments", "grades", "grande", "grass", "greece", "grew", "groundwater", "gst", "guess", "guilty", "gym", "haiti", "hampshire", "handled", "happened", "harder", "harrison", "hats", "hazards", "headline", "heard", "heaven", "hell", "hentai", "hero", "higher", "hill", "hiring", "hiv", "holding", "holmes", "honda", "hope", "horrible", "hostels", "hours", "however", "hu", "humanity", "hunt", "hydrogen", "ice", "ideas", "ids", "illinois", "imaging", "imperial", "importantly", "improvement", "inches", "income", "incredible", "indian", "indices", "induction", "infectious", "informative", "initiatives", "innovation", "insert", "inspired", "institute", "instrumental", "integrated", "intensity", "interesting", "internet", "interview", "introduction", "investigator", "invite", "ip", "irish", "islands", "issues", "its", "jackets", "james", "javascript", "jeffrey", "jet", "jm", "johnston", "jordan", "joy", "judicial", "junction", "juvenile", "kathy", "keith", "kept", "kick", "kim", "kissing", "knights", "ko", "kyle", "labs", "lamb", "landscapes", "largely", "later", "laugh", "laws", "lc", "league", "leaves", "legal", "lemon", "leone", "letter", "lexus", "librarian", "lie", "lights", "limitation", "lined", "lips", "lit", "lived", "llp", "loc", "locking", "logistics", "longer", "loose", "lottery", "lovely", "lt", "lunch", "ma", "made", "magnet", "mailto", "major", "male", "manager", "manual", "mapping", "margin", "mark", "married", "mas", "masturbation", "mathematical", "maui", "mc", "meanwhile", "mechanisms", "medicines", "mega", "memorial", "menu", "merger", "meta", "methods", "mh", "micro", "mighty", "milfs", "mime", "minimize", "minority", "miss", "mit", "mls", "modelling", "modified", "mom", "monica", "montgomery", "morgan", "most", "motorcycle", "mouth", "mozilla", "msgid", "multimedia", "museum", "muze", "mysql", "named", "nascar", "native", "navigator", "nearest", "needle", "neo", "networking", "newer", "newton", "nice", "nights", "nj", "nominated", "normally", "not", "notifications", "november", "nude", "nursery", "ny", "obituaries", "observed", "occasions", "oclc", "offensive", "officially", "ok", "olympus", "onion", "opened", "operations", "opposition", "or", "ordinary", "organizations", "original", "ottawa", "outer", "oval", "owned", "pa", "packets", "paintball", "palestinian", "panties", "paradise", "parents", "partially", "parties", "pass", "passwords", "pathology", "pavilion", "pb", "peace", "penalties", "penny", "percentage", "perfume", "permission", "personalized", "pete", "ph", "phentermine", "phones", "phpbb", "piano", "pictures", "pilot", "piss", "pl", "planes", "plastic", "player", "pleasure", "pm", "poems", "polar", "polls", "poor", "porno", "portraits", "positive", "postcards", "potential", "power", "practice", "preceding", "preference", "premium", "present", "press", "previews", "prime", "printers", "privilege", "proc", "processor", "productions", "profit", "prohibited", "promising", "proof", "proposed", "protected", "proudly", "province", "psychiatry", "publicly", "pulling", "purchases", "pushed", "qatar", "qualities", "queen", "quick", "quotes", "radar", "rain", "ranch", "rankings", "rated", "raymond", "reaction", "realistic", "reasonable", "receipt", "receptors", "recommendations", "recover", "reduce", "reference", "reflect", "refurbished", "region", "regulated", "related", "relaxation", "religion", "remains", "remote", "renewable", "repeated", "reported", "represented", "republicans", "requiring", "reserves", "resolutions", "respiratory", "rest", "result", "retention", "returns", "reverse", "reward", "rica", "rider", "ringtones", "rj", "robertson", "rod", "rom", "roommates", "rotation", "routine", "rpm", "rugs", "rush", "sa", "sage", "sale", "same", "sandy", "sat", "savage", "says", "scary", "scheme", "scientific", "scott", "screw", "seafood", "seasonal", "secretariat", "security", "seemed", "selections", "seminar", "senior", "sep", "serbia", "service", "settlement", "sexuality", "shake", "shared", "shed", "shepherd", "ships", "shoppercom", "shorts", "shown", "siemens", "significance", "silver", "simulation", "singles", "situated", "skiing", "skype", "slightly", "slut", "smoke", "so", "sodium", "soldiers", "soma", "son", "sorted", "south", "spain", "speaker", "specially", "specifies", "spencer", "spirit", "sponsorship", "spring", "squirt", "stadium", "standard", "start", "states", "statute", "steam", "steven", "stockings", "storage", "strange", "strength", "string", "structural", "studies", "stylish", "submission", "subsequent", "succeed", "sue", "suggestions", "summaries", "super", "supplier", "supreme", "surgery", "surveillance", "suspended", "swedish", "switching", "sync", "system", "tackle", "taking", "tampa", "targets", "taylor", "teaches", "techno", "teeth", "telling", "ten", "termination", "terrorists", "text", "thai", "theatre", "theorem", "thereof", "think", "thongs", "threaded", "through", "thumbs", "tied", "tim", "tion", "title", "today", "tom", "tons", "topic", "touched", "tower", "trace", "trade", "trail", "trance", "transferred", "transmission", "travel", "treasurer", "trek", "tribe", "trinidad", "trouble", "trustee", "tube", "tuning", "turtle", "twinks", "typically", "ultimate", "uncle", "undertaken", "unions", "university", "until", "updating", "upskirts", "usa", "users", "utilities", "vacation", "valley", "vanilla", "vary", "vector", "vendors", "verified", "very", "viagra", "vid", "viewing", "vintage", "virtual", "visiting", "vocals", "volume", "voting", "w", "wales", "walls", "war", "warrant", "washington", "watt", "we", "webcast", "wedding", "weights", "went", "wheat", "whilst", "wicked", "wild", "wind", "winning", "wise", "witnesses", "wonder", "work", "workshops", "worse", "wrapped", "written", "wy", "xp", "yards", "yen", "you", "yukon", "zoloft", "zus"};

	public static void main(String[] args)
	{
		for (String s : strings)
		{
			System.out.printf("MAP.put(\"%s\",%s);%n", s, doesAliceWin(s));
		}
	}

	public static boolean doesAliceWin(String s)
	{
		for (int i = 0; i < s.length(); ++i)
		{
			if (isVowel(s.charAt(i)))
			{
				return true;
			}
		}
		return false;
	}

	private static boolean isVowel(char c)
	{
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}
