package com.wix.autotestapp.pages;

import com.wix.autotestapp.Exceptions.ElementNotFoundByTextHerokuException;
import com.wix.autotestapp.core.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by archi on 5/9/2018.
 */
public class HerokuPage extends PageObject {

    @FindBy(id = "ext-gen1032")
    private WebElement titleHeader;

    @FindBy(css = "[id*='column-10']")
    private List<WebElement> columns;

    @FindBy(css = "tr.x-grid-row")
    private List<WebElement> bugs;

    @FindBy(id = "ext-gen1087")
    private WebElement addButton;

    @FindBy(id = "button-1045")
    private WebElement deleteButton;

    @FindBy(id = "button-1010")
    private WebElement confirmButton;

    @FindBy(css = "#ext-comp-1059  [type='text']")
    private WebElement nameTextField;

    private Map<String, WebElement> elementsMap = null;
    private JavascriptExecutor js = (JavascriptExecutor) this.driver;

    public boolean IsVisible(String element){
      return getWebElementByKey(element).isDisplayed();
    }

    public String FindTextByWebElement(String element) {
        String text = js.executeScript("return arguments[0].innerText;", getWebElementByKey(element)).toString();
        return text;
    }

    public void enterParameter(WebElement element, String parameter){
        element.sendKeys(parameter);
    }

    public HerokuPage submitButton(String button){
        getWebElementByKey(button).click();
        return new HerokuPage(this.driver);
    }

    public synchronized HerokuPage deleteBugByName(String name){
        Actions builder = new Actions(this.driver);
        WebElement findElement = getBugByName(name);
        builder.doubleClick(findElement).build().perform();
        deleteButton.click();
        confirmButton.click();
        return new HerokuPage(this.driver);
    }

    public HerokuPage InitBugName(String name){
      enterParameter(nameTextField, name);
      titleHeader.click();
      return new HerokuPage(this.driver);
    }


    public HerokuPage(WebDriver driver) {
        super(driver);
        initElementMap();
    }

    public int GridColumnsCount(){
        return this.columns.size();
    }

    public int GridBugsCount(){
        return bugs.size();
    }

    public boolean IsTitleExistsInColumns(String text){
        boolean isExists = false;
        for ( WebElement column: this.columns){
            if (js.executeScript("return arguments[0].innerText;", column).toString().equals(text)) {
                isExists = true;
            }
        }
        return isExists;
    }

    public WebElement getBugByName(String text){
        WebElement findBug = null;
        try {
        for ( WebElement bug: this.bugs){
            if (js.executeScript("return arguments[0].innerText;", bug).toString().contains(text)) {
                findBug = bug;
            }
            }
            if (findBug == null){
                    throw new ElementNotFoundByTextHerokuException(text);
            }
        } catch (ElementNotFoundByTextHerokuException ex) {

        }
        return findBug;
    }

    private synchronized void initElementMap(){
        if(this.elementsMap == null){
            this.elementsMap = new HashMap();
            this.elementsMap.put("addButton",this.addButton);
            this.elementsMap.put("titleHeader", this.titleHeader);
            this.elementsMap.put("deleteButton", this.deleteButton);
        }
    }
    
    private WebElement getWebElementByKey(String key){
        return this.elementsMap.get(key);
    }
}

