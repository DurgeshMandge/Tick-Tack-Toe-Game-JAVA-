import java.util.Scanner;

public class Index{

    static char[][] matrix=new char[3][3];
    static boolean gameOver;
    static char player='O';
    public static void main(String[] args) {

        // initial
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("   !!! THE TICK TACK TOE GAME !!!");System.out.println();
        while (!gameOver){
            
            displayBoard(matrix);
            System.out.println("Enter Player " + player + " ->");
            int row=sc.nextInt()-1;int col=sc.nextInt()-1;           //taking inputs

            if(matrix[row][col]!='O' || matrix[row][col]!='X'){
                matrix[row][col]=player;                                //adding in matrix
            }else{
                System.out.println("Already filled try another block");
            }

            gameOver=isGameOver(matrix) || hasWon(player);          //check for gameOver
            if(hasWon(player)){
                System.out.println("Congratulations Player "+player+" has won the game!!");
            }

            player=(player=='O')?'X':'O';                           //changing player
        }
    
    }

    private static boolean hasWon(char player) {
        return false;
    }

    private static boolean isGameOver(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }

    private static void displayBoard(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " | ");
            }
            System.out.println();
        }
    }
}