package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagedescription.CwCellList;
import webdriver.ConfProperties;
import webdriver.RunWebdriver;

import java.net.MalformedURLException;


public class RunTest {

    private static RunWebdriver runWebdriver;
    private static CwCellList cwCellList;


    @BeforeClass
    protected void invoke() throws MalformedURLException {

        runWebdriver.getInstance().get(ConfProperties.getProperty("url"));
        cwCellList = new CwCellList(runWebdriver);

    }

    @Test
    public void createContactFamily() throws InterruptedException {

       cwCellList.enterNameMesut();
       cwCellList.enterLastNameOzil();
       cwCellList.enterBirthdayMO();
       cwCellList.selectCalendarMO();
       cwCellList.enterAddressMO();
       cwCellList.createContact();
       cwCellList.scrollContactList();
    }

    @AfterClass
    protected static void tearDown() {
        runWebdriver.CloseDriver();
    }
}
