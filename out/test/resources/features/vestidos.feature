@tag
Feature: Registrar vestido
 

  @tag1
  Scenario: Registrar 2 vestidos uno caro y uno barato
    Given que el usuario desee crear una cuenta en la web
    When el usuario ingresa sus datos para la creacion
   | juan     | valdez   | 123456 |  15   | June  | 2000 | luiz        | lopez      | Company   | circular11 | miami | Florida |     05000 | 45789  |sebgav |
    And selecciona el vestido mas caro y el mas barato
    Then se validaran los vestidos seleccionados en el carro
