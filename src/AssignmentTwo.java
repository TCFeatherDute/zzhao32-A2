public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo a2 = new AssignmentTwo();
        a2.partThree();
        a2.partFourA();
        a2.partFourB();
        a2.partFive();
    }

    public void partThree() {
        System.out.println("=== Part 3: Queue Demo ===");

        //1 Create an operator
        Employee op = new Employee(1, "Xiaoming", 30, "Ride Operator", 25.0);

        //2 Create a Ride object
        Ride ride = new Ride("Tom", 140, op);

        //3 Create 5 visitors
        Visitor v1 = new Visitor(101, "Xiaohong",   16, "Standard", 150.0);
        Visitor v2 = new Visitor(102, "Xiaohuang", 17, "VIP",      155.0);
        Visitor v3 = new Visitor(103, "Xiaobai",  18, "VIP", 160.0);
        Visitor v4 = new Visitor(104, "Xiaoli",  19, "Standard", 165.0);
        Visitor v5 = new Visitor(105, "Xiaozhao",  20, "VIP",      170.0);

        //4 Add tourists to the queue in turn
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        //5.Print
        System.out.println("\n----- Queue Initial Status -----");
        ride.printQueue();

        //6 Remove a Visitor
        System.out.println("\n----- Call removeVisitorFromQueue() -----");
        ride.removeVisitorFromQueue();

        //7 Print Queue Again
        System.out.println("\n----- Queue status after removing the queue leader -----");
        ride.printQueue();
    }

    public void partFourA() {
        System.out.println("\n=== Part 4A: Ride History Demo ===");

        // 1.Create an operator and a Ride
        Employee op = new Employee(2, "Bob", 35, "Ride Operator", 30.0);
        Ride ride = new Ride("Ferris Wheel", 120, op);

        // 2.Create three Visitors, two of which have the same ID, to test duplication removal
        Visitor v1 = new Visitor(201, "Anna", 22, "Standard", 160.0);
        Visitor v2 = new Visitor(202, "Ben", 25, "VIP",      170.0);
        Visitor v3 = new Visitor(201, "Anna-dup", 22, "Standard", 160.0); // 故意和 v1 同 ID

        // 3.Add History
        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);

        // 4.print
        System.out.println("\n----- Ride History -----");
        ride.printRideHistory();

        // 5.Test inspection and statistics
        System.out.println("Check Anna in history: " + ride.checkVisitorFromHistory(v1));
        System.out.println("Number of visitors in history: " + ride.numberOfVisitors());
    }

    public void partFourB() {
        System.out.println("\n=== Part 4B: Sort Ride History Demo ===");

        // 1.Create an operator and a ride
        Employee op = new Employee(3, "Daisy", 32, "Ride Operator", 26.0);
        Ride ride = new Ride("Haunted House", 130, op);

        // 2.Create visitors with different membership types and heights
        Visitor v1 = new Visitor(001, "A", 20, "Standard", 165.0);
        Visitor v2 = new Visitor(002, "B", 22, "VIP",      160.0);
        Visitor v3 = new Visitor(003, "C", 24, "Standard", 170.0);
        Visitor v4 = new Visitor(004, "D", 21, "VIP",      150.0);
        Visitor v5 = new Visitor(005, "E", 23, "Standard", 180.0);

        // 3.Add history
        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        System.out.println("\n----- Before sorting Ride History -----");
        ride.printRideHistory();

        // 4. 使用 VisitorComparator 排序
        VisitorComparator comp = new VisitorComparator();
        ride.sortRideHistory(comp);

        System.out.println("\n----- Sorted Ride History -----");
        ride.printRideHistory();
    }

    public void partFive() {
        System.out.println("\n=== Part 5: runOneCycle Demo ===");

        // 1.Create operators and amusement facilities
        Employee op = new Employee(4, "Charlie", 28, "Ride Operator", 28.0);
        Ride ride = new Ride("Drop Tower", 140, op);

        // 2. Create multiple tourists who meet the height requirements
        Visitor v1 = new Visitor(001, "V1", 18, "Standard", 150.0);
        Visitor v2 = new Visitor(002, "V2", 19, "Standard", 155.0);
        Visitor v3 = new Visitor(003, "V3", 20, "Standard", 160.0);
        Visitor v4 = new Visitor(004, "V4", 21, "Standard", 165.0);
        Visitor v5 = new Visitor(005, "V5", 22, "Standard", 170.0);
        Visitor v6 = new Visitor(006, "V6", 23, "Standard", 175.0);
        Visitor v7 = new Visitor(007, "V7", 24, "Standard", 180.0);

        // 3. Add all tourists to the queue
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);
        ride.addVisitorToQueue(v6);
        ride.addVisitorToQueue(v7);

        System.out.println("\n----- Initial Queue -----");
        ride.printQueue();

        // 4.Run one round for the first time
        ride.runOneCycle();

        System.out.println("----- Queue after first cycle -----");
        ride.printQueue();

        // 5.Run one round for the second time (run the remaining queue)
        ride.runOneCycle();

        System.out.println("----- Queue after second cycle -----");
        ride.printQueue();

        // 6.Print the final historical record
        System.out.println("\n----- Final Ride History -----");
        ride.printRideHistory();
    }
    public void partSix() { }
    public void partSeven() { }
}
