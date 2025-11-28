//Abstract class Person
public abstract class Person {
    //Private member variable
    private Integer id;
    private String name;
    private Integer age;

    //Parameterless constructor
    public Person() {
        this.id = 0;
        this.name = "unknown";
        this.age = 0;
    }

    //Parametric constructor
    public Person(Integer pId, String pName, Integer pAge) {
        this.id = pId;
        this.name = pName;
        this.age = pAge;
    }

    // getter / setter method
    public Integer getId() {
        return id;
    }

    public void setId(Integer pId) {
        this.id = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        this.name = pName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer pAge) {
        this.age = pAge;
    }
}