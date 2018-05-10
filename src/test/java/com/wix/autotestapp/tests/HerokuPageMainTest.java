package com.wix.autotestapp.tests;

import com.wix.autotestapp.data.Names;
import org.junit.Test;
import org.junit.Assert;

/**
 * Created by archi on 5/9/2018.
 */
public class HerokuPageMainTest extends BaseTest {

    @Test
    public void titleHeaderDisplaying(){
        Assert.assertTrue(herokuPage.IsVisible("titleHeader"));
        Assert.assertEquals(super.staticNames.getHeaderTitle(),herokuPage.FindTextByWebElement("titleHeader"));
    }

    @Test
    public void gridColumnsCount(){
        Assert.assertEquals(8,herokuPage.GridColumnsCount());
    }

    @Test
    public void gridColumnsContainTitleName(){
        Assert.assertTrue(herokuPage.IsTitleExistsInColumns(this.staticNames.getColumnName()));
    }

}
