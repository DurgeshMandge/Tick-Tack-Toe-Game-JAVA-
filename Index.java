import java.util.Scanner;


public class Index{

    public static void main(String[] args) {

        int choise=1;
        int Oscore=0, Xscore=0;

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
                System.out.print("Enter Player " + player + " ->");
                int input=sc.nextInt();
                int row=-1,col=-1;
                if(input<10 && input>0){
                    row=convert(input)[0]; col=convert(input)[1];           		//taking inputs


                    if ( matrix[row][col] != 'O' && matrix[row][col] != 'X' ){

                        matrix[row][col]=player;                             		//adding in matrix

                        gameOver=isGameOver(matrix) || hasWon(matrix,player);               //check for gameOver

                        if(hasWon(matrix, player)){
                            displayBoard(matrix);
                            if(player=='O'){Oscore++;}else{Xscore++;}
                            System.out.println();
                            System.out.println("Congratulations Player "+player+" has won the game!!");System.out.println();
                        }
                        if(isGameOver(matrix)){
                            System.out.println("The game is tied.");System.out.println();
                        }
                        if(gameOver){
                            System.out.println("Scores: ");
                            System.out.println("Player O: "+Oscore+" Player X: "+Xscore);System.out.println();
                        }

                        player=(player=='O')?'X':'O';                        		//changing player

                    }else{
                        System.out.println("Already filled try another block");		//check for duplicate entry
                    }
                }else{
                    System.out.println("Please Enter Values Between 1-9");
                }

            }

            System.out.println("Press 1 to next round 0 to exit");
            choise=sc.nextInt();                     
        }

        System.out.println();
        System.out.println("Thank You");
    }

	//Checking whether any player has won the match after the move
	
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
	
	//Cheacking whether the game is over when there is no space remaining for input

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

	//Coverting the user inputs from numeric to co-ordinates(row,col)
	//eg. 1=(0,0) , 5=(1,2) , 9=(2,2)
	
    private static int[] convert(int n){
        int row=-1,col;
        int mod=n%3;
        if(mod==1){
            col=0;
        }else if (mod==2) {
            col=1;
        } else {
            col=2;
        }
        while(n>0){
            n-=3;
            row++;
        }
        return new int[]{row,col};
    }

	//printing the Board consisting of matrix of inputs
	
    private static void displayBoard(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.print("| ");
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
