
import java.util.Iterator;

public class GeneticAlgorithm {
////mo ta:
//	Khoi tao quan the (population) ban dau
//	Danh gia quan the
//		Fitness: do phu hop
//	Chon loc 
//	Tao ra the he tiep thep ( next generation): lai ghep, dot bien
//	Lap lai qua trinh
//-------------------------------
//	initPopulation();
//	evalPopulation();
//	while(generation<maxGeneration) {
//		crossover();
//		mutate()
//		evalPopulation()
//		generation++;
//	}
	private int populationSize;
	
	// tinh fitness
	public double calFitness(Individual individual,City cities[]) {
		Route route=new Route(individual,cities);
		double fitness=1/route.getDistance();
		individual.setFitness(fitness);
		return fitness;
	}
	//Khoi tao quan the
	public Population initPopulation(int chromosomeLength) {
		Population population=new Population(this.populationSize, chromosomeLength);
		return population;
	}
	// Danh gia quan the: tinh theo fitness
	public void evalPopulation(Population population, City cities[]) {
		double populationFitness =0;// tong fitness cua moi individual
		for (Individual individual : population.getIndividual()) {
			populationFitness+=this.calFitness(individual, cities);
		}
		double avgFitness=populationFitness/populationSize;
		population.setPopulationFitness(avgFitness);
	}
	
	
	//	lựa chọn cha cho phép lai
//	Selects parent for crossover using tournament selection

//	 * Tournament selection works by choosing N random individuals, and then
//	 * choosing the best of those.
	public Individual selectParent(Population population) {
	}
	// Lai ghep
	public Population crossoverPopulation(Population population) {
		return newPopulation;	
	}
	// Dot bien
	public Population mutatePopulation(Population population) {
		return newPopulation;
	}



/**
	 *Select Parent for crossover using Roulette Wheel 
	 */
	public Individual rouletteSelection(Population population) {
		double totalFitness = population.getPopulationFitness();
		
		// We pick a random value - a point on our roulette wheel
		Random Random = new Random();
		int selectedValue = Random.nextInt((int) totalFitness);
		
		// the probability of selecting a genome would be
		    // inversely proportional to its fitness - the smaller the fitness
		    // the higher the probability
		double recValue = 1/ selectedValue;
		
		double currentSum = 0;
		 // We add up values until we reach out recValue, and we pick the
	    // genome that crossed the threshold
		for (int populationIndex = 0; populationIndex < population.size(); populationIndex ++) {
				Individual chromosome = population.getIndividuals()[populationIndex];
				currentSum += 1/chromosome.getFitness();
				
				if (currentSum >= recValue) {
					return chromosome;
				}
		}
		// In case the return doesn't happen in the loop above, we just
		// select at all random
		int selectRandom = Random.nextInt(population.size());
		return population.getIndividuals()[selectRandom];
	}
	

	//Elitism is name of method, which first copies the best chromosome (or a few best chromosomes) to new population.
	//public Individual elitismSelection(Population population ) {
	//return population.getFittest(population.size());
	//}
