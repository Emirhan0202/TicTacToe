public class TicTacToe {
    // Erstellen von Variablen für die Spalten, Reihen und einer 2D Array
    public static final int ROWS = 3;
    public static final int COLUMNS = 3;
    public static String[][] board;


    /**
     * Erstellen einer Konstruktor für das Initialisieren der Spalten und Reihen*/
    public TicTacToe(){
        board = new String[ROWS][COLUMNS];
    }


    /**
     * Initialisieren des Spielbretts
     */
    public void initBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = "   ";
            }
        }
    }


    /**
     * Das Spielbrett auf die Konsole Printen
     */
   public String printBoard() {
        String strBoard = "";
        for (int i =0; i < ROWS; i++){
            for (int j = 0; j < COLUMNS; j++) {
                if (j != COLUMNS - 1)
                    strBoard += board[i][j] + "|";
                else
                    strBoard += board[i][j];
            }
            if (i != COLUMNS - 1){
                strBoard += "\n---+---+---\n";
            }
        }
        return strBoard;
   }


    /**
     * Eine Methode für den Ablauf der Spielvorgang
     **/
   public boolean setPlay(int i, int j, String player){ // i = zeilenindex, j = spaltenindex, player = symbol(x, o)
        if (board[i][j].equals("   ")) {
            board[i][j] = player;
            return true;
        } else {
            System.out.println("Andere Position wählen! ");
        }
       return false;
   }


   /**
    * Regelt welcher Spieler dran ist*/
    public String getPlayer(String player){
       if(player.equals(" X ")){
           player = " O ";
        }
       else if(player.equals(" O ")){
           player = " X ";
       }
        return player;
    }


    /**
     * Überprüft, ob wer Gewonnen hat oder es ein Unentschieden ist*/
    public boolean isGameOver() {
        // Zeile überprüfen
        for (int i = 0; i < ROWS; i++) {
            if (!board[i][0].equals("   ") && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                return true;
            }
        }
        // Spalte überprüfen
        for (int j = 0; j < COLUMNS; j++) {
            if (!board[0][j].equals("   ") && board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j])) {
                return true;
            }
        }
        //Diagonale \ überprüfung
        if (!board[0][0].equals("   ")&& board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])){
            return true;
        }
        //Diagonale / überprüfung
        if (!board[0][2].equals("   ")&& board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])){
        return true;
        }
        return false;
    }
}
