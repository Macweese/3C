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

package challenge.leetcode.easy.restoreFinishingOrder;

import challenge.leetcode.easy.restoreFinishingOrder.RestoreFinishingOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.DataUtils;
import utils.IntArraySpec;

@DisplayName("3668. Restore Finishing Order")
class RestoreFinishingOrderTest
{
	private static final Triple[] TRIPLES = new ImmutableTriple[]{
		new ImmutableTriple(new int[]{1}, new int[]{1}, new int[]{1}),
		new ImmutableTriple(new int[]{2,3,1}, new int[]{2}, new int[]{2}),
		new ImmutableTriple(new int[]{1,2}, new int[]{1,2}, new int[]{1,2}),
		new ImmutableTriple(new int[]{2,1,3,4}, new int[]{2}, new int[]{2}),
		new ImmutableTriple(new int[]{2,1}, new int[]{1,2}, new int[]{2,1}),
		new ImmutableTriple(new int[]{4,2,3,1}, new int[]{3}, new int[]{3}),
		new ImmutableTriple(new int[]{2,3,4,5,1}, new int[]{2}, new int[]{2}),
		new ImmutableTriple(new int[]{1,3,2}, new int[]{1,2,3}, new int[]{1,3,2}),
		new ImmutableTriple(new int[]{2,3,1}, new int[]{1,2,3}, new int[]{2,3,1}),
		new ImmutableTriple(new int[]{1,2,3}, new int[]{1,2,3}, new int[]{1,2,3}),
		new ImmutableTriple(new int[]{2,1,3}, new int[]{1,2,3}, new int[]{2,1,3}),
		new ImmutableTriple(new int[]{2,4,3,1}, new int[]{2,3,4}, new int[]{2,4,3}),
		new ImmutableTriple(new int[]{2,5,1,4,3}, new int[]{1,2,4}, new int[]{2,1,4}),
		new ImmutableTriple(new int[]{7,1,4,5,3,2,6}, new int[]{2,3}, new int[]{3,2}),
		new ImmutableTriple(new int[]{6,1,4,5,3,2}, new int[]{1,4,5}, new int[]{1,4,5}),
		new ImmutableTriple(new int[]{3,9,5,6,10,7,8,2,4,1}, new int[]{4,5}, new int[]{5,4}),
		new ImmutableTriple(new int[]{2,1,5,7,6,4,8,9,3}, new int[]{2,5,9}, new int[]{2,5,9}),
		new ImmutableTriple(new int[]{6,5,7,3,9,4,8,2,1}, new int[]{3,4,9}, new int[]{3,9,4}),
		new ImmutableTriple(new int[]{12,3,6,11,1,4,2,13,10,8,5,9,7}, new int[]{1}, new int[]{1}),
		new ImmutableTriple(new int[]{5,3,4,1,6,2}, new int[]{1,2,3,4,5,6}, new int[]{5,3,4,1,6,2}),
		new ImmutableTriple(new int[]{4,5,3,2,6,1}, new int[]{1,2,3,4,5,6}, new int[]{4,5,3,2,6,1}),
		new ImmutableTriple(new int[]{4,1,2,5,3,6}, new int[]{1,2,3,4,5,6}, new int[]{4,1,2,5,3,6}),
		new ImmutableTriple(new int[]{5,2,4,3,6,1}, new int[]{1,2,3,4,5,6}, new int[]{5,2,4,3,6,1}),
		new ImmutableTriple(new int[]{5,1,4,6,2,3}, new int[]{1,2,3,4,5,6}, new int[]{5,1,4,6,2,3}),
		new ImmutableTriple(new int[]{2,3,12,13,1,11,10,4,7,8,5,6,9}, new int[]{7,9}, new int[]{7,9}),
		new ImmutableTriple(new int[]{6,8,7,5,12,4,3,10,9,2,11,1}, new int[]{5,6,7}, new int[]{6,7,5}),
		new ImmutableTriple(new int[]{4,7,3,6,1,5,2}, new int[]{1,2,3,4,5,6,7}, new int[]{4,7,3,6,1,5,2}),
		new ImmutableTriple(new int[]{6,2,3,4,7,5,1}, new int[]{1,2,3,4,5,6,7}, new int[]{6,2,3,4,7,5,1}),
		new ImmutableTriple(new int[]{7,12,3,14,9,1,11,6,2,13,5,10,4,8}, new int[]{5,13}, new int[]{13,5}),
		new ImmutableTriple(new int[]{5,10,4,3,7,2,8,6,1,9}, new int[]{1,3,4,5,8,9}, new int[]{5,4,3,8,1,9}),
		new ImmutableTriple(new int[]{16,7,3,15,9,4,12,8,5,6,1,10,14,2,11,13}, new int[]{11}, new int[]{11}),
		new ImmutableTriple(new int[]{5,2,7,9,8,6,4,1,10,3}, new int[]{2,3,5,8,9,10}, new int[]{5,2,9,8,10,3}),
		new ImmutableTriple(new int[]{1,4,2,8,7,5,6,3}, new int[]{1,2,3,4,5,6,7,8}, new int[]{1,4,2,8,7,5,6,3}),
		new ImmutableTriple(new int[]{2,13,11,7,8,1,4,14,6,10,3,9,12,5}, new int[]{1,3,5,8}, new int[]{8,1,3,5}),
		new ImmutableTriple(new int[]{6,8,3,12,11,4,13,1,9,5,2,15,16,7,14,10}, new int[]{13,15}, new int[]{13,15}),
		new ImmutableTriple(new int[]{7,3,1,8,9,10,2,14,4,15,13,17,18,11,16,5,6,12}, new int[]{11}, new int[]{11}),
		new ImmutableTriple(new int[]{4,10,7,6,5,9,3,2,8,11,1}, new int[]{2,3,4,5,6,7,10}, new int[]{4,10,7,6,5,3,2}),
		new ImmutableTriple(new int[]{10,5,11,9,2,1,4,6,7,8,3}, new int[]{1,2,3,6,9,10,11}, new int[]{10,11,9,2,1,6,3}),
		new ImmutableTriple(new int[]{12,18,9,13,2,5,7,6,14,15,10,17,16,11,8,3,4,1}, new int[]{6,8,9}, new int[]{9,6,8}),
		new ImmutableTriple(new int[]{15,13,4,3,5,11,1,18,7,2,10,6,16,8,9,17,14,12}, new int[]{3,6,18}, new int[]{3,18,6}),
		new ImmutableTriple(new int[]{9,10,7,17,8,11,16,12,13,3,2,1,18,5,15,6,4,14,19}, new int[]{11,18}, new int[]{11,18}),
		new ImmutableTriple(new int[]{2,18,4,3,13,22,12,6,1,8,9,10,19,14,11,5,17,7,16,15,21,20}, new int[]{19}, new int[]{19}),
		new ImmutableTriple(new int[]{10,1,14,11,5,8,12,6,13,3,9,18,17,4,16,2,7,15}, new int[]{1,5,6,12}, new int[]{1,5,12,6}),
		new ImmutableTriple(new int[]{2,19,20,16,3,5,8,17,6,23,10,21,1,18,12,14,7,4,9,11,13,22,15}, new int[]{9}, new int[]{9}),
		new ImmutableTriple(new int[]{18,12,7,5,1,22,3,13,9,6,16,21,17,8,20,14,2,11,10,19,15,4}, new int[]{11,18}, new int[]{18,11}),
		new ImmutableTriple(new int[]{3,21,15,6,5,7,8,19,1,22,14,24,16,20,4,18,17,11,2,13,12,9,23,10}, new int[]{10}, new int[]{10}),
		new ImmutableTriple(new int[]{3,5,10,13,15,11,7,8,12,1,14,9,2,4,6}, new int[]{2,7,8,11,12,14,15}, new int[]{15,11,7,8,12,14,2}),
		new ImmutableTriple(new int[]{14,19,6,22,11,15,10,3,21,1,13,9,18,17,5,20,16,23,2,7,8,4,12}, new int[]{3,7,9}, new int[]{3,9,7}),
		new ImmutableTriple(new int[]{9,4,11,16,8,13,7,15,10,2,1,14,3,5,6,12}, new int[]{2,7,8,10,11,14,16}, new int[]{11,16,8,7,10,2,14}),
		new ImmutableTriple(new int[]{1,3,8,14,9,12,4,2,10,16,13,15,11,6,17,5,7}, new int[]{2,4,6,8,10,12,13}, new int[]{8,12,4,2,10,13,6}),
		new ImmutableTriple(new int[]{23,4,14,2,13,3,22,12,20,11,15,18,5,17,7,8,16,10,9,21,19,6,1}, new int[]{3,12,21}, new int[]{3,12,21}),
		new ImmutableTriple(new int[]{16,8,17,15,6,11,18,14,4,1,7,19,9,2,5,13,12,10,3}, new int[]{3,5,6,8,9,12,15}, new int[]{8,15,6,9,5,12,3}),
		new ImmutableTriple(new int[]{5,10,27,22,14,17,24,3,19,16,25,23,8,7,9,18,20,11,6,2,1,26,21,4,15,13,28,12,29}, new int[]{9,24}, new int[]{24,9}),
		new ImmutableTriple(new int[]{4,10,23,11,14,24,5,19,15,22,12,13,1,9,8,2,20,16,3,21,17,6,18,7}, new int[]{2,5,7,8,9,16}, new int[]{5,9,8,2,16,7}),
		new ImmutableTriple(new int[]{15,9,3,21,12,1,2,5,6,10,17,13,7,11,14,19,4,8,16,22,18,20}, new int[]{2,3,11,12,18,20}, new int[]{3,12,2,11,18,20}),
		new ImmutableTriple(new int[]{17,9,19,21,5,20,10,18,6,2,15,8,4,7,13,11,3,12,16,1,14}, new int[]{6,7,8,9,14,16,20,21}, new int[]{9,21,20,6,8,7,16,14}),
		new ImmutableTriple(new int[]{18,2,24,3,1,21,14,10,6,13,5,19,7,23,22,16,20,11,9,25,8,4,15,17,12}, new int[]{8,14,19,23,25}, new int[]{14,19,23,25,8}),
		new ImmutableTriple(new int[]{9,29,25,6,13,1,3,24,16,15,17,4,27,11,28,19,12,22,10,2,20,18,23,21,8,5,26,14,7}, new int[]{24,28,29}, new int[]{29,24,28}),
		new ImmutableTriple(new int[]{16,10,19,8,3,18,5,7,9,22,23,4,20,2,1,13,15,21,11,6,14,12,17}, new int[]{2,4,6,7,8,9,15,22}, new int[]{8,7,9,22,4,2,15,6}),
		new ImmutableTriple(new int[]{3,8,7,25,31,9,20,28,33,18,4,21,30,32,13,11,2,26,23,6,14,10,1,34,22,16,19,24,12,5,29,27,17,15}, new int[]{12}, new int[]{12}),
		new ImmutableTriple(new int[]{4,17,8,16,25,19,21,2,3,6,24,7,12,10,1,5,14,20,22,9,11,23,13,18,15}, new int[]{3,8,12,15,18,20,24}, new int[]{8,3,24,12,20,18,15}),
		new ImmutableTriple(new int[]{25,3,1,24,21,4,20,29,2,19,22,26,18,16,15,17,5,27,13,14,9,6,11,7,8,12,10,23,28}, new int[]{2,5,12,18,22}, new int[]{2,22,18,5,12}),
		new ImmutableTriple(new int[]{7,23,26,28,17,10,24,5,14,27,20,12,15,18,8,21,2,25,3,4,16,9,6,22,19,11,1,13}, new int[]{4,5,6,11,17,19}, new int[]{17,5,4,6,19,11}),
		new ImmutableTriple(new int[]{6,13,29,9,7,25,1,35,17,24,4,8,10,12,16,2,5,32,31,14,11,22,19,34,28,18,36,27,30,23,3,33,21,26,15,20}, new int[]{12}, new int[]{12}),
		new ImmutableTriple(new int[]{11,21,23,24,14,13,10,8,19,25,15,12,3,22,4,7,17,16,27,20,26,5,6,9,2,1,18}, new int[]{2,12,16,17,18,23}, new int[]{23,12,17,16,2,18}),
		new ImmutableTriple(new int[]{12,24,17,3,11,23,27,31,2,4,19,5,26,7,13,8,18,6,20,10,15,22,30,32,21,9,28,16,25,1,29,14}, new int[]{1,4,7,10,17}, new int[]{17,4,7,10,1}),
		new ImmutableTriple(new int[]{6,13,21,31,4,28,3,34,8,35,9,14,10,15,2,17,20,7,30,24,19,5,29,32,18,16,12,11,23,1,22,27,33,26,25}, new int[]{9,11,29}, new int[]{9,29,11}),
		new ImmutableTriple(new int[]{30,20,1,14,26,4,21,15,11,8,3,13,12,10,23,24,34,32,28,19,6,18,33,2,25,31,7,5,17,27,16,22,29,9}, new int[]{8,14,20,21,27}, new int[]{20,14,21,8,27}),
		new ImmutableTriple(new int[]{16,27,12,1,13,6,30,31,29,22,2,14,21,20,33,19,28,26,5,18,11,25,8,7,15,24,10,32,17,23,4,3,34,9}, new int[]{2,3,12,18,24,32}, new int[]{12,2,18,24,32,3}),
		new ImmutableTriple(new int[]{14,15,9,31,33,6,24,7,30,12,19,5,4,27,20,10,22,28,2,11,17,25,26,32,29,21,8,3,13,18,34,16,1,23}, new int[]{1,7,10,15,28,33}, new int[]{15,33,7,10,28,1}),
		new ImmutableTriple(new int[]{14,5,36,27,32,38,22,3,29,15,33,17,35,30,1,10,25,39,13,23,31,20,16,12,7,18,2,8,6,34,4,19,28,21,26,24,11,37,9}, new int[]{21,25,37}, new int[]{25,21,37}),
		new ImmutableTriple(new int[]{20,7,19,24,13,12,21,28,23,9,16,30,29,8,10,27,14,4,3,32,2,17,18,34,25,5,1,11,26,6,22,33,15,31}, new int[]{6,7,21,24,25,26,33}, new int[]{7,24,21,25,26,6,33}),
		new ImmutableTriple(new int[]{10,7,42,22,24,49,45,17,41,44,33,13,6,50,46,15,12,21,30,1,9,11,2,39,20,29,27,36,32,48,19,8,43,25,4,26,28,47,34,14,37,40,35,38,5,18,31,3,16,23}, new int[]{4}, new int[]{4}),
		new ImmutableTriple(new int[]{5,32,23,47,21,20,10,31,16,4,18,11,6,14,33,7,19,3,8,40,39,43,46,9,44,22,13,36,30,37,17,29,12,26,1,35,41,2,45,25,42,34,28,15,27,38,24}, new int[]{18,23,27}, new int[]{23,18,27}),
		new ImmutableTriple(new int[]{23,11,45,34,28,49,5,17,12,18,13,22,27,44,6,10,46,48,40,42,14,1,3,39,43,31,29,15,32,4,7,19,33,9,41,24,20,38,16,26,35,37,25,21,36,8,2,47,30}, new int[]{13,15}, new int[]{13,15}),
		new ImmutableTriple(new int[]{3,44,19,40,9,5,33,10,21,48,34,31,28,43,24,46,17,22,37,36,32,25,11,42,50,29,45,20,14,27,7,13,4,18,16,30,41,38,2,39,49,23,47,1,6,12,15,8,26,35}, new int[]{12,29}, new int[]{29,12}),
		new ImmutableTriple(new int[]{39,51,16,32,45,36,27,6,22,5,35,38,29,46,47,33,50,23,1,54,8,52,31,25,42,49,11,7,40,48,41,30,14,24,15,37,44,10,26,4,13,28,21,12,53,2,19,3,17,9,20,43,34,18}, new int[]{8,11,17}, new int[]{8,11,17}),
		new ImmutableTriple(new int[]{10,19,24,27,39,42,46,20,41,32,22,25,7,43,44,38,1,31,37,18,34,6,30,40,45,50,14,5,12,17,21,26,16,33,3,35,36,49,2,48,13,9,11,15,29,8,47,23,28,4}, new int[]{22,23,33,39,45}, new int[]{39,22,45,33,23}),
		new ImmutableTriple(new int[]{49,5,32,52,4,53,3,20,11,25,29,22,36,27,43,14,45,17,2,19,24,39,21,10,46,38,34,18,35,48,13,44,23,8,6,33,7,54,51,37,15,50,47,42,16,41,55,40,12,31,26,9,28,1,30}, new int[]{7,20,49,50}, new int[]{49,20,7,50}),
		new ImmutableTriple(new int[]{53,39,42,9,27,21,20,48,13,31,35,7,24,5,58,22,47,4,50,45,1,30,59,41,43,38,61,56,6,25,33,23,51,54,12,29,60,28,32,15,2,3,40,46,10,16,55,26,18,17,44,36,57,49,37,34,8,14,52,11,19}, new int[]{20}, new int[]{20}),
		new ImmutableTriple(new int[]{45,36,27,25,37,50,41,46,1,20,24,39,47,7,31,42,22,13,8,26,4,10,19,15,11,2,14,29,32,9,53,17,52,18,54,5,3,38,51,23,12,16,33,49,34,6,44,30,21,43,48,35,40,28}, new int[]{1,13,18,26,34}, new int[]{1,13,26,18,34}),
		new ImmutableTriple(new int[]{9,20,38,7,8,16,6,33,35,5,17,3,42,21,55,22,1,45,50,14,58,29,10,24,59,48,32,18,51,53,12,27,11,57,43,37,52,49,41,13,62,56,46,60,47,15,25,61,19,26,23,44,34,2,4,39,31,54,28,40,30,36}, new int[]{35}, new int[]{35}),
		new ImmutableTriple(new int[]{41,9,45,20,38,18,12,5,57,8,22,56,6,46,25,31,47,17,11,58,50,28,60,7,44,34,61,40,29,23,53,32,42,14,55,24,21,52,37,35,59,48,43,16,2,3,39,27,15,49,19,62,13,33,54,10,26,1,4,51,30,36}, new int[]{12,32}, new int[]{12,32}),
		new ImmutableTriple(new int[]{23,37,33,41,44,17,35,29,40,5,16,46,31,39,7,18,38,21,25,50,63,48,53,30,60,56,43,66,9,28,22,19,58,27,34,61,54,51,12,11,2,6,1,13,20,3,4,47,8,32,45,59,26,42,10,64,14,62,24,49,57,52,15,55,65,36}, new int[]{15}, new int[]{15}),
		new ImmutableTriple(new int[]{25,1,46,15,27,14,22,55,6,8,12,2,49,48,45,11,40,31,33,58,5,39,7,41,36,28,35,51,43,56,18,4,32,30,16,47,21,17,44,19,53,24,9,13,61,50,29,34,52,3,20,57,38,60,26,10,59,54,37,23,42}, new int[]{8,12,17,48}, new int[]{8,12,48,17}),
		new ImmutableTriple(new int[]{47,59,16,37,17,3,57,15,55,46,50,63,13,22,12,52,33,11,28,6,31,9,23,44,10,35,42,40,56,29,30,64,60,32,48,4,34,1,45,39,62,25,41,51,58,24,26,49,18,2,65,8,43,38,27,36,5,20,14,53,19,61,54,7,21}, new int[]{18,48}, new int[]{48,18}),
		new ImmutableTriple(new int[]{19,44,46,1,50,39,24,23,26,47,33,54,32,11,4,42,55,43,17,38,14,37,6,29,9,21,15,22,49,18,36,34,31,7,28,13,52,51,8,53,27,12,3,10,41,20,45,40,25,35,5,16,48,2,30}, new int[]{1,9,14,19,29,35,41,55}, new int[]{19,1,55,14,29,9,41,35}),
		new ImmutableTriple(new int[]{28,55,33,38,21,26,52,58,42,44,57,32,17,47,18,16,24,6,53,5,45,31,40,9,41,34,23,50,7,39,27,1,35,8,15,10,46,56,51,11,22,30,4,14,54,43,3,59,12,13,19,36,48,29,49,20,25,60,37,2}, new int[]{7,12,35,41,42,43,47}, new int[]{42,47,41,7,35,43,12}),
		new ImmutableTriple(new int[]{32,36,2,25,53,27,7,8,23,41,24,9,29,10,15,40,47,44,5,42,31,28,14,43,57,51,11,33,56,39,12,17,55,58,37,35,26,18,22,20,52,3,38,21,16,54,4,6,34,48,1,13,45,30,46,49,19,50}, new int[]{13,17,22,25,26,27,40,45}, new int[]{25,27,40,17,26,22,13,45}),
		new ImmutableTriple(new int[]{37,29,1,36,9,23,16,32,13,57,8,41,15,49,40,10,4,30,55,2,6,27,14,47,39,33,46,20,11,48,22,54,21,26,7,44,45,35,38,18,28,59,53,58,5,31,19,43,52,3,12,17,24,50,51,42,56,25,34}, new int[]{8,14,19,23,27,28,29,54}, new int[]{29,23,8,27,14,54,28,19}),
		new ImmutableTriple(new int[]{37,19,17,8,30,70,60,46,33,65,54,2,20,39,49,23,31,34,41,43,32,38,48,21,42,53,40,4,14,56,3,28,52,25,68,36,1,15,16,59,55,67,5,18,27,50,22,44,69,66,24,9,45,64,51,29,6,10,61,12,63,11,47,13,7,26,58,35,62,57}, new int[]{43,53,57}, new int[]{43,53,57}),
		new ImmutableTriple(new int[]{13,54,18,17,42,32,39,3,4,52,50,5,56,53,2,14,37,29,40,25,64,51,43,35,38,31,34,63,47,60,45,12,59,21,19,44,30,62,24,8,7,36,28,46,9,16,26,58,11,41,27,57,22,20,61,49,6,15,33,1,48,55,23,10}, new int[]{7,15,23,27,45,50,55}, new int[]{50,45,7,27,15,55,23}),
		new ImmutableTriple(new int[]{44,27,53,58,55,40,17,33,6,38,24,37,47,5,49,4,62,56,70,67,74,46,7,1,9,11,72,10,31,48,15,73,36,51,26,68,60,30,32,12,21,71,69,35,23,52,13,14,25,50,19,63,16,8,41,18,45,57,61,29,34,39,64,28,20,43,22,65,54,66,3,59,2,42}, new int[]{2,43,56,64,65,66,74}, new int[]{56,74,64,43,65,66,2}),
		new ImmutableTriple(new int[]{15,35,39,48,45,5,44,1,42,36,23,25,67,59,72,29,41,74,38,75,50,9,18,55,19,49,6,47,17,22,40,14,77,65,61,13,68,60,26,76,51,64,12,73,58,11,28,27,63,31,71,30,69,21,3,34,2,16,4,78,32,46,7,52,20,43,56,79,70,62,57,54,37,24,33,10,53,8,66}, new int[]{6,19,22,23,54,57,62}, new int[]{23,19,6,22,62,57,54}),
	};

