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
package challenge.leetcode.medium.usingARobotToPrintTheLexicographicallySmallestString;

import challenge.leetcode.medium.usingARobotToPrintTheLexicographicallySmallestString.UsingARobotToPrintTheLexicographicallySmallestString;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("2434. Using a Robot to Print the Lexicographically Smallest String")
class UsingARobotToPrintTheLexicographicallySmallestStringTest
{

	static final Map<String, String> MAP = new HashMap<>();

	static
	{
		MAP.put("bydizfve", "bdevfziy");
		MAP.put("bzeyxf", "befxyz");
		MAP.put("vzhofnpo", "fnohopzv");
		MAP.put("mmuqezwmomeplrtskz", "eekstrlpmomwzqummz");
		MAP.put("zza", "azz");
		MAP.put("bac", "abc");
		MAP.put("bdda", "addb");
		MAP.put("z", "z");
		MAP.put("wwqwvysxyrrxttvxtsurqwvxqvrsxxrxqxwutvqtuwqyryquyrqxrqvwsvxsvvyuquqwxxyqyqwtuqyvsqyqxyvquxyysrtuswxs", "qqqqqqqqqqqqqqqqqrsssxwutyyxuvyxysvyutwyyxxwuuyvvsxvswvrxryuyrywutvtuwxxrxxsrvxvwrustxvttxrryxsyvwww");
		MAP.put("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		MAP.put("lcnzsfnzzialfjjxjvtmmjfsldphhilhbjslvgsepspjzucntpdzobmzkdcbztlqggfxxtenytncikbcaktbesmnppbmigvkdttuycmfsyaruytxcfnxzrqpwehslaukcphsgglvchvdeshiyhtvplhqaefclgcvxkbcruqiyecdvhamqfzfxcualrcibtnbcpjggjxdtjcliclfafoypqphuchpigilunhavdsmokcohbccjpezhzuahmqmvcimghsmjmkiwbsumxsorcxshozkmjkxgufupebxoffhenjvqslzfvrbzgiurxcqlkzsibugdcznkiusygenerngrgrnuyzouebgmdcaxtcquhjxqgcmfcdumjfpzixanklglmlqdgfskslpqaehevmuiumkaeklvtpxuxtvbndejicufamyckfmxgeptjoepoogagjjdeceqfezkciuwiephcmeuqfbczgunpvovcaxcalocpzogdeezvqawnmyqnujsvvueivzmsawbdfmlhhktuldadzaaipyqvisodsupaswxosquxjuwnnlxbbmfxnuvnccjakqnzgmpchypivykyzoqumiljgeamflxiwambgsfaennsrymnqaqakiwuawosmwqdpqjismjqzweydqydoozrwaxsflxfzcyjrcbiytxpckjiqbjyhccthyagbwtqryiyjajpljaenjucmyxfzgqgekjgoecvsegorkotriukoxenztgofensvqgxbksfkppgolqwvarzxwwpkqjdpzhvxbcozswivsfvpwozkyzebuavttrdgjjtvlnwewtepvwboxiasuulqhwplvrkxumuudccuulcxiovycychhovtjyurgjbrycmwdxgwaetzshohqpbrybyligsnujvyesgfuetlcmeyurufpxwxmhzgdnbnyxujxlubfuejweuqytxmagjwjnlagtwfgbgwysohjemkaljymdglj", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadgjlmyjlkmejhosywgbgfwtglnjwjgmxtyquewjeufbulxjuxynbndgzhmxwxpfuruyemclteufgseyvjunsgilybyrbpqhohsztewgxdwmcyrbjgruyjtvohhcycyvoixcluuccduumuxkrvlpwhqluusixobwvpetwewnlvtjjgdrttvubezykzowpvfsviwszocbxvhzpdjqkpwwxzrvwqlogppkfskbxgqvsnefogtznexokuirtokrogesvceogjkegqgzfxymcujnejlpjjyiyrqtwbgyhtcchyjbqijkcpxtyibcrjyczfxlfsxwrzoodyqdyewzqjmsijqpdqwmsowuwikqqnmyrsnnefsgbmwixlfmegjlimuqozykyvipyhcpmgznqkjccnvunxfmbbxlnnwujxuqsoxwspusdosivqypizddlutkhhlmfdbwsmzvieuvvsjunqymnwqvzeedgozpcolcxcvovpnugzcbfquemchpeiwuickzefqecedjjggoopeojtpegxmfkcymfucijednbvtxuxptvlkekmuiumveheqplsksfgdqlmlglknxizpfjmudcfmcgqxjhuqctxcdmgbeuozyunrgrgnrenegysuiknzcdgubiszklqcxruigzbrvfzlsqvjnehffoxbepufugxkjmkzohsxcrosxmusbwikmjmshgmicvmqmhuzhzepjccbhockomsdvhnuligiphcuhpqpyofflcilcjtdxjggjpcbntbicrlucxfzfqmhvdceyiqurcbkxvcglcfeqhlpvthyihsedvhcvlggshpckulshewpqrzxnfcxtyurysfmcyuttdkvgimbppnmsebtkcbkicntynetxxfggqltzbcdkzmbozdptncuzjpspesgvlsjbhlihhpdlsfjmmtvjxjjflizznfszncl");
		MAP.put("cadb", "abdc");
	}

	@Test
	void robotWithString()
	{
		for (Map.Entry<String, String> entry : MAP.entrySet())
		{
			String expected = entry.getValue();
			String actual = UsingARobotToPrintTheLexicographicallySmallestString.robotWithString(entry.getKey());
			String message = "Test failed for case '" + entry.getKey() + "'\nExpected: '" + expected + "'\nActual: '" + actual + "'";

			assertEquals(expected, actual, message);
		}
	}
}