package com.ruisu.sectorabackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_order")
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "order_sequence",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id_order")
    private Long Id;
    private String description;
    private double price;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "fk_branch",//name of branch id's new column into order table
            referencedColumnName = "id_branch"//add foreign key to make reference, in this case Branch ID(parent class)
    )
    private Branch branch;
}
