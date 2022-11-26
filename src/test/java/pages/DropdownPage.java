package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static constansts.StringConstants.*;
import static org.testng.Assert.assertEquals;

public class DropdownPage {

    @FindBy(css = "h3")
    WebElement pageTitle;

    @FindBy(id = "dropdown")
    WebElement dropdown;

    private WebDriver webDriver;

    public DropdownPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openDropdownPage() {
        webDriver.get("https://" + BASE_URL + "/dropdown");
    }

    public void verifyPageTitle(String expectedPageTitle) {
        assertEquals(pageTitle.getText(), expectedPageTitle);
    }

    public void verifyAllOptions() {
        Select selectDropdown = new Select(dropdown);
        List<String> dropdownOptionsValues = new ArrayList<>();
        List<WebElement> dropdownOptions = selectDropdown.getOptions();
        for (WebElement dropdownOption : dropdownOptions) {
            dropdownOptionsValues.add(dropdownOption.getText());
        }
        assertEquals(dropdownOptionsValues, DROPDOWN_ALL_VALUES);
    }

    public void verifyDefaultValue() {
        Select selectDropdown = new Select(dropdown);
        assertEquals(selectDropdown.getFirstSelectedOption().getText(), DROPDOWN_DEFAULT_VALUE);
    }
}
