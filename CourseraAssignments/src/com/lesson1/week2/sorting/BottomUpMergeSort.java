package com.lesson1.week2.sorting;

import java.util.Arrays;

/*
  Non recursive version of merge sort
  1. Pass through array merging sub-arrays of size 1
  2. Repeat step 1 for sub-arrays of size 2,4,8,16 etc.



 */
public class BottomUpMergeSort<T> implements Sort<T> {

  @Override
  public void sort(T[] data) {
    mergeSort(data, 0, data.length - 1);
  }

  private void mergeSort(T[] data, int low, int high) {

    int totalSize = high - low + 1;

    for (int size = 1; size <= totalSize; size *= 2) {
      for(int i = 0 ; i+size < totalSize ; i+= 2*size){
             merge(data,i,  (i+2*size-1+i)/2,Math.min(i+2*size-1, high));
             System.out.println("###");
             //Arrays.stream(data).forEach(System.out::println);
      }
    }

  }

  // [low ... mid]   [mid+1 ... high]
  //TODO Merge without aux array
  private void merge(T[] data, int low, int mid, int high) {

    T[] aux = (T[]) new Object[high - low + 1];

    int index = 0, i = low, j = mid + 1;

    while (i <= mid && j <= high) {

      Double val1 = Double.valueOf(data[i].toString());
      Double val2 = Double.valueOf(data[j].toString());

      if (val1 <= val2) {
        aux[index++] = data[i];
        i++;
      } else {
        aux[index++] = data[j];
        j++;
      }
    }

    while (i <= mid) {
      aux[index++] = data[i];
      i++;
    }
    while (j <= high) {
      aux[index++] = data[j];
      j++;
    }

    j = 0;
    for (i = low; i <= high; i++) {
      data[i] = aux[j++];
    }

  }

  public static void main(String[] args) {

    Integer[] input = {4, 9, 1, 2, 0, 3, 8};
    Sort<Integer> sort = new BottomUpMergeSort();
    sort.sort(input);

    Arrays.stream(input).forEach(System.out::println);

    System.out.println("-----------------------");
    Float[] inputFloat = {0.0f, -1.5f, 3.5f, 2.2f, -3.5f};
    Sort<Float> sortFloat = new BottomUpMergeSort();
    sortFloat.sort(inputFloat);

    Arrays.stream(inputFloat).forEach(System.out::println);

    System.out.println("-----------------------");
    Float[] inputFloat2 = {0.0f,  3.5f, 2.2f, -3.5f};
    Sort<Float> sortFloat2 = new BottomUpMergeSort();
    sortFloat.sort(inputFloat2);

    Arrays.stream(inputFloat2).forEach(System.out::println);



  }


}
