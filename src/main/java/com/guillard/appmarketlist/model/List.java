package com.guillard.appmarketlist.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_list")
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_list")
    private Integer id;

    @Column(name = "creation_date", nullable = false)
    private LocalDate date;

    @Column(name = "market_name", length = 45)
    private String marketName;

    @Column(name = "total_value")
    private Double totalValue;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL)
    private java.util.List<ItemList> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public java.util.List<ItemList> getItems() {
        return items;
    }

    public void setItems(java.util.List<ItemList> items) {
        this.items = items;
    }
}
