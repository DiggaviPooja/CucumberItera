package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.MyAccountLoginSteps;

import java.util.List;

public class MyAccountLoginStepDefinitions  {

    @Steps
    private MyAccountLoginSteps myAccountLoginSteps;

   /* public MyAccountLoginStepDefinitions(MyAccountLoginSteps myAccountLoginSteps) {
        this.myAccountLoginSteps = myAccountLoginSteps;
    }*/

    @Given("^Open the browser$")
    public void open_the_browser() throws Throwable {
        myAccountLoginSteps.launchTheBrowser();
    }

    @And("^User Enter the URL \"([^\"]*)\"$")
    public void enter_the_URL(String arg1) throws Throwable {
        myAccountLoginSteps.provideTheURL();
    }
    @When("User Enter the URL")
    public void userEnterTheURL() {
        myAccountLoginSteps.provideTheURL();
    }

    @And("^Click on My Account Menu$")
    public void click_on_My_Account_Menu() throws Throwable {
        myAccountLoginSteps.clickOnAccountMenuu();

    }

    @And("^Enter registered username and password$")
    public void enter_registered_username_and_password() throws Throwable {
        myAccountLoginSteps.ProvideUsernameAndPassword();
    }

    @And("^Click on login button$")
    public void click_on_login_button() throws Throwable {
        myAccountLoginSteps.clickOnLoginButton();
    }

    @Then("^User must successfully login to the web page$")
    public void user_must_successfully_login_to_the_web_page() throws Throwable {
        myAccountLoginSteps.verifyUserLogin();
    }


    @And("user enters registered username and password")
    public void userEntersRegisteredUsernameAndPassword(DataTable credentials) {
        myAccountLoginSteps.EnterDataTableCredentials(credentials);
    }

    @And("user enters registered username and password with headers")
    public void userEntersRegisteredUsernameAndPasswordwithheaders(DataTable credentials) {
        myAccountLoginSteps.EnterDataTableCredentialsFromMap(credentials);
    }


    @Then("Verify Login")
    public void verifyLogin() {

    }


}
