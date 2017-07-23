package com.codnect.go.binder;

import java.util.HashMap;

/**
 * Created by User on 23.7.2017.
 */
public class ValidationErrors {

    private HashMap<String, String> errors;

    public ValidationErrors(){
        errors = new HashMap<>();
    }

    public void put(String name, String message){
        errors.put(name, message);
    }

    public String getErrorMessage(String name){
        return errors.get(name);
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public int size(){
        return errors.size();
    }
}
