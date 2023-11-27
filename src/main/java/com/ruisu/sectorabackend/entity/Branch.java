package com.ruisu.sectorabackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name="branches")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "manager")
public class Branch {

    @Id
    @SequenceGenerator(
            name = "branch_sequence",
            sequenceName = "branch_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "branch_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @NotBlank()
    private String name;

    @Length(min = 7, max = 20)
    private String telephone;

    @Length(min = 5, max = 100)
    private String address;

    @OneToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER, //Lazy only bring branch, not manager
            optional = false
    )
    @JoinColumn(
            name = "fk_manager",
            referencedColumnName = "id"
    )
    private Manager manager;

    /*@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name="id",
            referencedColumnName = "id"
    )
    private List<Order> orders;*/
}
