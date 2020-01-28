package com.nQueens.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nQueens.logic.nQueens;
/**
 * Test methods for n queens problem
 * @author Rahul
 * Created 24 January 2020
 */
public class nQueensTest {

	@Test
	public void TestForFourQueens() {
		int n = 4;
		nQueens.set_values(n);
		boolean res = nQueens.nQueen(n);
		assertEquals(res, true);
		assert2DArrayEquals(nQueens.chessBoard, new int[][]{{0, 1, 0, 0},
				{0, 0, 0, 1},
				{1, 0, 0, 0},
				{0, 0, 1, 0}});
	}
	
	@Test
	public void TestForEightQueens() {
		int n = 8;
		nQueens.set_values(n);
		boolean res = nQueens.nQueen(n);
		assertEquals(res , true);
		assert2DArrayEquals(nQueens.chessBoard, new int[][]{{1, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1},
				{0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 1, 0},
				{0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0, 0}});

	}
	
	private void assert2DArrayEquals(int[][] board, int[][] result) {
		int boardRows = board.length;
		int resultRows = result.length;

		assertEquals(boardRows, resultRows);

		for(int i = 0; i < boardRows; i++){
			assertArrayEquals(board[i] , result[i]);
		}
	}
}
