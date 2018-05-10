package com.wix.autotestapp.Exceptions;

/**
 * Created by archi on 5/9/2018.
 */
public class ElementNotFoundByTextHerokuException extends Exception {
    private static String exceptionMessage = "Element not found by text in heroku Page";
    public ElementNotFoundByTextHerokuException(String message) {
         super(exceptionMessage+message);
    }
}
