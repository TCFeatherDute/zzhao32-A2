// Tourist class: inherits from the abstract parent class Person
public class Visitor extends Person {
    // Subclass private attributes: membership type, height (cm)
    private String membershipType; // This is the membership type
    private Double height;         // This item is for height

    // No-argument constructor
    // Initialize subclass default values
    public Visitor() {
        super();
        this.membershipType = "Standard"; //Default
        this.height = 0.0;
    }

    // Parameterized constructor
    // first calls the parent class's parameterized constructor, then initializes the subclass fields
    public Visitor(Integer pId, String pName, Integer pAge, String pMembershipType, Double pHeight) {
        super(pId, pName, pAge);
        this.membershipType = pMembershipType;
    //Reuse validation logic
        this.setHeight(pHeight);
    }

    // Getter method for membershipType
    public String getMembershipType() {
        return membershipType;
    }

    // Setter method for membershipType
    public void setMembershipType(String pMembershipType) {
        this.membershipType = pMembershipType;
    }

    // Getter method for m // height
    public Double getHeight() {
        return height;
    }

    // Setter method for m // height
    public void setHeight(Double pHeight) {
        //Validate that height cannot be negative; if invalid, throw a runtime exception.
        if (pHeight < 0) {
            throw new IllegalArgumentException("height cannot be negative");
        }
        this.height = pHeight;
    }
}