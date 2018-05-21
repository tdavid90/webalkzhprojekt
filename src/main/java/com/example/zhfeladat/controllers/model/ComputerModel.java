package com.example.zhfeladat.controllers.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ComputerModel {

    private Long id;
    @NotBlank
    @Size(min=2, max=20)
    private String name;

    @NotNull
    @Min(10)
    private Integer number;

    @NotNull
    @Min(10000)
    @Max(300000)
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}


