//Amusement facilities: including basic information of facilities, height limit, operator association
public class Ride {
    //Private attributes: facility name, minimum height limit, operator
    private String rideName;    //Facility name
    private Integer minHeight;  //Minimum height limit
    private Employee operator;  //Operator

    //Parameterless constructor
    //Set Default
    public Ride() {
        this.rideName = "unknown";
        this.minHeight = 0;
        this.operator = null; //The default is no operator
    }

    //Parametric constructor
    public Ride(String pRideName, Integer pMinHeight, Employee pOperator) {
        this.rideName = pRideName;
    //Reuse the check logic of setMinHeight
        this.setMinHeight(pMinHeight);
        this.operator = pOperator;
    }

    //The getter and setter methods of rideName
    public String getRideName() {
        return rideName;
    }


    public void setRideName(String pRideName) {
        this.rideName = pRideName;
    }

    //Getter and setter methods of minHeight
    public Integer getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(Integer pMinHeight) {
        if (pMinHeight < 0) {
            throw new IllegalArgumentException("minHeight cannot be negative");
        }
        this.minHeight = pMinHeight;
    }

    //The getter and setter methods of the operator
    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee pOperator) {
        this.operator = pOperator;
    }
}