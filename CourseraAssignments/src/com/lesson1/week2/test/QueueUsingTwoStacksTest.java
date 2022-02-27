package com.lesson1.week2.test;

import com.lesson1.week2.QueueUsingTwoStacks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueUsingTwoStacksTest {

  @BeforeEach
  void setUp() {

  }

  @Test
  void testQueue(){

    QueueUsingTwoStacks<Integer> queueUsingTwoStacks = new QueueUsingTwoStacks(5);
    queueUsingTwoStacks.enqueue(1);
    queueUsingTwoStacks.enqueue(2);
    queueUsingTwoStacks.enqueue(3);

    Assertions.assertEquals( 1 , queueUsingTwoStacks.dequeue());
    Assertions.assertEquals( 2 , queueUsingTwoStacks.dequeue());
    //System.out.println("Q:"+queueUsingTwoStacks.dequeue());
    queueUsingTwoStacks.enqueue(4);
    //System.out.println("Q:"+queueUsingTwoStacks.dequeue());
    Assertions.assertEquals( 3 , queueUsingTwoStacks.dequeue());


    //System.out.println("Q isEmpty:"+queueUsingTwoStacks.isEmpty());
    Assertions.assertFalse(queueUsingTwoStacks.isEmpty());

    //System.out.println("Q:"+queueUsingTwoStacks.dequeue());
    Assertions.assertEquals( 4 , queueUsingTwoStacks.dequeue());

    //System.out.println("Q isEmpty:"+queueUsingTwoStacks.isEmpty());
    Assertions.assertTrue(queueUsingTwoStacks.isEmpty());

  }


}
