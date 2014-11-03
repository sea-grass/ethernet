import java.util.ArrayList;

public class DeviceList {
	public ArrayList<Device> devices;

	public DeviceList(int numDevices) {
		devices = new ArrayList<Device>();

		double spaceBetweenDevices = 1.0 / numDevices;
		double p = 0;
		double sum = 0;

		for (int i = 0; i < numDevices; i++) {
			devices.add(new Device(p, i));
			System.out.println(p);
			sum += p;

			p += spaceBetweenDevices;
		}
	}


	public int length() {
		return devices.size();
	}
  public void add(Device newDevice) {
    this.devices.add(newDevice);
  }
  public Device get(int index) {
    return devices.get(index);
  }

	/* Given a randomDouble, iterate through the devices and find one that fits the following:
		Choose device[i] iff:
			device[i-1].p < randomDouble <= device[i].p
		AND
			device[i].busy == 0
			If device[i].busy == 1
	*/
	public int getFreeSenderIndex(double randomDouble) {
		//Try to delegate to device according to probability
		if (randomDouble >= this.get(0).getProbability() && randomDouble < this.get(1).getProbability()) {			System.out.println("Should go to index 0!!");
		} else {
			for (int i = 1; i < this.length() - 1; i++) {
				if (randomDouble >= this.get(i).getProbability())
          System.out.println("doin nothin");
					//DONE 
			}
		}
		//If the device is busy, give to first free device

		//Filter busy frames out
		DeviceList freeDevices = this.filterBusy();
		for (int i = 0; i < freeDevices.length(); i++) {

			System.out.println("delegate: rand: " + randomDouble);
		}
    return -1;
	}

	/* Iterates through the current device list and returns a new one with only free devices */
	public DeviceList filterBusy() {
		int numFreeDevices = this.numFreeDevices();
		DeviceList freeDevices = new DeviceList(numFreeDevices);
		for (int i = 0; i < this.length(); i++) {
			if (this.get(i).isFree()) {
				freeDevices.add(this.get(i));
			}
		}
		return freeDevices;
	}

	public int numFreeDevices() {
		int count = 0;
		for (int i = 0; i < this.length(); i++) {
			if(this.get(i).isFree()) {
				count++;
			}
		}
		return count;
	}
}
