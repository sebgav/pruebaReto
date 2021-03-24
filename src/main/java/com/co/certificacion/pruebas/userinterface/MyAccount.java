package com.co.certificacion.pruebas.userinterface;

import static org.junit.Assert.assertEquals;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyAccount extends PageObject {

	@FindBy(xpath = "//span[contains(text(),'My credit slips')]")
	WebElementFacade btnMycredit;
	
	@FindBy(xpath = "//p[@class='alert alert-warning']")
	WebElementFacade txtMensajeCredit;

	@FindBy(xpath = "//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]//a[@title='Dresses']")
	WebElementFacade btnDresses;

	@FindBy(xpath = "//*[@class='cat-name']")
	WebElementFacade lblDreses;

	@FindBy(xpath = "//*[@class='product-desc']//ancestor::div[1]//*[@class='price product-price' ]")
	List<WebElementFacade> lsLblPreciosDreses;

	@FindBy(xpath = "//*[@title='Continue shopping']")
	WebElementFacade btnContinuarCompras;

	@FindBy(xpath = "//*[@title='Proceed to checkout']")
	private WebElementFacade btnCheckout;

	@FindBy(xpath = "//*[@id='total_product']")
	private WebElementFacade lblTotal;


	public void selMyCredit() {
		btnMycredit.click();
	}
	
	public void CapturaMensaje(String txtCredit) {
		assertEquals(txtCredit, txtMensajeCredit.getText());
	}

	public void presionarVestidos()
	{
		btnDresses.click();
	}

	public List<Double> ordenarPrecios()
	{
		List<Double> lsPrecios=new ArrayList<>();
		Actions actions=new Actions(getDriver());

		waitFor(ExpectedConditions.visibilityOf(lblDreses));
		actions.moveToElement(lblDreses).build().perform();
waitFor(3).second();
		for (int i=0;lsLblPreciosDreses.size()>i;i++)
		{
			lsPrecios.add(Double.parseDouble(lsLblPreciosDreses.get(i).getText().replaceAll("\\$","")));
		}
		Collections.sort(lsPrecios);


		return lsPrecios;
	}

	public void seleccionarVestidoBarato(String pBarato)
	{

		WebElement btnVestidoBarato=getDriver().findElement(By.xpath(String.format("//*[@class=\"product-desc\"]//ancestor::div[1]//*[@class='price product-price'  and contains(text(),'%s')]",pBarato )));

		btnVestidoBarato.click();
		btnContinuarCompras.click();
	}

	public void seleccionarVestidoCaro(String pCaro) {
		waitFor(3).second();
		WebElement btnVestidoCaro=getDriver().findElement(By.xpath(String.format("//*[@class=\"product-desc\"]//ancestor::div[1]//*[@class='price product-price'  and contains(text(),'%s')]",pCaro )));
		waitFor(ExpectedConditions.visibilityOf(btnVestidoCaro));

		btnVestidoCaro.click();
		btnCheckout.click();
	}

	public void validadPreciosEnCarrito() {
	}

	public String getValorTotal() {
		Actions action=new Actions(getDriver()) ;
		action.moveToElement(lblTotal).build().perform();

		return lblTotal.getText().trim();
	}
}
