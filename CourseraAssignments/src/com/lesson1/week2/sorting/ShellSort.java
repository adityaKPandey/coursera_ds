package com.lesson1.week2.sorting;

import java.util.Arrays;

/*
  In ith iteration , keep swapping a[i] with each larger entry to its left till no element on its
   left is larger
*/

public class ShellSort<T> implements Sort<T> {

  @Override
  public void sort(T[] array) {

    int n = array.length;
    int h = 1;
    while (h < n / 3) {
      h = h * 3 + 1;
    }

    while (h > 0) {

      for (int i = h; i < n; i++) {
        boolean numeric = array[i] instanceof Double || array[i] instanceof Integer || array[i] instanceof Float;

        for (int j = i ; j >= h; j = j - h) {
          boolean elementOnLeftNeedsSwap = false;
          if (numeric) {
            Double val1 = Double.valueOf(array[j].toString());
            Double val2 = Double.valueOf(array[j-h].toString());
            if (val2 > val1) {
              elementOnLeftNeedsSwap = true;
            }

          } else if (array[j] instanceof String) {
            String val1 = (String) array[j];
            String val2 = (String) array[j-h];
            if (val1.compareTo(val2) < 0) {
              elementOnLeftNeedsSwap = true;
            }
          }

          if (elementOnLeftNeedsSwap) {
            //swap array[j] and array[j-h]
            T temp = array[j];
            array[j] = array[j - h];
            array[j - h] = temp;
          }
        }
      }
      h /= 3;

    }
  }


  public static void main(String[] args) {

    Integer[] input = {4, 9, 1, 2, 0, 3, 8};
    Sort<Integer> shellSort = new ShellSort();
    shellSort.sort(input);

    Arrays.stream(input).forEach(System.out::println);

    System.out.println("-----------------------");
    Float[] inputFloat = {0.0f, -1.5f, 3.5f, 2.2f, -3.5f};
    Sort<Float> shellSortFloat = new ShellSort();
    shellSortFloat.sort(inputFloat);

    Arrays.stream(inputFloat).forEach(System.out::println);


  }


}
