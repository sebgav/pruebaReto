package com.sofka.certificacion.yourlogo.userinterface;

import static org.junit.Assert.assertEquals;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyAccount extends PageObject {

	@FindBy(xpath = "//span[contains(text(),'My credit slips')]")
	WebElementFacade btnMycredit;
	
	@FindBy(xpath = "//p[@class='alert alert-warning']")
	WebElementFacade txtMensajeCredit;
	
	public void selMyCredit() {
		btnMycredit.click();
	}
	
	public void CapturaMensaje(String txtCredit) {
		assertEquals(txtCredit, txtMensajeCredit.getText());
	}
}
