package com.sofka.certificacion.yourlogo.definitions;

import java.util.List;

import com.sofka.certificacion.yourlogo.steps.YourlogoSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CuentaYourlogoDefinitions {

	YourlogoSteps yourlogoSteps;
	
	@Given("^que el usuario desee crear una cuenta en la web$")
	public void queElUsuarioDeseeCrearUnaCuentaEnLaWeb() {
		yourlogoSteps.abrirUrl();
		yourlogoSteps.autenticarUsuario();
		
	}


	@When("^el usuario ingresa sus datos para la creacion$")
	public void elUsuarioIngresaSusDatosParaLaCreacion(List<String> datos) {
		yourlogoSteps.ingresarEmail(datos);
		yourlogoSteps.datosFormulario(datos);
	}


	@Then("^el debera visualizar mensaje \"([^\"]*)\"$")
	public void elDeberaVisualizarMensaje(String txtCredit) {
		yourlogoSteps.miCreditoDisp(txtCredit);
	}
}
