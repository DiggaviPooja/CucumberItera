package steps;

import Util.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MyAccountLoginSteps {

    WebDriver driver;
    String baseURL;
    private ConfigReader configReader = new ConfigReader();;
    Properties prop =configReader.init_prop();

    @Before
    public void setUp()
    {
        System.out.println("Testing Hooks"); //No- /does this gets printed in console
        Serenity.recordReportData().withTitle("Check Hooks");
    }



    public MyAccountLoginSteps() {

    }
     @Step("Launching the Browser")
        public void launchTheBrowser ()
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @Step("Enter url")
        public void provideTheURL ()
        {
            baseURL= prop.getProperty("url");
            driver.get(baseURL);
        }
        @Step("Navigate to My Account")
        public void clickOnAccountMenuu ()
        {
            driver.findElement(By.linkText("My Account")).click();
        }

        @Step("Enter username and password")
        @Screenshots(forEachAction=true)
        public void ProvideUsernameAndPassword ()
        {
            //String user=prop.getProperty("username"); //can send values in both ways
            String pass=prop.getProperty("password");
            driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
            driver.findElement(By.id("password")).sendKeys(pass);
        }

        @Step("click on login")
        @Screenshots(forEachAction=true)
        public void clickOnLoginButton ()
        {
            driver.findElement(By.name("login")).click();
        }

        @Step("Verify the user login")
        public void verifyUserLogin ()
        {
            String capText = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div/p[1]/strong")).getText();
            Assert.assertEquals(true, capText.contains("pavanoltraining")); //wrong input is given
            driver.quit();
        }

    @Step("Enter username and password from DataTable")
    @Screenshots(forEachAction=true) //not working
    public void EnterDataTableCredentials (DataTable credentials)
    {
        List<List<String>> data =credentials.asLists();
        driver.findElement(By.id("username")).sendKeys(data.get(0).get(0));//1 get is row 2nd get is for username
        driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));
    }

    @Step("Enter username and password from DataTable with Header")
    public void EnterDataTableCredentialsFromMap (DataTable credentials)
    {
        List<Map<String,String>> data =credentials.asMaps(String.class,String.class);
        driver.findElement(By.id("username")).sendKeys(data.get(0).get(0));//1 get is row 2nd get is for username
        driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));
    }

    @Step("verify login for multiple users")
    public void VerifyLoginforMultipleUSers ()
    {
        String capText = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div/p[1]/strong")).getText();
        if(capText.contains("Error"))
        {
            Assert.assertTrue("",true);
            driver.quit();
        }
        else
        {
            Assert.assertTrue(false);
        }
    }
   /* @After
    public void tearDown()
    {
        System.out.println("close the browser");
        driver.quit();

    }*/
}
