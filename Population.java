//Name: Isfandyar Virani  &  Riyanson Alfred
//ID: 7751854 & 7810835  
//Course: ITI 1121 Section A
//Assignment: 1

import java.util.Arrays;
import java.util.Random;

/** 
 * A <code>Population</code> is a collection of individuals (each one
 * representing a candidate solution for the n-queens problem).  To
 * facilitate the implementation of the various methods, <b>the
 * individuals will always be kept in increasing value of fitness</b>.
 */

public class Population {
  
  // INSERT YOUR CLASS AND INSTANCE VARIABLES HERE
  
  /**
   * A constructor of arity 2 to initialize the <b>Population</b>.
   * 
   * @param size is the number of individuals of this population
   * @param dimension is the size of the board and also the number of queens
   */
  
  private static final double MUTATION_RATE = 0.8;
  private int size;
  private int dimension;
  private static Individual[] population;
  
  public Population(int size, int dimension) {
    
    
    this.population = new Individual [size];
    this.dimension = dimension;
    int permutation [];
    
    for (int i = 0; i < size; i++)
    {
      permutation = Util.getPermutation(dimension);
      this.population[i] = new Individual(permutation);
    }
    
    
  }
  
  /**
   * The method <code>evolve</code> selects parent individuals. An offspring
   * is then created from the two parents, using the method
   * <code>crossover</code>. With probability <code>MUTATION_RATE</code>, the
   * offspring is <code>mutated</code>. Use 0.8 as the default
   * <code>MUTATION_RATE</code> The resulting child is inserted into the
   * population. As a result, the least fitted individual will be eliminated
   * from the population. Remember that the <code>population</code> is kept in
   * increasing order of fitness. For the selection of the parents, you can
   * experiment with different scenarios. A possible scenario is to randomly
   * select two parents. Another possible one would be to select the most fit,
   * and a randomly selected one. Or else, select the two most fitted
   * individuals.
   */
  
//  public void evolve() {
//    
//    
//    
//    
//   Individual parent1, parent2, child;
////   Individual [] temp= new Individual [size];
//   Individual [] temp = (Individual[])this.population.clone();  //A temporary array for the population array
////   for(int i =0; i < size; i++)
////   {
////     temp[i] = this.population[i];
////   }
//    double probability  = Math.random();    
//    
//    if(probability <= MUTATION_RATE)
//    {
//      sortbyFitness ();
//           int position = (int)(Math.random() * ((population.length-1)-0));
//      
//      parent1 = this.population[(int)(Math.random()*(this.population.length))];
//      parent2 = this.population[(int)(Math.random()*(this.population.length))]; 
//      child = parent1.recombine(parent2);
//      
//      
//      
//      A:  for (int i = 0; i < this.population.length; i++)
//      {
//        if (child.getFitness() < this.population[i].getFitness())
//        {
//          this.population[i] = child;
//          while (i < this.population.length -1)
//          {           
//            this.population[(i+1)] = temp[i];
//            i++;
//          }
//          break A;
//        }
//      }
//      
//    }
//      
//      
//      
//      
//      
//    }
    
  public void evolve()
  {
  
    
       sortbyFitness();
     Individual offspring = population[0].recombine( population[1] );
    
    double probability = (Math.random());
    
    if( probability < MUTATION_RATE )
      offspring.mutate();
    
    population[ population.length-1 ] = offspring;
    
    sortbyFitness();
  }
    
 
  
  
//  private void sortbyFitness ()
//  {
//    Individual temp;
//    
//    for(int k=0; k<this.population.length; k++)
//    {
//    
//    for (int i =0; i< (this.population.length-1);i++)
//   {
//      if (this.population[i].getFitness() > this.population[i+1].getFitness())
//      {
//        temp = this.population[i];
//        this.population[i]= this.population[i+1]; 
//        this.population[i+1] = temp;
//      }
//   
//    }
//    }
//  }
  
  
  private void sortbyFitness()
  {
   Arrays.sort(this.population); 
    
  }
  
  /**
   * The instance method <code>public Individual getFittest()</code> returns the
   * "best" individual of the population, i.e. the one that has the smallest
   * fitness value.
   * 
   * @return returns the currently best solution
   */
  
  public Individual getFittest() {
  
    int fitValue = this.population[0].getFitness();
    for (int i = 1 ; i < this.population.length ; i++)
    {
      if (this.population[i].getFitness() > fitValue)
        fitValue = this.population[i].getFitness();
      
    }
    return this.population[fitValue];
  }
  
  /**
   * Returns a <code>String</code> representation of this <code>Population</code>.
   * 
   * @return the String representation of this Population
   */
  
  public String toString() {
    
    String result;                                                           // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
    result = "The the number of possible solutions is " + size + " and on each possible solution there is " + dimension + " number of queens on " + dimension + " by " + " board."; 
    return result;
  }
  
}
