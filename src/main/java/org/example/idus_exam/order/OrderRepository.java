package org.example.idus_exam.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    static List<Order> findAllId(Long memberidx) {
        return null;
    }
}
