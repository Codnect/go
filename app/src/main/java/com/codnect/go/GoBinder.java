package com.codnect.go;

import android.app.Activity;
import android.view.View;

import com.codnect.go.annotation.Form;
import com.codnect.go.annotation.FormField;
import com.codnect.go.annotation.LayoutBind;
import com.codnect.go.annotation.OnClick;
import com.codnect.go.annotation.ViewBind;
import com.codnect.go.form.FormBind;
import com.codnect.go.form.ModelForm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by User on 21.7.2017.
 */
public class GoBinder {

    private static GoBinder goBinder = new GoBinder();

    private HashMap<Integer, View> viewHashMap = new HashMap<>();

    private HashMap<String, FormBind> formBindHashMap = new HashMap<>();

    private GoBinder(){
    }

    public static GoBinder getInstance(){
        return goBinder;
    }

    public void initilaze(Activity activity){
        bind(activity);
    }

    private void bind(final Activity activity){

        Class activityClass = activity.getClass();
        LayoutBind layoutBindAnnotation =
                (LayoutBind) activityClass.getAnnotation(LayoutBind.class);
        if(layoutBindAnnotation != null){
            activity.setContentView(layoutBindAnnotation.value());
        }

        Field[] declaredFields = activityClass.getDeclaredFields();
        for(Field field : declaredFields){
            ViewBind viewBindAnnotation = field.getAnnotation(ViewBind.class);
            Form formAnnotation = field.getAnnotation(Form.class);
            //ValueBind valueBindAnnotation = field.getAnnotation(ValueBind.class);

            boolean fieldAccessible = field.isAccessible();
            if(!fieldAccessible){
                field.setAccessible(true);
            }
            if(viewBindAnnotation != null){
                try {
                    field.set(activity, activity.findViewById(viewBindAnnotation.value()));
                    viewHashMap.put(viewBindAnnotation.value(), (View) field.get(activity));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            else if(formAnnotation != null){
                FormBind formBind = new FormBind(activity);
                formBind.setName(formAnnotation.name());
                FormField[] formFields = formAnnotation.fields();
                for(FormField formField : formFields){
                    formBind.putField(formField.name(), formField.id());
                }
                formBindHashMap.put(formBind.getName(), formBind);
                try {
                    ModelForm modelForm = new ModelForm();
                    field.set(activity, modelForm);
                    formBind.setModelForm(modelForm);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            /*
            else if(valueBindAnnotation != null){
                try {
                    if(field.getType().isAssignableFrom(String.class)){
                        field.set(activity, activity.getResources().getString(valueBindAnnotation.value()));
                    }
                    else if(field.getType().isAssignableFrom(String[].class)){
                        field.set(activity, activity.getResources().getStringArray(valueBindAnnotation.value()));
                    }
                    else if(field.getType().isAssignableFrom(Integer.class)
                            || field.getType().isAssignableFrom(int.class)){
                        field.set(activity, activity.getResources().getInteger(valueBindAnnotation.value()));
                    }
                    else if(field.getType().isAssignableFrom(Integer[].class)
                            || field.getType().isAssignableFrom(int[].class)){
                        field.set(activity, activity.getResources().getIntArray(valueBindAnnotation.value()));
                    }
                    else if(field.getType().isAssignableFrom(Drawable.class)){
                        field.set(activity, ContextCompat.getDrawable(activity.getApplicationContext(),
                                valueBindAnnotation.value()));
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            */
            if(!fieldAccessible){
                field.setAccessible(false);
            }
        }

        Method[] declaredMethods = activityClass.getDeclaredMethods();
        for(final Method method : declaredMethods){
            final OnClick onClickAnnotation = method.getAnnotation(OnClick.class);

           /* boolean fieldAccessible = method.isAccessible();
            if(!fieldAccessible){
                field.setAccessible(true);
            }*/
            if(onClickAnnotation != null){
                View view = viewHashMap.get(onClickAnnotation.value());
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            String formName = onClickAnnotation.formName();
                            if(formName != null){
                                formBindHashMap.get(formName).bind();
                            }
                            method.invoke(activity);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }

            /*
            if(!fieldAccessible){
                field.setAccessible(false);
            }*/
        }


    }
}
