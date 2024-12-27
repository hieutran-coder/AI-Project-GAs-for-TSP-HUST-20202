
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Population {
	//Population : quan the -- tap hop tat ca cac Individual
	private Individual population[];
	private double populationFitness = -1;
	public Individual[] getIndividual() {
		return this.population;
	}
	public void setIndividual(int offset, Individual individual) {
		this.population[offset] = individual;
	}
	//construtor
	public Population(int populationSize) {
		// Initial population
		this.population = new Individual[populationSize];
	}
	public Population(int populationSize, int chromosomeLength) {
		// Initial population
		this.population = new Individual[populationSize];

		// Loop over population size
		for (int individualCount = 0; individualCount < populationSize; individualCount++) {
			// Create individual
			Individual individual = new Individual(chromosomeLength);
			// Add individual to population
			this.population[individualCount] = individual;
		}
	}
	// tra ve lo trinh min <-> lo trinh fittest
	public Individual getFittest(int offset) {
		Arrays.sort(this.population, new Comparator<Individual>(){
			
			public int compare(Individual o1, Individual o2) {
				if (o1.getFitness()>o2.getFitness())
				return -1;
				else if (o1.getFitness() < o2.getFitness()) {
					return 1;
				}
				return 0;
			}
		});
		return this.population[offset];
	}
	// dao thu tu population
	public void shuffle() {
		Random rd = new Random();
		for (int i = 0; i<population.length-1;i++) {
			int index=rd.nextInt(i+1);
			Individual a=population[index];
			population[index]=population[i];
			population[i]=a;
		}
	}
	public void setPopulationFitness(double fitness) {
		this.populationFitness=fitness;
	}
	
	
}
