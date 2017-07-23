package com.codnect.go.binder;

import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.codnect.go.annotation.ModelBind;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 21.7.2017.
 */
public class ModelBinder {

    private String modelName;

    private Object model;

    private HashMap<String, Integer> fields;

    private Activity activity;

    public ModelBinder(Activity activity){
        this.activity = activity;
        fields = new HashMap<>();
    }

    public void bind(){

        if(model instanceof HashMap){

            for(Map.Entry<String, Integer> entry : fields.entrySet()){

                Integer viewId = entry.getValue();

                if(viewId != null){
                    View view = activity.findViewById(viewId);
                    Object value = null;
                    if(view instanceof EditText){
                        value = ((EditText) view).getText().toString();
                    }
                    else if(view instanceof CheckBox){
                        value = ((CheckBox) view).isChecked();
                    }
                    ((HashMap)model).put(entry.getKey(), value);
                }




            }

        }
        else{

            Field[] fields = model.getClass().getDeclaredFields();
            for(Field field : fields){
                ModelBind modelBindAnnotation = field.getAnnotation(ModelBind.class);

                if(modelBindAnnotation != null){
                    String fieldName = modelBindAnnotation.value();
                    if(fieldName.length() == 0){
                        fieldName = field.getName();
                    }

                    if(fieldName.isEmpty()){
                        continue;
                    }

                    Integer viewId =  getField(fieldName);
                    if(viewId == null){
                        continue;
                    }
                    View view = activity.findViewById(viewId);
                    Object value = null;
                    if(view instanceof EditText){
                        value = ((EditText) view).getText().toString();
                    }
                    else if(view instanceof CheckBox){
                        value = ((CheckBox) view).isChecked();
                    }

                    boolean isAccessible = field.isAccessible();
                    if(!isAccessible){
                        field.setAccessible(true);
                    }

                    try {
                        field.set(model, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    if(!isAccessible){
                        field.setAccessible(false);
                    }

                }

            }

        }



    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

    public void putField(String name, Integer id){
        fields.put(name, id);
    }

    public Integer getField(String name){
        return fields.get(name);
    }

}
