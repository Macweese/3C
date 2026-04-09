/*
 *
 *     Copyright (C) 2026 Macweese <https://www.github.com/Macweese>
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

package challenge.leetcode.medium.decodeTheSlantedCiphertext;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 07:03 Sat 04 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2075. Decode the Slanted Ciphertext")
class DecodeTheSlantedCiphertextTest
{
	private static final Map<Input, String> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input("coding",1),"coding");
		MAP.put(new Input("ch   ie   pr",3),"cipher");
		MAP.put(new Input("             a     b",4),"      ab");
		MAP.put(new Input("iveo    eed   l te   olc",4),"i love leetcode");
		MAP.put(new Input("zcnbsyedjgeiu ywwdge hygibdagfnybwif j lpfelxkyuizfzlrgpcvkrcahvzecgtqmjetyqbexqvsckynvgcandbu zlkhjc",1),"zcnbsyedjgeiu ywwdge hygibdagfnybwif j lpfelxkyuizfzlrgpcvkrcahvzecgtqmjetyqbexqvsckynvgcandbu zlkhjc");
		MAP.put(new Input("wmihfwf bddhzaizuzhbuoovyyjstardqceaqzafdzihjbj ywly amkeemr jmvsfaavbpgiafgxzciwmrrtasthc hqfrtwoizoilw",2),"wammikhefewmfr  bjdmdvhszfaaiazvubzphgbiuaofogvxyzycjiswtmarrrdtqacsetahqcz ahfqdfzrithwjobijz oyiwllwy");
		MAP.put(new Input("osljjaooouqphokrnf     lsdoioccbdhbsqkm b     qmqoitpqnpqwnebsou     llvfotmazegriuigrs     vjpbgaqifwo  kaqto     dsupahycdgbyoubsu",6),"olqlvdssmljsldqvpujoofbpjiiogaaottahocpmqyocqaicobnzfdudpewgqhqgobpbwr yhsni ooqeukukkbiabrmsgqsn ortufbuso");
		MAP.put(new Input("suyexvjtk             lduoqccop             mbxotagus             ibrnbyxhs             ttxjbhkmy             inqntngxg             alqvlwsgg             z lxfupvz             ofpqlhydq             iztogeqis             pdtrqnuhu             sqjfwdyhd             wkvegwkoy             wa smlty",14),"slmitiazoipswwudbbtnl fzdqkayuxrxqqlpttjv eoonjnvxqorfesxqtbbtlflgqwgmvcayhnwuhendwljcgxkgspyquykttouhmxgvdihhoykpssyggzqsudy");
		MAP.put(new Input("bzqlagy                gxwd tx                uvqinyi                jjmdhhb                kjcm la                rxwcqnf                ycuxczg                wwnvnqz                bsdqkqr                ushfkzu                heny dw                qvbuagj                blawlga                wzhgxxg                tzb thk                shtxjof                feguqx",17),"bgujkrywbuhqbwtsfzxvjjxcwssevlzzheqwqmcwundhnbahbtgldidmcxvqfyuwg xua nh qcnkk alxtjqgtyhlnzqqzdggxhoxyxibafgzruwjagkf");
		MAP.put(new Input("issqcpi                  wjgpvbw                  mncblia                  rkujbgs                  ivvaulw                  bcspydl                  iokjaka                  cic zne                  xmwcnnr                  t bujij                  wlrrvvi                  nkkbgxy                  plwtxab                  vku pff                  khqszzb                  ellpduv                  ndmghwq                  sqzgvhb                  vxzibo",19),"iwmribicxtwnpvkensvsjnkvcoim lklkhldqxsgcuvskcwbrkwuqlmzzqpbjapj curbt spggicvlbuyaznjvgxpzdhvbpbigldknnivxafzuwhoiwaswlaerjiybfbvqb");
	}

	@Test
	void decodeCiphertext()
	{
		for (Map.Entry<Input, String> entry : MAP.entrySet())
		{
			final String encodedText = entry.getKey().encodedText();
			final int rows = entry.getKey().rows();
			final String expected = entry.getValue();
			final String actual = DecodeTheSlantedCiphertext.decodeCiphertext(encodedText, rows);

			String message = String.format("Test failed for case:"
					+ "%n%10s :"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s :"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Encoded Text", encodedText,
				"Rows", rows,
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(actual, expected, message);
		}
	}
}
record Input(String encodedText, int rows)
{

}