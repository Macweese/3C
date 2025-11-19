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
package challenge.leetcode.easy.defangingAnIpAddress;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("1108. Defanging an IP Address")
class DefangingAnIPAddressTest
{
	private static final Map<String, String> MAP = new HashMap<>();

	static
	{
		MAP.put("1.6.6.0", "1[.]6[.]6[.]0");
		MAP.put("6.0.9.1", "6[.]0[.]9[.]1");
		MAP.put("2.1.31.0", "2[.]1[.]31[.]0");
		MAP.put("5.2.39.1", "5[.]2[.]39[.]1");
		MAP.put("71.2.6.1", "71[.]2[.]6[.]1");
		MAP.put("4.8.1.84", "4[.]8[.]1[.]84");
		MAP.put("8.52.9.6", "8[.]52[.]9[.]6");
		MAP.put("4.3.81.4", "4[.]3[.]81[.]4");
		MAP.put("5.75.1.0", "5[.]75[.]1[.]0");
		MAP.put("97.75.4.9", "97[.]75[.]4[.]9");
		MAP.put("7.21.5.65", "7[.]21[.]5[.]65");
		MAP.put("4.57.59.2", "4[.]57[.]59[.]2");
		MAP.put("35.4.7.91", "35[.]4[.]7[.]91");
		MAP.put("4.2.5.769", "4[.]2[.]5[.]769");
		MAP.put("0.6.4.951", "0[.]6[.]4[.]951");
		MAP.put("15.8.56.3", "15[.]8[.]56[.]3");
		MAP.put("265.1.6.2", "265[.]1[.]6[.]2");
		MAP.put("495.0.0.0", "495[.]0[.]0[.]0");
		MAP.put("5.51.23.8", "5[.]51[.]23[.]8");
		MAP.put("1.49.21.5", "1[.]49[.]21[.]5");
		MAP.put("7.1.1.181", "7[.]1[.]1[.]181");
		MAP.put("47.67.0.5", "47[.]67[.]0[.]5");
		MAP.put("8.96.27.8", "8[.]96[.]27[.]8");
		MAP.put("7.85.54.29", "7[.]85[.]54[.]29");
		MAP.put("25.361.3.7", "25[.]361[.]3[.]7");
		MAP.put("136.47.1.4", "136[.]47[.]1[.]4");
		MAP.put("11.1.562.3", "11[.]1[.]562[.]3");
		MAP.put("842.6.45.4", "842[.]6[.]45[.]4");
		MAP.put("53.75.16.2", "53[.]75[.]16[.]2");
		MAP.put("5.49.5.237", "5[.]49[.]5[.]237");
		MAP.put("72.8.744.3", "72[.]8[.]744[.]3");
		MAP.put("94.359.8.0", "94[.]359[.]8[.]0");
		MAP.put("9.8.662.19", "9[.]8[.]662[.]19");
		MAP.put("66.64.66.9", "66[.]64[.]66[.]9");
		MAP.put("77.2.91.23", "77[.]2[.]91[.]23");
		MAP.put("882.11.3.0", "882[.]11[.]3[.]0");
		MAP.put("1.43.39.97", "1[.]43[.]39[.]97");
		MAP.put("363.7.11.7", "363[.]7[.]11[.]7");
		MAP.put("22.14.23.6", "22[.]14[.]23[.]6");
		MAP.put("866.8.75.58", "866[.]8[.]75[.]58");
		MAP.put("2.53.37.245", "2[.]53[.]37[.]245");
		MAP.put("39.3.918.28", "39[.]3[.]918[.]28");
		MAP.put("0.21.25.838", "0[.]21[.]25[.]838");
		MAP.put("22.1.533.31", "22[.]1[.]533[.]31");
		MAP.put("31.0.215.75", "31[.]0[.]215[.]75");
		MAP.put("49.956.92.4", "49[.]956[.]92[.]4");
		MAP.put("37.35.733.0", "37[.]35[.]733[.]0");
		MAP.put("26.35.82.49", "26[.]35[.]82[.]49");
		MAP.put("1.695.437.0", "1[.]695[.]437[.]0");
		MAP.put("3.4.498.639", "3[.]4[.]498[.]639");
		MAP.put("54.0.66.452", "54[.]0[.]66[.]452");
		MAP.put("84.0.431.73", "84[.]0[.]431[.]73");
		MAP.put("241.7.49.82", "241[.]7[.]49[.]82");
		MAP.put("12.7.51.212", "12[.]7[.]51[.]212");
		MAP.put("13.7.823.16", "13[.]7[.]823[.]16");
		MAP.put("5.271.65.73", "5[.]271[.]65[.]73");
		MAP.put("96.6.18.642", "96[.]6[.]18[.]642");
		MAP.put("317.914.8.2", "317[.]914[.]8[.]2");
		MAP.put("276.38.46.7", "276[.]38[.]46[.]7");
		MAP.put("73.12.945.9", "73[.]12[.]945[.]9");
		MAP.put("2.97.886.25", "2[.]97[.]886[.]25");
		MAP.put("2.51.147.57", "2[.]51[.]147[.]57");
		MAP.put("554.3.989.9", "554[.]3[.]989[.]9");
		MAP.put("23.449.39.4", "23[.]449[.]39[.]4");
		MAP.put("6.37.67.498", "6[.]37[.]67[.]498");
		MAP.put("5.926.23.782", "5[.]926[.]23[.]782");
		MAP.put("651.56.0.167", "651[.]56[.]0[.]167");
		MAP.put("53.968.44.19", "53[.]968[.]44[.]19");
		MAP.put("32.5.655.998", "32[.]5[.]655[.]998");
		MAP.put("81.47.68.352", "81[.]47[.]68[.]352");
		MAP.put("598.1.57.343", "598[.]1[.]57[.]343");
		MAP.put("5.254.879.69", "5[.]254[.]879[.]69");
		MAP.put("85.776.85.93", "85[.]776[.]85[.]93");
		MAP.put("1.668.71.721", "1[.]668[.]71[.]721");
		MAP.put("879.94.489.0", "879[.]94[.]489[.]0");
		MAP.put("93.122.7.934", "93[.]122[.]7[.]934");
		MAP.put("42.79.61.196", "42[.]79[.]61[.]196");
		MAP.put("29.5.948.457", "29[.]5[.]948[.]457");
		MAP.put("457.57.34.44", "457[.]57[.]34[.]44");
		MAP.put("85.98.66.253", "85[.]98[.]66[.]253");
		MAP.put("57.749.636.0", "57[.]749[.]636[.]0");
		MAP.put("699.5.98.344", "699[.]5[.]98[.]344");
		MAP.put("521.151.4.914", "521[.]151[.]4[.]914");
		MAP.put("242.788.56.35", "242[.]788[.]56[.]35");
		MAP.put("937.38.43.199", "937[.]38[.]43[.]199");
		MAP.put("343.22.367.26", "343[.]22[.]367[.]26");
		MAP.put("135.142.18.27", "135[.]142[.]18[.]27");
		MAP.put("47.32.553.958", "47[.]32[.]553[.]958");
		MAP.put("753.82.236.31", "753[.]82[.]236[.]31");
		MAP.put("65.471.574.82", "65[.]471[.]574[.]82");
		MAP.put("941.4.583.662", "941[.]4[.]583[.]662");
		MAP.put("11.846.34.636", "11[.]846[.]34[.]636");
		MAP.put("0.356.359.438", "0[.]356[.]359[.]438");
		MAP.put("734.993.31.154", "734[.]993[.]31[.]154");
		MAP.put("719.25.174.786", "719[.]25[.]174[.]786");
		MAP.put("798.713.22.754", "798[.]713[.]22[.]754");
		MAP.put("64.393.497.922", "64[.]393[.]497[.]922");
		MAP.put("798.51.554.449", "798[.]51[.]554[.]449");
		MAP.put("473.383.84.861", "473[.]383[.]84[.]861");
		MAP.put("413.611.742.873", "413[.]611[.]742[.]873");
	}

