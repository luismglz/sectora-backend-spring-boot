package com.ruisu.sectorabackend.repository;

import com.ruisu.sectorabackend.entity.Branch;
import com.ruisu.sectorabackend.entity.Manager;
import com.ruisu.sectorabackend.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;


    @Test
    public void saveOrder(){

        Manager manager = Manager.builder()
                .firstName("Hideto")
                .lastName("Matsumoto")
                .build();

        Branch branch = Branch.builder()
                .name("Akihabara")
                .address("4-3-3 Sotokanda Chiyoda-ku Tokyo, JAPAN, 101-0021")
                .telephone("0570-024-511")
                .manager(manager)
                .build();

        Order order = Order.builder()
                .description("Anime-themed Ramen Bowl Set")
                .price(5500)
                .branch(branch)
                .build();

        orderRepository.save(order);
    }

    @Test
    public void findAllOrdersPaging(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);

        List<Order> orders = orderRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = orderRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = orderRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println(orders);
        System.out.println(totalElements);
        System.out.println(totalPages);

    }

    @Test
    public void findAllOrdersWithSorting(){
        Pageable sortByPriceAsc = PageRequest.of(0, 3, Sort.by("price"));
        Pageable sortByPriceDesc = PageRequest.of(0, 3, Sort.by("price").descending());

        List<Order> orders = orderRepository.findAll(sortByPriceAsc).getContent();

        System.out.println(orders);
    }

    
    @Test
    public void findAllOrdersDescriptionContaining(){
        Pageable pageable = PageRequest.of(0,5);

        List<Order> orders = orderRepository.findByDescriptionContaining("An", pageable).getContent();
        System.out.println(orders);
    }



}