package com.jesus.curso.springboot.di.factura.springbootdifactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.jesus.curso.springboot.di.factura.springbootdifactura.models.Item;
import com.jesus.curso.springboot.di.factura.springbootdifactura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class appconfig {

    //creamos directo una lista que se agregara en invoice items y se inyectara en la misma
    @Bean
    @Primary
    List<Item> itemsInvoice(){

        Product p1 = new Product("Camara Sony", 800.00);
        Product p2 = new Product("Xbox One S", 1200.00);
       return Arrays.asList(new Item(p1, 2), new Item(p2, 3));
    }

    @Bean("default")
    List<Item> itemsInvoiceOffice(){

        Product p1 = new Product("Monitor Samsung 24", 500.00);
        Product p2 = new Product("NoteBook Razer", 1500.00);
        Product p3 = new Product("Impresora Epson", 700.00);
        Product p4 = new Product("Escritorio", 450.00);
       return Arrays.asList(new Item(p1, 4), new Item(p2, 4), new Item(p3, 2), new Item(p4, 4));
    }

}
