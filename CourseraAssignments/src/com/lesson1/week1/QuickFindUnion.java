package com.lesson1.week1;

public class QuickFindUnion {

  private int [] id; // elements belonging to same connected component have same id[i] value

  public QuickFindUnion(int N){
     id = new int [N] ;
     for(int i = 0 ; i < N ; i++){
       id [i] = i ;
     }
  }

  public boolean connected (int p , int q) {
     return id[p] == id[q] ;
  }

  public void union (int p , int q) {

    if( id[p] != id[q] ){

      int pVal = id[p] ;
      int qVal = id[q] ;
      for(int i = 0 ; i < id.length ; i++){
           if(id[i] == pVal){
             id[i] = qVal ;
           }
      }

    }

  }

}
