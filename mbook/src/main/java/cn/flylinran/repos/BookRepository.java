package cn.flylinran.repos;

import cn.flylinran.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * author: huzunrong
 * date: 2017/6/6
 * description:
 * version: 1.0
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findAllByDeletedFalse(Pageable pageable);

    @Modifying
    @Query("UPDATE Book b SET b.deleted = true WHERE b.id =?1")
    int logicalDeleteById(Long id);
}
