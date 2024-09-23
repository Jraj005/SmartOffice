public class BookRoomCommand implements Command {
    private Room room;
    private String startTime;
    private int duration;

    public BookRoomCommand(Room room, String startTime, int duration) {
        this.room = room;
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public void execute() {
        try {
            if (!validateTimeFormat(startTime)) {
                throw new IllegalArgumentException("Invalid time format.");
            }
            if (room.hasBookingConflict(startTime)) {
                throw new Exception("Room is already booked during this time.");
            } else {
                room.bookRoom(startTime, duration);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Booking failed: " + e.getMessage());
        }
    }

    public boolean validateTimeFormat(String time) {
        if (!time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
            return false;
        }
        return true;
    }
}
