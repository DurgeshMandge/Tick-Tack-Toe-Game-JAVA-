import java.util.Scanner;


public class Index{

    public static void main(String[] args) {

        int choise=1;

        while(choise==1){

	    //initializing matrix, player, game etc.
            char[][] matrix=new char[3][3];
            boolean gameOver=false;
            char player='O';

            // initial head
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("   !!! THE TICK TACK TOE GAME !!!");System.out.println();

            while (!gameOver){

                displayBoard(matrix);
                System.out.println("Enter Player " + player + " ->");
                int row=sc.nextInt()-1;int col=sc.nextInt()-1;           		//taking inputs


                if(matrix[row][col]!='O' && matrix[row][col]!='X'){

                    matrix[row][col]=player;                             		//adding in matrix

                    gameOver=isGameOver(matrix) || hasWon(matrix,player);               //check for gameOver

                    if(hasWon(matrix, player)){
                        System.out.println("Congratulations Player "+player+" has won the game!!");
                    }

                    player=(player=='O')?'X':'O';                        		//changing player

                }else{
                    System.out.println("Already filled try another block");		//check for duplicate entry
                }

                displayBoard(matrix);
            }

            System.out.println("Press 1 to next round 0 to exit");
            choise=sc.nextInt();                     
        }

        System.out.println();
        System.out.println("Thank You");
    }

    private static boolean hasWon(char[][] matrix, char player) {

        for (int i = 0; i < 3; i++) {
            if ( matrix[i][0]==player && matrix[i][1]==player && matrix[i][2]==player ){		//check for row
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if ( matrix[0][i]==player && matrix[1][i]==player && matrix[2][i]==player ){		//check for col
                return true;
            }
        }

        if ( matrix[0][0]==player && matrix[1][1]==player && matrix[2][2]==player ){
            return true;			
        }												//check for diagonal
        if ( matrix[0][2]==player && matrix[1][1]==player && matrix[2][0]==player ){
            return true;
        }

        return false;
    }

    private static boolean isGameOver(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]=='\0'){                     						//check for empty char
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
