Feature: Poder generar el código de depósito


   Background:
     Given realizo el inicio de sesión con un usuario en moneda soles sin depósitos

  @ValidarCodigoKashioSolesMontoMinimo @RegresionGeneracionCodigo
   Scenario Outline: Validar que genere el código de pago con el monto mínimo
     When Me encuentro en "<Vertical>"
     And ingreso los datos del usuario
       | usuario | contrasenna |
       |usuVahpc |  atl1Vipeh  |
     And Selecciono botón Depositar"
     And Selecciono "<Pasarela>"
     And Selecciono el monto:
      |MontoOrigen|
      |30               |
     And Selecciono botón Siguiente
     Then Se debe mostrar el siguiente mensaje
      |mensaje                    |
      |Tu código se está generando|
     And Se muestra código de pago
     And Se muestra el monto mínimo
     |MontoMinimoResultante |
     |S/ 30.00              |
     Examples:
       |Vertical          | Pasarela    |
       |Ir a casino       | Kashio      |
       |Ir a sports       | Safetypay   |
       |Ir a casino       | PagoEfectivo|
       |Ir a sports       | PagoQR      |


  @ValidarCodigoKashioSolesMontoMaximo @RegresionGeneracionCodigo
  Scenario Outline: Validar que genere el código de pago con el monto mínimo
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |usuVahpc |  atl1Vipeh  |
    And Selecciono botón Depositar"
    And Selecciono "<Pasarela>"
    And Selecciono el monto:
      |MontoOrigen|
      |300        |
    And Selecciono botón Siguiente
    Then Se debe mostrar el siguiente mensaje
      |mensaje                    |
      |Tu código se está generando|
    And Se muestra código de pago
    And Se muestra el monto maximo
      |MontoMaximoResultante |
      |S/ 300.00                |
    Examples:
      |Vertical          | Pasarela    |
      |Ir a casino       | Kashio      |
      |Ir a sports       | Safetypay   |
      |Ir a casino       | PagoEfectivo|
      |Ir a sports       | Pago con QR |




