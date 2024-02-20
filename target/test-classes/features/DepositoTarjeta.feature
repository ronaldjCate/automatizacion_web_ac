Feature: Poder generar el código de depósito


   Background:
     Given realizo el inicio de sesión con un usuario en moneda soles sin depósitos

     @ValidarDepositoMontoMinimo
    Scenario Outline: Validar que permita depositar mediante tarjeta con el monto máximo
      When Me encuentro en "<Vertical>"
      And ingreso los datos del usuario
         | usuario | contrasenna |
         |usuVahpc |  atl1Vipeh  |
       And Selecciono botón Depositar"
      And Selecciono "<Pasarela>"
      And Selecciono el monto:
         |MontoOrigen|
         |300        |
      And Acepto términos y condiciones de depósito
      And Selecciono botón Siguiente tarjeta
      And Selecciono boton Pagar sin agregar tarjeta
      And Ingreso "<Tarjeta>" "<Fechacaducidad>" Ingreso "<CVV>"
      And Selcciono botón Depositar
      Then Se muestra mensaje "Estamos procesando tu depósito"
      Examples:
        |Vertical          | Pasarela         | Tarjeta           | Fechacaducidad   | CVV |
        |Ir a casino       | DebitoCredito   | 4009175332806176  |11/25             | 123 |
        #|Ir a sports      |          |  |                   |                |    |



