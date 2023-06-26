package lastExam;

import java.util.Comparator;

public class bicycle {
	String bikeId;
	String bikeName;
	String bikeRenter;
	int bikeCost;
	public bicycle(String id,String name,String rent,int cost) {
		this.bikeId = id;
		this.bikeName = name;
		this.bikeRenter = rent;
		this.bikeCost = cost;
	}
	public String getBikeId() {
		return bikeId;
	}
	public void setBikeId(String bikeId) {
		this.bikeId = bikeId;
	}
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public String getBikeRenter() {
		return bikeRenter;
	}
	public void setBikeRenter(String bikeRenter) {
		this.bikeRenter = bikeRenter;
	}
	public int getBikeCost() {
		return bikeCost;
	}
	public void setBikeCost(int bikeCost) {
		this.bikeCost = bikeCost;
	}
}
