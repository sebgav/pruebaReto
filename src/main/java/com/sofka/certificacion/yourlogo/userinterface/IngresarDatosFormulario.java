package com.sofka.certificacion.yourlogo.userinterface;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class IngresarDatosFormulario extends PageObject {

	@FindBy(id = "uniform-id_gender1")
	WebElementFacade checkboxMr;

	@FindBy(id = "customer_firstname")
	WebElementFacade txtFirstName;

	@FindBy(id = "customer_lastname")
	WebElementFacade txtLastName;

	@FindBy(id = "passwd")
	WebElementFacade txtPassword;

	@FindBy(id = "uniform-days")
	WebElement txtdays;

	@FindBy(id = "uniform-months")
	WebElement txtmonth;

	@FindBy(id = "uniform-years")
	WebElement txtyear;

	@FindBy(id = "firstname")
	WebElementFacade txtNameAddress;

	@FindBy(id = "lastname")
	WebElementFacade txtLastAddress;

	@FindBy(id = "company")
	WebElementFacade txtCompany;

	@FindBy(id = "address1")
	WebElementFacade txtaddress;

	@FindBy(id = "city")
	WebElementFacade txtcity;

	@FindBy(id = "uniform-id_state")
	WebElementFacade txtstate;

	@FindBy(id = "postcode")
	WebElementFacade txtpostCode;

	@FindBy(id = "phone_mobile")
	WebElementFacade txtphoneMobile;

	@FindBy(id = "alias")
	WebElementFacade txtAlias;

	@FindBy(id = "submitAccount")
	WebElementFacade btnRegister;

	public void selCheckboxMr() {
		checkboxMr.click();
	}

	public void ingresarName(List<String> datos) {
		txtFirstName.type(datos.get(17));
	}

	public void ingresarLastName(List<String> datos) {
		txtLastName.type(datos.get(18));
	}

	public void ingresarPassword(List<String> datos) {
		txtPassword.typeAndTab(datos.get(19));
	}

	public void ingresarDay(List<String> datos) {
		WebElement day = txtdays.findElement(By.id("days"));
		day.click();
		day.sendKeys(datos.get(20));
	}

	public void ingresarMonth(List<String> datos) {
		WebElement month = txtmonth.findElement(By.id("months"));
		month.click();
		month.sendKeys(datos.get(21));
	}

	public void ingresarYear(List<String> datos) {
		WebElement year = txtyear.findElement(By.id("years"));
		year.click();
		year.sendKeys(datos.get(22));
	}

	public void ingresarNameAddress(List<String> datos) {
		txtNameAddress.type(datos.get(23));
	}

	public void ingresarLastAddress(List<String> datos) {
		txtLastAddress.type(datos.get(24));
	}

	public void ingresarCompany(List<String> datos) {
		txtCompany.type(datos.get(25));

	}

	public void ingresarAddress(List<String> datos) {
		txtaddress.type(datos.get(26));

	}

	public void ingresarCity(List<String> datos) {
		txtcity.type(datos.get(27));

	}

	public void ingresarState(List<String> datos) {
		WebElement state = txtstate.findElement(By.id("id_state"));
		state.click();
		state.sendKeys(datos.get(28));
	}

	public void ingresarCodPostal(List<String> datos) {
		txtpostCode.type(datos.get(29));

	}

	public void ingresarMobil(List<String> datos) {
		txtphoneMobile.type(datos.get(30));
	}

	public void ingresarAlias(List<String> datos) {
		txtAlias.type(datos.get(31));
	}

	public void pressionarContinuar() {
		btnRegister.click();
	}
}
