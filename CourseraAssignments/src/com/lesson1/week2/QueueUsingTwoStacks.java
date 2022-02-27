package com.lesson1.week2;

import java.util.Objects;

public class QueueUsingTwoStacks<T> {

  private StackArrayWithIterator stack1 = new StackArrayWithIterator(5) ;
  private  StackArrayWithIterator stack2 = new StackArrayWithIterator(5);

  private boolean lastOpDequeue;

  public QueueUsingTwoStacks(int initialSize) {
    this.stack1 =  new StackArrayWithIterator(initialSize) ;

    this.stack2 =  new StackArrayWithIterator(initialSize) ;
  }

  /*
      1. keep enqueuing onto stack1 till we don't encounter dequeue operation
      if need for dequeue , pop all but 1  elements from stack1 and push them onto stack2 . Then pop remaining element from stack 1
      if again dequeue operation comes , pop from stack2, else keep enqueuing onto stack1
      If stack 2 goes empty , and dequeue operation comes , repeat from step 1

   */

  public boolean isEmpty(){
    return stack1.isEmpty() && stack2.isEmpty();
  }

  public void enqueue(T element){
    lastOpDequeue = false ;
    stack1.push(element);
  }

  public T dequeue(){
     T popped = null;
     if(stack2.isEmpty()){
       while (!stack1.isEmpty()){
         popped = (T) stack1.pop();
         if(Objects.nonNull(popped))
           stack2.push(popped);
         else
           break;
       }
       if(Objects.nonNull(popped)){
         popped = (T) stack2.pop();
       }
     }else{
        popped = (T) stack2.pop();
     }

     if(Objects.nonNull(popped))
       lastOpDequeue = true ;

     return popped ;
  }



}
