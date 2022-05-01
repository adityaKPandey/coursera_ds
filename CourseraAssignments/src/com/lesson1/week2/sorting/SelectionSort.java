package com.lesson1.week2.sorting;

import java.util.Arrays;

/*
  In ith iteration , find index m of smallest entry in array a [] , among all a[j] such that j >= i
*/

public class SelectionSort<T> implements Sort<T>{

  @Override
  public void sort(T [] array){

    int n = array.length;

    for(int i = 0 ; i < n - 1 ; i++){

      int minIndex = findMinElementIndex(array,i);

      //swap array[minIndex] and array[i]
      T temp = array[minIndex];
      array[minIndex] = array[i];
      array[i] = temp;

    }
  }

  int findMinElementIndex(T [] array , int index){
    int minIndex = index ;
    for(int i = index+1 ; i < array.length ; i++){
      if(array[i] instanceof  Double || array[i] instanceof Integer || array[i] instanceof Float){
         Double val1 = Double.valueOf(array[i].toString());
         Double val2 = Double.valueOf(array[minIndex].toString());
         if(val1 < val2)
           minIndex = i;

      }else if(array[i] instanceof String){
         String val1 = (String) array[i] ;
         String val2 = (String) array[minIndex];
         if(val1.compareTo(val2) < 0)
           minIndex = i;
      }
    }
    return minIndex;
  }

  public static void main(String [] args){

    Integer [] input = {4,9,1,2,0,3,8} ;
    Sort<Integer> selectionSort = new SelectionSort();
    selectionSort.sort(input);

    Arrays.stream(input).forEach(System.out :: println);

    System.out.println("-----------------------");
    Float [] inputFloat = {0.0f , -1.5f , 3.5f , 2.2f , -3.5f} ;
    Sort<Float> selectionSortFloat = new SelectionSort();
    selectionSortFloat.sort(inputFloat);

    Arrays.stream(inputFloat).forEach(System.out :: println);


  }


}
