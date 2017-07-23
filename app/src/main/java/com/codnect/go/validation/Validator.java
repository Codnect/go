package com.codnect.go.validation;

import com.codnect.go.binder.ValidationErrors;

/**
 * Created by User on 23.7.2017.
 */
public abstract class Validator<T> {

    public abstract void validate(T model,ValidationErrors errors);

}
