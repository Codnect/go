package com.codnect.go.form;

import java.util.HashMap;

/**
 * Created by User on 21.7.2017.
 */
public class ModelForm {

    private HashMap<String, Object> formFields;

    public ModelForm(){
        formFields = new HashMap<>();
    }

    public void putField(String name, Object o){
        formFields.put(name, o);
    }

    public Object getField(String name){
        return formFields.get(name);
    }
}
