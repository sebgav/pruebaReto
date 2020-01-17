#Author: hamtont@gmail.com
@tag
Feature: Automation practice crear usuario
 

  @tag1
  Scenario: Crear usuario para verificar boleto de credito en la web yourlogo
    Given que el usuario desee crear una cuenta en la web
    When el usuario ingresa sus datos para la creacion
      | email               | firsname | lastname | pdw    | day   | month | year | addressname | adresslast | company | address    | city  | state   | postalcod | mobile |alias|
      | juanv129@tinton.com | juan     | valdez   | 123456 |  15   | June  | 2000 | luiz        | lopez      | sofka   | circular11 | miami | Florida |     05000 | 45789  |taba |
    Then el debera visualizar mensaje "You have not received any credit slips."
