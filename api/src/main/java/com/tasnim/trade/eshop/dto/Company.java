package com.tasnim.trade.eshop.dto;

public class Company extends DtoBase {

    private String name;

    private String persianName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersianName() {
        return persianName;
    }

    public void setPersianName(String persianName) {
        this.persianName = persianName;
    }
}
