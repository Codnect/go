package com.codnect.test_app.model;

import com.codnect.go.annotation.ModelBind;
import com.codnect.go.annotation.validation.NotEmpty;

/**
 * Created by User on 23.7.2017.
 */
public class PersonFormModel {

    @ModelBind
    @NotEmpty
    private String name;

    @ModelBind
    private int age;

    public PersonFormModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
