package com.codnect.test_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.codnect.go.GoBinder;
import com.codnect.go.annotation.LayoutBind;
import com.codnect.go.annotation.Model;
import com.codnect.go.annotation.OnClick;
import com.codnect.go.annotation.ViewBind;
import com.codnect.go.binder.ValidationErrors;
import com.codnect.test_app.model.PersonFormModel;
import com.codnect.test_app.validator.PersonValidator;

@LayoutBind(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewBind(R.id.buttonClick)
    private Button buttonClick;

    @ViewBind(R.id.editTextMessage)
    private EditText editTextMessage;

    @ViewBind(R.id.checkBox)
    private CheckBox checkBox;

    @Model(value = "personModel", validator = PersonValidator.class)
    private PersonFormModel personFormModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GoBinder.getInstance().initialize(this);

    }

    @OnClick(value = R.id.buttonClick)
    public void submitPersonForm(View view, ValidationErrors errors){
        /* ... */
    }

}
