//Employee class: inherited from abstract parent class Person
public class Employee extends Person {
    //Subclass private attribute: position, hourly salary
    private String position;   // 职位，如 "Ride Operator"
    private Double hourlyRate; // 时薪

    //Parameterless constructor
    public Employee() {
        super();
        this.position = "unknown";
        this.hourlyRate = 0.0;
    }

    //Parametric constructor
    public Employee(Integer pId, String pName, Integer pAge, String pPosition, Double pHourlyRate) {
        super(pId, pName, pAge); //Call Person's constructor with parameters
        this.position = pPosition;
        this.hourlyRate = pHourlyRate;
    }

    //Getter/setter method of position
    public String getPosition() {
        return position;
    }

    public void setPosition(String pPosition) {
        this.position = pPosition;
    }

    // 时薪的getter/setter方法
    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double pHourlyRate) {
    //Added an hourly salary validity check
        if (pHourlyRate < 0) {
            throw new IllegalArgumentException("Hourly salary cannot be negative");
        }
        this.hourlyRate = pHourlyRate;
    }
}