public class Event {
	public String type;
	public double arrival_time;
	public EtherFrame frame;

	public Event(String newType, double arrival_in_mus, EtherFrame evtFrame) {
		type = newType;
		arrival_time = arrival_in_mus;
		frame = evtFrame;
	}

	public double getArrivalTime() {
		return this.arrival_time;
	}
}
