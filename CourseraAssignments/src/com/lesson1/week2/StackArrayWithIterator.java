package com.lesson1.week2;

import java.lang.reflect.Array;
import java.util.Iterator;

public class StackArrayWithIterator<T> implements Iterable{

  private T [] data;
  private int size;
  private int top;

  public StackArrayWithIterator(int size){
    this.size = size;
    this.top = -1;
    //this.data = (T[])Array.newInstance(StackWithArrayResize.class , size) ;
    this.data = (T[]) new Object [size] ;
  }

  public boolean isEmpty(){
    return top == -1;
  }

  private void resizeOnPush(){
    System.out.println("Resizing stack array before push");
    int newSize = size*2 ;
    //T [] resizedArray = (T[]) Array.newInstance(StackWithArrayResize.class , newSize) ;

    T [] resizedArray =  (T[]) new Object [newSize] ;
    for(int i = 0 ; i < top+1 ; i++){
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

    if(newSize == 0)
      newSize = 1;

    //T [] resizedArray = (T[]) Array.newInstance(StackWithArrayResize.class , newSize) ;

    T [] resizedArray =  (T[]) new Object [newSize] ;

    for(int i = 0 ; i <= top ; i++){
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


  @Override
  public Iterator iterator() {
    return new StackIterator();
  }

  private class StackIterator implements  Iterator{

    private int index = top;

    @Override
    public boolean hasNext() {
      return index > -1;
    }

    @Override
    public Object next() {
      return data[index--];
    }
  }
}
