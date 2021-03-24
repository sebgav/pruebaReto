package com.co.certificacion.pruebas.definitions;

import java.util.List;

import com.co.certificacion.pruebas.steps.VestidosSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VestidosYourlogoDefinitions {

	VestidosSteps vestidosSteps;
	
	@Given("^que el usuario desee crear una cuenta en la web$")
	public void queElUsuarioDeseeCrearUnaCuentaEnLaWeb() {
		vestidosSteps.abrirUrl();
		vestidosSteps.autenticarUsuario();
		
	}


	@When("^el usuario ingresa sus datos para la creacion$")
	public void elUsuarioIngresaSusDatosParaLaCreacion(List<String> datos) {
		vestidosSteps.ingresarEmail();
		vestidosSteps.datosFormulario(datos);
	}
	@When("^selecciona el vestido mas caro y el mas barato$")
	public void seleccionaElVestidoMasCaroYElMasBarato() {
		// Write code here that turns the phrase above into concrete actions
		vestidosSteps.seleccionarVestidoBarato();
		vestidosSteps.seleccionarVestidoCaro();
	}
	@Then("^se validaran los vestidos seleccionados en el carro$")
	public void seValidaranLosVestidosSeleccionadosEnElCarro() {
		vestidosSteps.validadPreciosEnCarrito();

	}



}
