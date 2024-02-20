package atlantic.main.xpath;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;


public class XpathIniciarSesion {
    // singleton
    private static XpathIniciarSesion obj = null;
    private XpathIniciarSesion() {
    }
    public static XpathIniciarSesion getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new XpathIniciarSesion();
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public final String Xpath_btnCookies="//*[@id='cookies-popover']/button";
    public final String Xpath_btnIniciarSesion="//button[contains(text(),'Ingresar')]";
    public final String Xpath_btnIrACasino="//button[contains(text(),'Ir a casino')]";
    public final String Xpath_btnIrASports="//button[contains(text(),'Ir a sports')]";
    public final String Xpath_txtUsuario="//input[@id='user']";
    public final String Xpath_txtPassword="//input[@id='password']";
    public final String Xpath_btnIngresar="//*[@id='menuSlideLogin']/form/button";
    public final String Xpath_lblUsuarioLogueado="//p[contains(text(),'usuVahpc')]";
    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium clmc-white-icon clmc-hidden mobile-login-button css-slyssw']")
    public WebElement Xpath_btnCuentaIngresada;
    //oprueba



    public String retornarXpathParametroVertical(String dato){
        return "//button[contains(text(),'"+dato+"')]";
    }

}
