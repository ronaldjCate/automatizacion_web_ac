package com.atlantic.test.definition;


import atlantic.main.step.StepDeposito;
import atlantic.main.step.StepIniciarSesion;
import atlantic.main.step.StepPaginaPrincipal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

import static org.junit.Assert.assertEquals;


public class DefRealizarInicioSesionUsuario {

    @Steps
    private StepPaginaPrincipal stepPaginaPrincipal;
    @Steps
    StepIniciarSesion stepIniciarSesion;
    @Steps
    StepDeposito stepDepositoKashio;

    @Given("ingreso a la web del casino")
    public void ingreso_a_la_web_del_casino() {
        // Write code here that turns the phrase above into concrete actions
        stepPaginaPrincipal.abrirPaginaPrincipal();
    }
    @When("selecciono la opcion iniciar sesion")
    public void selecciono_la_opcion_iniciar_sesion() {
        // Write code here that turns the phrase above into concrete actions
        stepIniciarSesion.seleccionarIniciarSesion();
        Serenity.takeScreenshot();
        stepIniciarSesion.seleccionarIrACasino();
    }
    @When("ingreso el {string} y {string}")
    public void ingreso_el_y(String usuario, String contrasenna) {
        // Write code here that turns the phrase above into concrete actions
        stepIniciarSesion.ingresarDatosInicioSesion(usuario,contrasenna);
        Serenity.takeScreenshot();
    }
    @When("selecciono el boton iniciar sesion")
    public void selecciono_el_boton_iniciar_sesion() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        stepIniciarSesion.seleccionarIngresar();
    }
    @Then("se debe mostrar el usuario logueado {string}")
    public void se_debe_mostrar_el_boton_para_hacer_deposito(String usuarioLogueado) {
        // Write code here that turns the phrase above into concrete actions

        //assertEquals(stepIniciarSesion.getUsuarioLogueado(), usuarioLogueado);
        //Serenity.takeScreenshot();
    }

}
