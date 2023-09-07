package com.fcwebapp.mediaproducts.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Embeddable
@Data
@RequiredArgsConstructor
public class Address {
    private String streetAddress;
    private String city;
    private String postalCode;
}
