
import java.util.Scanner;

public class Main {
	
	public static Scanner reader;
	
    public static void main(String[] args) {
    	
    	reader = new Scanner(System.in);
    	System.out.println("Welcome to the boxes game! :)\n");
    	System.out.println("Type the amount of columns of the board.");
    	int columns = reader.nextInt();
    	
    	System.out.println("Type the amount of rows of the board.");
    	int rows = reader.nextInt();
    	
    	System.out.println("Type the name of player #1");
    	String p1 = reader.next();
    	
    	System.out.println("Type the name of player #2");
    	String p2 = reader.next();
    	
    	Board board = new Board(columns, rows);
    	board.addPlayerToBoard(p1);
    	board.addPlayerToBoard(p2);
    	
    	boolean runFlag = true;

		while (runFlag) {

			System.out.println("What do you want to do?");
	    	System.out.println("1) Throw the dice. \n2) See board. \n0) Exit.");
	    	int decision = reader.nextInt();

			switch (decision){

				case 1:
					System.out.println(board.play());
				break;

				case 2:
					System.out.println(board.print());
				break;

				case 0:
					System.out.println("Thank you for playing! Have a good one :).");
					runFlag = false;
				break;

				default:
					System.out.println("\nPlease, type a valid option.\n");
				break;
			} // switch
		} // while
    } // main
}
