package com.wix.autotestapp.tests;

import com.wix.autotestapp.data.Names;
import com.wix.autotestapp.pages.HerokuPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by archi on 5/9/2018.
 */
public class HerokuPageAddBug extends BaseTest {
    @Test
    public void AddBugToReport(){
        int expectedBugsCount = herokuPage.GridBugsCount()+1;
        int actualBugsCount = herokuPage.submitButton("addButton").GridBugsCount();
        Assert.assertEquals(expectedBugsCount,actualBugsCount);
    }

    @Test
    public void initBugName(){
        HerokuPage newHeroku = herokuPage.submitButton("addButton")
                                         .InitBugName(super.staticNames.getBugName());
        Assert.assertNotNull(newHeroku.getBugByName(super.staticNames.getBugName()));
    }
}
