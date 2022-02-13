package com.lesson1.week1;

import java.util.HashSet;
import java.util.Set;

public class WeightedQuickUnionFind {

   private int [] id;  // id[i] is parent of i
   private int [] size ;

   public WeightedQuickUnionFind(int N){

     this.id = new int[N] ;
     this.size = new int[N] ;

     for(int i = 0 ; i < N ; i++){
       id[i] = i;
       size[i] = 1 ;
     }

   }

  public boolean connected (int p , int q) {
    return getRoot(p) == getRoot(q) ;
  }

  //operates on roots : merges smaller tree(with lesser total number of nodes in it) into larger one
  public void union (int p , int q) {
     int smaller = getRoot(p);
     int larger = getRoot(q) ;

     if(smaller == larger)
       return ;
     else if(size[smaller] > size[larger]){
       int temp = smaller ;
       smaller = larger;
       larger = temp;
     }

     id[smaller] = larger ;
     size[larger] += size[smaller] ;

  }

  private int getRoot(int node) {

     int parent = node;
     while (id[parent] != parent)
        parent = id[parent];

     return parent ;

   }


}
