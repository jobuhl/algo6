/**
 * Created by Rackenrotz on 13.01.16.
 */

import java.util.Random;

/**
 * Created by Rackenrotz on 13.01.16.
 */
public class quicksortwithinsertion {

    int counter;

    int count;
    //Liste für Börsenkurse mit namen
    StockTick[] array;

    //Liste mit Namen
    String[] name = {"IBM", "CSCO", "HPQ", "GOOG", "ORCL", "GPRO", "BABA", "AAPL", "SAP", "MSFT"};


    //Konstruktor mit wert eingabe
    public quicksortwithinsertion(int array) {
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
/*
       for (int i = 0; i < array.length; i++) {

            System.out.println(array[i].getKurs() + "       " + array[i].getSymbol());


        }
*/
        quickSort(0, array.length - 1);

  //      System.out.println();
        for (int k = 0; k < array.length; k++) {

            System.out.println(array[k].getKurs() + "       " + array[k].getSymbol());

        }

        System.out.println("Bewegungen:     " + count);
        System.out.println("Bewegungen:     " + counter);


    }


    public void quickSort(int left, int right) {

        if ((right - left) <= 5) {

            insertion(left, right);

        } else {

            StockTick pivot = array[(left + right) / 2];
            int i = left;
            int j = right;

            // --- Partition ---

            while (i <= j) {

                while (array[i].getKurs() < pivot.getKurs())

                    i++;


                while (pivot.getKurs() < array[j].getKurs())
                    j--;


                if (i <= j) {

                    swap(i, j);
                    i++;
                    j--;

                }


            } // es gilt nun i > j

            // ---- Rekursiion ----

            if (left <= j) {
                quickSort(left, j);
            }

            if (i <= right) {

                quickSort(i, right);

            }

        }


    }



    private void swap(int i, int j) {

        StockTick swap1 = array[i];
        array[i] = array[j];
        array[j] = swap1;

        count = count + 3;

    }

    public void insertion(int left, int right) {

        int i;
        int j;
        StockTick x;
        for (i = left + 1; i <= right; i++) {

            //Merkt sich den Verlgeichswert
            x = array[i];
            //variable zum zwischenspeichern
            j = i;



            //Führt so lange eine vertauschung durch, bis kein größeres Element mehr davor steht
            while (j > 0 && x.getKurs() < array[j - 1].getKurs()) {


                array[j] = array[j - 1];
                j--;

                counter++;

            }
            array[j] = x;





        }
        //Stellt sicher das die Sortierung stabil ist
    }
}
