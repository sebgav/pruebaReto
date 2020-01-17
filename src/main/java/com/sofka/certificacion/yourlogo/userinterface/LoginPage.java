package com.sofka.certificacion.yourlogo.userinterface;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

	@FindBy(xpath = "//div[@class='header_user_info']")
	WebElementFacade btnSingIn;
	
	@FindBy(id = "email_create")
	WebElementFacade lblEmail;
	
	@FindBy(id = "SubmitCreate")
	WebElementFacade btnCreateAccount;
	
	public void ingresarCuenta() {
		btnSingIn.click();
	}
	
	public void ingresarEmail(List<String>datos) {
		lblEmail.type(datos.get(16));
		
	}
	
	public void pressCreateAccount() {
		btnCreateAccount.click();
	}
}
