import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class RandomWord {

  public static void main(String [] args){

         int i = 0;
         String champion = "" ;
         while(!StdIn.isEmpty()){
            String str = StdIn.readString();
            String out = "" ;
            i++ ;

            StdOut.println(StdRandom.bernoulli(1/i));
         }

         StdOut.println(champion);

  }

}
