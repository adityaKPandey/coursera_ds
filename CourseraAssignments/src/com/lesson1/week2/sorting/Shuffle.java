package com.lesson1.week2.sorting;

import java.util.Arrays;
import java.util.Random;

public class Shuffle<T> {

  private void shuffle(T[] array) {

    int n = array.length;

    Random random = new Random();

    for (int i = 0; i < n; i++) {

      int randomIndex = random.nextInt(i + 1);

      //swap a[i] and a[randomIndex]
      T temp = array[i];
      array[i] = array[randomIndex];
      array[randomIndex] = temp;

    }

  }

  public void print(T[] array) {
    System.out.println("---------------------");
    Arrays.stream(array).forEach(System.out::println);
  }


  public static void main(String[] args) {

    Shuffle shuffle = new Shuffle();
    Integer[] array = {1, 2, 3, 4, 5};
    shuffle.shuffle(array);
    shuffle.print(array);

    shuffle.shuffle(array);
    shuffle.print(array);

    shuffle.shuffle(array);
    shuffle.print(array);

    shuffle.shuffle(array);
    shuffle.print(array);


  }


}
