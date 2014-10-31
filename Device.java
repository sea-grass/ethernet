public class Device {
	public double p;
	public int state;	//0=free, 1=busy
	public int id;
	public Device(double probability, int newId) {
		p = probability;
		id = newId;

		state = 0;	//Starts off free
	}

	public Boolean isFree() {
		return !state;
	}
}
