package com.ruisu.sectorabackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="branches")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @OneToOne
    @JoinColumn(
            name = "manager",
            referencedColumnName = "id"
    )
    private Manager manager;
}
