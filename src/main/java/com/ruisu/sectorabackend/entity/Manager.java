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
public class Manager {

    @Id
    @SequenceGenerator(
            name = "manager_sequence",
            sequenceName = "manager_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "manager_sequence",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id_manager")
    private Long id;
    private String firstName;
    private String lastName;

    @OneToOne(
            mappedBy = "manager",
            fetch = FetchType.EAGER
    )
    private Branch branch;
}
