package com.wix.autotestapp.tests;

import com.wix.autotestapp.data.Names;
import com.wix.autotestapp.pages.HerokuPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by archi on 5/9/2018.
 */
public class HerocuPageDeleteBug extends BaseTest {
    @Test
    public void DeleteBugByNameFromReport(){
        int expectedBugsCount = herokuPage.GridBugsCount();
        HerokuPage newHeroku = herokuPage.submitButton("addButton")
                .InitBugName(super.staticNames.getBugName());
        int actualBugsCount = newHeroku.deleteBugByName(super.staticNames.getBugName()).GridBugsCount();
        Assert.assertEquals(expectedBugsCount,actualBugsCount);
    }
}
