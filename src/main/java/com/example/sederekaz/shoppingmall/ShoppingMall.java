package com.example.sederekaz.shoppingmall;

import com.example.sederekaz.shop.Shop;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shopping_malls")
public class ShoppingMall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name",nullable = false)
    private String name;

    @OneToMany(mappedBy = "shoppingMall")
    private Set<Shop> shops;

}
