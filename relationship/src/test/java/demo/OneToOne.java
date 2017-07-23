package demo;

import demo.entity.Address;
import demo.entity.Person;
import demo.repos.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * author: Flyli
 * date: 2017/7/2
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToOne {

    @Resource
    private PersonRepository personRepository;

    private Person person;

    @Before
    public void before() {
        Address address = new Address();
        address.setCountry("中国");
        address.setCity("南昌");
        address.setStreet("三经路");

        Person person1 = new Person();
        person1.setName("小胡");
        person1.setAge(18);
        person1.setAddress(address);

        person = personRepository.save(person1);
    }

    @Test
    public void save() {
        Address address = new Address();
        address.setCountry("中国");
        address.setCity("南昌");
        address.setStreet("三经路");

        Person person = new Person();
        person.setName("小胡");
        person.setAge(18);
        person.setAddress(address);

        System.out.println(personRepository.save(person));
    }

    @Test
    public void find() {
        Person one = personRepository.findOne(person.getId());
        System.out.println(one);
    }

    @Test
    public void delete() {
        personRepository.delete(person.getId());
    }
}
