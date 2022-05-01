package com.lesson1.week2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class RandomizedQueue<Item> implements Iterable<Item> {

  private Item [] array;
  private int front,rear;
  private int capacity = 0;

  // construct an empty randomized queue
  public RandomizedQueue(){
    this.capacity = 10;
    this.array =  (Item[]) new Object [this.capacity];
    this.front = this. rear = -1 ;
  }

  // is the randomized queue empty?
  public boolean isEmpty(){
    return this.rear == -1 || this.rear < this.front;
  }

  // return the number of items on the randomized queue
  public int size(){
    return this.rear - this.front + 1;
  }

  // add the item
  public void enqueue(Item item){
    if(size() == capacity){
      //resize
      Item [] newArray =  (Item[]) new Object [this.capacity*2];
      int i = 0 ;
      for(Item item1 : array)
        newArray[i++] = item1;

      array = newArray ;
    }

    if(this.front == -1)
       this.front++;

    this.array[++this.rear] = item ;

  }

  // remove and return a random item
  public Item dequeue(){
    if(isEmpty())
      throw new NoSuchElementException();


    int index = new Random().nextInt(100)%size();

    if(index != this.front){
      Item temp = this.array[index] ;
      this.array[index] = this.array[front];
      this.array[front] = temp;
    }
    return this.array[front++] ;
  }

  // return a random item (but do not remove it)
  public Item sample(){
    if(isEmpty())
      throw new NoSuchElementException();

    int index = new Random().nextInt(100)%size();
    return this.array[index] ;
  }

  public void print(Integer k){

    Iterator iterator = null;
    if(Objects.isNull(k))
      iterator = iterator();
    else
      iterator = iterator(k);

    while (iterator.hasNext())
      System.out.println(iterator.next());

  }

  // return an independent iterator over items in random order
  public Iterator<Item> iterator(){
     return new RandomizedDequeIterator<>() ;
  }

  public Iterator<Item> iterator(int sizeLimit){
    return new RandomizedDequeIterator<>(sizeLimit) ;
  }

  private class RandomizedDequeIterator<Item> implements Iterator{

    private Set<Integer> travelledIndexes = new HashSet<>() ;
    int sizeLimit = -1;

    public RandomizedDequeIterator(){

    }


    public RandomizedDequeIterator(int n){
         sizeLimit = n;
    }


    @Override
    public boolean hasNext() {
      boolean hasNext = travelledIndexes.size() < size();
      if(sizeLimit != -1){
        hasNext &=  travelledIndexes.size() < sizeLimit;
      }
      return hasNext;
    }


    @Override
    public Object next() {
      Random random = new Random();
      int index = random.ints(front,rear+1).findFirst().getAsInt();
      while(travelledIndexes.contains(index) || (index > rear || index < front))
         index = random.ints(front,rear+1).findFirst().getAsInt();

      travelledIndexes.add(index);
      return array[index];
    }


  }

  // unit testing (required)
  public static void main(String[] args){

    RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue();
    randomizedQueue.enqueue(1);
    randomizedQueue.enqueue(2);
    randomizedQueue.enqueue(3);
    System.out.println("Sample:"+randomizedQueue.sample());

    System.out.println("-----");
    randomizedQueue.print(null);
    randomizedQueue.enqueue(0);
    System.out.println("-----");
    randomizedQueue.print(null);
    System.out.println("Sample:"+randomizedQueue.sample());

    randomizedQueue.enqueue(4);
    System.out.println("-----");
    System.out.println("Sample:"+randomizedQueue.sample());

    randomizedQueue.enqueue(-1);
    System.out.println("-----");
    randomizedQueue.print(null);
    System.out.println("Sample:"+randomizedQueue.sample());

    System.out.println("Dequeued element:"+randomizedQueue.dequeue());

    System.out.println("-----");
    randomizedQueue.print(null);
    System.out.println("Sample:"+randomizedQueue.sample());

    System.out.println("-----");
    System.out.println("Dequeued element:"+randomizedQueue.dequeue());
    randomizedQueue.print(null);

  }

}

