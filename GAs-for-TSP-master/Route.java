// tinh quang duong cua lo trinh --> getDistance(); cho GA.calFitness su dung
public class Route {
	private City[] route;
	private double distance;
	public Route(Individual individual, City cities[]) {
		int chromosome[]=individual.getChromosome();
		this.route = new City[cities.length];
		for(int genIndex=0;genIndex<chromosome.length;genIndex++) {
			this.route[genIndex]=cities[chromosome[genIndex]];
		}
	}
	public City[] getRoute() {
		return route;
	}
	public void setRoute(City[] route) {
		this.route = route;
	}
	public double getDistance() {
		if (this.distance > 0) {
			return this.distance;
		}

		//distance di qua tat ca thanh pho
		double totalDistance = 0;
		for (int cityIndex = 0; cityIndex + 1 < this.route.length; cityIndex++) {
			totalDistance += this.route[cityIndex].distanceFrom(this.route[cityIndex + 1]);
		}
// cong them khoang cach tu thanh pho cuoi cung ve thanh pho xuat phat de hoan thanh lo trinh
		totalDistance += this.route[this.route.length - 1].distanceFrom(this.route[0]);
		this.distance = totalDistance;

		return totalDistance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
}
