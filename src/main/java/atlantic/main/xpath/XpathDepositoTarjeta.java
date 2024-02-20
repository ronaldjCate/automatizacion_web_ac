package atlantic.main.xpath;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class XpathDepositoTarjeta {
    // singleton
    private static XpathDepositoTarjeta obj = null;
    private XpathDepositoTarjeta() {
    }
    public static XpathDepositoTarjeta getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new XpathDepositoTarjeta();
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static final String Xpath_CheckTerminoCondiciones ="//*[@id='terms_check_div']";

    public static final String Xpath_afuera ="//*[contains(concat( ' ', @class, ' ' ), concat( ' ', 'depositForm-step1', ' ' ))]";
    @FindBy(id = "//*[@id='terms_check_div']/label/span[1]")
    public static WebElement checkbox;

    @FindBy(xpath = "//div[@id='inputOtroMonto']")
    public static WebElement otroMonto;

    public final String Xpath_iframe ="//iframe[@id='depositResponseIframe']";
    public final String Xpath_btnPagarSinTarjeta = "//*[@id='depositWithoutCardButton']";
    public final String Xpath_txtNumeroTarjeta = "//*[@id='cc-number']";
    public final String Xpath_txtMesAnnio = "//*[@id='cc-exp']";
    public final String Xpath_txtCVV = "//*[@id='cc-cvc']";
    public final String Xpath_btnDepositar = "//*[@id='depositButtonId']";


}
