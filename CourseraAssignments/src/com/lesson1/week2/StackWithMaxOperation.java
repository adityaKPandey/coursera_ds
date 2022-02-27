package com.lesson1.week2;

import edu.princeton.cs.algs4.In;
import java.lang.reflect.Array;
import java.util.Objects;

public class StackWithMaxOperation<T> {

  private StackArrayWithIterator stack;
  private T max ;

  public StackWithMaxOperation(int size){
    this.stack = new StackArrayWithIterator(size);
    this.max = null ;
  }

  public void push(T newVal) {

    if (Objects.isNull(max)){
      max = newVal ;
      stack.push(newVal);
      return;
    }
    if(newVal instanceof Double  || newVal instanceof Float) {
      Double doubleMax = (Double) max;
      Double doubleNewVal = (Double) newVal;
      if (doubleNewVal > doubleMax){
        stack.push(doubleMax - doubleNewVal);
        max = newVal;
      }else
        stack.push(newVal);
    }

  }

  public T pop(){
    T popped = (T) stack.pop();

    if(Objects.nonNull(popped))
    if(popped instanceof Double || popped instanceof Integer || popped instanceof Float){
       Double doublePopped = (Double) popped ;
       Double doubleMax = (Double) max;
       if(doublePopped < 0.0D){
         doubleMax += doublePopped ;
         max = (T) doubleMax;
       }
    }
    return popped ;
  }

  public T getMax(){
    return max ;
  }

}
