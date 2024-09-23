import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void releaseRoomAfterTimeout(Room room) {
        scheduler.schedule(() -> {
            if (!room.isOccupied()) {
                room.releaseRoom();
            }
        }, 5, TimeUnit.MINUTES);
    }

    public Room validateRoomId(OfficeConfig officeConfig, int roomId) {
        Room room = officeConfig.getRoom(roomId);
        if (room == null) {
            System.out.println("Room " + roomId + " does not exist.");
        }
        return room;
    }

    public static void main(String[] args) {
        OfficeConfig officeConfig = OfficeConfig.getInstance();
        Main officeFacility = new Main();

        // Configuring rooms
        officeConfig.configureRooms(3);

        // Adding sensors to rooms
        Room room1 = officeConfig.getRoom(1);
        Room room2 = officeConfig.getRoom(2);
        RoomSensor sensor = new RoomSensor();
        room1.addObserver(sensor);
        room2.addObserver(sensor);

        // Booking and Canceling operations with commands
        Command bookRoom1 = new BookRoomCommand(room1, "09:00", 60);
        Command cancelRoom1 = new CancelBookingCommand(room1);

        // Validations and actions
        bookRoom1.execute(); // Booking room 1
        room1.setOccupants(2); // Adding occupants to room 1

        room1.setOccupants(0); // Emptying the room
        officeFacility.releaseRoomAfterTimeout(room1); // Automatically release after timeout
        cancelRoom1.execute(); // Manually cancel room 1 booking

        // Negative case: Trying to book already booked room
        Command bookRoomConflict = new BookRoomCommand(room1, "09:00", 60);
        bookRoomConflict.execute(); // Should print conflict error
    }
}
