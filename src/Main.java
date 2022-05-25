import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.initBoard();
        String player = " O ";
        System.out.println(game.printBoard());
        while (true) {
            int row = getRow();
            int column = getColumn();
            player = game.getPlayer(player);

            if(game.setPlay(row, column, player)){
                System.out.println(game.printBoard());
            }
            else{
                player = game.getPlayer(player);
            }
            if (game.isGameOver() == true){
                System.out.println(player + "gewinnt !");
                break;
            }
        }
    }


    public static int getRow(){
        Scanner sc1 = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Gebe die Reihe an: ");
                String input = sc1.nextLine();
                int row = checkStringNumeric(input);
                if (row >= 0 && row <= TicTacToe.ROWS - 1) {
                    return row;
                } else {
                    System.out.println("Versuche es nochmal, ungültiger wert !");
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
    }


    public static int getColumn(){
        Scanner sc1 = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Gebe die Spalte an: ");
                String input = sc1.nextLine();
                int column = checkStringNumeric(input);
                if (column >= 0 && column <= TicTacToe.COLUMNS - 1) {
                    return column;
                } else {
                    System.out.println("Versuche es nochmal, ungültiger wert !");
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static int checkStringNumeric(String input) {
        int num;
        try {
            if (input == null){
                return -1;
            }
            num = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return -1;
        }
        return num;
    }
}
