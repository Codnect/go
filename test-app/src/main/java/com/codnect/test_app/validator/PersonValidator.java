package com.codnect.test_app.validator;

import com.codnect.go.binder.ValidationErrors;
import com.codnect.go.validation.Validator;
import com.codnect.test_app.model.PersonFormModel;

/**
 * Created by User on 23.7.2017.
 */
public class PersonValidator extends Validator<PersonFormModel>
{
    @Override
    public void validate(PersonFormModel model, ValidationErrors errors) {
        /* ... */
    }

}
