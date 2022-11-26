package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static constansts.StringConstants.BASE_URL;

public class BasicAuthPage {

    @FindBy(css = "h3")
    WebElement pageTitle;

    @FindBy(css = "p")
    WebElement pageText;

    private WebDriver webDriver;

    public BasicAuthPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginUser(String userName, String userPassword) {
        String urlComplete = "https://" + userName + ":" + userPassword + "@" + BASE_URL + "/basic_auth";
        webDriver.get(urlComplete);
    }

    public void verifyPageTitle(String expectedPageTitle) {
        Assert.assertEquals(pageTitle.getText(), expectedPageTitle);
    }

    public void verifyPageText(String expectedPageTitle) {
        Assert.assertEquals(pageText.getText(), expectedPageTitle);
    }
}
