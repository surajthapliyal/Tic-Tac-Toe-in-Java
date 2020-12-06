import java.util.*;

public class main_file {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char board[][] = {{' ','|',' ','|',' '},
                            {'-','+','-','+','-'},
                            {' ','|',' ','|',' '},
                            {'-','+','-','+','-'},
                            {' ','|',' ','|',' ' }};
        printBoard(board);
        System.out.print("Enter your character choice (X \\ O) = ");
        char ch = sc.next().charAt(0);
        if(ch == 'X' || ch == 'O'){
            System.out.print("Enter your placement (1-9) = ");
            int place = sc.nextInt();
            doPlacement(place,ch,board);
            printBoard(board);
        }else{
            System.out.println("Invalid character choice !!");
        }
    }
    static void printBoard(char[][] board){
        for (char[] row : board) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
    static void doPlacement(int place,char ch,char[][] board){
        switch (place) {
            case 1:
                board[0][0] = ch;
                break;
            case 2:
                board[0][2] = ch;
                break;
            case 3:
                board[0][4] = ch;
                break;
            case 4:
                board[2][0] = ch;
                break;
            case 5:
                board[2][2] = ch;
                break;
            case 6:
                board[2][4] = ch;
                break;
            case 7:
                board[4][0] = ch;
                break;
            case 8:
                board[4][2] = ch;
                break;
            case 9:
                board[4][4] = ch;
                break;
            default: 
                System.out.println("Invalid Choice!! , please enter place again.");
                break;
        }
    }
}
