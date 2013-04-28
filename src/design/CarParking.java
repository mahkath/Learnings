package design;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CarParking {
	private int PARKING_SIZE = 10;
	List<ParkingSlot> parkingSlots = new ArrayList<ParkingSlot>(PARKING_SIZE);
	private int size = 0;
	
	public ParkingSlot isParkingSlotAvailable() throws Exception {
		synchronized (parkingSlots) {
			
			if(!(size < PARKING_SIZE)) {
				parkingSlots.wait();
			}
			
			ParkingSlot slot = null;
			for(int index=0; index < parkingSlots.size(); index++) {
				slot = parkingSlots.get(index);
				if(slot == null)  
					slot = new ParkingSlot(index); 
					
				if(slot.isEmpty()){
					slot.setEmpty(false);
					parkingSlots.set(index, slot);
					size++;
					break;
				}
			}
			
			return slot;
			
		}
	}
	
	public void returnParkingSlot(ParkingSlot slot) {
		synchronized (parkingSlots) {
			slot.setEmpty(true);
			parkingSlots.set(slot.getParkingSlotNumber(), slot);
			size--;
			parkingSlots.notifyAll();
		}
	}
	
	

}

class ParkingSlot {
	private int parkingSlotNumber;
	private boolean isEmpty = true;
	
	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public int getParkingSlotNumber() {
		return parkingSlotNumber;
	}

	public void setParkingSlotNumber(int parkingSlotNumber) {
		this.parkingSlotNumber = parkingSlotNumber;
	}

	public ParkingSlot(int slot){
		parkingSlotNumber = slot;
	}
	
}
