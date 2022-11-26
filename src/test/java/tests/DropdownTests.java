package tests;

import config.TestBase;
import org.testng.annotations.Test;
import pages.DropdownPage;

import static constansts.StringConstants.DROPDOWN_TITLE;

public class DropdownTests extends TestBase {

    @Test
    public void dropDown() {
        DropdownPage dropdownPage = new DropdownPage(webDriver);
        dropdownPage.openDropdownPage();

        dropdownPage.verifyPageTitle(DROPDOWN_TITLE);
        dropdownPage.verifyDefaultValue();
        dropdownPage.verifyAllOptions();
    }
}
