package com.lesson1.week2.test;

import com.lesson1.week2.StackArrayWithIterator;
import com.lesson1.week2.StackWithMaxOperation;
import java.util.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackWithMaxOperationTest {


  @Test
  void testStackMax(){
    StackWithMaxOperation<Double> integerStack = new StackWithMaxOperation<>(3);
    integerStack.push(1D);
    integerStack.push(2D);
    integerStack.push(3D);
    Assertions.assertTrue(3 ==  integerStack.getMax());
    integerStack.push(4D);
    integerStack.push(5D);



    Assertions.assertTrue(5 ==  integerStack.getMax());
    integerStack.pop();
    Assertions.assertTrue(4 ==  integerStack.getMax());
    integerStack.pop();


    integerStack.push(23D);
    integerStack.push(30D);

    Assertions.assertTrue(30 ==  integerStack.getMax());




  }

}
