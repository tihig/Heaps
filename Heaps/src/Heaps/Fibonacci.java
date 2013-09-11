
package Heaps;

import BuildHeaps.Node;

public class Fibonacci {
   
   private Node n;
   private int min;
   private int d;
   
   public Fibonacci(Node n){
      this.n = n;
      this.min = n.getKey();
      this.d= 0;
   }

   public Node getN() {
      return n;
   }

   public int getMin() {
      return min;
   }
   
   public void decrease_key(int i , int newk){
      
   }
   public void delete_min(){
      
   }
   public void insert(Node k){
      if(min > k.getKey()){
         k.setChild(n);
         n.setP(k);
         n = k;
      }else{
         n.setLeft(k);
         k.setRight(n);
      }
      
   }
   public void merge(){
      
   }
   public void consolidate(){
      
   }
   public void cut(){
      
   }
   public void cascading_cut(){
      
   }
   
}
