package demo.repos;

import demo.entity.CellPhone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: Flyli
 * date: 2017/7/2
 * description:
 */
public interface CellPhoneRepository extends JpaRepository<CellPhone, Long> {
}
