
public class Individual {
	// Individual la lo trinh di qua tat ca cac thanh pho -- nhiem sac the chua thong tin cac thanh pho di qua-> mang luu thong tin cac thanh pho
	// chromosome : Nhiem sac the
	// gene		  : gen tren NST ( chính là 1 thành phố )
	private int[] chromosome;
	private int chromosomeLength;
	private double fitness = -1;
	// constructor khoi tao Individual
	public Individual(int[] chromosome) {
		this.chromosome = chromosome;
	}
	public Individual(int chromosomeLength) {
		// Create random individual
		int[] individual;
		individual = new int[chromosomeLength];

		for (int gene = 0; gene < chromosomeLength; gene++) {
			individual[gene] = gene;
		}

		this.chromosome = individual;
	}
	// getter and setter
	public int[] getChromosome() {
		return chromosome;
	}
	public void setChromosome(int[] chromosome) {
		this.chromosome = chromosome;
	}
	public int getChromosomeLength() {
		return chromosomeLength;
	}
	public void setChromosomeLength(int chromosomeLength) {
		this.chromosomeLength = chromosomeLength;
	}
	
	public String toString() {
		String output = "";
		for (int gene = 0; gene < this.chromosome.length; gene++) {
			output += this.chromosome[gene] + ",";
		}
		return output;
	}

	public double getFitness() {
		// TODO Auto-generated method stub
		return this.fitness;
	}
	public void setFitness(double fitness) {
		this.fitness=fitness;
	}
	
	
}
