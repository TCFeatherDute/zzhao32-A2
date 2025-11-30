import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

// Amusement facilities: including basic information of facilities, height limit, operator association
public class Ride implements RideInterface {
    // Private attributes: facility name, minimum height limit, operator
    private String rideName;    // Facility name
    private Integer minHeight;  // Minimum height limit
    private Employee operator;  // Operator

    //===========Queue/history storage (interface method dependency)==========
    private Queue<Visitor> rideQueue = new LinkedList<>();    // Visitor queue (FIFO)
    private LinkedList<Visitor> rideHistory = new LinkedList<>();    // Ride history records

    // Parameterless constructor
    // Set Default
    public Ride() {
        this.rideName = "unknown";
        this.minHeight = 0;
        this.operator = null; // The default is no operator
    }

    // Parametric constructor
    public Ride(String pRideName, Integer pMinHeight, Employee pOperator) {
        this.rideName = pRideName;
        // Reuse the check logic of setMinHeight
        this.setMinHeight(pMinHeight);
        this.operator = pOperator;
    }

    // The getter and setter methods of rideName
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String pRideName) {
        this.rideName = pRideName;
    }

    // Getter and setter methods of minHeight
    public Integer getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(Integer pMinHeight) {
        if (pMinHeight < 0) {
            throw new IllegalArgumentException("minHeight cannot be negative");
        }
        this.minHeight = pMinHeight;
    }

    // The getter and setter methods of the operator
    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee pOperator) {
        this.operator = pOperator;
    }

    //==========Implement all methods of the RideInterface interface==========
    /**
     * Add visitor to queue (Part 3)
     * Check height limit before adding
     */
    @Override
    public void addVisitorToQueue(Visitor v) {
        if (v == null) {
            System.out.println("Error: Visitor object cannot be null!");
            return;
        }
        // Check if visitor's height meets the minimum requirement
        if (v.getHeight() >= this.minHeight) {
            rideQueue.offer(v);
            System.out.printf("[Queue] %s (Height: %.1fcm) added to %s queue%n",
                    v.getName(), v.getHeight(), this.rideName);
        } else {
            System.out.printf("[Queue] %s (Height: %.1fcm) is too short for %s (min: %dcm)%n",
                    v.getName(), v.getHeight(), this.rideName, this.minHeight);
        }
    }

    /**
     * Remove visitor from queue (Part 3)
     * Remove the first visitor in the queue by default
     */
    @Override
    public void removeVisitorFromQueue() {
        if (rideQueue.isEmpty()) {
            System.out.printf("[Queue] %s queue is empty, cannot remove visitor%n", this.rideName);
            return;
        }
        Visitor removedVisitor = rideQueue.poll();
        System.out.printf("[Queue] Removed visitor: %s from %s queue%n",
                removedVisitor.getName(), this.rideName);
    }

    /**
     * Print queue details (Part 3)
     */
    @Override
    public void printQueue() {
        System.out.printf("\n===== %s Queue Details =====%n", this.rideName);
        if (rideQueue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int index = 1;
        for (Visitor v : rideQueue) {
            System.out.printf("%d. ID: %d | Name: %s | Membership: %s | Height: %.1fcm%n",
                    index++, v.getId(), v.getName(), v.getMembershipType(), v.getHeight());
        }
        System.out.printf("Total visitors in queue: %d%n=========================%n", rideQueue.size());
    }

    /**
     * Add visitor to ride history (Part 4A/4B)
     * Avoid duplicate records by visitor ID
     */
    @Override
    public void addVisitorToHistory(Visitor v) {
        if (v == null) {
            System.out.println("Error: Visitor object cannot be null!");
            return;
        }
        // Check if visitor is already in history (by ID)
        if (!this.checkVisitorFromHistory(v)) {
            rideHistory.add(v);
            System.out.printf("[History] %s (ID: %d) added to %s ride history%n",
                    v.getName(), v.getId(), this.rideName);
        } else {
            System.out.printf("[History] %s (ID: %d) already exists in %s ride history%n",
                    v.getName(), v.getId(), this.rideName);
        }
    }

    /**
     * Check if visitor is in ride history (Part 4A/4B)
     * @return true if exists, false otherwise
     */
    @Override
    public boolean checkVisitorFromHistory(Visitor v) {
        if (v == null) {
            return false;
        }
        // Match by visitor ID (unique identifier)
        for (Visitor historyVisitor : rideHistory) {
            if (historyVisitor.getId().equals(v.getId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get total number of visitors in history (Part 4A/4B)
     * @return total count of unique visitors
     */
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    /**
     * Print ride history details (Part 4A/4B)
     */

    @Override
    public void printRideHistory() {
        System.out.printf("\n===== %s Ride History =====%n", this.rideName);
        if (rideHistory.isEmpty()) {
            System.out.println("No ride history records");
            return;
        }
        int index = 1;
    //Iterator<Visitor>loop traversal
        Iterator<Visitor> visitorIterator = rideHistory.iterator();
        while (visitorIterator.hasNext()) {
            Visitor v = visitorIterator.next();
            System.out.printf("%d. ID: %d | Name: %s | Age: %d | Membership: %s | Height: %.1fcm%n",
                    index++, v.getId(), v.getName(), v.getAge(), v.getMembershipType(), v.getHeight());
        }
        System.out.printf("Total unique visitors: %d%n=========================%n", this.numberOfVisitors());
    }

    /**
     * Run one cycle of the ride (Part 5)
     * Process all valid visitors in queue → add to history → clear queue
     */

    @Override
    public void runOneCycle() {
        System.out.printf("\n===== %s Starting One Cycle =====%n", this.rideName);

        // Check if operator exists
        if (this.operator == null) {
            System.out.println("Warning: No operator assigned, cycle terminated!");
            return;
        }
        System.out.printf("Operator: %s (Position: %s)%n",
                this.operator.getName(), this.operator.getPosition());

        // Check if queue is empty
        if (rideQueue.isEmpty()) {
            System.out.println("No visitors in queue, cycle ended");
            System.out.printf("=========================%n");
            return;
        }

        // Process visitors in queue
        int processedCount = 0;
        while (!rideQueue.isEmpty()) {
            Visitor currentVisitor = rideQueue.poll();
            // Re-check height (prevent data tampering)
            if (currentVisitor.getHeight() >= this.minHeight) {
                this.addVisitorToHistory(currentVisitor);
                processedCount++;
            } else {
                System.out.printf("[Cycle] %s (Height: %.1fcm) skipped (too short)%n",
                        currentVisitor.getName(), currentVisitor.getHeight());
            }
        }

        // Print cycle result
        System.out.printf("Cycle completed. Total visitors processed: %d%n", processedCount);
        System.out.printf("=========================%n");
    }
}