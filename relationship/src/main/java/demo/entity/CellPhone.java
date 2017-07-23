package demo.entity;

import javax.persistence.*;

/**
 * author: Flyli
 * date: 2017/7/2
 * description:
 */
@Entity
public class CellPhone {
    @Id
    @GeneratedValue
    private Long id;
    private String manufacture;
    private String color;
    private Long phoneNo;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_id")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }
}
