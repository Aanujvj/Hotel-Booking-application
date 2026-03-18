import java.util.LinkedHashMap;
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
    private Map<String, RoomDetails> inventory = new LinkedHashMap<>();

    public RoomInventory() {
        // Data exactly as shown in your image
        inventory.put("Single Room", new RoomDetails(1, 250, 1500.0, 5));
        inventory.put("Double Room", new RoomDetails(2, 400, 2500.0, 3));
        inventory.put("Suite Room", new RoomDetails(3, 750, 5000.0, 2));
    }

    public Map<String, RoomDetails> getRoomAvailability() {
        return inventory;
    }
}

public class HotelBookingApp {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();

        System.out.println("Room Search\n");

        inventory.getRoomAvailability().forEach((roomName, details) -> {
            System.out.println(roomName + ":");
            System.out.println("Beds: " + details.beds);
            System.out.println("Size: " + details.size + " sqft");
            System.out.println("Price per night: " + details.price);
            System.out.println("Available: " + details.available);
            System.out.println();
        });
    }
}
