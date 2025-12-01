public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo a2 = new AssignmentTwo();
        a2.partThree();
        a2.partFourA();
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

    public void partFourB() { }
    public void partFive() { }
    public void partSix() { }
    public void partSeven() { }
}
