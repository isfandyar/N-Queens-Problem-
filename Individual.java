//Name: Isfandyar Virani  &  Riyanson Alfred
//ID: 7751854 & 7810835  
//Course: ITI 1121 Section A
//Assignment: 1

import java.util.Random;
import java.util.Arrays;


public class Individual implements Comparable<Individual> {
  
  
  private int [] attributes;                                                
  
  public Individual(int size) {
    //this.attributes = new int[size];   
    this.attributes = Util.getPermutation(size);
  }
  
  
  
  public Individual(int[] permutation) { // 10
    
    this.attributes = new int[permutation.length];                
    for (int i=0; i < permutation.length; i++)
    {
      attributes [i] = permutation [i];
    }
    
  }

  
  
  public Individual crossover(Individual other, int position) {
    
  Individual offspring;                                                   // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
    int [] permutation = new int[this.attributes.length];
    

    for (int j=0; j < (position); j++)  //adding up to position attributes into off spring
    {
      permutation [j] = this.attributes[j];
    }
    
    
    A: for (int i = 0 ; i < this.attributes.length ; i++)
    {
      int yo=i;
      boolean testing = false;
      B: for (int k = 0 ; (k < this.attributes.length); k++)
      {
        if ((permutation[k] == other.attributes[i]))
        {
          testing = true;
          break B;
        }
 
      }

      if(!testing && (position <= this.attributes.length)){
        permutation [position] = other.attributes[yo];
        position++;
      }
    }
    offspring = new Individual (permutation);   
    return offspring;
  }
  
  public Individual recombine(Individual other) {
    
    int position = (int)(Math.random() * ((attributes.length-1)-0)); 
    return crossover(other,position);
  
  }
  
  
  public Individual mutate(int i, int j) { // 10
    
    
    Individual offspring;                                                       // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
    
    int [] permutation = new int[this.attributes.length];
    
    for (int k=0; k <attributes.length; k++)
    {
      permutation [k] = this.attributes[k];
    }
    
    permutation [i] = this.attributes[j];
    permutation [j] = this.attributes[i];
    
    
    
    offspring = new Individual (permutation);  
    return offspring;
    
  }
  
  public Individual mutate() {
    
    Individual offspring;                                                       // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
    
    int [] permutation = new int[this.attributes.length];
    int i = (int)(Math.random() * ((this.attributes.length-1)-0));
    int j=(int)(Math.random() * ((this.attributes.length-1)-0));
    
    while (i == j)
    {
      j=(int)(Math.random() * ((attributes.length-1)-0));
    }
    
    
    for (int k=0; k <attributes.length; k++)
    {
      permutation [k] = this.attributes[k];
    }
    
    permutation [i] = this.attributes[j];
    permutation [j] = this.attributes[i];
    
    
    
    offspring = new Individual (permutation);  
    return offspring;
    
    
  }
  
  
  public int getFitness() {
    
    
    int fitness=0;
    
    for (int i = 0 ; i < this.attributes.length ; i++){
      int counter = 1;
      for (int j = i+1;  j < this.attributes.length ; j++)
      {
        if(this.attributes[i] ==  this.attributes[j]) // Check Horizontal
          fitness++;
        
        
        if((this.attributes[i] ==  ((this.attributes[j]) - counter)) ||(this.attributes[i] ==  ((this.attributes[j]) + counter) )) {
          fitness++;
        }
        counter++;
      }
    }
    
    
    return fitness;
    
    
    
    
  }
  
  
  
  
  
  
  
  
  public int compareTo(Individual other) {
    
    if (this.getFitness() < other.getFitness())
      return -1;
    
    else if (this.getFitness() > other.getFitness())
      return 1;
    
    
    else 
      return 0;
    
  }
  
  
  public String toString() {
    
    String result = "attributes=[ " ;
    
    for (int i=0; i<this.attributes.length; i++)
    {
      result = result + (attributes[i] + " "); 
    }
    result = result + "]";
    
    return result;
  }
    
  
  private String toStringBoard()
  {
    String STR = "";
    for (int i = 0 ; i < this.attributes.length ; i++)
    {
      for (int j = 0 ; j < this.attributes.length ; j++)  
      {
        if(this.attributes[j] == i)
        {
          STR = STR + " Q "; 
        }
        else
          STR = STR + " * ";
      }
      STR = STR +"\n";
    }
    return STR;
    
    
  //  return Arrays.toString(this.attributes);
    
  }
  
  
  public int getSize()
  {
    return (attributes.length);
    
  }
  
  public int getAttribute(int position)
  {
    return (attributes [position]);    
  }
  
  
  public static void main(String[] args) {
    
    StudentInfo.display();
    int random = (int)((Math.random()*10)+3);
    int[] testing = Util.getPermutation(random);
    Individual A = new Individual (testing);
    System.out.println("A: " + A.toString());    
    System.out.println("The Fitness for A is: " + A.getFitness());

    System.out.println(A.toStringBoard());
     
    
    int[] testing2 = Util.getPermutation(random);
    Individual B = new Individual (testing2);
        System.out.println("\nB: " + B.toString()); 
            System.out.println("The Fitness for B is: " + B.getFitness());
                System.out.println(B.toStringBoard());
            
    Individual abc;
    abc = B.crossover(A, 2);
    
    System.out.println("\nFor the Crossover between A and B, "+abc.toString());
    
   if(  A.compareTo(B) > 0)
     System.out.println("B has a lower Fitness value.");
     
     else if (A.compareTo(B) < 0)
     System.out.println("A has a lower Fitness value.");
   
   else
     System.out.println("Both A and B have the same Fitness value.");

   
   System.out.println("When we replace first and last number for B, we get " + B.mutate(0,B.getSize()-1));
    
   
//   int[]testing3 = {0,1,2,3,4,5,6,7};
//   Individual C = new Individual (testing3);
//   System.out.println(C.getFitness());
    
    
    
  }
}
