 #Autor: Ronald Carrasco

 Feature: Poder realizar el inicio de sesión del usuario a la pltaforma web del casino Atlantic City
Como fanatico de las maquinas de tragamonedas
Quiero iniciar sesión en la web del casino Atlantic City
Para poder disfrutrar de los juegos virtuales

  Background:
    Given ingreso a la web del casino

  @ValidarInicioSesionUsuario
  Scenario Outline: Validar inicio de sesión para la cuenta creada
    When selecciono la opcion iniciar sesion
    And ingreso el "<usuario>" y "<contrasenna>"
    And selecciono el boton iniciar sesion
    Then se debe mostrar el usuario logueado "<usuarioLogueado>"
    Examples:Datos de usuario Loqueado
      | usuario | contrasenna |usuarioLogueado|
      |usuVahpc |  atl1Vipeh  | usuVahpc      |