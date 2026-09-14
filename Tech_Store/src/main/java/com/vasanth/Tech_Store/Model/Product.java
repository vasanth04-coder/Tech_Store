package com.vasanth.Tech_Store.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")

public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    @Min(value =100,message = "price must be greater than 100")
    @Max(value = 9999999,message = "Not valid price")
    private int price;

    @Min(value = 0, message = "Quantity cant't be negative")
    @Max(value = 9999,message = "Quantity is too high")
    private int quantity;

    @NotBlank
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;
}
