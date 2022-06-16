public class Main {
    public static void main(String[] args) {
        Main MainObj = new Main();
        MainObj.playFleetBattle();
    }

   public void playFleetBattle(){

        Field GameField = new Field();
        PlayersShipSetter Players = new PlayersShipSetter();
        TextManager Text = new TextManager();

        Text.WelcomeMessage();
        int Size = GameField.RequestFieldSize();
        String[][] Field = GameField.setGameField(Size);
        GameField.printGameField(Size, Field);
        String[][] Player1Field = Players.PlayerSetShips(Size, 1);
        String[][] Player2Field = Players.PlayerSetShips(Size, 2);
        Gameplay Game = new Gameplay(Player1Field, Player2Field, Size);
        Game.PlayerMakeGuess();


   }

}
//Heute wollen wir Fische ertränken ähh...Schiffe versenken.