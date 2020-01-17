package com.sofka.certificacion.yourlogo.steps;

import java.util.List;

import com.sofka.certificacion.yourlogo.userinterface.IngresarDatosFormulario;
import com.sofka.certificacion.yourlogo.userinterface.LoginPage;
import com.sofka.certificacion.yourlogo.userinterface.MyAccount;
import com.sofka.certificacion.yourlogo.userinterface.PaginaInicial;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class YourlogoSteps extends PageObject {

	PaginaInicial paginaInicial;
	LoginPage loginPage;
	IngresarDatosFormulario ingresarDatosFormulario;
	MyAccount myAccount;
	
	@Step
	public void abrirUrl() {
		paginaInicial.open();
	}
	@Step
	public void autenticarUsuario() {
		loginPage.ingresarCuenta();
	}
	@Step
	public void ingresarEmail(List<String> datos) {
		loginPage.ingresarEmail(datos);
		loginPage.pressCreateAccount();
	}
	@Step
	public void datosFormulario(List<String> datos) {
		ingresarDatosFormulario.selCheckboxMr();
		ingresarDatosFormulario.ingresarName(datos);
		ingresarDatosFormulario.ingresarLastName(datos);
		ingresarDatosFormulario.ingresarPassword(datos);
		ingresarDatosFormulario.ingresarDay(datos);
		ingresarDatosFormulario.ingresarMonth(datos);
		ingresarDatosFormulario.ingresarYear(datos);
		ingresarDatosFormulario.ingresarNameAddress(datos);
		ingresarDatosFormulario.ingresarLastAddress(datos);
		ingresarDatosFormulario.ingresarCompany(datos);
		ingresarDatosFormulario.ingresarAddress(datos);
		ingresarDatosFormulario.ingresarCity(datos);
		ingresarDatosFormulario.ingresarState(datos);
		ingresarDatosFormulario.ingresarCodPostal(datos);
		ingresarDatosFormulario.ingresarMobil(datos);
		ingresarDatosFormulario.ingresarAlias(datos);
		ingresarDatosFormulario.pressionarContinuar();
	}
	
	@Step
	public void miCreditoDisp(String txtCredit) {
		myAccount.selMyCredit();
		myAccount.CapturaMensaje(txtCredit);
	}
}
