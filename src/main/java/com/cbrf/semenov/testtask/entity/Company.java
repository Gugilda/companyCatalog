package com.cbrf.semenov.testtask.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "пустое поле")
    @Pattern(regexp = "[0-9]{10,12}", message = "ИНН 10 или 12 символов")
    private String INN;

    @NotEmpty(message = "пустое поле")
    @Pattern(regexp = "[0-9]{13}", message = "ОГРН 13 символов")
    private String OGRN;

    @NotEmpty(message = "пустое поле")
    private String name;

    @NotEmpty(message = "пустое поле")
    private String address;

    public Company() {
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getOGRN() {
        return OGRN;
    }

    public void setOGRN(String OGRN) {
        this.OGRN = OGRN;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
