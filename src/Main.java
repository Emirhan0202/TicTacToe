import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.initBoard();
        String player = " O ";
        System.out.println(game.printBoard());

        // Eine State Maschine für Durchführen des gesamten Spiels bis Spielende
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

    /**
     * Eine Methode für die Eingabe der Reihe auf dem Spielfeld
     */
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


    /**
     * Eine Methode für die Eingabe der Spalte auf dem Spielfeld
     */
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


    /**
     * Überprüft das eingegebene auf einem Zahl(String) und wandelt es zu einem Integer
     */
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
