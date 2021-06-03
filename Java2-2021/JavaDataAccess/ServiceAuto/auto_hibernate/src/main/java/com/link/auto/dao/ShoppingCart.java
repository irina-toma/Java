package com.link.auto.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "price")
    private float price;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cart_id")
    private List<ShoppingItem> shoppingItemList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<ShoppingItem> getItemList() {
        return shoppingItemList;
    }

    public void setItemList(List<ShoppingItem> shoppingItemList) {
        this.shoppingItemList = shoppingItemList;
    }
}