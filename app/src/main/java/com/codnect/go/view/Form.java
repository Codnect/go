package com.codnect.go.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.codnect.go.R;

/**
 * Created by User on 22.7.2017.
 */
public class Form extends LinearLayout {

    private String modelName;
    private int submitViewId;

    public Form(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Form,
                0, 0);

        try {
            modelName = a.getString(R.styleable.Form_modelName);
            submitViewId = a.getResourceId(R.styleable.Form_submit, 0);
        } finally {
            a.recycle();
        }
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getSubmitViewId() {
        return submitViewId;
    }

    public void setSubmitViewId(int submitViewId) {
        this.submitViewId = submitViewId;
    }
}
