package ru.maksirep.technique_registry.core.entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    private Integer id;
    private String name;
    private String country;
    private String manufacturer;
    private boolean isOnline;
    private boolean isInstallment;

    public Product() {
    }

    public Product(Integer id,
                   String name,
                   String country,
                   String manufacturer,
                   boolean isOnline,
                   boolean isInstallment) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.manufacturer = manufacturer;
        this.isOnline = isOnline;
        this.isInstallment = isInstallment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean getOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public boolean getInstallment() {
        return isInstallment;
    }

    public void setInstallment(boolean installment) {
        isInstallment = installment;
    }
}
