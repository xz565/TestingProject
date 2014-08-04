package lcojtest;

import static org.junit.Assert.assertEquals;
import lcoj.recursive.WordSearch;

import org.junit.Test;

public class WordSearchTest {

	@Test
	public void test() {

		char[][] board = {
							{'A', 'B', 'C', 'E'}, 
							{'S', 'F', 'C', 'S'}, 
							{'A', 'D', 'E', 'E'}
						};

		assertEquals(WordSearch.exist(board, "ABCCED"), true);
	}
	
	@Test
	public void test2() {

		char[][] board = {
							{'A', 'B', 'C', 'E'}, 
							{'S', 'F', 'C', 'S'}, 
							{'A', 'D', 'E', 'E'}
						};

		assertEquals(WordSearch.exist(board, "SEE"), true);
	}
	
	@Test
	public void test3() {

		char[][] board = {
							{'A', 'B', 'C', 'E'}, 
							{'S', 'F', 'C', 'S'}, 
							{'A', 'D', 'E', 'E'}
						};

		assertEquals(WordSearch.exist(board, "ABCB"), false);
	}

}
