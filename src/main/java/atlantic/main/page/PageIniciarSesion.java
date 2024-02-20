package atlantic.main.page;


import atlantic.main.util.UtilDef;
import atlantic.main.xpath.XpathIniciarSesion;
import atlantic.main.util.PageObjectUtil;
import net.serenitybdd.annotations.ClearCookiesPolicy;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
/*
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

 */
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;



@DefaultUrl("https://www.casinoatlanticcity.com/")
public class PageIniciarSesion extends PageObject {
    @Managed(clearCookies = ClearCookiesPolicy.BeforeEachTest)


    private WebDriverWait wdw = null;
    private long wdwTimeOut = 300L;

    //protected PageObjecUtil pageObjectUtil = PageObjecUtil.getInstancia();
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();

    UtilDef utilDef = new UtilDef();

    public void inicializar() {
        getDriver().get("https://www.casinoatlanticcity.com");
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        Serenity.takeScreenshot();
    }

    // xpath
    //protected XpathIniciarSesion xpathIniciarSesion = XpathIniciarSesion.getInstancia();
    protected XpathIniciarSesion xpathIniciarSesion = XpathIniciarSesion.getInstancia();
    // util
    //protected GeneralUtil generalUtil = GeneralUtil.getInstancia();

    public long getWdwTimeOut() {
        return wdwTimeOut;
    }

    public void seleccionarInicioSesion(){
        pageObjectUtil.seleniumClick(getDriver(), xpathIniciarSesion.Xpath_btnCookies, 0);
        utilDef.esperarElemento(3,element(xpathIniciarSesion.Xpath_btnIniciarSesion));
        element(xpathIniciarSesion.Xpath_btnIniciarSesion).click();
    }
    public void seleccionarCasinoOnline(){
        pageObjectUtil.seleniumClick(getDriver(), xpathIniciarSesion.Xpath_btnIrACasino, 0);
    }
    public void seleccionarVertical(String dato) {
        utilDef.esperarSegundos(4);
        pageObjectUtil.seleniumClick(getDriver(), xpathIniciarSesion.retornarXpathParametroVertical(dato), 0);
    }
    public void ingresarDatosInicioSesion(String usuario, String password){
        pageObjectUtil.seleniumEscribir(getDriver(), xpathIniciarSesion.Xpath_txtUsuario, usuario);
        pageObjectUtil.seleniumEscribir(getDriver(), xpathIniciarSesion.Xpath_txtPassword, password);
    }

    public void seleccionarIngresar(){
        pageObjectUtil.seleniumClick(getDriver(), xpathIniciarSesion.Xpath_btnIngresar, 0);
    }
    public void seleccionarCuentaIngresada() {
        try {
            Thread.sleep(3000);
            utilDef.esperarElemento(3,element(xpathIniciarSesion.Xpath_btnCuentaIngresada));
            element(xpathIniciarSesion.Xpath_btnCuentaIngresada).click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getUsuarioLogueado() {
        Serenity.takeScreenshot();
        String modelo = pageObjectUtil.seleniumGetText(getDriver(), xpathIniciarSesion.Xpath_lblUsuarioLogueado, 0);
        return modelo;
    }

}
