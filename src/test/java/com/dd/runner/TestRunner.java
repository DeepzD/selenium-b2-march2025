package com.dd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = {"src/test/resources/features"},
            glue = {"com.dd.steps"},
            plugin = {
                    "pretty",
                    "html:target/cucumber-report.html",
                    "json:target/cucumber-report.json"
            },
            publish = false,
            dryRun = false,
            monochrome = false
    )
    public class TestRunner extends AbstractTestNGCucumberTests {
    }


