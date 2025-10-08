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
package challenge.easy.findWordsContainingCharacter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 24/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Difficulty
 * @Tags
 * @link
 * @Description
 **/
class FindWordsContainingCharacterTest
{
	private static final List<Triple<String[], Character, List<Integer>>> T = new ArrayList<>();

	static
	{
		T.add(new ImmutableTriple<>(new String[]{"leet", "code"}, 'e', List.of(0, 1)));
		T.add(new ImmutableTriple<>(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'a', List.of(0, 2)));
		T.add(new ImmutableTriple<>(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'z', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"grandmother"}, 's', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"taste", "offer"}, 'm', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"grandfather", "possess"}, 'e', List.of(0, 1)));
		T.add(new ImmutableTriple<>(new String[]{"abhorrent", "chase", "rural"}, 'n', List.of(0)));
		T.add(new ImmutableTriple<>(new String[]{"hum", "moon", "snotty", "hall"}, 's', List.of(2)));
		T.add(new ImmutableTriple<>(new String[]{"handsome", "rightful", "crabby", "hot"}, 'f', List.of(1)));
		T.add(new ImmutableTriple<>(new String[]{"coherent", "dream", "judicious", "boat"}, 'd', List.of(1, 2)));
		T.add(new ImmutableTriple<>(new String[]{"protest", "war", "fantastic", "freezing"}, 'i', List.of(2, 3)));
		T.add(new ImmutableTriple<>(new String[]{"blue", "belief", "spiteful", "one", "amount"}, 'd', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"tree", "ladybug", "spoon", "promise", "sofa"}, 'm', List.of(3)));
		T.add(new ImmutableTriple<>(new String[]{"rake", "colorful", "kiss", "humor", "witty"}, 'o', List.of(1, 3)));
		T.add(new ImmutableTriple<>(new String[]{"continue", "jazzy", "boiling", "possess", "night", "ritzy"}, 'u', List.of(0)));
		T.add(new ImmutableTriple<>(new String[]{"nest", "motionless", "cap", "drag", "mute", "sign", "mom", "butter", "haunt"}, 'k', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"grain", "pretend", "adjustment", "history", "ancient", "attend", "jog", "road"}, 'k', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"elated", "possible", "labored", "live", "vast", "boil", "alleged", "fetch", "pipe"}, 'k', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"rhyme", "cruel", "cast", "ugly", "sturdy", "kneel", "icicle", "coherent", "consist"}, 'd', List.of(4)));
		T.add(new ImmutableTriple<>(new String[]{"wheel", "loving", "lumber", "curvy", "rain", "poised", "experience", "harm", "fear"}, 'g', List.of(1)));
		T.add(new ImmutableTriple<>(new String[]{"sigh", "addition", "distribution", "sable", "note", "damage", "rhyme", "mysterious"}, 'u', List.of(2, 7)));
		T.add(new ImmutableTriple<>(new String[]{"boat", "smiling", "wound", "trick", "mice", "oranges", "whispering", "verdant", "real"}, 'w', List.of(2, 6)));
		T.add(new ImmutableTriple<>(new String[]{"fine", "spiders", "milk", "birth", "blue", "guitar", "acceptable", "support", "coherent"}, 't', List.of(3, 5, 6, 7, 8)));
		T.add(new ImmutableTriple<>(new String[]{"luxuriant", "courageous", "weigh", "illegal", "resolute", "thirsty", "sweet", "giant", "continue"}, 'v', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"curtain", "nifty", "afford", "current", "wrench", "next", "exercise", "wave", "jittery", "applaud", "lock"}, 'g', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"creature", "driving", "bucket", "fuzzy", "damp", "fall", "jolly", "invite", "direction", "sophisticated"}, 'k', List.of(2)));
		T.add(new ImmutableTriple<>(new String[]{"addition", "rifle", "meat", "testy", "shallow", "protective", "scared", "exclusive", "overrated", "cry"}, 'o', List.of(0, 4, 5, 8)));
		T.add(new ImmutableTriple<>(new String[]{"sore", "stare", "jumbled", "birth", "unsightly", "responsible", "paper", "tickle", "blood", "summer", "horse"}, 'u', List.of(2, 4, 9)));
		T.add(new ImmutableTriple<>(new String[]{"questionable", "whispering", "two", "badge", "tacky", "bore", "berry", "chivalrous", "instrument", "shrill", "exercise"}, 's', List.of(0, 1, 7, 8, 9, 10)));
		T.add(new ImmutableTriple<>(new String[]{"development", "elfin", "throne", "fact", "rice", "comparison", "willing", "chase", "cagey", "peep", "sleet", "radiate", "piquant", "crazy"}, 'b', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"rambunctious", "wretched", "resonant", "manage", "railway", "tickle", "paper", "horrible", "fax", "thread", "heal", "aunt", "gaudy", "kaput"}, 'q', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"hop", "stupendous", "company", "cough", "squeal", "haunt", "reduce", "thunder", "flash", "jumpy", "nutty", "request", "rain", "highfalutin"}, 'q', List.of(4, 11)));
		T.add(new ImmutableTriple<>(new String[]{"mom", "wealth", "rambunctious", "comparison", "righteous", "waves", "trucks", "word", "trade", "writer", "thirsty", "fine", "request"}, 'a', List.of(1, 2, 3, 5, 8)));
		T.add(new ImmutableTriple<>(new String[]{"hall", "skinny", "hammer", "bead", "wary", "crook", "wrench", "awake", "tired", "cheer", "string", "snore", "holistic", "past", "tremble"}, 'i', List.of(1, 8, 10, 12)));
		T.add(new ImmutableTriple<>(new String[]{"increase", "vengeful", "industry", "caring", "superb", "afford", "uncovered", "grade", "tug", "exclusive", "sign", "elfin", "boat", "freezing"}, 's', List.of(0, 2, 4, 9, 10)));
		T.add(new ImmutableTriple<>(new String[]{"plantation", "lunchroom", "worried", "mushy", "moon", "excuse", "underwear", "obsequious", "digestion", "theory", "bath", "telephone", "scattered"}, 'i', List.of(0, 2, 7, 8)));
		T.add(new ImmutableTriple<>(new String[]{"common", "accidental", "curved", "mom", "hands", "faithful", "entertain", "rainstorm", "sun", "willing", "giddy", "cracker", "grateful", "dazzling", "rainy"}, 'b', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"fuzzy", "direful", "analyze", "ritzy", "explain", "supply", "oafish", "silly", "scream", "dynamic", "peaceful", "perpetual", "adjustment", "authority"}, 'r', List.of(1, 3, 8, 11, 13)));
		T.add(new ImmutableTriple<>(new String[]{"sophisticated", "work", "peaceful", "tart", "nut", "tense", "disagreeable", "famous", "harm", "aboard", "giddy", "pot", "sky", "shut", "sign", "obtainable", "adjustment"}, 'h', List.of(0, 8, 13)));
		T.add(new ImmutableTriple<>(new String[]{"bag", "marble", "behavior", "sail", "flesh", "giddy", "wide", "snow", "allow", "gabby", "queue", "fang", "reproduce", "oranges", "imperfect", "naughty", "tart", "calendar", "week"}, 'k', List.of(18)));
		T.add(new ImmutableTriple<>(new String[]{"stove", "flash", "tie", "wonder", "quill", "avoid", "holiday", "cruel", "avoid", "sofa", "nice", "squash", "subtract", "giddy", "prickly", "chop", "subtract", "cheer", "parsimonious"}, 'g', List.of(13)));
		T.add(new ImmutableTriple<>(new String[]{"pest", "winter", "disgusted", "men", "switch", "lock", "butter", "tremendous", "whirl", "rain", "judicious", "land", "curtain", "horse", "fertile", "hot", "itchy", "courageous", "glass"}, 'm', List.of(3, 7)));
		T.add(new ImmutableTriple<>(new String[]{"macabre", "eyes", "request", "reply", "crack", "existence", "prefer", "juvenile", "obtainable", "petite", "next", "fire", "harm", "cowardly", "spiteful", "precious", "eatable"}, 'a', List.of(0, 4, 8, 12, 13, 16)));
		T.add(new ImmutableTriple<>(new String[]{"potato", "red", "overrated", "soup", "wary", "gray", "petite", "children", "fuzzy", "nifty", "connect", "chop", "hook", "tie", "humorous", "desk", "view", "carriage", "perpetual"}, 'i', List.of(6, 7, 9, 13, 16, 17)));
		T.add(new ImmutableTriple<>(new String[]{"quill", "gaze", "fang", "disapprove", "relieved", "self", "thing", "enter", "explain", "parallel", "handsome", "glove", "unusual", "caption", "bells", "hands", "curtain"}, 'n', List.of(2, 6, 7, 8, 10, 12, 13, 15, 16)));
		T.add(new ImmutableTriple<>(new String[]{"ludicrous", "harbor", "boil", "aunt", "concern", "action", "elbow", "wriggle", "haircut", "chop", "enchanting", "pets", "amount", "disappear", "boiling", "vacation", "mysterious", "tricky"}, 's', List.of(0, 11, 13, 16)));
		T.add(new ImmutableTriple<>(new String[]{"heat", "brown", "chunky", "answer", "industry", "breakable", "night", "can", "roof", "reduce", "nutty", "reproduce", "rest", "weak", "hook", "lowly", "nice", "exclusive", "cemetery", "slap"}, 't', List.of(0, 4, 6, 10, 12, 18)));
		T.add(new ImmutableTriple<>(new String[]{"scream", "influence", "tidy", "eyes", "racial", "macabre", "cold", "bucket", "aboard", "consist", "seashore", "inconclusive", "vessel", "ring", "scientific", "ring", "taste", "blood", "preserve", "front", "whine"}, 'p', List.of(18)));
		T.add(new ImmutableTriple<>(new String[]{"nifty", "male", "juice", "cracker", "flowers", "number", "jobless", "sweet", "rob", "boat", "frame", "few", "bucket", "embarrassed", "tremble", "plastic", "vivacious", "tacky", "troubled", "accessible"}, 'a', List.of(1, 3, 9, 10, 13, 15, 16, 17, 19)));
		T.add(new ImmutableTriple<>(new String[]{"ultra", "acoustics", "freezing", "range", "reduce", "actually", "stew", "night", "songs", "road", "breathe", "tree", "desk", "fire", "flash", "numberless", "disgusted", "abnormal", "helpless", "crazy", "steady", "second", "coherent"}, 'f', List.of(2, 13, 14)));
		T.add(new ImmutableTriple<>(new String[]{"thing", "check", "useless", "reproduce", "riddle", "plot", "tremble", "lock", "mom", "front", "flashy", "ignore", "clam", "flower", "risk", "quack", "night", "distribution", "jobless", "questionable", "earthy", "voracious", "heartbreaking"}, 'g', List.of(0, 11, 16, 22)));
		T.add(new ImmutableTriple<>(new String[]{"prevent", "knot", "foolish", "bucket", "compete", "sigh", "visitor", "famous", "giddy", "mean", "sisters", "manage", "macabre", "effect", "juggle", "unique", "battle", "peel", "hollow", "thankful", "ski", "fetch", "mice", "freezing", "tin"}, 'm', List.of(4, 7, 9, 11, 12, 22)));
		T.add(new ImmutableTriple<>(new String[]{"nerve", "authority", "cagey", "lush", "allow", "gruesome", "nut", "driving", "underwear", "flesh", "detect", "mouth", "amusing", "guttural", "automatic", "contain", "grade", "giant", "sigh", "point", "dark", "film", "stingy", "aberrant", "pricey"}, 'h', List.of(1, 3, 9, 11, 18)));
		T.add(new ImmutableTriple<>(new String[]{"bait", "lighten", "north", "honorable", "various", "juice", "weigh", "responsible", "stingy", "mushy", "afternoon", "tree", "communicate", "giants", "shoes", "rifle", "frightening", "coherent", "dry", "fasten", "waggish", "ink", "knit", "proud", "request"}, 'm', List.of(9, 12)));
		T.add(new ImmutableTriple<>(new String[]{"gaudy", "applaud", "dime", "stare", "humdrum", "wretched", "butter", "charge", "interrupt", "reflect", "clam", "closed", "brake", "appliance", "continue", "grease", "zoo", "alarm", "nine", "preserve", "steadfast", "obsequious", "frighten"}, 'r', List.of(3, 4, 5, 6, 7, 8, 9, 12, 15, 17, 19, 22)));
		T.add(new ImmutableTriple<>(new String[]{"unwritten", "statuesque", "face", "rabbits", "functional", "talk", "try", "month", "sad", "regret", "annoying", "stain", "adjustment", "gullible", "immense", "jobless", "wheel", "market", "lush", "uppity", "moan", "flavor", "bleach", "meat", "discreet", "prefer", "word", "violet"}, 'p', List.of(19, 25)));
		T.add(new ImmutableTriple<>(new String[]{"precious", "stroke", "ludicrous", "manage", "living", "kill", "wealthy", "wrench", "cowardly", "mysterious", "curl", "parcel", "wave", "luxuriant", "mountainous", "political", "functional", "month", "collect", "elbow", "cactus", "teeth", "treatment", "mailbox", "humorous", "view"}, 'd', List.of(2, 8)));
		T.add(new ImmutableTriple<>(new String[]{"riddle", "limit", "quilt", "pull", "cow", "moldy", "night", "tender", "stimulating", "obscene", "enchanting", "unsightly", "squeamish", "trees", "occur", "talk", "bikes", "tidy", "found", "guitar", "glossy", "apparatus", "oceanic", "geese", "brown", "gaudy", "moldy"}, 'a', List.of(8, 10, 12, 15, 19, 21, 22, 25)));
		T.add(new ImmutableTriple<>(new String[]{"utter", "shelter", "heal", "cold", "hall", "hammer", "few", "mate", "wanting", "discover", "guard", "ski", "chickens", "yell", "dizzy", "hose", "guard", "sparkling", "curvy", "sail", "cast", "treatment", "try", "basket", "coherent", "stimulating", "quilt", "park", "pies", "event", "tall", "crowded", "unequal"}, 'j', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"face", "motionless", "group", "night", "parsimonious", "highfalutin", "ground", "desk", "adorable", "fantastic", "calendar", "frame", "humdrum", "alleged", "kill", "protective", "bells", "outstanding", "park", "colour", "pour", "throne", "thaw", "annoy", "seashore", "note", "vessel", "nation"}, 'h', List.of(3, 5, 12, 21, 22, 24)));
		T.add(new ImmutableTriple<>(new String[]{"silly", "lettuce", "cobweb", "substance", "loving", "handsomely", "meddle", "reply", "rabid", "trees", "chew", "vacation", "hateful", "guide", "mouth", "disagreeable", "action", "blood", "friendly", "price", "question", "company", "fear", "peep", "domineering", "statement", "slim"}, 'o', List.of(2, 4, 5, 11, 14, 16, 17, 20, 21, 24)));
		T.add(new ImmutableTriple<>(new String[]{"juggle", "thirsty", "afford", "sweater", "obscene", "stay", "harm", "ubiquitous", "jumpy", "caption", "grumpy", "tickle", "forgetful", "chunky", "racial", "funny", "lick", "ground", "spurious", "babies", "ablaze", "hose", "nutty", "regret", "testy", "living", "wilderness", "berry", "death", "superb", "egg", "second"}, 'q', List.of(7)));
		T.add(new ImmutableTriple<>(new String[]{"necessary", "fine", "stream", "murky", "delirious", "afternoon", "chickens", "charge", "earthy", "snakes", "amusement", "majestic", "lonely", "wrong", "curtain", "freezing", "famous", "found", "grumpy", "grandfather", "sturdy", "applaud", "action", "holistic", "serious", "discussion", "curl", "cagey", "relieved"}, 'j', List.of(11)));
		T.add(new ImmutableTriple<>(new String[]{"measure", "opposite", "hose", "question", "regret", "lock", "flashy", "wriggle", "tail", "mute", "illegal", "jittery", "jog", "elated", "telephone", "loud", "somber", "aboard", "press", "current", "squeamish", "protect", "grateful", "horse", "fowl", "sore", "pie", "friendly", "milk", "scientific", "nut", "parallel"}, 'w', List.of(7, 24)));
		T.add(new ImmutableTriple<>(new String[]{"reading", "gruesome", "chubby", "promise", "value", "peaceful", "boat", "discreet", "brown", "witty", "talented", "aboard", "juggle", "cactus", "rightful", "grateful", "curved", "growth", "parsimonious", "acceptable", "thunder", "steer", "geese", "digestion", "dirty", "place", "answer", "miss"}, 'a', List.of(0, 4, 5, 6, 10, 11, 13, 15, 18, 19, 25, 26)));
		T.add(new ImmutableTriple<>(new String[]{"butter", "wing", "lying", "seashore", "bag", "spectacular", "annoy", "flavor", "explain", "tug", "helpless", "stare", "leather", "upset", "dizzy", "uncovered", "curvy", "taste", "eager", "soup", "pest", "gabby", "cast", "flat", "zoom", "cold", "tease", "help", "disgusting", "damage", "paper", "fax", "stain", "merciful", "boil", "want"}, 'x', List.of(8, 31)));
		T.add(new ImmutableTriple<>(new String[]{"toad", "settle", "crowded", "maddening", "obtainable", "lie", "slim", "tranquil", "wise", "concern", "lick", "growth", "horse", "file", "playground", "answer", "marked", "vacation", "afford", "oranges", "value", "trouble", "limit", "determined", "fit", "abnormal", "aquatic", "illegal", "verdant"}, 'r', List.of(2, 7, 9, 11, 12, 14, 15, 16, 18, 19, 21, 23, 25, 28)));
		T.add(new ImmutableTriple<>(new String[]{"nut", "suspect", "protect", "wrench", "wing", "acquiescence", "rough", "pour", "bizarre", "curved", "trot", "scared", "caring", "curvy", "carry", "marble", "bless", "farm", "male", "explain", "pointless", "caring", "ahead", "butter", "tire", "grade", "plot", "peel", "ludicrous", "exultant", "riddle", "compete", "grandfather", "attack", "dashing"}, 'q', List.of(5)));
		T.add(new ImmutableTriple<>(new String[]{"tomatoes", "mouth", "detect", "flower", "toothpaste", "current", "month", "wretched", "night", "delirious", "jolly", "confess", "eager", "aquatic", "lush", "daughter", "hook", "tidy", "hammer", "lazy", "oceanic", "shrill", "eager", "stitch", "apparatus", "sordid", "quixotic", "dirt", "nervous", "wrong", "dizzy"}, 'e', List.of(0, 2, 3, 4, 5, 7, 9, 11, 12, 15, 18, 20, 22, 28)));
		T.add(new ImmutableTriple<>(new String[]{"resonant", "delightful", "bucket", "male", "colorful", "disgusting", "behave", "practice", "elfin", "impress", "wealth", "stitch", "snakes", "oranges", "invention", "pastoral", "resonant", "second", "try", "cynical", "curvy", "page", "wary", "crack", "haunt", "oceanic", "vessel", "fallacious", "fall", "harass", "famous", "hobbies"}, 'h', List.of(1, 6, 10, 11, 24, 29, 31)));
		T.add(new ImmutableTriple<>(new String[]{"suspect", "handsome", "promise", "cheer", "tired", "rare", "holiday", "answer", "caption", "seashore", "string", "industry", "abusive", "billowy", "drag", "steer", "substance", "profit", "tenuous", "death", "ubiquitous", "quicksand", "imported", "bag", "rambunctious", "wealth", "adjustment", "upset", "famous"}, 't', List.of(0, 4, 8, 10, 11, 15, 16, 17, 18, 19, 20, 22, 24, 25, 26, 27)));
		T.add(new ImmutableTriple<>(new String[]{"toad", "trucks", "boundary", "drag", "wide", "lick", "fetch", "abnormal", "effect", "drag", "depend", "tricky", "shame", "complex", "sense", "reply", "exciting", "aboard", "note", "tickle", "guess", "calendar", "meat", "fearless", "wind", "didactic", "stem", "potato", "fang", "scintillating", "cough", "little", "shut", "sense", "maddening", "charge"}, 'r', List.of(1, 2, 3, 7, 9, 11, 15, 17, 21, 23, 35)));
		T.add(new ImmutableTriple<>(new String[]{"steer", "correct", "quilt", "wretched", "rare", "driving", "awful", "adjustment", "sea", "float", "addition", "superb", "children", "impress", "dark", "plastic", "responsible", "toad", "growth", "precious", "null", "icy", "scare", "plastic", "oafish", "concerned", "taste", "sky", "rough", "mountainous", "wealth", "decorate", "governor", "nutty", "jumpy"}, 'l', List.of(2, 6, 9, 12, 15, 16, 20, 23, 30)));
		T.add(new ImmutableTriple<>(new String[]{"steadfast", "expert", "physical", "humorous", "witty", "fallacious", "disgusting", "superb", "temporary", "modern", "top", "giants", "jumbled", "stew", "statuesque", "mitten", "tease", "tired", "unlock", "crazy", "accessible", "badge", "rabbits", "shame", "flood", "basketball", "freezing", "judge", "madly", "mom", "conscious", "basket", "effect", "occur", "strong", "dazzling"}, 'x', List.of(1)));
		T.add(new ImmutableTriple<>(new String[]{"deceive", "cloudy", "influence", "day", "kitty", "inconclusive", "helpless", "disappear", "unique", "jolly", "found", "look", "bead", "moon", "jittery", "honorable", "miss", "godly", "protect", "funny", "tiny", "sink", "curtain", "petite", "steel", "thunder", "unwritten", "plot", "marble", "stingy", "glass", "hose", "toad", "grateful", "ground", "bite", "somber", "grateful"}, 'c', List.of(0, 1, 2, 5, 18, 22)));
		T.add(new ImmutableTriple<>(new String[]{"nervous", "exclusive", "cover", "dime", "tiny", "feigned", "fax", "rush", "lighten", "aboard", "pies", "pull", "spade", "tacit", "profuse", "grumpy", "scientific", "glove", "lettuce", "agreeable", "glib", "utter", "luxuriant", "gray", "profuse", "allow", "true", "belief", "answer", "manage", "aboard", "mailbox", "little", "sun", "necessary", "road"}, 'a', List.of(6, 9, 12, 13, 19, 22, 23, 25, 28, 29, 30, 31, 34, 35)));
		T.add(new ImmutableTriple<>(new String[]{"tiresome", "authority", "drag", "talented", "grate", "elated", "dashing", "apparatus", "bizarre", "wave", "sneaky", "downtown", "calendar", "strong", "gabby", "protect", "desk", "harm", "chop", "famous", "rightful", "colour", "shut", "momentous", "rice", "mute", "soft", "writer", "resolute", "promise", "breathe", "nutty", "rainy", "chivalrous", "birth"}, 'e', List.of(0, 3, 4, 5, 8, 9, 10, 12, 15, 16, 23, 24, 25, 27, 28, 29, 30)));
		T.add(new ImmutableTriple<>(new String[]{"depend", "concerned", "profuse", "aloof", "effect", "peep", "wealth", "expert", "songs", "closed", "imperfect", "utter", "press", "salt", "little", "part", "grate", "stop", "dark", "cut", "stupendous", "bait", "close", "toothpaste", "mountainous", "enthusiastic", "cemetery", "grumpy", "stem", "caption", "knowing", "month", "useless", "edge", "yell", "cable", "basket", "seashore", "colour", "flowery", "omniscient"}, 'x', List.of(7)));
		T.add(new ImmutableTriple<>(new String[]{"jelly", "giddy", "strong", "harsh", "sun", "event", "prefer", "authority", "lock", "respect", "godly", "squash", "sidewalk", "vague", "collect", "practice", "eager", "cry", "peep", "adorable", "smile", "stitch", "bizarre", "trick", "attend", "creator", "metal", "serious", "ubiquitous", "tart", "basin", "cover", "aboard", "wandering", "hospitable", "answer", "fuzzy", "fruit", "selective", "nerve", "pest"}, 'd', List.of(1, 10, 12, 19, 24, 32, 33)));
		T.add(new ImmutableTriple<>(new String[]{"necessary", "offer", "shrill", "correct", "request", "uncovered", "wary", "boil", "colorful", "value", "ritzy", "radiate", "male", "sidewalk", "dusty", "curtain", "ski", "practice", "nimble", "wing", "canvas", "scare", "hospitable", "soft", "walk", "toothpaste", "abandoned", "living", "jumbled", "lazy", "winter", "rough", "juvenile", "whine", "cute", "grandfather", "guitar", "tiny", "connect", "charge", "sun", "funny", "lethal"}, 'm', List.of(12, 18, 28)));
		T.add(new ImmutableTriple<>(new String[]{"obtain", "stove", "tenuous", "dance", "fascinated", "object", "hum", "basin", "theory", "playground", "grease", "squeamish", "frightening", "jaded", "honorable", "gun", "whip", "try", "grandfather", "excellent", "front", "mysterious", "island", "womanly", "dream", "tow", "ritzy", "haircut", "geese", "sturdy", "dream", "tense", "mate", "rare", "fact", "piquant", "page", "kitty"}, 't', List.of(0, 1, 2, 4, 5, 8, 12, 17, 18, 19, 20, 21, 25, 26, 27, 29, 31, 32, 34, 35, 37)));
		T.add(new ImmutableTriple<>(new String[]{"night", "wandering", "fine", "gun", "basin", "macabre", "vast", "stain", "jazzy", "wave", "damage", "comparison", "gaudy", "cheer", "wax", "tremble", "verdant", "invincible", "harm", "tow", "roof", "shock", "butter", "lamentable", "impress", "oceanic", "compete", "ambiguous", "pot", "frightening", "ski", "jumbled", "woozy", "foot", "uttermost", "kill", "collect", "nutty", "ignore", "return", "actually", "lick", "guitar", "fax", "boundary"}, 'k', List.of(21, 30, 35, 41)));
		T.add(new ImmutableTriple<>(new String[]{"dark", "faint", "horrible", "coherent", "awful", "waves", "one", "lie", "contain", "bikes", "scattered", "amusing", "political", "request", "north", "moldy", "breathe", "tug", "actually", "frighten", "spoon", "tenuous", "arithmetic", "tow", "sense", "peep", "vessel", "upset", "harsh", "parallel", "sun", "fasten", "leather", "imperfect", "heap", "judicious", "sick", "hobbies", "kneel", "plants", "stuff", "development", "group", "playground"}, 'k', List.of(0, 9, 36, 38)));
		T.add(new ImmutableTriple<>(new String[]{"horse", "possess", "hum", "talk", "day", "red", "stay", "gaze", "shallow", "queue", "aback", "dirt", "apparel", "continue", "assorted", "accessible", "obsequious", "spade", "obtainable", "pushy", "found", "dime", "ambiguous", "annoying", "bore", "add", "badge", "harm", "tender", "fireman", "stiff", "bleach", "visitor", "shame", "chunky", "murky", "underwear", "average", "offer", "unusual", "occur", "giant", "concerned", "actually", "touch", "meeting", "save"}, 'j', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"aromatic", "battle", "abstracted", "can", "snotty", "flap", "hall", "dazzling", "license", "tall", "rainy", "parallel", "dashing", "crowded", "spectacular", "skillful", "found", "exciting", "march", "sisters", "driving", "forgetful", "muddled", "existence", "teeth", "radiate", "imperfect", "tank", "scattered", "jumpy", "car", "basin", "axiomatic", "stay", "writer", "train", "imperfect", "bucket", "longing", "temporary", "didactic", "lethal", "wiry"}, 'w', List.of(13, 34, 42)));
		T.add(new ImmutableTriple<>(new String[]{"lewd", "jaded", "crow", "spotted", "wretched", "jaded", "hanging", "wriggle", "rainstorm", "cute", "acidic", "glamorous", "bait", "murky", "wax", "invention", "fit", "awful", "squash", "string", "past", "increase", "sparkling", "scare", "connect", "nation", "utter", "omniscient", "picture", "wealth", "quill", "correct", "rural", "toothpaste", "ear", "roof", "handsome", "milk", "grate", "animated", "dime", "effect", "grandmother"}, 'c', List.of(2, 4, 9, 10, 21, 23, 24, 27, 28, 31, 41)));
		T.add(new ImmutableTriple<>(new String[]{"aback", "possible", "hysterical", "spicy", "pot", "righteous", "tug", "invention", "rambunctious", "different", "harsh", "pest", "confess", "car", "sturdy", "rake", "jumbled", "effect", "heartbreaking", "dime", "edge", "mailbox", "downtown", "harass", "aunt", "mysterious", "blood", "direful", "skinny", "blood", "thank", "wriggle", "market", "living", "opposite", "tacit", "squeamish", "aloof", "flat", "scatter", "unusual", "clam"}, 'n', List.of(7, 8, 9, 12, 18, 22, 24, 28, 30, 33, 40)));
		T.add(new ImmutableTriple<>(new String[]{"moldy", "big", "immense", "drag", "haunt", "cynical", "welcome", "spiteful", "colorful", "relieved", "possess", "basin", "queue", "self", "ski", "fuzzy", "bead", "red", "enchanting", "conscious", "calendar", "nest", "group", "bent", "thankful", "thunder", "elated", "holiday", "pleasure", "telephone", "thirsty", "park", "allow", "road", "drag", "unpack", "adorable", "moan", "aromatic", "chickens", "slap", "selective", "current", "winter", "page", "acidic", "curvy"}, 'j', List.of()));
		T.add(new ImmutableTriple<>(new String[]{"parsimonious", "float", "ground", "market", "reply", "jelly", "ubiquitous", "meddle", "nerve", "cowardly", "big", "furtive", "rice", "exultant", "wriggle", "frame", "answer", "rainstorm", "bouncy", "scattered", "abusive", "rightful", "action", "scientific", "chop", "lush", "contain", "adhoc", "political", "dead", "breakable", "tire", "oceanic", "foot", "road", "tease", "pets", "handsomely", "development", "flap", "railway", "red", "boil", "breathe", "ground", "fuzzy"}, 'x', List.of(13)));
		T.add(new ImmutableTriple<>(new String[]{"answer", "island", "tired", "account", "physical", "sable", "month", "machine", "precious", "push", "heavenly", "tug", "sound", "aberrant", "clover", "awful", "carry", "curtain", "statement", "count", "yak", "hobbies", "practice", "abstracted", "milk", "lettuce", "resonant", "start", "humdrum", "axiomatic", "mitten", "repulsive", "trucks", "lying", "sound", "defective", "dad", "imperfect", "invincible", "queue", "imperfect", "face", "slim", "resonant", "petite", "compete"}, 'q', List.of(39)));
		T.add(new ImmutableTriple<>(new String[]{"bad", "unpack", "scared", "mate", "heat", "precious", "tangible", "second", "mom", "fax", "quill", "next", "digestion", "toothbrush", "lowly", "gruesome", "whirl", "labored", "flat", "vacation", "defective", "exercise", "stay", "badge", "thank", "rightful", "calendar", "zoom", "butter", "farm", "tremendous", "tame", "aberrant", "crazy", "opposite", "town", "heavy", "jazzy", "tire", "dry", "winter", "tickle", "kneel", "forgetful", "haircut", "sweet", "unlock", "mysterious", "plants", "queue"}, 'j', List.of(37)));
		T.add(new ImmutableTriple<>(new String[]{"loving", "deceive", "rich", "trade", "grandfather", "clam", "scatter", "cry", "witty", "size", "nut", "unique", "aboard", "amusement", "glossy", "spotted", "ugly", "radiate", "stream", "carriage", "kneel", "obtain", "charge", "belief", "night", "car", "notebook", "cheer", "bucket", "wise", "influence", "sparkle", "heap", "itchy", "haunt", "honorable", "ugliest", "meat", "pull", "comparison", "harm", "limit", "wing", "heavy", "common", "throne", "answer", "rightful", "hum", "hobbies"}, 'm', List.of(5, 13, 18, 37, 39, 40, 41, 44, 48)));
		T.add(new ImmutableTriple<>(new String[]{"hobbies", "kneel", "machine", "muddled", "juice", "sleet", "chop", "practice", "range", "leather", "butter", "hospitable", "troubled", "rich", "imported", "cynical", "bomb", "humdrum", "colour", "unequal", "license", "bite", "squeal", "horse", "useless", "oafish", "unusual", "arithmetic", "trees", "bless", "settle", "annoying", "helpless", "wing", "ultra", "fruit", "embarrassed", "unique", "jumbled", "tremendous", "self", "male", "add", "acquiescence", "different", "leather", "didactic", "whispering"}, 'f', List.of(25, 35, 40, 44)));
		T.add(new ImmutableTriple<>(new String[]{"market", "caring", "fax", "settle", "mute", "hands", "file", "hum", "fit", "vast", "pretend", "wacky", "guard", "gun", "gabby", "continue", "disagreeable", "committee", "nut", "horrible", "point", "scream", "abstracted", "didactic", "impress", "jar", "observation", "fertile", "squeamish", "jumpy", "first", "remember", "unequal", "righteous", "communicate", "vacuous", "profuse", "fine", "uttermost", "found", "touch", "grain", "statement", "responsible", "outstanding", "birth", "toy", "lie", "lumber", "obscene"}, 'j', List.of(25, 29)));
		T.add(new ImmutableTriple<>(new String[]{"wriggle", "communicate", "dime", "tart", "roof", "nice", "amusing", "humorous", "moldy", "quicksand", "thread", "obtainable", "parallel", "steadfast", "outstanding", "pastoral", "sparkle", "physical", "protect", "cow", "uttermost", "wire", "abhorrent", "broad", "physical", "perpetual", "troubled", "frightening", "hop", "wheel", "heavy", "tickle", "crime", "lush", "lunchroom", "fix", "word", "trucks", "cactus", "attend", "suppose", "jazzy", "committee", "questionable", "alarm", "ahead", "pipe", "wire"}, 'b', List.of(11, 22, 23, 26, 43)));
		T.add(new ImmutableTriple<>(new String[]{"help", "lush", "ablaze", "scattered", "common", "parsimonious", "can", "nice", "guard", "nation", "billowy", "acceptable", "attack", "strong", "friendly", "tray", "wanting", "thread", "statement", "testy", "moan", "trees", "hands", "lick", "lettuce", "committee", "shoes", "machine", "wilderness", "wonder", "tidy", "current", "mixed", "top", "push", "number", "unlock", "ambiguous", "start", "support", "conscious", "jagged", "outstanding", "nerve", "kiss", "woozy", "bait", "gaze", "rabbits"}, 'u', List.of(1, 5, 8, 24, 31, 34, 35, 36, 37, 39, 40, 42)));
		T.add(new ImmutableTriple<>(new String[]{"sun", "talk", "lumber", "telephone", "aboard", "tickle", "blue", "amusement", "rice", "brake", "quicksand", "egg", "shut", "bouncy", "pull", "yak", "tart", "lying", "welcome", "toothpaste", "relieved", "basketball", "development", "snotty", "aloof", "confess", "heal", "comparison", "waste", "miss", "jelly", "different", "unwieldy", "current", "canvas", "summer", "one", "effect", "scream", "wealthy", "sisters", "breathe", "bouncy", "quill", "fax", "terrify", "ladybug", "guide", "momentous", "applaud"}, 'c', List.of(5, 8, 10, 13, 18, 25, 27, 33, 34, 37, 38, 42)));
		T.add(new ImmutableTriple<>(new String[]{"adhoc", "collect", "consist", "yell", "supply", "chubby", "business", "account", "enchanting", "battle", "creepy", "ask", "rightful", "stare", "axiomatic", "possess", "wary", "scream", "top", "famous", "serious", "ladybug", "naughty", "little", "disappear", "spectacular", "hysterical", "obtain", "ladybug", "ground", "market", "cable", "hug", "current", "feigned", "honey", "next", "economic", "spark", "authority", "request", "abusive", "questionable", "expert", "plot", "caring", "film", "illustrious", "blood"}, 'p', List.of(4, 10, 15, 18, 24, 25, 38, 43, 44)));
		T.add(new ImmutableTriple<>(new String[]{"thank", "psychedelic", "quicksand", "guiltless", "instrument", "top", "frog", "subtract", "mailbox", "pretend", "mailbox", "angle", "wrench", "acceptable", "picture", "illustrious", "rake", "remember", "machine", "diligent", "wide", "clover", "blue", "try", "play", "breakable", "seashore", "self", "hands", "oceanic", "fluffy", "search", "cut", "bless", "fallacious", "manage", "lazy", "treatment", "jumbled", "cry", "tenuous", "grateful", "tin", "touch", "uppity", "visitor", "luxuriant", "peel"}, 'i', List.of(1, 2, 3, 4, 8, 10, 14, 15, 18, 19, 20, 29, 34, 42, 44, 45, 46)));
		T.add(new ImmutableTriple<>(new String[]{"juice", "found", "heap", "stiff", "tacit", "sticky", "invite", "kneel", "cracker", "cynical", "sparkling", "basket", "little", "dirt", "history", "bottle", "wound", "earthy", "continue", "apparatus", "exist", "help", "respect", "snakes", "wrench", "snakes", "servant", "trouble", "annoy", "consist", "stroke", "scattered", "illustrious", "long", "tire", "worthless", "substantial", "range", "hulking", "vast", "teaching", "ritzy", "vessel", "carriage", "icicle", "stingy", "modern", "fowl", "aunt"}, 'a', List.of(2, 4, 8, 9, 10, 11, 17, 19, 23, 25, 26, 28, 31, 36, 37, 39, 40, 43, 48)));
		T.add(new ImmutableTriple<>(new String[]{"boat", "size", "disappear", "clam", "strange", "prefer", "entertain", "functional", "measure", "tail", "sound", "train", "rejoice", "compete", "wipe", "naughty", "soft", "excellent", "sisters", "chief", "guitar", "spark", "face", "shelter", "behave", "wise", "glamorous", "physical", "frame", "basketball", "collect", "hall", "subtract", "mean", "tidy", "suppose", "fantastic", "exercise", "acceptable", "grate", "numberless", "quill", "excuse", "rhyme", "stop", "scintillating", "profuse", "ablaze", "arm", "jagged"}, 'c', List.of(3, 7, 12, 13, 17, 19, 22, 27, 30, 32, 36, 37, 38, 42, 45)));
		T.add(new ImmutableTriple<>(new String[]{"statement", "sun", "machine", "crabby", "toothpaste", "guide", "float", "pretend", "acidic", "walk", "humdrum", "eager", "functional", "afraid", "mailbox", "farm", "grumpy", "dapper", "cherry", "impress", "acquiescence", "fix", "mitten", "pretend", "tiresome", "file", "cherry", "string", "trick", "tremendous", "vague", "cute", "reply", "wiry", "cough", "scintillating", "big", "summer", "glove", "stem", "pull", "miss", "jumbled", "steady", "heartbreaking", "expert", "event", "wealthy"}, 'e', List.of(0, 2, 4, 5, 7, 11, 17, 18, 19, 20, 22, 23, 24, 25, 26, 29, 30, 31, 32, 37, 38, 39, 42, 43, 44, 45, 46, 47)));
		T.add(new ImmutableTriple<>(new String[]{"innocent", "chew", "wilderness", "leather", "grumpy", "lunchroom", "icy", "functional", "fasten", "vivacious", "good", "dynamic", "ground", "instrument", "fowl", "gather", "adorable", "relieved", "one", "horse", "lewd", "avoid", "two", "butter", "squash", "precious", "male", "fetch", "guitar", "aloof", "squeal", "cynical", "help", "tin", "canvas", "flap", "delightful", "verdant", "witty", "pushy", "waves", "glamorous", "flap", "accidental", "trot", "frighten", "exultant", "shallow", "sticky", "soup"}, 'e', List.of(0, 1, 2, 3, 8, 13, 15, 16, 17, 18, 19, 20, 23, 25, 26, 27, 30, 32, 36, 37, 40, 43, 45, 46)));
		T.add(new ImmutableTriple<>(new String[]{"direction", "delirious", "flesh", "gather", "cry", "jolly", "fall", "gullible", "deceive", "opposite", "hollow", "kneel", "size", "hum", "scientific", "rhyme", "detect", "march", "alleged", "part", "frame", "dead", "curl", "fearless", "invention", "numberless", "cow", "apparatus", "limit", "vacation", "squeamish", "plantation", "regret", "sign", "car", "thunder", "toothpaste", "afford", "lopsided", "selective", "squeamish", "distribution", "word", "parcel", "ear", "relation", "cold", "cloudy", "frame", "thunder"}, 'e', List.of(0, 1, 2, 3, 7, 8, 9, 11, 12, 14, 15, 16, 18, 20, 21, 23, 24, 25, 30, 32, 35, 36, 38, 39, 40, 43, 44, 45, 48, 49)));

	}

	private static final String[] DICTIONARY = new String[]{

		"reproduce", "amusement", "uneven", "metal", "curvy", "bore", "guide", "wax", "ancient", "nut", "one", "mountainous", "prevent", "cagey", "men", "thirsty", "statuesque", "shut", "reading", "riddle", "rhyme", "tremendous", "pour", "bucket", "cloudy",
		"correct", "bath", "addition", "film", "instrument", "uncovered", "bouncy", "marble", "abnormal", "attend", "foot", "impress", "supply", "kaput", "gun", "bleach", "butter", "ubiquitous", "tacky", "tremble", "radiate", "badge", "freezing", "precious", "diligent",
		"contain", "crack", "wiry", "troubled", "size", "face", "pull", "welcome", "sink", "flavor", "horses", "stimulating", "abusive", "icy", "existence", "teeth", "battle", "scintillating", "loud", "spicy", "alleged", "disgusting", "pointless", "lighten", "poised",
		"guiltless", "illustrious", "ritzy", "scared", "arithmetic", "tree", "rough", "murky", "afford", "luxuriant", "disagreeable", "dusty", "obscene", "muddled", "mailbox", "smile", "snore", "tranquil", "fit", "moldy", "pie", "boundary", "curved", "wretched", "charge",
		"grandfather", "next", "cactus", "observation", "perpetual", "bag", "knife", "highfalutin", "toothbrush", "elbow", "ablaze", "automatic", "ink", "cough", "dead", "close", "taste", "lethal", "ahead", "check", "giants", "children", "canvas", "heavy", "ugly",
		"faint", "lewd", "cheer", "crow", "testy", "talk", "jog", "gaudy", "elated", "clover", "null", "nutty", "grate", "glass", "judicious", "word", "home", "haunt", "nervous", "wound", "imperfect", "mouth", "hammer", "guess", "cruel",
		"communicate", "hose", "fasten", "grateful", "loss", "chunky", "responsible", "strange", "cub", "cold", "sticky", "damage", "statement", "rare", "wealth", "avoid", "leather", "hobbies", "animated", "entertain", "mitten", "possess", "sophisticated", "beds", "parallel",
		"sneaky", "number", "authority", "ladybug", "tense", "touch", "apparatus", "limit", "repulsive", "edge", "adorable", "stay", "fang", "gaze", "march", "holiday", "fireman", "calendar", "necessary", "milk", "shivering", "rabid", "suspect", "ludicrous", "average",
		"stain", "hum", "exercise", "opposite", "outstanding", "quill", "uppity", "toothpaste", "sound", "help", "chickens", "voracious", "complex", "machine", "rainstorm", "blue", "foolish", "hollow", "protect", "colour", "guard", "crowded", "helpless", "humorous", "aquatic",
		"invincible", "cook", "wanting", "lowly", "sail", "fearless", "jittery", "flood", "bent", "regret", "somber", "page", "chop", "hall", "nation", "walk", "thing", "male", "brake", "shrill", "momentous", "direful", "harm", "summer", "fantastic",
		"snow", "creature", "miss", "spark", "assorted", "heap", "tail", "depend", "stream", "spurious", "cut", "omniscient", "horrible", "uttermost", "town", "appliance", "point", "tin", "hot", "launch", "suppose", "interrupt", "mixed", "picture", "carry",
		"holistic", "parcel", "spiteful", "car", "accidental", "lick", "trick", "exultant", "itchy", "month", "jolly", "jazzy", "actually", "birth", "squash", "digestion", "file", "tickle", "yoke", "broad", "throne", "enthusiastic", "physical", "shelter", "breakable",
		"building", "enter", "vengeful", "improve", "serious", "didactic", "wonder", "vacation", "crime", "bite", "heal", "bead", "jobless", "exclusive", "analyze", "current", "lazy", "furtive", "brown", "rainy", "imported", "wise", "meat", "sigh", "heavenly",
		"switch", "spectacular", "scientific", "babies", "rob", "scare", "development", "invite", "resolute", "relation", "stove", "steel", "compete", "plantation", "cable", "dynamic", "delirious", "toad", "berry", "teaching", "pies", "fax", "jar", "place", "paper",
		"quicksand", "tidy", "hurried", "knot", "trade", "fallacious", "defective", "adjustment", "grade", "flock", "road", "tip", "rambunctious", "rejoice", "thundering", "knit", "funny", "need", "decorate", "disapprove", "flat", "ultra", "preserve", "add", "tame",
		"spiders", "play", "embarrassed", "aboard", "enchanting", "innocent", "willing", "conscious", "amusing", "arm", "unusual", "harbor", "creator", "fine", "fetch", "dizzy", "wipe", "jumpy", "sleet", "tangible", "invention", "weigh", "maddening", "park", "license",
		"lush", "gather", "apparel", "shock", "long", "amount", "train", "enchanted", "oafish", "save", "squeamish", "faithful", "thread", "half", "hook", "damp", "subtract", "macabre", "support", "mate", "steady", "whispering", "self", "answer", "pushy",
		"stuff", "hop", "handsome", "mute", "bad", "enormous", "plot", "whine", "growth", "driving", "wacky", "few", "different", "questionable", "whirl", "dime", "unsightly", "agreeable", "sable", "ear", "selective", "market", "humdrum", "tomatoes", "downtown",
		"mushy", "toy", "sisters", "vessel", "nice", "egg", "basin", "question", "part", "afraid", "psychedelic", "thought", "servant", "acidic", "pick", "carriage", "sore", "farm", "profit", "exciting", "silly", "wealthy", "telephone", "rich", "nine",
		"juice", "frog", "history", "inconclusive", "giddy", "useless", "righteous", "lamentable", "hateful", "basket", "merciful", "rice", "remember", "dream", "glove", "common", "cowardly", "aloof", "bomb", "request", "ski", "labored", "little", "tow", "concerned",
		"string", "honorable", "wave", "sense", "hands", "kneel", "nifty", "fowl", "thank", "juvenile", "tiresome", "frighten", "annoying", "stew", "flag", "thunder", "abandoned", "oceanic", "ring", "weak", "deceive", "boiling", "war", "tie", "substance",
		"treatment", "reflect", "thankful", "tramp", "tender", "scream", "ground", "dirty", "flowers", "big", "tricky", "elfin", "accessible", "pricey", "trot", "closed", "relieved", "awful", "steer", "wriggle", "account", "try", "press", "unique", "frightening",
		"nimble", "daughter", "zoom", "lock", "cry", "cover", "unpack", "ban", "sweet", "courageous", "hanging", "reply", "giant", "functional", "cow", "jagged", "peep", "heat", "vivacious", "found", "glib", "longing", "dry", "occur", "snotty",
		"sparkle", "fix", "waves", "grease", "sign", "gruesome", "company", "chief", "angle", "madly", "famous", "scatter", "gullible", "songs", "coherent", "juggle", "guitar", "terrify", "real", "learned", "fire", "front", "plants", "piquant", "feigned",
		"pot", "comparison", "abhorrent", "slap", "lopsided", "rural", "nest", "committee", "moan", "frame", "prefer", "tall", "crazy", "shake", "curl", "dazzling", "rush", "cap", "ambiguous", "lettuce", "glow", "icicle", "ignore", "cherry", "can",
		"fear", "manage", "governor", "meeting", "political", "ticket", "look", "flowery", "cracker", "utter", "steadfast", "range", "collect", "skinny", "seashore", "visitor", "bikes", "fascinated", "wilderness", "sick", "day", "loving", "pet", "friendly", "railway",
		"knowing", "smiling", "event", "wire", "superb", "stare", "various", "tire", "peaceful", "influence", "clam", "scattered", "young", "prickly", "increase", "boat", "dad", "tray", "want", "stem", "settle", "cynical", "view", "selection", "awake",
		"unwieldy", "honey", "stingy", "north", "yell", "true", "humor", "billowy", "mom", "dirt", "reduce", "waggish", "promise", "tenuous", "unlock", "immense", "obtainable", "yak", "float", "search", "hulking", "waste", "unit", "discreet", "disappear",
		"dashing", "slim", "pipe", "vacuous", "grain", "wing", "writer", "squeal", "racial", "tart", "action", "obsequious", "tacit", "sparkling", "good", "proud", "desk", "picayune", "protective", "shoes", "pets", "basketball", "earthy", "applaud", "godly",
		"guttural", "caring", "value", "behavior", "admire", "chew", "offer", "two", "island", "pastoral", "deranged", "sky", "annoy", "worried", "hallowed", "haircut", "wandering", "effect", "tank", "education", "experience", "jaded", "bless", "sun", "ten",
		"tired", "verdant", "ask", "heartbreaking", "eyes", "dance", "jelly", "nerve", "majestic", "unwritten", "eggs", "lying", "stupendous", "glamorous", "fuzzy", "stitch", "cooing", "modern", "naughty", "acceptable", "judge", "confess", "violet", "start", "lunchroom",
		"trouble", "attack", "petite", "red", "trucks", "eatable", "object", "cemetery", "flower", "afternoon", "wrong", "wide", "royal", "domineering", "winter", "lie", "unequal", "grumpy", "squirrel", "concern", "abstracted", "sidewalk", "bait", "night", "crook",
		"wind", "deeply", "aunt", "skillful", "work", "kill", "mean", "geese", "flesh", "reaction", "colorful", "creepy", "belief", "slave", "vast", "imaginary", "moon", "top", "rain", "chivalrous", "excuse", "sea", "aback", "deserve", "direction",
		"flap", "oven", "pretend", "practice", "glossy", "snakes", "rabbits", "note", "discussion", "underwear", "lumber", "office", "stiff", "fruit", "numberless", "soup", "peel", "gabby", "temporary", "dark", "dapper", "return", "boil", "wash", "jumbled",
		"sweater", "aromatic", "rightful", "hug", "fertile", "wary", "axiomatic", "breathe", "flash", "continue", "fall", "disgusted", "witty", "sturdy", "business", "living", "strong", "cute", "attractive", "explain", "pest", "alarm", "chase", "theory", "prose",
		"cobweb", "quixotic", "adaptable", "gray", "delight", "rest", "potato", "push", "stop", "respect", "playground", "bizarre", "example", "quilt", "talented", "measure", "cast", "zoo", "aberrant", "sofa", "caption", "upset", "hospitable", "spoon", "spotted",
		"stroke", "notebook", "salt", "parsimonious", "soft", "woozy", "spade", "horse", "determined", "mysterious", "blood", "behave", "adhoc", "queue", "pleasure", "lonely", "quack", "womanly", "fluffy", "kitty", "tiny", "excellent", "detect", "forgetful", "vague", "acquiescence",
		"kiss", "delightful", "marked", "rifle", "harass", "price", "possible", "exist", "flashy", "resonant", "female", "distribution", "eager", "laborer", "allow", "discover", "acoustics", "drag", "motionless", "sordid", "bottle", "better", "trees", "live", "protest",
		"roof", "second", "expert", "oranges", "death", "hysterical", "careful", "crabby", "meddle", "sad", "shame", "rake", "substantial", "grandmother", "harsh", "follow", "bells", "plastic", "land", "chubby", "count", "wrench", "curtain", "economic", "ugliest",
		"button", "tease", "fact", "group", "connect", "whip", "illegal", "obtain", "risk", "handsomely", "week", "past", "tug", "health", "flight", "consist", "thaw", "overrated", "mice", "first", "worthless", "industry", "profuse", "wheel", "shallow",

	};

	private static final List<Integer> test = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

	public static void main(String[] args)
	{
		generateTests(1);
	}

	@Test
	void findWordsContaining()
	{
		for (Triple<String[], Character, List<Integer>> entry : T)
		{
			final String[] words = entry.getLeft();
			final char c = entry.getMiddle();
			final List<Integer> expected = entry.getRight();
			final List<Integer> actual = FindWordsContainingCharacter.findWordsContaining(words, c);

			String message = "Test failed on case: " + Arrays.toString(words)
				+ ".\nExpected : " + expected
				+ "\nActual   : " + actual;

			assertEquals(expected, actual, message);
		}
	}

	private static void generateTest()
	{
		generateTests(1);
	}

	private static void generateTests(int quantity)
	{
		for (int i = 0; i < quantity; i++)
		{
			int size = ThreadLocalRandom.current().nextInt(50) + 1;
			String[] words = new String[size];

			for (int j = 0; j < words.length; j++)
			{
				words[j] = DICTIONARY[ThreadLocalRandom.current().nextInt(1001)];
			}

			char c = (char) (ThreadLocalRandom.current().nextInt('z' - 'a' - 1) + 'a');

			List<Integer> expected = new ArrayList<>();
			for (int j = 0; j < words.length; j++)
			{
				if (words[j].contains(String.valueOf(c)))
				{
					expected.add(j);
				}
			}

			final String w = Arrays.toString(words)
				.replaceAll("[\\[\\] ]", "")
				.replaceAll("(\\w+)\\s*(?=,|$)", "\"$1\"");
			final String e = expected.toString()
				.replaceAll("[\\[\\] ]", "");
			final String s = "TRIPLES.add(new ImmutableTriple<>(new String[]{" + w + "},'" + c + "',List.of(" + e + ")));";

			System.out.println(s);
		}
	}
}