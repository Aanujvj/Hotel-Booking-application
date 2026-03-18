import java.util.LinkedHashMap;
import java.util.Map;

// 1. Data model for room technical details
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

// 2. Inventory Management
class RoomInventory {
    private Map<String, RoomDetails> inventory = new LinkedHashMap<>();

    public RoomInventory() {
        // Mock data initialization
        inventory.put("Single", new RoomDetails(1, 250, 100.0, 5));
        inventory.put("Double", new RoomDetails(2, 400, 180.0, 3));
        inventory.put("Suite", new RoomDetails(3, 750, 350.0, 1));
    }

    public Map<String, RoomDetails> getRoomAvailability() {
        return inventory;
    }
}

// 3. Service to search and display
class RoomSearchService {
    public void searchAndDisplayAvailableRooms(RoomInventory inventory) {
        Map<String, RoomDetails> availability = inventory.getRoomAvailability();

        System.out.println("--- Available Rooms Search Results ---");
        
        availability.forEach((type, details) -> {
            if (details.available > 0) {
                displayRoomDetails(type, details);
            }
        });
    }

    private void displayRoomDetails(String type, RoomDetails details) {
        System.out.println("Room Type: " + type);
        System.out.println("Beds: " + details.beds + " | Size: " + details.size + " sqft");
        System.out.println("Price: $" + details.price);
        System.out.println("Rooms Remaining: " + details.available);
        System.out.println("---------------------------");
    }
}

// 4. Main Entry Point
public class HotelBookingApp {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        RoomSearchService searchService = new RoomSearchService();

        // Display current status
        searchService.searchAndDisplayAvailableRooms(inventory);
    }
}
