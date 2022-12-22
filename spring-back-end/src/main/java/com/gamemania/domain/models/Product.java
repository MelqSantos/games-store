package com.gamemania.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String img_url;

    private String title;

    private int stars;

    private BigDecimal price;
}
