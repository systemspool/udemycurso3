package com.jesus.curso.springboot.di.factura.springbootdifactura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Client {

    //con value inyectamos el valor de nombre desde el data.porperties
    @Value("${client.name}")
    private String name;
    @Value("${client.lastName}")
    private String lastName;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    

}
