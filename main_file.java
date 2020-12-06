import java.util.*;

public class main_file {
    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();
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
            while(true){
                System.out.print("\n\nEnter your placement (1-9) = ");
                int place = sc.nextInt();
                while(playerPositions.contains(place) || cpuPositions.contains(place)){
                    System.out.println("Position already taken!! enter another ..");
                    System.out.print("Enter your placement (1-9) = ");
                    place = sc.nextInt();
                }
                playerPositions.add(place);
                doPlacement(place,ch,board);
                printBoard(board);
                checkWinner(board);

                Random rand = new Random();
                char cpuCh;
                if(ch == 'X') cpuCh ='O';
                else cpuCh = 'X';
                int cpuPos = rand.nextInt(9) + 1;
                while(cpuPositions.contains(cpuPos) || playerPositions.contains(cpuPos)){
                    cpuPos = rand.nextInt(9) + 1;
                }
                cpuPositions.add(cpuPos);
                doPlacement(cpuPos,cpuCh,board);
                System.out.println("\nAfter Cpu turn : ");
                printBoard(board);

                checkWinner(board);
            }
        }else{
            System.out.println("Invalid character choice !!");
        }
        sc.close();
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
    static void checkWinner(char[][] board){
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList( 2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> diag1 = Arrays.asList(1, 5, 9);
        List<Integer> diag2 = Arrays.asList(7, 5, 3);
        
        List<List<Integer>> conditions = new ArrayList<>();
        conditions.add(topRow);
        conditions.add(midRow);
        conditions.add(botRow);
        conditions.add(leftCol);
        conditions.add(midCol);
        conditions.add(rightCol);
        conditions.add(diag1);
        conditions.add(diag2);

        for(List<Integer> l : conditions){
            if(playerPositions.containsAll(l)) {
                System.out.println("!!!!Congratulations you won!!!!");
                System.exit(1);
            }
            else if(cpuPositions.containsAll(l)) {
                System.out.println("You Loose , Better Luck Next Time :)");
                System.exit(1);
            }
            else if(playerPositions.size()+cpuPositions.size() == 9) {
                System.out.println("Its a Tie XD!!");
                System.exit(1);
            }
        }
    }
}
