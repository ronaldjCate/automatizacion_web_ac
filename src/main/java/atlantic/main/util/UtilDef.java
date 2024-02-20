package atlantic.main.util;

import java.time.Duration;
import java.util.Properties;

import net.serenitybdd.core.Serenity;

//import net.thucydides.core.environment.SystemEnvironmentVariables;
//import net.thucydides.core.util.SystemEnvironmentVariables;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import net.thucydides.core.util.EnvironmentVariables;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilDef extends PageObject{

	public static Properties p;
	private static UtilDef obj = null;

	public static UtilDef getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new UtilDef();
		}
	}


	public void esperarElemento(int intentos, WebElement elemento) {
		int contador=0;
		System.out.println("Espera Elemento : "  + elemento.toString());
		Serenity.takeScreenshot();
		while(element(elemento).isEnabled()==false) {
			contador++;
			if(element(elemento).isEnabled()==true||contador==intentos) {
				System.out.println("Se encuentra elemento o contador finalizo");
				break;
			}else {
				esperarSegundos(1);
				System.out.println("contador: " + contador + elemento);
			}

		}
	}
	public void esperaImplicita(String webElement,int time){
		getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		element(webElement).click();
	}

	public void esperarSegundos(int tipoEspera) {

		try {
			Thread.sleep(tipoEspera*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String obtnerMensaje(WebElement webelement, int intentos) {
		boolean flag = false;
		String mensajeConfirmacion="";
		flag = confirmarElementoActivo(3, webelement);
		System.out.println("flag "  + flag);
		if(flag==true) {
			mensajeConfirmacion = webelement.getText();
		}else {
			mensajeConfirmacion="No se recibio mensaje";
		}
		return mensajeConfirmacion;
	}

	public boolean confirmarElementoActivo(int intentos, WebElement elemento) {
		int contador=0;
		System.out.println("Espera Elemento : "  + elemento.toString());
		Serenity.takeScreenshot();
		boolean confirmacion = true;
		while(element(elemento).isEnabled()==false) {
			confirmacion = false;
			contador++;
			if(element(elemento).isEnabled()==true) {
				System.out.println("Se encuentra elemento");
				confirmacion = true;
				break;
			}
			if(element(elemento).isEnabled()==true||contador==intentos) {
				System.out.println("Se encuentra elemento o contador finalizo");
				break;
			}else {
				esperarSegundos(1);
				System.out.println("contador: " + contador + elemento);
			}
		}
		return confirmacion;
	}

	/**
	 * Metodo espera a que elemento sea visibile en el dom, segun su xpath.
	 *
	 * @param driver
	 * @param tiempo_seg
	 * @param xpath
	 */
	public void esperar_visibilidad_elemento(WebDriver driver, int tiempo_seg, final String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(tiempo_seg));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public void navegarDentroIframe(String xpath){
		withAction().moveToElement(find(By.xpath(xpath))).perform();
		WebElement iframe = getDriver().findElement(By.xpath(xpath));
		getDriver().switchTo().frame(iframe);
	}

	public void navegarDentroPopUp(String xpath){
		withAction().moveToElement(find(By.xpath(xpath))).perform();
		WebElement popUp = getDriver().findElement(By.xpath(xpath));
		getDriver().switchTo().frame(popUp);
	}

	public String concatenarSimboloMoneda(String dato, String moneda){
		String valorConcatenado="";
		if (moneda=="PEN"){
			valorConcatenado="S/ "+dato;
			System.out.println("ValorConcatenado:"+valorConcatenado);
		}else {
			valorConcatenado="USD "+dato;
		}
		return valorConcatenado;
	}

	public String extraerValor(String texto) {
		Pattern pattern = Pattern.compile("\\d+\\.\\d{2}");
		Matcher matcher = pattern.matcher(texto);
		if (matcher.find()) {
			return matcher.group(0);
		} else {
			return null;
		}
	}

	public String convertirFormatoPagoQR(String texto) {
		Pattern pattern = Pattern.compile("S/(\\d+)");
		Matcher matcher = pattern.matcher(texto);
		if (matcher.find()) {
			String numero = matcher.group(1);
			double valor = Double.parseDouble(numero);
			String valorFormateado = String.format("%.2f", valor);
			String textoFinal = "S/ " + valorFormateado;
			return textoFinal;
		} else {
			return texto;
		}
	}



	public static void tabAndClickCheckBox(WebDriver driver, WebElement webElement) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
		//webElement.click();
	}

	public void pressSpaceKeyOnCheckbox(WebDriver driver, WebElement webElement){
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).sendKeys(" ").build().perform();
	}




}
