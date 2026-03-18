import java.util.LinkedHashMap; // Use LinkedHashMap to keep the order from the image
import java.util.Map;

class RoomDetails {
    int beds;
    int size;
    double price;
    int available;

    public RoomDetails(int beds, int size, double price, int available) {
        this.beds = beds;
        this.size = size;
        this.price = price;
        this.available = available;
    }
}

class RoomInventory {
    // Change Map value from Integer to RoomDetails
    private Map<String, RoomDetails> roomAvailability;

    public RoomInventory() {
        // Use LinkedHashMap so the output stays in order: Single, Double, Suite
        this.roomAvailability = new LinkedHashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        // Add RoomDetails objects with the data from your image
        roomAvailability.put("Single Room", new RoomDetails(1, 250, 1500.0, 5));
        roomAvailability.put("Double Room", new RoomDetails(2, 400, 2500.0, 3));
        roomAvailability.put("Suite Room", new RoomDetails(3, 750, 5000.0, 2));
    }

    public Map<String, RoomDetails> getRoomAvailability() {
        return roomAvailability;
    }
}

public class HotelBookingApp {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();

        System.out.println("Hotel Room Inventory Status\n");

        inventory.getRoomAvailability().forEach((roomName, details) -> {
            System.out.println(roomName + ":");
            System.out.println("Beds: " + details.beds);
            System.out.println("Size: " + details.size + " sqft");
            System.out.println("Price per night: " + details.price);
            System.out.println("Available Rooms: " + details.available);
            System.out.println();
        });
    }
}
