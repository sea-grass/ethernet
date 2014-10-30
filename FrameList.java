import java.util.Random;
import java.util.ArrayList;

/*
A FrameList is initialized with:
	Random rand: Needed for determining the size of the new frames
	int num_frames: The number of frames to initialize in the list
	double bpmus: The transmission speed of the governing Ethernet simulation. Needed for creating a Frame
	int arrival_rate: The given arrival rate of the governing Ethernet simulation. Needed for creating a Frame

	On initialization, FrameList creates a new ArrayList and initializes num_frames EtherFrames, and enqueues them
*/
public class FrameList {
	public ArrayList<EtherFrame> frames;
	public FrameList(Random rand, int num_frames, double bpmus, int arrival_rate ) {
		frames = new ArrayList<EtherFrame>();

		for (int i = 0; i < num_frames; i++) {
			double interarrival_time = 1 - Math.pow(Math.E,-arrival_rate * i);
			EtherFrame frame = new EtherFrame(rand, bpmus, interarrival_time);
			enqueue(frame);
		}

	}

	public void enqueue(EtherFrame newFrame) {
		this.frames.add(newFrame);
		
	}
	public EtherFrame dequeue() {
		return this.frames.remove(0);
	}
	public int length() {
		return this.frames.size();
	}

	public EtherFrame get(int index) {
		return this.frames.get(index);
	}
}
