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

import data.lexicography.words.CsvWordSource;
import data.lexicography.words.WordProvider;
import data.lexicography.words.WordType;
import java.util.Random;

/**
 * @author Administrator
 * @Created 17/09/2025, 23:17 Wed 17 September 2025
 * @Project 3C: Competitive Coding Challenges
 *
 **/
public class PwGenerator
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; ++i)
		{
			threads[i] = new Thread(new PasswordGenerator());
			threads[i].start();
		}

		for (Thread thread : threads)
		{
			thread.join();
		}
	}
}

class PasswordGenerator implements Runnable
{

	private static final int PASSWORD_LENGTH = 128;
	private static final char[] SPACER_CHAR = new char[]{'.',',','/','+','_','-','=','#','@','*','?','^','%','$','&'};

	@Override
	public void run()
	{
		WordProvider wordProvider = WordProvider.builder()
			.addSource(new CsvWordSource(WordType.VERB))
			.addSource(new CsvWordSource(WordType.NOUN))
			.addSource(new CsvWordSource(WordType.ADJECTIVE))
			.addSource(new CsvWordSource(WordType.ADVERB))
			.build();

		StringBuilder sb = new StringBuilder();
		Random r = new Random();

		for (int i = 0; i < 10; ++i)
		{
			while (sb.length() < PASSWORD_LENGTH)
			{
				int option = r.nextInt(3);
				if (option == 0)
				{
					sb.append(wordProvider.query().lengthBetween(0, (PASSWORD_LENGTH - sb.length())).random().get())
						.append(SPACER_CHAR[r.nextInt(SPACER_CHAR.length)]);
				}
				else if (option == 1)
				{
					sb.append(r.nextInt(10));
				}
				else
				{
					sb.append(SPACER_CHAR[r.nextInt(SPACER_CHAR.length)]);
				}
			}

			sb.setLength(PASSWORD_LENGTH);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
