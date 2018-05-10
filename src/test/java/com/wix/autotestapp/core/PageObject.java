package com.wix.autotestapp.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by archi on 5/9/2018.
 */
public class PageObject {
    protected WebDriver driver;



    public PageObject(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }
}
