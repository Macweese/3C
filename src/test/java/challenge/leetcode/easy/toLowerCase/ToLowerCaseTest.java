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

package challenge.leetcode.easy.toLowerCase;

import data.lexicography.words.Attribute;
import data.lexicography.words.CsvWordSource;
import data.lexicography.words.Word;
import data.lexicography.words.WordProvider;
import data.lexicography.words.WordType;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 00:14 Tue 18 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("709. To Lower Case")
class ToLowerCaseTest
{
	private static final Map<String, String> MAP = new HashMap<>();
	private static final WordProvider wordProvider = WordProvider.builder()
		.addSource(new CsvWordSource(WordType.ADJECTIVE.source))
		.addSource(new CsvWordSource(WordType.ADVERB.source))
		.addSource(new CsvWordSource(WordType.CONJUNCTION.source))
		.addSource(new CsvWordSource(WordType.INTERJECTION.source))
		.addSource(new CsvWordSource(WordType.NOUN.source))
		.addSource(new CsvWordSource(WordType.PREPOSITION.source))
		.addSource(new CsvWordSource(WordType.PRONOUN.source))
		.addSource(new CsvWordSource(WordType.VERB.source))
		.build();

	static
	{
		MAP.put("tOP","top");
		MAP.put("BAh","bah");
		MAP.put("SLId","slid");
		MAP.put("daTA","data");
		MAP.put("pSsT","psst");
		MAP.put("land","land");
		MAP.put("pLug","plug");
		MAP.put("DATa","data");
		MAP.put("seNT","sent");
		MAP.put("deAD","dead");
		MAP.put("MilD","mild");
		MAP.put("cUREd","cured");
		MAP.put("AugHt","aught");
		MAP.put("gRAND","grand");
		MAP.put("SWUng","swung");
		MAP.put("speak","speak");
		MAP.put("BElOw","below");
		MAP.put("SPELl","spell");
		MAP.put("LAmelY","lamely");
		MAP.put("LatESt","latest");
		MAP.put("CAreer","career");
		MAP.put("pAcked","packed");
		MAP.put("tHEIrS","theirs");
		MAP.put("StAteD","stated");
		MAP.put("mEMORY","memory");
		MAP.put("fOnDEr","fonder");
		MAP.put("AcrOsS","across");
		MAP.put("STupid","stupid");
		MAP.put("runner","runner");
		MAP.put("mATUrE","mature");
		MAP.put("opiNioN","opinion");
		MAP.put("ReGAlly","regally");
		MAP.put("bREVITy","brevity");
		MAP.put("dilemma","dilemma");
		MAP.put("HarMinG","harming");
		MAP.put("SwiftlY","swiftly");
		MAP.put("hApPEnS","happens");
		MAP.put("SixtHlY","sixthly");
		MAP.put("GhastlY","ghastly");
		MAP.put("wAnTinG","wanting");
		MAP.put("AgitatOr","agitator");
		MAP.put("solitude","solitude");
		MAP.put("TRiMnEss","trimness");
		MAP.put("ELEcTinG","electing");
		MAP.put("proTESTS","protests");
		MAP.put("CLEaRINg","clearing");
		MAP.put("wOrKABLY","workably");
		MAP.put("dIsturBs","disturbs");
		MAP.put("ComPlIed","complied");
		MAP.put("VeRNALlY","vernally");
		MAP.put("bEComiNG","becoming");
		MAP.put("obLIquEly","obliquely");
		MAP.put("rEvEaLING","revealing");
		MAP.put("NONeNtITy","nonentity");
		MAP.put("sAnitiZer","sanitizer");
		MAP.put("dEXTeRiTY","dexterity");
		MAP.put("HYPOCRiSy","hypocrisy");
		MAP.put("SENSoRILY","sensorily");
		MAP.put("sEntimENT","sentiment");
		MAP.put("OPTAtIvElY","optatively");
		MAP.put("ineviTABLy","inevitably");
		MAP.put("MitigatIon","mitigation");
		MAP.put("STRicTnEsS","strictness");
		MAP.put("feMiNInITY","femininity");
		MAP.put("pROSPEcToR","prospector");
		MAP.put("UnsUiTAbLy","unsuitably");
		MAP.put("ConFErmENT","conferment");
		MAP.put("esCapement","escapement");
		MAP.put("irrigATION","irrigation");
		MAP.put("BIochEmIst","biochemist");
		MAP.put("FRIgHTEnEd","frightened");
		MAP.put("paINleSsLY","painlessly");
		MAP.put("eNDUrinGLY","enduringly");
		MAP.put("PrOdUctive","productive");
		MAP.put("ArRogAntLy","arrogantly");
		MAP.put("eXpERiEnce","experience");
		MAP.put("eVERyThinG","everything");
		MAP.put("alLOcatiNg","allocating");
		MAP.put("CoMPLETIoN","completion");
		MAP.put("ExPeCTAtIOn","expectation");
		MAP.put("percEptiblY","perceptibly");
		MAP.put("reSErvAtioN","reservation");
		MAP.put("KoRanIcalLy","koranically");
		MAP.put("IndIGNATion","indignation");
		MAP.put("EuPHoRiCalLy","euphorically");
		MAP.put("eSTrangEmenT","estrangement");
		MAP.put("AccoMmOdatEd","accommodated");
		MAP.put("uNTrUthfULly","untruthfully");
		MAP.put("ReVeNGEFuLLY","revengefully");
		MAP.put("reBEllioUsly","rebelliously");
		MAP.put("PerIODically","periodically");
		MAP.put("cOMpUlSIvItY","compulsivity");
		MAP.put("coNcENTRaTion","concentration");
		MAP.put("defEnSiBiLiTy","defensibility");
		MAP.put("ePIsTEmologiSt","epistemologist");
		MAP.put("EFferVeScEntlY","effervescently");
		MAP.put("uNSUSpecTiNGLY","unsuspectingly");
		MAP.put("beNEvolentNeSS","benevolentness");
		MAP.put("ILlegaLiZATiON","illegalization");
		MAP.put("ACCoUnTabiLitY","accountability");
	}

	@Test
	void toLowerCase()
	{
		for (Map.Entry<String, String > entry : MAP.entrySet())
		{
			final String input = entry.getKey();
			final String expected = entry.getValue();
			final String actual = ToLowerCase.toLowerCase(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s",
				"Input", input,
				"Expected", expected,
				"Actual", actual);

			assertEquals(expected, actual, message);
		}
	}

	static void generateTests()
	{
		for (int i = 0; i < 100; i++)
		{

			Word word = wordProvider.query()
				.attributes(Attribute.STANDARD)
				.random()
				.lengthBetween(1, 100)
				.any().orElse(null);

			if (word == null)
			{
				continue;
			}
			String lower = word.word().toLowerCase();
			StringBuilder w = new StringBuilder(word.word());
			for (int j = 0; j < w.length(); j++)
			{
				w.setCharAt(j, ThreadLocalRandom.current().nextBoolean() ? Character.toUpperCase(w.charAt(j)) : w.charAt(j));
			}

			System.out.printf("MAP.put(\"%s\",\"%s\");%n", w, lower);
		}
	}
}