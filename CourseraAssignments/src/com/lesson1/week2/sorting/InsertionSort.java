package com.lesson1.week2.sorting;

import java.util.Arrays;

/*
  In ith iteration , keep swapping a[i] with each larger entry to its left till no element on its
   left is larger
*/

public class InsertionSort<T> implements Sort<T>{

  @Override
  public void sort(T [] array){

    int n = array.length;

    for(int i = 0 ; i < n  ; i++){


      boolean numeric = array[i] instanceof  Double || array[i] instanceof Integer || array[i] instanceof Float ;
      for(int j = i-1 ; j > -1 ; j--){

        boolean elementOnLeftNeedsSwap = false;
        if(numeric) {
          Double val1 = Double.valueOf(array[j+1].toString());
          Double val2 = Double.valueOf(array[j].toString());
          if(val2 > val1)
            elementOnLeftNeedsSwap = true;

        }else if(array[j+1] instanceof String) {
          String val1 = (String) array[j+1];
          String val2 = (String) array[j];
          if (val1.compareTo(val2) < 0)
            elementOnLeftNeedsSwap = true;
        }

       if(elementOnLeftNeedsSwap){
         //swap array[j] and array[j+1]
         T temp = array[j];
         array[j] = array[j+1];
         array[j+1] = temp;
       }


      }


    }
  }


  public static void main(String [] args){

    Integer [] input = {4,9,1,2,0,3,8} ;
    Sort<Integer> insertionSort = new InsertionSort<>();
    insertionSort.sort(input);

    Arrays.stream(input).forEach(System.out :: println);

    System.out.println("-----------------------");
    Float [] inputFloat = {0.0f , -1.5f , 3.5f , 2.2f , -3.5f} ;
    Sort<Float> insertionSortFloat = new InsertionSort();
    insertionSortFloat.sort(inputFloat);

    Arrays.stream(inputFloat).forEach(System.out :: println);


  }


}
