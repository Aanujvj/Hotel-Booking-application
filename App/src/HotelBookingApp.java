import java.util.*;

// --- Core Service Class ---
class RoomAllocationService {
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        this.allocatedRoomIds = new HashSet<>();
        this.assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();
        String uniqueId = generateRoomId(type);

        // Update tracking structures
        allocatedRoomIds.add(uniqueId);
        assignedRoomsByType.computeIfAbsent(type, k -> new HashSet<>()).add(uniqueId);

        System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() + ", Room ID: " + uniqueId);
    }

    private String generateRoomId(String roomType) {
        // Count how many of this type already exist to increment the ID
        int nextId = assignedRoomsByType.getOrDefault(roomType, Collections.emptySet()).size() + 1;
        return roomType + "-" + nextId;
    }
}

// --- Data Models ---
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
}

class RoomInventory {
    // Placeholder for inventory management logic
}

// --- Main Entry Point ---
public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("Room Allocation Processing");

        RoomAllocationService service = new RoomAllocationService();
        RoomInventory inventory = new RoomInventory();

        // Execution matching your requirement image
        service.allocateRoom(new Reservation("Abhi", "Single"), inventory);
        service.allocateRoom(new Reservation("Subha", "Single"), inventory);
        service.allocateRoom(new Reservation("Vanmathi", "Suite"), inventory);
    }
}