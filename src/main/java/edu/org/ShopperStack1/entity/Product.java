package edu.org.ShopperStack1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String productFeatures;
    @Column(nullable = false)
    private BigDecimal productPrice;

    @ManyToOne
    @JoinColumn
    private Cart cart;
}
