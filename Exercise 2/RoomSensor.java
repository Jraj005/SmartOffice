public class RoomSensor implements OccupancyObserver {
    @Override
    public void update(Room room) {
        if (room.isOccupied()) {
            room.turnLightsOn();
            room.turnAcOn();
        } else {
            room.turnLightsOff();
            room.turnAcOff();
        }
    }
}
