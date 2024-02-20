package atlantic.main.page;

import atlantic.main.util.PageObjectUtil;
import atlantic.main.util.UtilDef;
import atlantic.main.xpath.XpathDepositoTarjeta;
import atlantic.main.xpath.XpathGeneracionCodigo;
import atlantic.main.xpath.XpathIniciarSesion;
import net.serenitybdd.annotations.ClearCookiesPolicy;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.pages.PageObject;

import java.time.Duration;

import static net.serenitybdd.screenplay.waits.Wait.until;

public class PageDeposito extends PageObject{

    @Managed(clearCookies = ClearCookiesPolicy.BeforeEachTest)


    private WebDriverWait wdw = null;
    private long wdwTimeOut = 300L;

    //protected PageObjecUtil pageObjectUtil = PageObjecUtil.getInstancia();
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
    protected XpathGeneracionCodigo xpathGeneracionCodigo = XpathGeneracionCodigo.getInstancia();
    protected XpathDepositoTarjeta xpathDepositoTarjeta = XpathDepositoTarjeta.getInstancia();

    UtilDef utilDef = new UtilDef();


    public void seleccionarBotonDepositar() throws InterruptedException {
        utilDef.esperaImplicita(xpathGeneracionCodigo.Xpath_btnDepositar,15);
    }
    public void seleccionarBotonTipoPago(String tipoPago){
        utilDef.esperarSegundos(3);
        switch (tipoPago){
            case "Kashio":
                pageObjectUtil.seleniumClick(getDriver(), xpathGeneracionCodigo.Xpath_btnPagoKashio, 0);
                break;
            case "Safetypay":
                pageObjectUtil.seleniumClick(getDriver(), xpathGeneracionCodigo.Xpath_btnPagoSafetyPay, 0);
                break;
            case "PagoEfectivo":
                pageObjectUtil.seleniumClick(getDriver(), xpathGeneracionCodigo.Xpath_btnPagoEfectivo, 0);
                break;
            case "PagoQR":
                pageObjectUtil.seleniumClick(getDriver(), xpathGeneracionCodigo.Xpath_btnPagoQR, 0);
                break;
            case "DebitoCredito":
                pageObjectUtil.seleniumClick(getDriver(),xpathGeneracionCodigo.Xpath_btnDebitoCredito,0);
                break;

        }
    }
    public void seleccionarMonto(String dato){
        utilDef.esperaImplicita(xpathGeneracionCodigo.retornarXpathMonto(dato),15);
    }
    public void seleccionarBotonDepositoSiguiente(){
        pageObjectUtil.seleniumClick(getDriver(),xpathGeneracionCodigo.Xpath_btnDepositarSiguiente,0);
        utilDef.esperarSegundos(2);
        waitForRenderedElements(By.xpath(xpathGeneracionCodigo.Xpath_depositoPopup));
    }

    /*
    Validar dentro del popup
     */
    public String obtenerMensajeMostrado(){
        String popup = "//div[@id='depositpopup']";
        String elementoV="//p[contains(text(),'Tu código se está generando')]";
        utilDef.esperar_visibilidad_elemento(getDriver(),2, popup);
        // Esperar a que el elemento esté visible dentro del popup
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        //WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='depositLoading']/div/p[1]")));
        utilDef.esperar_visibilidad_elemento(getDriver(),2,elementoV);
        String texto = pageObjectUtil.obtenerTexto(getDriver(),elementoV);
        // Obtener el texto del elemento
        //String texto = elemento.getText();
        System.out.println("Texto dentro del popup: " + texto);
        return texto;
    }


    public void validarVisibilidadElemento(){
        utilDef.navegarDentroIframe(xpathGeneracionCodigo.Xpath_iframe);
    }

    public String obtenerCodigoGenerado(String tipoPago){
        String valorDevuelto="";
        switch (tipoPago){
            case "Kashio":
                validarVisibilidadElemento();
                utilDef.esperar_visibilidad_elemento(getDriver(),5, xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoKashio);
                valorDevuelto= pageObjectUtil.obtenerTexto(getDriver(),xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoKashio);
                break;
            case "Safetypay":
                validarVisibilidadElemento();
                utilDef.esperar_visibilidad_elemento(getDriver(),5, xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoSafetypay);
                valorDevuelto= pageObjectUtil.obtenerTexto(getDriver(),xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoSafetypay);
                break;
            case "PagoEfectivo":
                validarVisibilidadElemento();
                utilDef.navegarDentroIframe(xpathGeneracionCodigo.Xpath_iframe_PE);
                utilDef.esperar_visibilidad_elemento(getDriver(),5, xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoPagoEfectivo);
                valorDevuelto= pageObjectUtil.obtenerTexto(getDriver(),xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoPagoEfectivo);
                break;
            default:
                utilDef.esperar_visibilidad_elemento(getDriver(),5, xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoQR);
                valorDevuelto= pageObjectUtil.obtenerTexto(getDriver(),xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoQR);
                break;
        }
        return valorDevuelto;
    }

    public String obtenerMontoMinimo(String tipoPago){
        String valorDevuelto="";
        switch (tipoPago){
            case "Kashio":
                utilDef.esperar_visibilidad_elemento(getDriver(),5, xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoKashio);
                valorDevuelto= pageObjectUtil.obtenerTexto(getDriver(), xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoKashio);
                valorDevuelto=utilDef.concatenarSimboloMoneda(valorDevuelto,"PEN");
                System.out.println("valorDevuelto: "+valorDevuelto);
                break;
            case "Safetypay":
                utilDef.esperar_visibilidad_elemento(getDriver(),5, xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoSafetypay);
                valorDevuelto= pageObjectUtil.obtenerTexto(getDriver(),xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoSafetypay);
                break;
            case "PagoEfectivo":
                utilDef.esperar_visibilidad_elemento(getDriver(),5, xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoPagoEfectivo);
                valorDevuelto= pageObjectUtil.obtenerTexto(getDriver(),xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoPagoEfectivo);
                valorDevuelto=utilDef.extraerValor(valorDevuelto);
                valorDevuelto=utilDef.concatenarSimboloMoneda(valorDevuelto,"PEN");
                break;
            default:
                utilDef.esperar_visibilidad_elemento(getDriver(),5, xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoQR);
                valorDevuelto= pageObjectUtil.obtenerTexto(getDriver(),xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoQR);
                valorDevuelto=utilDef.convertirFormatoPagoQR(valorDevuelto);
                break;
        }
        return valorDevuelto;

    }





   // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    public void seleccionarTerminosCondiciones(){

        //utilDef.navegarDentroIframe(xpathDepositoTarjeta.Xpath_afuera);
        utilDef.tabAndClickCheckBox(getDriver(),xpathDepositoTarjeta.otroMonto);
        utilDef.tabAndClickCheckBox(getDriver(),xpathDepositoTarjeta.checkbox);
        //utilDef.esperaImplicita(String.valueOf(xpathDepositoTarjeta.checkbox),2);
        //ExpectedConditions.elementToBeClickable(xpathDepositoTarjeta.checkbox);
        //utilDef.pressSpaceKeyOnCheckbox(getDriver(),xpathDepositoTarjeta.checkbox);
        pageObjectUtil.seleniumClick(getDriver(), String.valueOf(xpathDepositoTarjeta.otroMonto),0);



    }
    public void seleccionarBotonPagarSinAgregarTarjeta(){
        pageObjectUtil.seleniumClick(getDriver(),xpathDepositoTarjeta.Xpath_btnPagarSinTarjeta,0);
    }

    public String getIngresarDatosTarjetas(){
        return null;
    }








}
