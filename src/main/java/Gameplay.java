import java.util.Scanner;
public class Gameplay {
    Scanner scanner = new Scanner(System.in);
    String[][] GameField1;
    String[][] GameField2;

    int GameSize;
    public Gameplay(String[][] Player1, String[][] Player2, int Size){
        GameField1 = Player1;
        GameField2 = Player2;
        GameSize = Size;
    }
    void PlayerMakeGuess(){
        int player1ShipPoints = 15;
        int player2ShipPoints = 15;
        Field GameFieldOfPlayer1 = new Field();
        Field GameFieldOfPlayer2 = new Field();
        String[][] Player1Field = GameFieldOfPlayer1.setGameField(GameSize);
        String[][] Player2Field = GameFieldOfPlayer2.setGameField(GameSize);

        while(player1ShipPoints != 0 || player2ShipPoints != 0){
            this.Player1MakeGuess(GameField2,Player1Field,GameSize,player2ShipPoints);
            this.Player2MakeGuess(GameField1,Player2Field,GameSize,player1ShipPoints);
        }
        System.out.println("Spiel vorbei");
    }
    int Player1MakeGuess(String[][] GameField,String[][] Field, int Size,int player2ShipPoints){
        System.out.println(" \n Spieler 1 ist dran");
        System.out.print("Rate Wert X: ");
        int guessX = scanner.nextInt();
        System.out.print("Rate Wert Y: ");
        int guessY = scanner.nextInt();

        if (GameField[guessY][guessX] == "[*]"){
            System.out.println("TREFFER");
            GameField[guessY][guessX] = "[#]";
            Field[guessY][guessX] = "[#]";
            Field Player2Field = new Field();
            Player2Field.printGameField(Size, Field);

            Player1MakeGuess(GameField, Field,Size,player2ShipPoints-1);
            return player2ShipPoints;
        }
        else{
            System.out.println("DANEBEN");
            GameField[guessY][guessX] = "[/]";
            Field[guessY][guessX] = "[/]";
            Field Player2Field = new Field();
            Player2Field.printGameField(Size, Field);
            return player2ShipPoints;
        }
    }

    int Player2MakeGuess(String[][] GameField,String[][] Field, int Size,int player1ShipPoints){
        System.out.println(" \n Spieler 2 ist dran");
        System.out.print("Rate Wert X: ");
        int guessX = scanner.nextInt();
        System.out.print("Rate Wert Y: ");
        int guessY = scanner.nextInt();

        if (GameField[guessY][guessX] == "[*]"){
            System.out.println("TREFFER");
            GameField[guessY][guessX] = "[#]";
            Field[guessY][guessX] = "[#]";
            Field Player1Field = new Field();
            Player1Field.printGameField(Size, Field);

            Player1MakeGuess(GameField, Field,Size,player1ShipPoints-1);
            return player1ShipPoints;
        }
        else{
            System.out.println("DANEBEN");
            GameField[guessY][guessX] = "[/]";
            Field[guessY][guessX] = "[/]";
            Field Player2Field = new Field();
            Player2Field.printGameField(Size, Field);
            return player1ShipPoints;
        }
}
}
