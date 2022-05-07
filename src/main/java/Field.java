public class Field {

    String[][] setGameField(int size){
     String[][] Field = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Field[i][j] = "[ ]";
            }

        }
     return Field;
    }

    void printGameField(int size, String[][] Field){

        System.out.println(" ");
        System.out.println("----- BATTLESHIP JAVA EDT. -----");
        for (int i = 0; i < size; i++) {
            System.out.print(" "+i+" ");
        }
        System.out.println(" ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(Field[i][j]);
            }
            System.out.println(" "+ i);
        }
        System.out.println("----------Legenge----------");
        System.out.println("[ ] Feld noch nicht entdeckt");
        System.out.println("[#] Feld mit Treffer");
        System.out.println("[/] Feld ohne Treffer");
    }
}
