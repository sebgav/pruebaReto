package com.co.certificacion.pruebas.steps;

import java.util.List;

import com.co.certificacion.pruebas.userinterface.LoginPage;
import com.co.certificacion.pruebas.userinterface.MyAccount;
import com.co.certificacion.pruebas.userinterface.PaginaInicial;
import com.github.javafaker.Faker;
import com.co.certificacion.pruebas.userinterface.IngresarDatosFormulario;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class VestidosSteps extends PageObject {

	PaginaInicial paginaInicial;
	LoginPage loginPage;
	IngresarDatosFormulario ingresarDatosFormulario;
	MyAccount myAccount;
	private List<Double> lsPrecios;

	@Step
	public void abrirUrl() {
		paginaInicial.open();
	}
	@Step
	public void autenticarUsuario() {
		loginPage.ingresarCuenta();
	}
	@Step
	public void ingresarEmail() {
		Faker faker=new Faker();

		loginPage.ingresarEmail(faker.internet().emailAddress());
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
	public void seleccionarVestidoBarato()
	{
		myAccount.presionarVestidos();
		lsPrecios=myAccount.ordenarPrecios();
		myAccount.seleccionarVestidoBarato(String.valueOf(lsPrecios.get(0)));

	}

	public void seleccionarVestidoCaro() {
		myAccount.seleccionarVestidoCaro(String.valueOf(lsPrecios.get(lsPrecios.size()-1)));


	}

	@Step
	public void validadPreciosEnCarrito()
	{
		Assert.assertEquals(String.format("Se valida precio total pantalla %s vs suma articulos %s",("$"+String.valueOf(lsPrecios.get(0)+lsPrecios.get(lsPrecios.size()-1)).trim()),myAccount.getValorTotal()), ("$"+String.valueOf(lsPrecios.get(0)+lsPrecios.get(lsPrecios.size()-1)).trim()),myAccount.getValorTotal());
	}
}
