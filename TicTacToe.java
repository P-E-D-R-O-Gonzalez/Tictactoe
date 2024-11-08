public class TicTacToe
{
    private static String[][] board = new String[3][3];
    private static int turn = 0;
    // constructor
    TicTacToe()
    {
        for(int r = 0; r<board.length;r++)
        {
            for(int c = 0; c < board.length; c++)
            {
                board[r][c] = "-";
            }
        }
    }
    //this method returns the current turn
    public static int getTurn()
    {
       return turn;
    }
    
    public static String[][] getBoard()
    {
        return board;    
    }
    
    //This method prints out the board array on to the console
    public static void printBoard()
    {
        String[][] tempBoard = board;
        System.out.println("\nrows \n↑\n↓ 0 1 2\t columns ←→");
        for(int r = 0; r<board.length;r++)
        {
            System.out.print(r + " ");
            for(int c = 0; c<board.length;c++)
            {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
   
    //This method returns true if space row, col is a valid space
    public static boolean pickLocation(int row, int col)
    {
        String[][] tempBoard = board;
        if((row < board.length && col < board[row].length) && (board[row][col].equals("-")))
        {
            return true;
        }
        return false;
    }
   
    //This method places an X or O at location row,col based on the int turn
    public static void takeTurn(int row, int col)
    {
        String[][] tempBoard = board;
        if(getTurn()%2==0)
        {
            board[row][col] = "X";
        }
        else
        {
            board[row][col] = "O";
        }
        //turn++;
    }
   
    public static void turnUp()
    {
        turn++;
    }
    //This method returns a boolean that returns true if a row has three X or O's in a row
    public static boolean checkRow()
    {
        String[][] tempBoard = board;
        for(int r = 0; r<board.length;r++)
        {
            int xCount = 0;
            int oCount = 0;
            for(int c = 0; c<board.length;c++)
            {
                if(board[r][c].equals("X"))
                {
                    xCount++;
                }
                if(board[r][c].equals("O"))
                {
                   oCount++;
                }
            }
            if(oCount == 3 || xCount == 3)
            {
                return true;
            }
        }
        return false;
    }
   
    //This method returns a boolean that returns true if a col has three X or O's
    public static boolean checkCol()
    {
        String[][] tempBoard = board;
       for(int r = 0; r<board.length;r++)
        {
            int xCount = 0;
            int oCount = 0;
            for(int c = 0; c<board.length;c++)
            {
                if(board[c][r].equals("X"))
                {
                    xCount++;
                }
                if(board[c][r].equals("O"))
                {
                   oCount++;
                }
            }
            if(oCount == 3 || xCount == 3)
            {
                return true;
            }
        }
        return false;
    }
   
    //This method returns a boolean that returns true if either diagonal has three X or O's
    public static boolean checkDiag1()
    {
        String[][] tempBoard = board;
        int xCount = 0;
        int oCount = 0;
        for(int across = 0; across<board.length;across++)
        {
            if(board[across][across].equals("X"))
            {
                xCount++;
            }
            else if(board[across][across].equals("O"))
            {
                oCount++;    
            }
        }
        if(xCount == 3 || oCount == 3)
        {
            return true;    
        }
        return false;
    }
   
    public static boolean checkDiag2()
    {
        String[][] tempBoard = board;
        int xCount = 0;
        int oCount = 0;
        int i = 0;
        for(int across = 2; across<0;across--)
        {
            if(board[across][i].equals("X"))
            {
                xCount++;
            }
            else if(board[across][i].equals("O"))
            {
                oCount++;    
            }
            i++;
        }
        if(xCount == 3 || oCount == 3)
        {
            return true;    
        }
        return false;
    }
    //This method returns a boolean that checks if someone has won the game
    public static boolean checkWin()
    {
        String[][] tempBoard = board;
        if(checkCol() == true || checkRow() == true || checkDiag1() == true || checkDiag2() == true)
        {
           return true;
        }
        return false;
    }

    // checks for draw
    public static boolean isDraw()
    {
      String[][] tempBoard = board;
      int count = 0;
      for(int r =0;r<tempBoard.length;r++)
      {
        for(int c = 0; c<tempBoard[r].length;c++)
        {
          if(tempBoard[r][c] != "-" && checkWin()==false)
          {
            count++;
          }
        }
      }
      if(count == 9)
      {
        return true;
      }
      return false;
    }
}