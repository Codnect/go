package com.codnect.go.form;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 21.7.2017.
 */
public class FormBind {

    private String name;

    private ModelForm modelForm;

    private HashMap<String, Integer> fields;

    private Activity activity;

    public FormBind(Activity activity){
        this.activity = activity;
        fields = new HashMap<>();
    }

    public void bind(){

        for(Map.Entry<String, Integer> entry : fields.entrySet()) {
            String name = entry.getKey();
            int id = entry.getValue();

            View view= activity.findViewById(id);
            Object value = null;
            if(view instanceof EditText){
                value = ((EditText) view).getText().toString();
            }
            else if(view instanceof CheckBox){
                value = ((CheckBox) view).isChecked();
            }
            modelForm.putField(name, value);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void putField(String name, Integer id){
        fields.put(name, id);
    }

    public Integer getField(String name){
        return fields.get(name);
    }

    public HashMap<String, Integer> getFields() {
        return fields;
    }

    public void setFields(HashMap<String, Integer> fields) {
        this.fields = fields;
    }

    public ModelForm getModelForm() {
        return modelForm;
    }

    public void setModelForm(ModelForm modelForm) {
        this.modelForm = modelForm;
    }
}
