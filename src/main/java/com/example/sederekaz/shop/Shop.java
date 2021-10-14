package com.example.sederekaz.shop;

import com.example.sederekaz.shoppingmall.ShoppingMall;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name ="shopping_mall_id",nullable = false )
    private ShoppingMall shoppingMall;
}
