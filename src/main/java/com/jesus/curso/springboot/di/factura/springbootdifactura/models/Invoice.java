package com.jesus.curso.springboot.di.factura.springbootdifactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description.office}")
    private String description;

    @Autowired
    @Qualifier("default")
    private List<Item> items;

    private Double subTotal;
    private Double iva;
    private Double total;

    
    //aqui con el constructor cuando se instancia no tienen valor los componentes (null)
    public Invoice() {
        System.out.println("Creando componente de la factura");
        System.out.println(client);
        System.out.println(description);
    }

    //esto se ejecutara cuando se crea el componente despues del constructor y aqui si se instancia ya tienen valor los componentes
    @PostConstruct
    public void init(){
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat(" de Jesus"));  //aqui se le setea el nombre y se obnteiene del properties y se concatena con el dato adicional
        description = description.concat(" del cliente ").concat(getClient().getName().concat(" ").concat(client.getLastName()));
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destruyendo el componente o bean invoice");
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }


    public Double getsubTotal() {
        //calcular el total de la factura con un ciclo for
        /*for (Item item : items) {
            total += item.getImporte();
        }*/

        subTotal = items.stream()
        .map(item -> item.getImporte())  //convertimos al tipo importa
        .reduce(0.00, (sum, importe) -> sum + importe);  //se suma con reduce a 0 como valor inicial y en el acumulador(sum) se guarda el valor de cada iteracion y se suma
        return subTotal;
    }

    

    public Double getIva() {
        return subTotal *.16;
    }

    public Double getTotal() {
        return subTotal + iva;
    }

    

}
