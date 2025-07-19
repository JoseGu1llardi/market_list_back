package com.guillard.appmarketlist.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_itemlist")
public class ItemList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numb_seq")
    private Integer numbSeq;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "tbl_product_id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "tbl_list_id_list")
    private List list;

    public Integer getNumbSeq() {
        return numbSeq;
    }

    public void setNumbSeq(Integer numbSeq) {
        this.numbSeq = numbSeq;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
