package com.atlantic.test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(RunPersonalizar.class)

/*
@CucumberOptions(
		features = { "src/test/resources/features/" },
		tags = "@ValidarDepositoMontoMinimo",
		//tags = "@ValidarInicioSesionUsuario",
		glue = { "com.atlantic" },
		plugin = {
		"pretty", "html:target/serenity-reports/serenity-html-report",
		"json:target/serenity-reports/cucumber_report.json", "rerun:target/serenity-reports/rerun.txt" })
*/


public class Runner {

	@RunBefore
	public static void previo() {
//		ExcelUtilPropio.getInstancia().escribirFeatures();
		System.out.println("ss1");
		
	}
}
