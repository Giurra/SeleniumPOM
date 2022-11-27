package tests;

import config.TestBase;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

import static constansts.StringConstants.CHECKBOX_TITLE;
import static constansts.StringConstants.CHECKBOX_VALUES;

public class TestCheckBox extends TestBase {

    @Test
    public void checkBoxes() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(webDriver);
        checkboxesPage.openCheckBoxPage();

        checkboxesPage.verifyPageTitle(CHECKBOX_TITLE);
        checkboxesPage.verifyFirstCheckBoxIsSet(false);
        checkboxesPage.verifySecondCheckBoxIsSet(true);

        checkboxesPage.clickFirstCheckbox();
        checkboxesPage.clickSecondCheckbox();
        checkboxesPage.verifyFirstCheckBoxIsSet(true);
        checkboxesPage.verifySecondCheckBoxIsSet(false);

        checkboxesPage.verifyFormText(CHECKBOX_VALUES);
    }
}
