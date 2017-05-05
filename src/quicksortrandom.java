/**
 * Created by Rackenrotz on 13.01.16.
 */
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Rackenrotz on 13.01.16.
 */
public class quicksortrandom {


    int count;

    //Liste für Börsenkurse mit namen
    StockTick[] array;

    //Liste mit Namen
    String[] name = {"IBM", "CSCO", "HPQ", "GOOG", "ORCL", "GPRO", "BABA", "AAPL", "SAP", "MSFT"};


    //Konstruktor mit wert eingabe
    public quicksortrandom(int array) {
        this.array = new StockTick[array];
        fillArray();
    }

    //füllt den Array mit Zufallszahlen und Zufallsnamen
    private void fillArray() {
        System.out.println("Kurs" + "     " + "Name");

        System.out.println("-------------");

        for (int i = 0; i < array.length; i++) {
            //Wählt zufällig aus welcher Firmenname benutzt werden soll
            int var1 = (int) (Math.random() * 10);
            //Wählt zufälllig einen Kurs zwischen 60 und 70
            int var2 = (int) (Math.random() * 11 + 60);
            //Array wird gefüllt mit beiden zufallswerten
            array[i] = new StockTick(name[var1], var2);
        }
        //Aufruf der allgemeinen Sortier Methode

        for (int i = 0; i < array.length ; i++) {

            System.out.println(array[i].getKurs() + "       " +array[i].getSymbol());


        }

        quickSort(0,array.length-1);

        System.out.println();
        for (int k = 0; k < array.length ; k++) {

            System.out.println(array[k].getKurs() + "       " +array[k].getSymbol());


        }

        System.out.println("Bewegungen:     " + count );
    }


    public void quickSort(int left, int right){

        Random rand = new Random();
        int randi = rand.nextInt(right-left) + left;
        StockTick pivot = array[randi];
        System.out.println("Pivautelement =" + randi);
        int i = left;
        int j = right;

        // --- Partition ---

        while( i <= j){

            while(array[i].getKurs() < pivot.getKurs())

                i++;



            while (array[j].getKurs() > pivot.getKurs())
                j--;


            if (i <= j){

                swap(i,j);
                i++;
                j--;

            }



        } // es gilt nun i > j

        // ---- Rekursiion ----

        if (left < j) {
            quickSort(left, j);
        }

        if (i < right){

            quickSort(i, right);

        }



    }

    private void swap(int i, int j){

        StockTick swap1 = array[i];
        array[i] = array[j];
        array[j] = swap1;

        count = count+3;

    }




}

