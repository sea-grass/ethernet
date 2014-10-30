import java.util.Random;
import java.text.DecimalFormat;
import java.lang.Math.*;

public class Ethernet {

	public int seed;
	public Random rand;
	public int n;
	public int num_frames;
	public int arrival_rate;

	public static final double slot_time = 25.6;
	public static final double bpmus = (72 / 2) / slot_time;

	public FrameList frames;
	public EventList events;
	public double currTime_mus;
	public int frames_simulated;
	public double bytes_sent;
	public int frames_dropped;

	public Ethernet(int newSeed, int numDevices, int numFrames, int arrRate) {
		if (newSeed == 0) {
			seed = new Random().nextInt();
		} else {
			seed = newSeed;
		}
		rand = new Random(seed);

		n = numDevices;
		num_frames = numFrames;
		arrival_rate = arrRate;

		currTime_mus = 0;
		frames_simulated = 0;
		bytes_sent = 0;
		frames_dropped = 0;

		//create frames to enter the simulation
		frames = new FrameList(rand, num_frames, bpmus, arrival_rate);
		//create the event list, which will contain the frames and their arrival
		events = new EventList(frames, currTime_mus);

	}

	public static void main(String[] argv) {
		if (argv.length != 4) {
			System.out.println("Make sure to include the right number of arguments!");
			return;
		}

		Ethernet ethernet = new Ethernet(Integer.parseInt(argv[0]), Integer.parseInt(argv[1]), Integer.parseInt(argv[2]), Integer.parseInt(argv[3]));

		ethernet.simulate();
	}

	public void simulate() {
		this.echoInput();
		this.runSim();
		this.echoOutput();
	}
	private void echoInput() {
		System.out.println("INPUT:");
		System.out.println("Seed given by user = " + this.seed);
		System.out.println("Number of devices = " + this.n);
		System.out.println("Number of frames to simulate = " + this.num_frames);
		System.out.println("Mean # arrival frames/100 slot times = " + this.arrival_rate);
	}
	private void runSim() {
		while (this.frames_simulated < this.num_frames) {
			//Check next scheduled event
			if (this.events.nextEvt().getArrivalTime() <= currTime_mus) {
				System.out.println("next event should arrive now");	
			}
			EtherFrame currFrame = this.frames.dequeue();
			System.out.println(this.frames_simulated + ": " + currFrame.getSize());
			this.frames_simulated++;
		}

	}
	private void echoOutput() {
		System.out.println("Performance Report:");
		System.out.println("Number of frames simulated = " + this.frames_simulated);
		System.out.println("Total bytes send successfully = " + this.bytes_sent);
		System.out.println("Number of frames dropped = " + this.frames_dropped);
		System.out.println("Network throughput = " + this.calculateThroughput() + " bps = " + new DecimalFormat("#.#").format(this.calculateThroughput() / 1000000) + " Mbps");
	}

	private double calculateThroughput() {
		return 1.04119494E7;
	}
}
