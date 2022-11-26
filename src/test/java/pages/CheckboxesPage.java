package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static constansts.StringConstants.BASE_URL;
import static org.testng.Assert.assertEquals;

public class CheckboxesPage {

    @FindBy(css = "h3")
    WebElement pageTitle;

    @FindBy(id = "checkboxes")
    WebElement form;

    @FindBy(css = "#checkboxes > input:nth-of-type(1)")
    WebElement firstCheckBox;

    @FindBy(css = "#checkboxes > input:nth-of-type(2)")
    WebElement secondCheckBox;

    private WebDriver webDriver;

    public CheckboxesPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCheckBoxPage() {
        webDriver.get("https://" + BASE_URL + "/checkboxes");
    }

    public void verifyPageTitle(String expectedPageTitle) {
        assertEquals(pageTitle.getText(), expectedPageTitle);
    }

    public void verifyFirstCheckBoxIsSet(boolean checkBoxSet) {
        assertEquals(firstCheckBox.isSelected(), checkBoxSet);
    }

    public void verifySecondCheckBoxIsSet(boolean checkBoxSet) {
        assertEquals(secondCheckBox.isSelected(), checkBoxSet);
    }

    public void clickFirstCheckbox() {
        firstCheckBox.click();
    }

    public void clickSecondCheckbox() {
        secondCheckBox.click();
    }

    public void verifyFormText(String textValue) {
        assertEquals(form.getText(), textValue);
    }
}
