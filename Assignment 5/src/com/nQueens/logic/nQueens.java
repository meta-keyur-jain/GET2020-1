package com.nQueens.logic;
/**
 * 
 * @author Rahul
 * 24 January 2020
 * Contains methods for arranging n queens using backtracking
 */

public class nQueens {
	
	//number of queens
	public static int numQueens;
	public static int[][] chessBoard;
	public static void set_values(int num){
		numQueens = num;
		chessBoard = new int[num][num];
	}
	/**
	 * method to check if the cell is attacked or not
	 * @param row : row number of cell
	 * @param col : coloumn number of cell
	 * @return : true if the cell is attacked else false
	 */
	public static boolean isAttack(int row, int col)
	{
		//checking if there is a queen in row or column
		for(int k = 0; k < numQueens; k++)
		{
			if((chessBoard[row][k] == 1) || (chessBoard[k][col] == 1))
				return true;
		}
		//checking if there is a queen in diagonals
		for(int k = 0; k < numQueens; k++)
		{
			for(int p = 0; p < numQueens; p++)
			{
				if(((k + p) == (row + col)) || ((k - p) == (row - col)))
				{
					if(chessBoard[k][p] == 1)
						return true;
				}
			}
		}
		return false;
	}
	/**
	 * method for arranging n queens in a n*n chess board
	 * @param numQ : number of queens to be arranged
	 * @return : true if queens can be arranged
	 */
	public static boolean nQueen(int numQ){
		//if number of queens  is 0, solution found
		if(numQ == 0)
			return true;
		for(int i = 0; i < numQueens; i++){
			for(int j = 0; j < numQueens; j++){
				//checking if we can place a queen here or not
				//queen will not be placed if the place is being attacked or already occupied
				if((!isAttack(i, j)) && (chessBoard[i][j] != 1)){
					chessBoard[i][j] = 1;
					//recursion
					//wether we can put the next queen with this arrangment or not
					if(nQueen(numQ - 1) == true)
					{
						return true;
					}
					chessBoard[i][j] = 0;
				}
			}
		}
		return false;
	}
}

