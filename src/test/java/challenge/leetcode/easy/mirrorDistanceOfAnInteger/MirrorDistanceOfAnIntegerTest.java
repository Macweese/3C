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

package challenge.leetcode.easy.mirrorDistanceOfAnInteger;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 14:11 Mon 13 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3783. Mirror Distance of an Integer")
class MirrorDistanceOfAnIntegerTest
{
	private static final Map<Integer, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(25,27);
		MAP.put(10,9);
		MAP.put(7,0);
		MAP.put(1000000,999999);
		MAP.put(94695149,535500);
		MAP.put(26021297,53190765);
		MAP.put(54198353,18809208);
		MAP.put(10298812,11590389);
		MAP.put(62678991,42691365);
		MAP.put(840028838,1208790);
		MAP.put(147785350,94197609);
		MAP.put(502960285,79108920);
		MAP.put(293326843,55296549);
		MAP.put(324778403,19900980);
		MAP.put(222329303,81593919);
		MAP.put(844633328,21296880);
		MAP.put(549219316,64693629);
		MAP.put(651224127,70198029);
		MAP.put(179267790,81504819);
		MAP.put(786964958,72504729);
		MAP.put(487051854,28901070);
		MAP.put(200515761,33000759);
		MAP.put(443626763,76000419);
		MAP.put(772415968,97098309);
		MAP.put(286331643,59802039);
		MAP.put(740735326,117198279);
		MAP.put(221454601,115000479);
		MAP.put(100074475,474395526);
		MAP.put(566368490,471504825);
		MAP.put(170644023,149802048);
		MAP.put(850038644,403208586);
		MAP.put(544617143,202900698);
		MAP.put(484695298,407901186);
		MAP.put(728045723,400504896);
		MAP.put(556434723,229000068);
		MAP.put(907408324,483603615);
		MAP.put(512462999,486801216);
		MAP.put(808629555,252702747);
		MAP.put(881159493,486208305);
		MAP.put(751758342,507901185);
		MAP.put(967221206,365098437);
		MAP.put(262837954,196900308);
		MAP.put(228018153,123792669);
		MAP.put(292602904,116603388);
		MAP.put(271102238,561098934);
		MAP.put(277538784,210296988);
		MAP.put(361635191,170099028);
		MAP.put(862489411,747505143);
		MAP.put(608991931,469792125);
		MAP.put(402351547,342801657);
		MAP.put(338747685,248000148);
		MAP.put(516214919,403197696);
		MAP.put(566113322,342801657);
		MAP.put(700827825,172099818);
		MAP.put(159925855,398604096);
		MAP.put(956821057,206692398);
		MAP.put(486041869,482098815);
		MAP.put(944155832,705604383);
		MAP.put(525964372,252494847);
		MAP.put(948762466,284494617);
		MAP.put(745290125,224197578);
		MAP.put(956831954,497693295);
		MAP.put(209469338,624495564);
		MAP.put(205725665,360801837);
		MAP.put(610867751,453099735);
		MAP.put(293524437,440900955);
		MAP.put(270593651,114198579);
		MAP.put(607183547,138198159);
		MAP.put(738715405,234197568);
		MAP.put(538825910,519297075);
		MAP.put(185252705,321999876);
		MAP.put(980688621,853802532);
		MAP.put(188801747,558307134);
		MAP.put(925634441,781197912);
		MAP.put(521465196,170098929);
		MAP.put(550731486,133405569);
		MAP.put(758585113,446999256);
		MAP.put(276484328,547000344);
		MAP.put(907545566,241999857);
		MAP.put(727303909,181999818);
		MAP.put(648627599,347099247);
		MAP.put(279367748,568396224);
		MAP.put(999194500,993702501);
		MAP.put(699049359,254891637);
		MAP.put(476152513,160900839);
	}

	@Test
	void mirrorDistance()
	{
		for (Map.Entry<Integer, Integer> entry : MAP.entrySet())
		{
			final int input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = MirrorDistanceOfAnInteger.mirrorDistance(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", input,
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}