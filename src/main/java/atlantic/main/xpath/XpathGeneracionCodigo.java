package atlantic.main.xpath;


public class XpathGeneracionCodigo {
    // singleton
    private static XpathGeneracionCodigo obj = null;
    private XpathGeneracionCodigo() {
    }
    public static XpathGeneracionCodigo getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new XpathGeneracionCodigo();
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    public final String Xpath_btnDepositar="//body/div[6]/div[2]/div[1]/div[2]/div[1]/div[1]/button[1]";//*[@id='main-header']/div[2]/div[1]/div[1]/button";
    public static final String Xpath_btnPagoKashio ="//*[contains(concat( ' ', @class, ' ' ), concat( ' ', 'methodKASHIO_PEN', ' ' ))]";
    public static final String Xpath_btnPagoSafetyPay ="//*[contains(concat( ' ', @class, ' ' ), concat( ' ', 'methodSAFETYPAY_PEN', ' ' ))]";
    public static final String Xpath_btnPagoEfectivo ="//*[contains(concat( ' ', @class, ' ' ), concat( ' ', 'methodPAGOEFECTIVO_PEN', ' ' ))]";
    public static final String Xpath_btnPagoQR ="//*[contains(concat( ' ', @class, ' ' ), concat( ' ', 'methodNIUBIZ_QR_PEN', ' ' ))]";
    public static final String Xpath_btnDebitoCredito ="//*[contains(concat( ' ', @class, ' ' ), concat( ' ', 'methodNIUBIZ_DESACOP_TOKEN_PEN', ' ' ))]";
    public final String Xpath_btnDepositarSiguiente ="//button[@id='depositButton']";

    public String retornarXpathMonto(String dato){
        return "//form[@class='jsx-bbc0a237ca44e34d amountButtons clmc-flex-center clmc-flex-wrap clmc-mb20']//div[text()='S/"+dato+"']";
    }
    public final String Xpath_lblCodigoPagoEsperadoKashio ="//p[@id='copyText']";
    public final String Xpath_lblMontoMinimoMostradoKashio = "//*[@id='detalles']/div[3]/div[2]/div/p[2]";
    public final String Xpath_lblCodigoPagoEsperadoPagoEfectivo ="//*[@id='copyCip']/div/span";
    public final String Xpath_lblMontoMinimoMostradoPagoEfectivo ="//*[@id='root']/div/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/p";
    public final String Xpath_lblCodigoPagoEsperadoSafetypay="//*[@id='step_3']/strong[2]";
    public final String Xpath_lblMontoMinimoMostradoSafetypay = "//div[@class='montototal']/span";
    public final String Xpath_lblCodigoPagoEsperadoQR="//*[@id='depositResponseImgQR']/img";
    public final String Xpath_lblMontoMinimoMostradoQR = "//*[@id='depositResponseImgDataAmount']";



    public final String Xpath_iframe = "//iframe[@id='depositResponseIframe']";
    public final String Xpath_iframe_PE = "//*[@id='root']/div/iframe";
    public final String Xpath_lblMensajeMostrado = "//p[contains(text(),'Tu código se está generando')]";
    public final String Xpath_depositoPopup = "//div[@id='depositpopup']";

    public static String Xpath_btnCookiesPagoEfectivo = "//*[@id='onetrust-accept-btn-handler']";


}
