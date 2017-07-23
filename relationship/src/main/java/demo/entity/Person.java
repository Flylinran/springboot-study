package demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * author: Flyli
 * date: 2017/7/2
 * description:
 */
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.EAGER)
    private List<CellPhone> cellPhones = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<CellPhone> getCellPhones() {
        return cellPhones;
    }

    public void setCellPhones(List<CellPhone> cellPhones) {
        this.cellPhones = cellPhones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", cellPhones=" + cellPhones +
                '}';
    }
}
