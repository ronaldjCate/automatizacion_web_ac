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

public class DefDepositoTarjeta {

    @Steps
    StepDeposito stepDeposito;


    @When("Acepto términos y condiciones de depósito")
    public void acepto_términos_y_condiciones_de_depósito() {
        // Write code here that turns the phrase above into concrete actions
        stepDeposito.seleccionarTerminosCondiciones();
    }

    @When("Selecciono botón Siguiente tarjeta")
    public void selecciono_botón_siguiente_tarjeta() {
        // Write code here that turns the phrase above into concrete actions
        stepDeposito.seleccionarDepositoSiguiente();
    }

    @When("Selecciono boton Pagar sin agregar tarjeta")
    public void Selecciono_boton_Pagar_sin_agregar_tarjeta() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("hhhh");
    }

    @When("Ingreso {string} {string} Ingreso {string}")
    public void ingreso_ingreso(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("Selcciono botón Depositar")
    public void selcciono_botón_depositar() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("Se muestra mensaje {string}")
    public void se_muestra_mensaje(String string) {
        // Write code here that turns the phrase above into concrete actions

    }


}
