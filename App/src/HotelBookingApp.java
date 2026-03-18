/**
 * =============================================================================
 * HOTEL ROOM INITIALIZATION SYSTEM
 * =============================================================================
 */

// Abstract Base Class
abstract class Room {
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;
    protected int available;

    public Room(int beds, int size, double price, int available) {
        this.numberOfBeds = beds;
        this.squareFeet = size;
        this.pricePerNight = price;
        this.available = available;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
        System.out.println("Available: " + available + "\n");
    }
}

// Single Room Subclass
class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0, 5);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Single Room:");
        super.displayRoomDetails();
    }
}

// Double Room Subclass
class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.0, 3);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Double Room:");
        super.displayRoomDetails();
    }
}

// Suite Room Subclass
class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000.0, 2);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Suite Room:");
        super.displayRoomDetails();
    }
}

// Main Runner Class
public class HotelBookingApp {
    public static void main(String[] args) {
        // Print Header
        System.out.println("Hotel Room Initialization\n");

        // Instantiate Rooms
        Room single = new SingleRoom();
        Room dbl = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Display Output
        single.displayRoomDetails();
        dbl.displayRoomDetails();
        suite.displayRoomDetails();
    }
}
