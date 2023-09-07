package com.fcwebapp.mediaproducts.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
@Entity
public class Game extends Product{
    private String author;
}