	private static final Pattern VALID_IPV4_REGEX = Pattern.compile("(\\b25[0-5]|\\b2[0-4]\\d|\\b[01]?\\d\\d?)(\\.(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)){3}");

	@Test
	void defangIPaddr()
	{
		for (Map.Entry<String, String> entry : MAP.entrySet())
		{
			final String address = entry.getKey();
			final String expected = entry.getValue();
			final String actual = DefangingAnIPAddress.defangIPaddr(address);

			String message = "Test failed on case: " + address
				+ ".\nExpected : " + expected
				+ "\nActual   : " + actual;

			assertEquals(expected, actual, message);
		}
	}

	private static void generateTests(int quantity)
	{
		for (int q = 0; q < quantity; q++)
		{
			StringBuilder ip = new StringBuilder();
			int a = ThreadLocalRandom.current().nextInt(3) + 1;
			int b = ThreadLocalRandom.current().nextInt(3) + 1;
			int c = ThreadLocalRandom.current().nextInt(3) + 1;
			int d = ThreadLocalRandom.current().nextInt(3) + 1;

			boolean leadingZeroPermitted = a == 1;
			for (int i = 0; i < a; i++)
			{
				int x = ThreadLocalRandom.current().nextInt(10);
				if (!leadingZeroPermitted && x == 0)
				{
					i--;
					continue;
				}
				ip.append(x);
			}
			ip.append(".");

			leadingZeroPermitted = b == 1;
			for (int i = 0; i < b; i++)
			{
				int x = ThreadLocalRandom.current().nextInt(10);
				if (!leadingZeroPermitted && x == 0)
				{
					i--;
					continue;
				}
				ip.append(x);
			}
			ip.append(".");

			leadingZeroPermitted = c == 1;
			for (int i = 0; i < c; i++)
			{
				int x = ThreadLocalRandom.current().nextInt(10);
				if (!leadingZeroPermitted && x == 0)
				{
					i--;
					continue;
				}
				ip.append(x);
			}
			ip.append(".");

			leadingZeroPermitted = d == 1;
			for (int i = 0; i < d; i++)
			{
				int x = ThreadLocalRandom.current().nextInt(10);
				if (!leadingZeroPermitted && x == 0)
				{
					i--;
					continue;
				}
				ip.append(x);
			}

			String address = ip.toString();
			String expected = address.replaceAll("\\.", "[.]");

			if (!VALID_IPV4_REGEX.matcher(address).matches())
			{
				q--;
				continue;
			}

			String s = "MAP.put(\"" + address + "\",\"" + expected + "\");";

			System.out.println(s);
		}
	}
}