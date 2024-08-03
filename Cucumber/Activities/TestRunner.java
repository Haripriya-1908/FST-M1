package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"stepDefinitions"},
    tags = "@DatatableExample",
    publish = true,
    plugin = {
    		"pretty",
    		"html:src/reports/HTML_Report.html",
    		"json:src/reports/JSON_Report.json",
    		"junit:src/reports/xml_Report.xml"
    		
    		
    }
    		
)


public class TestRunner {

}
