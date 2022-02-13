import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  private int [] [] grid ;

  private  WeightedQuickUnionUF weightedQuickUnionUF ;

  private int matrixLen ;

  //creates n-by-n grid, with all sites initially blocked (0)
  public Percolation(int n){

    grid = new int [n] [n] ;
    matrixLen = n ;
    for ( int i = 0 ; i < n; i++ ) {
       for(int j = 0 ; j < n ; j++){
         grid [i][j] = 0 ;
       }
    }

    weightedQuickUnionUF = new WeightedQuickUnionUF(n+2) ;

    for(int i = 1 ; i <= n ; i++) {
      weightedQuickUnionUF.union(0, i);
      weightedQuickUnionUF.union( i , n*n+1);
    }

  }

  // opens the site (row, col) if it is not open already
  public void open(int row, int col){
      grid[row][col] = 1 ;

      // 1. get corresponding nodes in weighted union array
      // 2. find neighbours index in matrix
      // 3. if they are open , then connect corresponding nodes in weighted union array
      // 4. else(if closed) then do nothing .

    if( col-1 > -1 && grid[row][col-1] == 1  )
         weightedQuickUnionUF.union(matrixLen*row + col  , matrixLen*(row) + col +1);

    if( col+1 < matrixLen && grid[row][col+1] == 1  )
      weightedQuickUnionUF.union(matrixLen*row + col +1 , matrixLen*(row) + col + 2);

    if( row+1 < matrixLen && grid[row+1][col] == 1  )
      weightedQuickUnionUF.union(matrixLen*(row+1) + col +1 , matrixLen*row + col + 1);

    if( row-1 > -1 && grid[row-1][col] == 1  )
      weightedQuickUnionUF.union(matrixLen*(row-1) + col +1 , matrixLen*row + col + 1);


  }

  // does the system percolate?
  public boolean percolates(){
     return weightedQuickUnionUF.connected(0 , matrixLen*matrixLen + 1) ;
  }

  // is the site (row, col) open?
  public boolean isOpen(int row, int col){
    return grid[row][col] == 1 ;
  }

  // is the site (row, col) full? A full site is an open site that can be connected to an open site in the top row via a
  // chain of neighboring (left, right, up, down) open sites. We say the system percolates if there is a full site in the bottom row
  public boolean isFull(int row, int col){

      for(int i = 0; i < matrixLen ; i++){
        if (grid[0][i] == 1) {
          boolean isFull = weightedQuickUnionUF.connected(matrixLen * row + col + 1, i + 1);
          if(isFull)
            return true;
        }
      }

      return false;
  }

  // returns the number of open sites
  public int numberOfOpenSites(){
     return 0;
  }



  // test client (optional)
  public static void main(String[] args){

  }
}