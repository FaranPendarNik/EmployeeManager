
package employeemanagement;

import javafx.scene.image.Image;

public class employee {   
    private String firstName;
    private String lastName;
    private long codemeli;
    private String dateBirthday;
    private String sex;
    private String Position;
    private String fatherName;
    private String motherName;
    private long mobile;
    private String Address;
    private long postCode;
    private String dateEmployment;
    private long salary;
    private String relationship;
    private Image img;
    private String access;

    public employee() {
    }

    public employee(String firstName, String lastName, long codemeli, String dateBirthday, String sex, String Position, String fatherName, String motherName, long mobile, String Address, long postCode, String dateEmployment, long salary, String relationship, Image img, String access) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.codemeli = codemeli;
        this.dateBirthday = dateBirthday;
        this.sex = sex;
        this.Position = Position;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.mobile = mobile;
        this.Address = Address;
        this.postCode = postCode;
        this.dateEmployment = dateEmployment;
        this.salary = salary;
        this.relationship = relationship;
        this.img = img;
        this.access = access;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getCodemeli() {
        return codemeli;
    }

    public void setCodemeli(long codemeli) {
        this.codemeli = codemeli;
    }


    public String getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(String dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public long getPostCode() {
        return postCode;
    }

    public void setPostCode(long postCode) {
        this.postCode = postCode;
    }

    public String getDateEmployment() {
        return dateEmployment;
    }

    public void setDateEmployment(String dateEmployment) {
        this.dateEmployment = dateEmployment;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    
    
    

    
    
    
}