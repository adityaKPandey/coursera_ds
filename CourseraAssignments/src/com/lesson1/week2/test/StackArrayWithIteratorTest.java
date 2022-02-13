package com.lesson1.week2.test;

import com.lesson1.week2.StackArrayWithIterator;
import java.util.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackArrayWithIteratorTest {

  @BeforeEach
  void setUp() {

  }

  @Test
  void testStackIterator(){
    StackArrayWithIterator<Integer> integerStack = new StackArrayWithIterator<>(3);
    integerStack.push(1);
    integerStack.push(2);
    integerStack.push(3);
    integerStack.push(4);
    integerStack.push(5);

    Iterator iterator = integerStack.iterator();

    while (iterator.hasNext()){
      System.out.println(iterator.next());
    }


    Assertions.assertTrue(5 ==  integerStack.pop());
    Assertions.assertTrue(4 ==  integerStack.pop());
    Assertions.assertTrue(3 ==  integerStack.pop());


     iterator = integerStack.iterator();

    while (iterator.hasNext()){
      System.out.println(iterator.next());
    }

    Assertions.assertTrue(2 ==  integerStack.pop());
    Assertions.assertTrue(1 ==  integerStack.pop());


  }

}
