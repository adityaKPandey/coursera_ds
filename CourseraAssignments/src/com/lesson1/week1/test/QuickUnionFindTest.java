package com.lesson1.week1.test;

import com.lesson1.week1.QuickFindUnion;
import com.lesson1.week1.QuickUnionFind;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuickUnionFindTest {

  private QuickUnionFind quickUnionFind ;

  @BeforeEach
  void setUp() {

    quickUnionFind = new QuickUnionFind(8) ;

    quickUnionFind.union(1,4);
    quickUnionFind.union(4,5);
    quickUnionFind.union(2,6);
    quickUnionFind.union(2,3);
    quickUnionFind.union(3,6);
    quickUnionFind.union(3,7);

  }

  @AfterEach
  void tearDown() {

  }


  @Test
  void testConnected(){

    Assertions.assertTrue(quickUnionFind.connected(1,5));
    Assertions.assertFalse(quickUnionFind.connected(1,2));
    Assertions.assertTrue(quickUnionFind.connected(7,2));
    Assertions.assertTrue(quickUnionFind.connected(6,7));
    Assertions.assertFalse(quickUnionFind.connected(0,3));

  }


}