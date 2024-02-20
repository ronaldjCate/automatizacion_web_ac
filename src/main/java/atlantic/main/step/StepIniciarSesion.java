package atlantic.main.step;


import atlantic.main.page.PageIniciarSesion;
import net.serenitybdd.annotations.Steps;


public class StepIniciarSesion {

    @Steps
    private PageIniciarSesion pageIniciarSesion;

    public void seleccionarIniciarSesion(){
        pageIniciarSesion.seleccionarInicioSesion();
    }
    public void seleccionarIrACasino(){
        pageIniciarSesion.seleccionarCasinoOnline();
    }
    public void seleccionarVertical(String dato){
        pageIniciarSesion.seleccionarVertical(dato);
    }
    public void ingresarDatosInicioSesion(String usuario, String contrasenna){
        pageIniciarSesion.ingresarDatosInicioSesion(usuario,contrasenna);
    }
    public void seleccionarIngresar(){
        pageIniciarSesion.seleccionarIngresar();
    }
    public void seleccionarCuentaIngresada() {
        pageIniciarSesion.seleccionarCuentaIngresada();
    }


}
