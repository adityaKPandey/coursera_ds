package com.lesson1.week1.test;

import static org.junit.jupiter.api.Assertions.*;

import com.lesson1.week1.QuickFindUnion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class QuickFindUnionTest {

  private  QuickFindUnion quickFindUnion ;

  @BeforeEach
  void setUp() {

    quickFindUnion = new QuickFindUnion(8) ;

    quickFindUnion.union(1,4);
    quickFindUnion.union(4,5);
    quickFindUnion.union(2,6);
    quickFindUnion.union(2,3);
    quickFindUnion.union(3,6);
    quickFindUnion.union(3,7);

  }

  @AfterEach
  void tearDown() {

  }


  @Test
  void testConnected(){

    Assertions.assertTrue(quickFindUnion.connected(1,5));
    Assertions.assertFalse(quickFindUnion.connected(1,2));
    Assertions.assertTrue(quickFindUnion.connected(7,2));
    Assertions.assertTrue(quickFindUnion.connected(6,7));
    Assertions.assertFalse(quickFindUnion.connected(0,3));

  }


}