	@Test
	void recoverOrder()
	{
		String message;

		for (Triple<int[], int[], int[]> triple : TRIPLES)
		{
			final int[] order = triple.getLeft();
			final int[] friends = triple.getMiddle();
			final int[] expected = triple.getRight();
			final int[] actual = RestoreFinishingOrder.recoverOrder(order, friends);

			message = "Test failed for case: \nOrder  : " + Arrays.toString(order) + "Friends : " + Arrays.toString(friends)
				+ "\nExpected: " + Arrays.toString(expected)
				+ "\n  Actual: " + Arrays.toString(actual);

			assertArrayEquals(expected, actual, message);
		}
	}

	private static void generateTests()
	{
		Random r = new Random();
		for (int i = 0; i < 100; i++)
		{
			int[] order = DataUtils.generateArray(IntArraySpec.builder(100).fixedSize().lowerBound(1).build());

			int friendsSize = Math.min(r.nextInt(1, 9), order.length);
			int[] friends;
			Set<Integer> set = new HashSet<>();

			while (set.size() < friendsSize)
			{
				set.add(order[r.nextInt(order.length)]);
			}

			friends = set.stream().sorted().mapToInt(Integer::intValue).toArray();

			final String o = Arrays.toString(order).replaceAll("[\\[\\] ]", "");
			final String f = Arrays.toString(friends).replaceAll("[\\[\\] ]", "");
			final String e = Arrays.toString(recoverOrder(order, friends)).replaceAll("[\\[\\] ]", "");
			System.out.printf("new ImmutableTriple(new int[]{%s},new int[]{%s},new int[]{%s}),%n", o, f, e);
		}
	}

	public static int[] recoverOrder(int[] order, int[] friends)
	{
		List<Integer> result = new ArrayList<>();
		for (int id : order)
		{
			for (int f : friends)
			{
				if (id == f)
				{
					result.add(f);
					break;
				}
			}
		}
		return result.stream().mapToInt(i -> i).toArray();
	}
}