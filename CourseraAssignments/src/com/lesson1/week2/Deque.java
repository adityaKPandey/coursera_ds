package com.lesson1.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Deque<Item> implements Iterable<Item> {

  private Item [] array;
  private int front,rear;
  private int capacity = 0;

  // construct an empty deque
  public Deque(){
    this.capacity = 10;
    this.array =  (Item[]) new Object [this.capacity];
    this.front = this. rear = -1 ;
  }

  // is the deque empty?
  public boolean isEmpty(){
     return this.front > this.rear || this.front == -1 ;
  }

  // return the number of items on the deque
  public int length(){
    if(isEmpty())
      return 0;
    return this.rear - this. front + 1;
  }

  // add the item to the front
  public void addFirst(Item item){
    if(Objects.isNull(item))
      throw new IllegalArgumentException();

    if(this.front > 0)
       this.array[--this.front] = item ;
     else if(isEmpty())
       addLast(item);
     else {
        // shift elements on 1 place to right
       //TODO move resizing logic to new method resize()
         int newSize = capacity ;
         if(newSize <= length())
           newSize = capacity*2 ;

         Item [] newArray =  (Item[]) new Object [newSize];
         newArray[0] = item;
         int index = 1;
         int i = this.front;
         while(i <= this.rear)
           newArray[index++] = this.array[i++];

         this.array = newArray;
         this.rear = index-1;
         this.front = 0;



     }


  }

  // add the item to the back
  public void addLast(Item item){
    if(Objects.isNull(item))
      throw new IllegalArgumentException();

     //TODO handle resize
     this.array[++ this.rear] = item;
    if(this.front == -1)
      this.front = this.rear;
  }

  // remove and return the item from the front
  public Item removeFirst(){
    if(isEmpty())
      throw new NoSuchElementException();

    return this.array[this.front++] ;
  }

  // remove and return the item from the back
  public Item removeLast(){
    if(isEmpty())
      throw new NoSuchElementException();

    return this.array[this.rear--] ;
  }

  // return an iterator over items in order from front to back
  public Iterator<Item> iterator(){
     return new DequeueFrontToBackIterator<>();
  }

  public void print(){

    Iterator iterator = iterator();

    while (iterator.hasNext())
      System.out.println(iterator.next());

  }

  private class DequeueFrontToBackIterator<Item>  implements Iterator{

    private int index = front;
    @Override
    public boolean hasNext() {
      return index <= rear;
    }

    @Override
    public Object next() {
      if(!hasNext())
        throw new NoSuchElementException();

      return array[index++];
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  // unit testing (required)
  public static void main(String[] args){
    Deque<Integer> deque = new Deque();
    deque.addFirst(1);
    deque.addLast(2);
    deque.addLast(3);

    System.out.println("-----");
    deque.print();
    deque.addFirst(0);
    System.out.println("-----");
    deque.print();

    deque.addLast(4);
    System.out.println("-----");
    deque.print();

    deque.addFirst(-1);
    System.out.println("-----");
    deque.print();





  }

}