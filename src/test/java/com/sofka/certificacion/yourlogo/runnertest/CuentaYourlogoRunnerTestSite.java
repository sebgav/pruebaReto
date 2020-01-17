package com.sofka.certificacion.yourlogo.runnertest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/yourlogo.feature",
				 glue = "com.sofka.certificacion.yourlogo.definitions",
				 snippets = SnippetType.CAMELCASE)
public class CuentaYourlogoRunnerTestSite {

}
