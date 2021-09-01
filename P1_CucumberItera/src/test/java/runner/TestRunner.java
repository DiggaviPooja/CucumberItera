package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import javax.naming.spi.ObjectFactory;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin= {"pretty"},
        // to get output in particular folder->html,json and xml format
        features="src/test/resources/features",
        glue="stepdefs",
        // dryRun = false, //it will verify mapping
        //strict = false,
        monochrome = true //will give detail info in console
      //  tags = {"@DataTableTest","~@simpleTest"}
    //,"html:test-output","json:json_output/cucumber.json","junit:junit_xml_output/cucumber.xml"


)
public class TestRunner {
}
