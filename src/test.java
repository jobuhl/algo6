/**
 * Created by Rackenrotz on 13.01.16.
 */
public class test {

    public static void main(String[] args) {

        //System.out.println("Quicksosrt median");
        quicksort a = new quicksort(100);

        //System.out.println("");
        //System.out.println("Quicksort Random");

        //quicksortrandom b = new quicksortrandom(100);


        //System.out.println("");
        System.out.println("Quicksort Random + Insertion");
        quicksortwithinsertion c = new quicksortwithinsertion(100);

        //System.out.println("");
        //System.out.println("Differenz: " + (b.count - c.count));

    }

}
