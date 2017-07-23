package demo;

import com.alibaba.fastjson.JSONObject;
import demo.entity.Address;
import demo.entity.CellPhone;
import demo.entity.Person;
import demo.repos.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * author: Flyli
 * date: 2017/7/2
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToMany {
    @Resource
    private PersonRepository personRepository;

    private Person person;

    @Before
    public void before() {

    }

    @Test
    public void save() {
        Address address = new Address();
        address.setCountry("中国");
        address.setCity("南昌");
        address.setStreet("三经路");

        Person p = new Person();
        p.setAge(19);
        p.setName("鲁班");
        p.setAddress(address);

        List<CellPhone> cellPhones = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CellPhone cellPhone = new CellPhone();
            cellPhone.setPerson(p);
            cellPhone.setColor("red");
            cellPhone.setManufacture("AAA");
            cellPhone.setPhoneNo(11111L);
            cellPhones.add(cellPhone);
        }
        p.setCellPhones(cellPhones);
        person = personRepository.save(p);
        System.out.println(person);
    }

    @Test
    public void find() {

        Person one = personRepository.findOne(3L);
        System.out.println(one.getAddress());
        System.err.println(JSONObject.toJSONString(one.getCellPhones().get(1).getPerson()));
//        System.out.println(one.getCellPhones()); //懒加载挂掉
    }

    @Test
    public void update() {
        Address address = new Address();
        address.setCountry("中国");
        address.setCity("南昌");
        address.setStreet("三经路");

        Person p = new Person();
        p.setAge(19);
        p.setName("老夫子");
        p.setAddress(address);
        Person one = personRepository.findOne(1L);
        List<CellPhone> cellPhones = one.getCellPhones();
        cellPhones.forEach(cellPhone -> cellPhone.setPerson(p));
        one.setCellPhones(cellPhones);
        System.err.println(JSONObject.toJSONString(personRepository.save(p)));
        System.err.println(JSONObject.toJSONString(personRepository.save(one)));
    }
}
