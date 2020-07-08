/*
 * Auther:Lyheang Chiv; Ratanakvial Chhouk; Phouyeang Chung
 */
import java.util.Arrays; //make the Arrays class available
import java.util.Scanner; //make the Scanner class available
import java.util.InputMismatchException; //make the InputMismatchExeception available

public class myQuizChiv_Chung_Chhuk { //class name

		// TODO Auto-generated method stub
		//static variable:
		static Scanner in; 
		static String[] board; 
		static String turn; 

		public static void main(String[] args) { //java main method function
			in = new Scanner(System.in); 
			board = new String[9]; //stores array of 9 strings in static variable board
			turn = "X"; //variable in stores X
			String winner = null; //declare variable winner in string data type and its value is null
			//calling populateEmptyBoard method
			populateEmptyBoard(); //calling populateEmptyBoard
			
			//display
			System.out.println("Welcome to 2 Players Tic Tac Toe.");
			System.out.println("--------------------------------");
			printBoard(); //calling printBoard method
			System.out.println("X's will play first. Enter a slot number to place X in:"); //ask for user input

			while (winner == null) { //check winner
				int numInput; //declare variable numInput in int data type
				try {
					numInput = in.nextInt(); //input value
					if (!(numInput > 0 && numInput <= 9)) { //check if input is smaller than 0 and bigger than 9
						System.out.println("Invalid input; re-enter slot number:"); //print output
						continue; //break iteration, then continue
					}
				} catch (InputMismatchException e) { //import java.util.InputMismatchException;
					System.out.println("Invalid input; re-enter slot number:"); //print output
					continue; //break iteration, then continue
				} 
				
				if (board[numInput-1].equals(String.valueOf(numInput))) { //check if array of inputs of integer change into string
					board[numInput-1] = turn; 
					if (turn.equals("X")) { //check if turn is used to equal to X
						turn = "O"; //turn is O
					} else {
						turn = "X"; //turn is X
					}
					printBoard(); //call printBoard method
					winner = checkWinner(); //call checkWinner method
				} else {
					System.out.println("Slot already taken; re-enter slot number:"); //display output
					continue; //break iteration, then continue
				}
			}
			
			if (winner.equalsIgnoreCase("draw")) { //compares two strings between winner's and draw, ignoring lower case and upper case differences
				System.out.println("Oops, we cannot find the winner! Thanks for playing."); //display output
			} else {
				System.out.println("Yayy! " + winner + "'s have won! Thanks for playing."); //display output
			}
		}
			

		static String checkWinner() { //checkWinner method
			for (int a = 0; a < 8; a++) { //loop to check winner
				String line = null; //declare variable line in string data type, and its value is null
				
				//set up switch statement in below cases of winning logics
				switch (a) { 
				case 0: 
					line = board[0] + board[1] + board[2]; //1 2 3
					break;
				case 1:
					line = board[3] + board[4] + board[5]; //4 5 6
					break;
				case 2:
					line = board[6] + board[7] + board[8]; //7 8 9
					break;
				case 3:
					line = board[0] + board[3] + board[6]; //1 4 7
					break;
				case 4:
					line = board[1] + board[4] + board[7]; //2 5 8
					break;
				case 5:
					line = board[2] + board[5] + board[8]; //3 6 9
					break;
				case 6:
					line = board[0] + board[4] + board[8]; //1 5 9
					break;
				case 7:
					line = board[2] + board[4] + board[6]; //3 5 7
					break;
				}
				if (line.equals("XXX")) { //if the line equals to XXX 
					return "X"; //return X
				} else if (line.equals("OOO")) { //if the line equals to OOO
					return "O"; //return O
				}
			}

			for (int a = 0; a < 9; a++) { 
				if (Arrays.asList(board).contains(String.valueOf(a+1))) { //check if comparing Strings and ints
					break; //break the loop
				}
				else if (a == 8)
					return "draw"; //if user inputs 8 times, and still we cannot find winner
			}

			System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:"); //display output
			return null; //return 
		}

		static void printBoard() { //method to display Board 
			System.out.println(".-----------.");
			System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
			System.out.println("|-----------|");
			System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
			System.out.println("|-----------|");
			System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
			System.out.println(".-----------.");
		}

		static void populateEmptyBoard() { //method to populateEmptyBoard
			for (int a = 0; a < 9; a++) { 
				board[a] = String.valueOf(a+1); 
			}
		}

	}