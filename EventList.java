import java.util.ArrayList;

public class EventList {
	ArrayList<Event> events;

	public EventList(FrameList frames, double start_time) {
		events = new ArrayList<Event>();
		//Add each frame (in order) to the event list with an "arrival" type
		double currTime = start_time;

		for (int i = 0; i < frames.length(); i++) {
			EtherFrame currFrame = frames.get(i);
			
			events.add(new Event("arrival", currTime, currFrame));

			currTime = currTime + currFrame.getInterarrival();
		}
		System.out.println(frames.length());
	}

	public Event nextEvt() {
		return this.events.get(0);
	}
	public void removeFirstEvt() {
		this.events.remove(0);
	}
}
