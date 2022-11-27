package tests;

import config.TestBase;
import org.testng.annotations.Test;
import pages.BasicAuthPage;

import static constansts.StringConstants.BASIC_AUTH_TEXT;
import static constansts.StringConstants.BASIC_AUTH_TITLE;

public class TestLogin extends TestBase {

    @Test
    public void basicAuth() {
        String userName = "admin";
        String userPassword = "admin";

        BasicAuthPage basicAuthPage = new BasicAuthPage(webDriver);
        basicAuthPage.loginUser(userName, userPassword);

        basicAuthPage.verifyPageTitle(BASIC_AUTH_TITLE);
        basicAuthPage.verifyPageText(BASIC_AUTH_TEXT);
    }
}
