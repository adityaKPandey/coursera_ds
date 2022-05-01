package com.lesson1.week2;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {

  public static void main(String[] args){


     int k = Integer.parseInt(args[0]);

     RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
     System.out.println("Enter strings , enter -1 to stop");
     String input ;


     do{
       input  = StdIn.readString();
       if(!"-1".equals(input))
         randomizedQueue.enqueue(input);

     }while(!"-1".equals(input));


     randomizedQueue.print(k);
     System.out.println("-------");
     randomizedQueue.print(k);
     System.out.println("-------");
     randomizedQueue.print(k);


  }

}
