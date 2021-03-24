@tag
Feature: operaciones  Servicios


  @tag1
  Scenario: Operacion gGet
    Given consumo el  serivio
    When listo los valores
    Then se mostraran

  @tag2
  Scenario: Operacion post
    Given consumo el serivio post
    When listo los valores
    Then se mostraran

  @tag3
  Scenario: Operacion delete
    Given consumo el serivio para eliminar
    When valido el status code
    Then valido que  halla eliminado
