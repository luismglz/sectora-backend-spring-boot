package com.ruisu.sectorabackend.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "addressLine",
                column = @Column(name = "addressLine")
        ),
        @AttributeOverride(
                name = "postalCode",
                column = @Column(name = "postalCode")
        ),
        @AttributeOverride(
                name = "city",
                column = @Column(name = "city")
        ),
        @AttributeOverride(
                name = "state",
                column = @Column(name = "state")
        ),
        @AttributeOverride(
                name = "country",
                column = @Column(name = "country")
        )
})
public class Address {
    private String addressLine;
    private String postalCode;
    private String city;
    private String state;
    private String country;
}
