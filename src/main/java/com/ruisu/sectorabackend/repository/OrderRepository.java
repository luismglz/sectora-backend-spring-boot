package com.ruisu.sectorabackend.repository;

import com.ruisu.sectorabackend.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findByDescriptionContaining(String description, Pageable pageable);

}
