public class Main {
    public static void main(String[] args) {
        Main MainObj = new Main();
        MainObj.playFleetBattle();
    }

   public void playFleetBattle(){

        int Size = 10;
        Field GameField = new Field();
        PlayersShipSetter Players = new PlayersShipSetter();

        String[][] Field = GameField.setGameField(Size);
        GameField.printGameField(Size, Field);
        String[][] Player1 = Players.Player1SetShips(Size);
        String[][] Player2 = Players.Player2SetShips(Size);
        Gameplay Game = new Gameplay(Player1, Player2);
        Game.PlayerMakeGuess();

   }
}
//Schiffe versenken