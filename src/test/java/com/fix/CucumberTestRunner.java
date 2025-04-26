
package com.fix;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // path to your .feature files
    glue = "com.fix.stepdefs"                 // package of your step definitions
)
public class CucumberTestRunner {
}

