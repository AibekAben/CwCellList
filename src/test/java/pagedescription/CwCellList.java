package pagedescription;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.ConfProperties;
import webdriver.RunWebdriver;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class CwCellList {

    private static RunWebdriver runWebdriver;

    WebDriverWait wait = new WebDriverWait(runWebdriver.getDriver(), 10);

    public CwCellList(RunWebdriver runWebdriver) {
        this.runWebdriver = runWebdriver;
        PageFactory.initElements(runWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "//tbody/tr[2]/td[2]/input[1]")
    private WebElement firstName;

    @FindBy(xpath = "//tbody/tr[3]/td[2]/input[1]")
    private WebElement lastName;

    @FindBy(xpath = "//tbody/tr[4]/td[2]/select[1]")
    private WebElement category;

    @FindBy(className = "gwt-DateBox")
    private WebElement birthday;

    @FindBy(xpath = "//tbody/tr[3]/td[4]/div[1]")
    private WebElement calendarFebTen;

    @FindBy(className = "gwt-TextArea")
    private WebElement address;

    @FindBy(xpath = "//button[contains(text(),'Create Contact')]")
    private WebElement btnCreateContact;

    @FindBy(xpath = "//tbody/tr[1]/td[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    private WebElement contactList;

    @FindBy(className = "GNHGC04CCB")
    private List<WebElement> counterContacts;


    public void enterNameMesut(){
        firstName.sendKeys(ConfProperties.getProperty("firstName1"));
    }

    public void enterLastNameOzil(){
        lastName.sendKeys(ConfProperties.getProperty("lastName1"));
    }

    public void enterBirthdayMO(){
        birthday.click();
    }

    public void selectCalendarMO(){
        calendarFebTen.click();
    }

    public void enterAddressMO(){
        address.sendKeys(ConfProperties.getProperty("address1"));
    }

    public void createContact(){
        wait.until(ExpectedConditions.elementToBeClickable(btnCreateContact));
        btnCreateContact.click();
    }

    public void scrollContactList() throws InterruptedException {

        contactList.sendKeys(Keys.END);
        Thread.sleep(5000);  //добавил только чтобы визуально увидеть что данные правильно записались и скрол отработал верно
        assertTrue(runWebdriver.getDriver().getPageSource().contains("Mesut Ozil"), "contact not found!");
        assertTrue(runWebdriver.getDriver().getPageSource().contains(": 251"),"counter is not correct");
    }


}
