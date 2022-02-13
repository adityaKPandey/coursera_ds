package com.lesson1.week1;

public class QuickUnionFind {

  private int [] id ; // id[i] is parent of i

  public QuickUnionFind(int N) {
    this.id = new int [N] ;

    for(int i = 0 ; i < N ; i++){
       id[i] = i;
    }

  }

  public boolean connected (int p , int q) {
    return getRoot(p) == getRoot(q) ;
  }



  //make first item - p child of second item - q
  public void union (int p , int q) {

    int pRoot = getRoot(p) ;
    id[pRoot] = getRoot(q) ;

  }

  private int getRoot(int node){

    int element = node ;
    while(id[element] != element)
      element = id[element];

    return element;
  }

}
