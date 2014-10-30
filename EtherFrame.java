import java.util.Random;

public class EtherFrame {
	private static int MIN_SIZE = 72;
	private static int MAX_SIZE = 1526;

	public int len;
	public double trantm;
	public double interarrival;

	public EtherFrame(Random rng, double bpmus, double int_arr_time) {
		len = genSize(rng);
		trantm = genTranTime(bpmus);
		interarrival = int_arr_time;
	}

	public int getSize() {
		return this.len;
	}

	private int genSize(Random rng) {
		return rng.nextInt(MAX_SIZE - MIN_SIZE + 1) + MIN_SIZE;
	}
	private double genTranTime(double bpmus) {
		return this.len * bpmus;
	}

	public double getInterarrival() {
		return this.interarrival;
	}
}
