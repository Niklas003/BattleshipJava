import java.util.Scanner;
public class PlayersShipSetter {
    int endX;
    int endY;
    int dir;

    Scanner scanner = new Scanner(System.in);
    String[][] PlayerSetShips(int FieldSize, int PlayerNumber){
        String[][] Player1Field = new String[FieldSize][FieldSize];
        for (int i = 0; i < FieldSize; i++) {
            for (int j = 0; j < FieldSize; j++) {
                Player1Field[i][j] = "[ ]";
            }
        }
        for (int i = 2; i < 6; i++) {
            SetShips(Player1Field, FieldSize, i);
        }
        System.out.println("Spieler "+PlayerNumber+" hat seine Schiffe gesetzt. Loesche bitte die Konsole\n -------------------------------");
        return Player1Field;
    }

    void SetShips(String[][] PlayerField, int FieldSize, int Shipsize){
        System.out.println("Setze dein "+Shipsize+"er Schiff");
        System.out.print("Wert X: ");
        int valueX = scanner.nextInt();
        System.out.print("Wert Y: ");
        int valueY = scanner.nextInt();
        System.out.print("Richtung int Input (U, D, L, R) :");
        int direction = scanner.nextInt();
        if (this.CheckIfValidInput(valueX, valueY, direction, Shipsize, PlayerField, FieldSize)){
            this.setShip(direction, PlayerField, valueX, valueY, Shipsize);

            Field PlayersField = new Field();
            PlayersField.printGameField(FieldSize, PlayerField);
        }
        else{
            System.out.println("!!! KONFLIKT !!!");
            SetShips(PlayerField, FieldSize, Shipsize);
        }

    }

    boolean CheckIfValidInput(int valueX,int valueY,int direction, int ShipSize, String[][] PlayerField, int FieldSize){

        switch (direction){
            case 1:
                 endY = valueY - ShipSize-1;
                 dir = -1;
                break;
            case 2:
                 endY = valueY + ShipSize-1;
                 dir = 1;
                break;
            case 3:
                endX = valueX - ShipSize-1;
                dir = -1;
                break;
            case 4:
                endX = valueX + ShipSize-1;
                dir = 1;
                break;
        }
        for (int i = 0; i < ShipSize; i++) {
            if (direction == 1 || direction == 2 && PlayerField[valueY+(i*dir)][valueX] == "[ ]"){
                 continue;
            }
            else if(direction == 3 || direction == 4 && PlayerField[valueY][valueX+(i*dir)] == "[ ]"){
                continue;
            }
            else{
                return false;
            }
        }
        return valueX >=0 && valueX <= FieldSize && valueY >=0 && valueY <= FieldSize && endX >=0 &&
                endX <= FieldSize && endY >=0 && endY <= FieldSize;
    }

    void setShip(int direction, String[][] PlayerField, int valueX, int valueY, int Size){
        switch (direction){
            case 1:
                for (int i = 0; i < Size; i++) {
                    PlayerField[valueY-i][valueX] = "[*]";
                }
                break;
            case 2:
                for (int i = 0; i < Size; i++) {
                    PlayerField[valueY+i][valueX] = "[*]";
                }
                break;
            case 3:
                for (int i = 0; i < Size; i++) {
                    PlayerField[valueY][valueX-i] = "[*]";
                }
                break;
            case 4:
                for (int i = 0; i < Size; i++) {
                    PlayerField[valueY][valueX+i] = "[*]";
                }
                break;
        }
    }
}
