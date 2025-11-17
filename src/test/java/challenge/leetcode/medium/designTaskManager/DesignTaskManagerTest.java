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

package challenge.leetcode.medium.designTaskManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("3408. Design Task Manager")
class DesignTaskManagerTest
{

	private static List<Integer> triple(int userId, int taskId, int priority) {
		return Arrays.asList(userId, taskId, priority);
	}

	@Test
	@DisplayName("Constructor seeds initial tasks and executeTop returns highest priority, then tie-break by highest taskId")
	void constructorAndBasicExecuteOrder() {
		List<List<Integer>> init = Arrays.asList(
			triple(1, 1, 2),
			triple(1, 3, 3),
			triple(1, 4, 10),
			triple(1, 5, 10),
			triple(2, 2, 20),
			triple(2, 6, 5),
			triple(2, 7, 10),
			triple(2, 8, 10)
		);

		TaskManager tm = new TaskManager(init);

		// Highest priority is 20 -> taskId 2 belongs to user 2
		assertEquals(2, tm.execTop());

		// Next highest is priority 10; tie among {4,5,7,8}; highest taskId is 8 -> user 2
		assertEquals(2, tm.execTop());

		// Follow-up sanity: still has items
		assertNotEquals(-1, tm.execTop());
	}

	@Test
	@DisplayName("add: Tasks with same priority execute by highest taskId first")
	void addAndTieBreakOnTaskId() {
		TaskManager tm = new TaskManager(Collections.emptyList());

		tm.add(1, 1, 10);
		tm.add(2, 2, 10);
		tm.add(3, 3, 10);

		assertEquals(3, tm.execTop()); // taskId 3 highest -> user 3
		assertEquals(2, tm.execTop()); // then taskId 2 -> user 2
		assertEquals(1, tm.execTop()); // then taskId 1 -> user 1
		assertEquals(-1, tm.execTop()); // now empty
	}

	@Test
	@DisplayName("edit: Increasing a task's priority should reorder it to the top")
	void editRaisesPriority() {
		TaskManager tm = new TaskManager(Collections.emptyList());

		tm.add(1, 101, 5);
		tm.add(2, 202, 10);

		// Raise task 101 above the current max
		tm.edit(101, 15);

		assertEquals(1, tm.execTop()); // task 101 now on top
		assertEquals(2, tm.execTop()); // then task 202
		assertEquals(-1, tm.execTop());
	}

	@Test
	@DisplayName("edit: Changing to a tie keeps highest taskId first")
	void editToTieKeepsHighestTaskIdFirst() {
		TaskManager tm = new TaskManager(Collections.emptyList());

		tm.add(1, 11, 12);
		tm.add(2, 22, 10);

		// Lower task 11 to tie at 10; highest taskId is 22, so user 2 should execute first
		tm.edit(11, 10);

		assertEquals(2, tm.execTop()); // taskId 22 first
		assertEquals(1, tm.execTop()); // then taskId 11
		assertEquals(-1, tm.execTop());
	}

	@Test
	@DisplayName("remove: Removed task should not be executed")
	void removeSkipsTask() {
		TaskManager tm = new TaskManager(Collections.emptyList());

		tm.add(1, 900, 100);
		tm.add(2, 800, 90);

		tm.rmv(900); // remove the highest-priority task

		assertEquals(2, tm.execTop()); // next highest is user 2's task
		assertEquals(-1, tm.execTop()); // now empty
	}

	@Test
	@DisplayName("executeTop on empty returns -1")
	void executeTopOnEmpty() {
		TaskManager tm = new TaskManager(Collections.emptyList());
		assertEquals(-1, tm.execTop());
	}

}