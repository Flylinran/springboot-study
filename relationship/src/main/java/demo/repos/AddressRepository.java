package demo.repos;

import demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: Flyli
 * date: 2017/7/2
 * description:
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
