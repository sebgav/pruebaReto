package com.co.certificacion.pruebas.runnertest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/vestidos.feature",
				 glue = "com.co.certificacion.pruebas.definitions",
				 snippets = SnippetType.CAMELCASE)
public class VestidosRunnerTestSite {

}
