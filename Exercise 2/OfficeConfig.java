import java.util.ArrayList;
import java.util.List;

public class OfficeConfig {
    private static OfficeConfig instance;
    private List<Room> rooms;

    private OfficeConfig() {
        rooms = new ArrayList<>();
    }

    public static OfficeConfig getInstance() {
        if (instance == null) {
            instance = new OfficeConfig();
        }
        return instance;
    }

    public void configureRooms(int roomCount) {
        for (int i = 1; i <= roomCount; i++) {
            rooms.add(new Room(i));
        }
        System.out.println("Office configured with " + roomCount + " rooms.");
    }

    public Room getRoom(int roomId) {
        return rooms.stream()
                .filter(room -> room.getRoomId() == roomId)
                .findFirst()
                .orElse(null);
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
