package com.lesson1.week2;

import java.lang.reflect.Array;

public class QueueWithArrayResize<T> {

  private T [] data ;
  private int front;
  private int rear;
  private int size ;

  public QueueWithArrayResize(int size) {
    this.front = this.rear = -1;
    this.data = (T[]) Array.newInstance(QueueWithArrayResize.class , size);
    this.size = size;
  }

  public boolean isEmpty(){
    return (rear == front) ;
  }

  public void enqueue(T entry){
     if(rear-front == size-1){
       resizeOnEnqueue();
     }
     data[++rear] = entry;
  }

  public T dequeue(){
    if(isEmpty())
      return null;

    T result = data[front];
    resizeOnDequeue();
    return result;

  }

  public void resizeOnEnqueue(){

    int newSize = 2 * size;
    T [] resizedArray = (T[]) Array.newInstance(QueueWithArrayResize.class , newSize);

    int j = 0 ;
    for(int i = front ; i <= rear ; i++)
      resizedArray[j++] = data[i] ;

    size = newSize;
    data = resizedArray ;
    front = 0;
    rear  = j;

  }

  public void resizeOnDequeue(){

    int newSize = size/2;
    T [] resizedArray = (T[]) Array.newInstance(QueueWithArrayResize.class , newSize);

    int j = 0 ;
    for(int i = front ; i <= rear ; i++)
      resizedArray[j++] = data[i] ;

    size = newSize;
    data = resizedArray ;

  }

}
