package com.jesus.curso.springboot.di.factura.springbootdifactura.models;

public class Item {

    private Product product;
    private Integer quantity;

    

    public Item() {
    }

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    //para mostrar el total del producto creamos este metodo 
    public Double getImporte(){
        return quantity * product.getPrice();
    }

    
}
