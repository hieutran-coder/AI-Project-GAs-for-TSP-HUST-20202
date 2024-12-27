package ai.ga;

public class City {
private int x;
private int y;
public City(int x,int y) {
	this.x=x;
	this.y=y;
}
// khoang cach 2 thanh pho
public double distanceFrom(City city) {
	double xDiff = Math.pow((city.getX() - this.getX()), 2);
	double yDiff = Math.pow((city.getY() - this.getY()), 2);
	double distance=Math.sqrt(Math.abs(xDiff + yDiff));
	return distance;
}
public int getX() {
	return this.x;
}
public int getY() {
	return this.y;
}

}
