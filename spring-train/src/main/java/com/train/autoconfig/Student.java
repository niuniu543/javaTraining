package com.train.autoconfig;

import org.springframework.context.annotation.Configuration;


public class Student {

    private  String name;
    private  String cell;
    public Student(String name, String cell) {
        this.name = name;
        this.cell = cell;
    }

    public Student(){

    }
    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
