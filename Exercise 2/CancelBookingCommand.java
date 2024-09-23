public class CancelBookingCommand implements Command {
    private Room room;

    public CancelBookingCommand(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        room.releaseRoom();
    }
}
