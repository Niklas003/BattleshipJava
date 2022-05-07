import java.util.Scanner;
public class Gameplay {
    Scanner scanner = new Scanner(System.in);
    String[][] GameField1;
    String[][] GameField2;
    public Gameplay(String[][] Player1, String[][] Player2){
        GameField1 = Player1;
        GameField2 = Player2;
    }
    void PlayerMakeGuess(){
        int player1ShipPoints = 15;
        int player2ShipPoints = 15;
        while(player1ShipPoints != 0 || player2ShipPoints != 0){
            this.Player1MakeGuess(GameField2,player2ShipPoints);
            this.Player2MakeGuess(GameField1, player1ShipPoints);
        }
        System.out.println("Spiel vorbei");
    }
    int Player1MakeGuess(String[][] GameField, int player2ShipPoints){
        System.out.println(" \n Spieler 1 ist dran");
        System.out.print("Rate Wert X: ");
        int guessX = scanner.nextInt();
        System.out.print("Rate Wert Y: ");
        int guessY = scanner.nextInt();

        if (GameField[guessY][guessX] == "[*]"){
            System.out.println("TREFFER");
            GameField[guessY][guessX] = "[#]";
            Player1MakeGuess(GameField, player2ShipPoints-1);
            return player2ShipPoints;
        }
        else{
            System.out.println("DANEBEN");
            GameField[guessY][guessX] = "[/]";
            return player2ShipPoints;
        }
    }

    int Player2MakeGuess(String[][] GameField, int player1ShipPoints){
        System.out.println(" \n Spieler 2 ist dran");
        System.out.print("Rate Wert X: ");
        int guessX = scanner.nextInt();
        System.out.print("Rate Wert Y: ");
        int guessY = scanner.nextInt();

        if(GameField[guessY][guessX] == "[*]"){
            System.out.println("TREFFER");
            GameField[guessY][guessX] = "[#]";
            Player2MakeGuess(GameField, player1ShipPoints-1);
            return player1ShipPoints;
        }
        else{
            System.out.println("DANEBEN");
            GameField[guessY][guessX] = "[/]";
            return player1ShipPoints;
        }
    }
}
