import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Room {
    private int roomId;
    private boolean isOccupied;
    private int occupants;
    private boolean lightsOn;
    private boolean acOn;
    private String bookedTime;
    private List<OccupancyObserver> observers = new ArrayList<>();

    private static final Logger logger = Logger.getLogger(Room.class.getName());

    public Room(int roomId) {
        this.roomId = roomId;
        this.isOccupied = false;
        this.occupants = 0;
        this.lightsOn = false;
        this.acOn = false;
        this.bookedTime = null;
    }

    public int getRoomId() {
        return roomId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupants(int occupants) {
        this.occupants = occupants;
        this.isOccupied = occupants >= 2;
        notifyObservers();
    }

    public void addObserver(OccupancyObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (OccupancyObserver observer : observers) {
            observer.update(this);
        }
    }

    public void turnLightsOn() {
        lightsOn = true;
        logger.info("Lights in Room " + roomId + " turned on.");
    }

    public void turnLightsOff() {
        lightsOn = false;
        logger.info("Lights in Room " + roomId + " turned off.");
    }

    public void turnAcOn() {
        acOn = true;
        logger.info("AC in Room " + roomId + " turned on.");
    }

    public void turnAcOff() {
        acOn = false;
        logger.info("AC in Room " + roomId + " turned off.");
    }

    public void bookRoom(String startTime, int duration) {
        this.bookedTime = startTime;
        logger.info("Room " + roomId + " booked from " + startTime + " for " + duration + " minutes.");
    }

    public boolean hasBookingConflict(String startTime) {
        return bookedTime != null && bookedTime.equals(startTime);  // Basic conflict check
    }

    public void releaseRoom() {
        logger.info("Room " + roomId + " is now unoccupied. Booking released.");
        bookedTime = null;
        turnLightsOff();
        turnAcOff();
    }
}
