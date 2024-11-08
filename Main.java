import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        TicTacToe game = new TicTacToe();
        TicTacToe.printBoard();   
        while(TicTacToe.checkWin()==false)
        {
            // scanner object
            Scanner input = new Scanner(System.in);
            // user prompt
            System.out.println("Enter the row: ");
            int row = input.nextInt();
            System.out.println("Enter the column: ");
            int col = input.nextInt();
            // validation
            if(TicTacToe.pickLocation(row,col)==true)
            {
                TicTacToe.takeTurn(row,col);
            }
            else
            {
                // correcting incorrect validation
                System.out.println("Invalid Index\n");
                System.out.println("Enter the row: ");
                row = input.nextInt();
                System.out.println("Enter the column: ");
                col = input.nextInt();
                // reverifing
                if(TicTacToe.pickLocation(row,col)==true)
                {
                    TicTacToe.takeTurn(row,col);
                }
            }
            TicTacToe.printBoard();   
            // checking for winner
            if(TicTacToe.checkWin()==false)
            {
                if(TicTacToe.isDraw()==true)
                {
                  System.out.println("DRAW");
                  break;
                }
                else
                {
                  TicTacToe.turnUp();    
                }
            }
            else
            {
                if(TicTacToe.getTurn()%2==1)
                {
                    System.out.println("Player Two won");
                }
                else
                {
                    System.out.println("Player One won");
                }
            }
        }
    }
}