import java.util.LinkedList;
import java.util.Queue;

// 1. Reservation Class to hold guest details
class Reservation {
    private String name;
    private String roomType;

    public Reservation(String name, String roomType) {
        this.name = name;
        this.roomType = roomType;
    }

    public String getName() { return name; }
    public String getRoomType() { return roomType; }
}

// 2. BookingRequestQueue Class to handle the FIFO logic
class BookingRequestQueue {
    private Queue<Reservation> queue = new LinkedList<>();

    public void addRequest(Reservation res) {
        queue.add(res);
    }

    public boolean hasPendingRequests() {
        return !queue.isEmpty();
    }

    public Reservation processNext() {
        return queue.poll();
    }
}

// 3. Main Class
public class HotelBookingApp {
    public static void main(String[] args) {

        // Display application header
        System.out.println("Booking Request Queue");

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add requests to the queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Display queued booking requests in FIFO order
        while (bookingQueue.hasPendingRequests()) {
            Reservation current = bookingQueue.processNext();
            System.out.println("Processing booking for Guest: " + current.getName() +
                    ", Room Type: " + current.getRoomType());
        }
    }
}