package aop1;

import java.util.Scanner;
import java.util.Random;


public class TicTacToe {

	public static void main(String[] args) {
		
		//take input from user
		Scanner scanner = new Scanner(System.in);	
		
		//create an 2D array 
		//want 3 rows with 3 char a piece for grid 
		char [][] board = {{' ', ' ', ' '},  
				           {' ', ' ', ' '},
				           {' ', ' ', ' '}}; 
		
			printBoard(board);
			
			//need to call a method to say who won and when the game is over 
			
			while (true) {
			playerTurn(board, scanner);  
			if (isGameFinished(board)){
				break;
			}
			printBoard(board);
						
			//create a turn for the computer and pick a random number 
			computerTurn(board);
			if (isGameFinished(board)) {
			break;
			}
			printBoard(board);
		}
			//scanner.close();
	}

	private static boolean isGameFinished(char[][] board) {
		
		//write a method for a winner for both player and computer 
			if (hasContestantWon(board, 'X')) {
				printBoard(board);
				System.out.println("Player wins!");
				return true;
			}
			
			if (hasContestantWon(board, 'O')) {
				printBoard(board);
				System.out.println("Computer wins!");
				return true;
			}
	
		
		//write a check to see if the board is full 
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		printBoard(board);
		System.out.println("The game ended in a tie!");
		return true;
		
		
	}

	private static boolean hasContestantWon(char[][] board, char symbol) {
		    if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
				(board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
				(board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
				
				(board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
				(board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
				(board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
				
				(board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
				(board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
				return true;
          }
		return false;
	}

	private static void computerTurn(char[][] board) {
		Random rand = new Random();
		int computerTurn; 
		while (true) {
			computerTurn = rand.nextInt(9) + 1; 
			if (isValidMove(board, Integer.toString(computerTurn))) {
			break;
		}
} 
//tell computer to place move to play move for the computer
placeMove(board, Integer.toString(computerTurn), 'O');
	}
	
	//need to add a check to see if spot is taken or not
	private static boolean isValidMove (char[][] board, String position) {
		switch(position) {
		case "1":
			return (board[0][0] == ' ');
		case "2":
			return (board[0][1] == ' ');
		case "3":
			return (board[0][2] == ' '); 
		case "4":
			return (board[1][0] == ' '); 
		case "5":
			return (board[1][1] == ' ');
		case "6":
			return (board[1][2] == ' ');
		case "7":
			return (board[2][0] == ' ');
		case "8":
			return (board[2][1] == ' ');	
		case "9":
			return (board[2][2] == ' ');
		default:
			return false;
		}
	}
	
	//create own method to call on for whenever we want to call on a player to take a turn 
	private static void playerTurn(char[][] board, Scanner scanner) {
		String userInput;
		//make sure to check for a valid move 
		while (true) {
			//prompt user 
			System.out.println("Where would you like to play? (1-9)");
			userInput = scanner.nextLine();
			if (isValidMove(board, userInput)){
				break;
			} else {
				System.out.println(userInput + "is not a valid move");
			}
		}
		//want to place their statement into the spot where player wants it to go 
		//must include breaks whenever switch statements 
		placeMove(board, userInput, 'X');
		
	}

		//method will be used for both comp and player 
	private static void placeMove(char[][] board, String position, char symbol) {
		switch(position) {
		case "1":
			board[0][0] = symbol;
			break;
		case "2":
			board[0][1] = symbol;
			break;
		case "3":
			board[0][2] = symbol;
			break;
		case "4":
			board[1][0] = symbol;
			break;
		case "5":
			board[1][1] = symbol;
			break;
		case "6":
			board[1][2] = symbol;
			break;
		case "7":
			board[2][0] = symbol;
			break;
		case "8":
			board[2][1] = symbol;
			break;
		case "9":
			board[2][2] = symbol;
			break;
		default:
			System.out.println("You must input 1-9 only");
		}
	}
	
	//create a call method to call it whenever needed 
	private static void printBoard(char[][] board) {
		//first row
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2] );
		//separator
		System.out.println("-+-+-");
		//second row
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2] );
		//separator
		System.out.println("-+-+-");
		//third row 
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2] );
	}
}
	
