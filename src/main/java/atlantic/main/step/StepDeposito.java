package atlantic.main.step;


import atlantic.main.page.PageDeposito;
import net.serenitybdd.annotations.Steps;


public class StepDeposito {

    @Steps
    private PageDeposito pageDeposito;

    public void seleccionarBotonDeposito() throws InterruptedException {
        pageDeposito.seleccionarBotonDepositar();
    }
    public void seleccionarBotonTipoPago(String tipoPago){
        pageDeposito.seleccionarBotonTipoPago(tipoPago);
    }
    public void seleccionarMonto(String dato){
        pageDeposito.seleccionarMonto(dato);
    }
    public void seleccionarDepositoSiguiente(){
        pageDeposito.seleccionarBotonDepositoSiguiente();
    }
    public String validarCodigoGenerado(String tipoPago) {
        String codigoMostrado= pageDeposito.obtenerCodigoGenerado(tipoPago);
        return codigoMostrado;
    }
    public String validarMontoMinimoGenerado(String tipoPago){
        return pageDeposito.obtenerMontoMinimo(tipoPago);
    }
    public String validarMensajeMostrado(){
        return pageDeposito.obtenerMensajeMostrado();
    }
    public void seleccionarTerminosCondiciones(){
        pageDeposito.seleccionarTerminosCondiciones();
    }
    public void seleccionarBotonPagarSinAgregarTarjeta(){
        pageDeposito.seleccionarBotonPagarSinAgregarTarjeta();
    }


}
