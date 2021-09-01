package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import steps.MyAccountLoginSteps;

import java.util.Properties;

public class ApplicationHooks {
  //  private MyAccountLoginSteps myAccountLoginSteps;
  //  private WebDriver driver;

    @Before
    public void getScenarioName(Scenario scenario)
    {
        System.out.println("Scenario Name :" +scenario.getName());
        Serenity.getCurrentSession().put("Scenario_Name",scenario.getName());
    }





}
