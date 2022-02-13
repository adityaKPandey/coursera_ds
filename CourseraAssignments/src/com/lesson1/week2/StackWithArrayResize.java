package com.lesson1.week2;

import java.lang.reflect.Array;

public class StackWithArrayResize<T> {

  private T [] data;
  private int size;
  private int top;

  public StackWithArrayResize(int size){
    this.size = size;
    this.top = -1;
    this.data = (T[])Array.newInstance(StackWithArrayResize.class , size) ;
  }

  public boolean isEmpty(){
    return top == -1;
  }

  private void resizeOnPush(){
    System.out.println("Resizing stack array before push");
    int newSize = size*2 ;
    T [] resizedArray = (T[]) Array.newInstance(StackWithArrayResize.class , newSize) ;

    for(int i = 0 ; i < size ; i++){
      resizedArray[i] = data[i];
    }

    data = resizedArray;
    size = newSize ;
  }


  public void push(T element){
    if(size == top + 1)
      resizeOnPush();

    data[++top] = element;
  }

  private void resizeOnPop(){

     System.out.println("Resizing stack array on pop");
     int newSize = size/2 ;

     T [] resizedArray = (T[]) Array.newInstance(StackWithArrayResize.class , newSize) ;

     for(int i = 0 ; i < size ; i++){
       resizedArray[i] = data[i];
     }

     data = resizedArray;
     size = newSize ;

  }

  public T pop(){

     if(!isEmpty()){
       T element = data[top--] ;
       if(top <= size/4){
         resizeOnPop();
       }
       return element ;
     }
     return null;

  }


}
