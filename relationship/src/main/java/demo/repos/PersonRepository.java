package demo.repos;

import demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: Flyli
 * date: 2017/7/2
 * description:
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
