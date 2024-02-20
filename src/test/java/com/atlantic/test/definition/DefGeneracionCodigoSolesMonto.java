package com.atlantic.test.definition;

import atlantic.main.step.StepDeposito;
import atlantic.main.step.StepIniciarSesion;
import atlantic.main.step.StepPaginaPrincipal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DefGeneracionCodigoSolesMonto {

    @Steps
    private StepPaginaPrincipal stepPaginaPrincipal;
    @Steps
    StepIniciarSesion stepIniciarSesion;
    @Steps
    StepDeposito stepDepositoKashio;

    String tipoPagoGlobal;
    @Given("realizo el inicio de sesión con un usuario en moneda soles sin depósitos")
    public void realizo_el_inicio_de_sesión_con_un_usuario_en_moneda_soles_sin_depósitos() {
        stepPaginaPrincipal.abrirPaginaPrincipal();
        stepIniciarSesion.seleccionarIniciarSesion();
    }
    @When("Me encuentro en {string}")
    public void me_encuentro_en(String dato) {
        stepIniciarSesion.seleccionarVertical(dato);
    }
    @When("ingreso los datos del usuario")
    public void ingreso_los_datos_del_usuario(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> datosClientes = dataTable.asMaps(String.class, String.class);
        String usuario =datosClientes.get(0).get("usuario");
        String password =datosClientes.get(0).get("contrasenna");
        stepIniciarSesion.ingresarDatosInicioSesion(usuario,password);
        stepIniciarSesion.seleccionarIngresar();
        Serenity.takeScreenshot();
    }
    @When("Selecciono botón Depositar\"")
    public void selecciono_botón_depositar() throws InterruptedException {
        stepDepositoKashio.seleccionarBotonDeposito();
        Serenity.takeScreenshot();
    }
    @When("Selecciono {string}")
    public void selecciono(String tipoPago) {
        tipoPagoGlobal=tipoPago;
        stepDepositoKashio.seleccionarBotonTipoPago(tipoPagoGlobal);
        Serenity.takeScreenshot();
    }
    @When("Selecciono el monto:")
    public void selecciono_el_monto(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> datosMonto = dataTable.asMaps(String.class, String.class);
        String montoMinimo =datosMonto.get(0).get("MontoOrigen");
        stepDepositoKashio.seleccionarMonto(montoMinimo);
        Serenity.takeScreenshot();
    }
    @When("Selecciono botón Siguiente")
    public void selecciono_botón_siguiente() {
        // Write code here that turns the phrase above into concrete actions
        stepDepositoKashio.seleccionarDepositoSiguiente();
    }
    @Then("Se debe mostrar el siguiente mensaje")
    public void se_debe_mostrar_el_siguiente_mensaje(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> datosMonto = dataTable.asMaps(String.class, String.class);
        String mensajeEsperado =datosMonto.get(0).get("mensaje");
        System.out.println("Mensaje: "+mensajeEsperado);
        Serenity.takeScreenshot();

    }
    @Then("Se muestra código de pago")
    public void se_muestra_código_de_pago() {
        // Write code here that turns the phrase above into concrete actions
        //stepDepositoKashio.esperarVisibilidadCodigoPago();
        String codigoGenerado = stepDepositoKashio.validarCodigoGenerado(tipoPagoGlobal);
        System.out.println("Código Generado" + codigoGenerado);
        Serenity.takeScreenshot();
    }
    @Then("Se muestra el monto mínimo")
    public void se_muestra_el_monto_mínimo(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> montoMostrado = dataTable.asMaps(String.class, String.class);
        String montoEsperado =montoMostrado.get(0).get("MontoMinimoResultante");
        String montoMinimoGenerado =stepDepositoKashio.validarMontoMinimoGenerado(tipoPagoGlobal);
        System.out.println("Código Generado" + montoMinimoGenerado);
        assertEquals(montoEsperado,montoMinimoGenerado);
        Serenity.takeScreenshot();
    }
    @Then("Se muestra el monto maximo")
    public void se_muestra_el_monto_maximo(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> montoMostrado = dataTable.asMaps(String.class, String.class);
        String montoEsperado =montoMostrado.get(0).get("MontoMaximoResultante");
        String montoMinimoGenerado =stepDepositoKashio.validarMontoMinimoGenerado(tipoPagoGlobal);
        System.out.println("Código Generado" + montoMinimoGenerado);
        assertEquals(montoEsperado,montoMinimoGenerado);
    }

}
