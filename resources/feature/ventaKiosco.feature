Feature: Ingresar a la aplicacion kiosco y realizar pedidos de comidas

  #  Background
  #  Scenario: Modificar el archivo de configuracion a kiosco
  #    Given que yo necesite modificar archivo
  @tag1
  Scenario: Ingresar al Home de app Kiosco y abandonar una compra acumulando puntos
    Given que yo me encuentre en el Home de app Kiosco
    When yo ingrese el numero de nit de JuanValdez
      | tipodoc | cedula     | nombre y puntos             |
      | NIT     | 9889128822 | JUAN VALDEZ \| Puntos: 2040 |
    And yo seleciono categoria "3"
    And selecciono producto "0" card en la categoria seleccionada
    And presiono el boton agregar
    And agrego el plu a la tirilla
    And yo ejecuto la accion de abandonar compra y respondo si
    Then visualizo mensaje "Por favor contacte a un asesor"
    And Presiono el boton magico

  @tag2
  Scenario: Ingresar al Home de app Kiosco y comprar sin acumular puntos y abandonar la compra
    Given que yo me encuentre en el Home de app Kiosco
    When yo presiono el boton sin puntos colombia
    And yo seleciono categoria "3"
    And selecciono producto "1" card en la categoria seleccionada
    And presiono el boton agregar
    And agrego el plu a la tirilla
    And yo debo visualizar el total a pagar este correcto
    And yo ejecuto la accion de abandonar compra y respondo si
    Then visualizo mensaje "Por favor contacte a un asesor"
    And Presiono el boton magico

  @tag3
  Scenario: Realizar transaccion no exitosa pagando con tarjeta medio de pago credito
    Given que yo me encuentre en el Home de app Kiosco
    When yo presiono el boton sin puntos colombia
    And yo seleciono categoria "3"
    And selecciono producto "2" card en la categoria seleccionada
    And presiono el boton agregar
    And agrego el plu a la tirilla
    And selecciono el medio de pago tarjeta credito
    Then yo debo visualizar la tirilla con los items registrados
    And yo debo visualizar el total a pagar este correcto
    And yo visualizo el proceso de pago con datafono transaccion NO fue aprobada

  @tag4
  Scenario: Abandonar tx validando que actualice pantalla categorias de kiosco
    Given que yo me encuentre en el Home de app Kiosco
    When yo presiono el boton sin puntos colombia
    And yo seleciono categoria "3"
    And selecciono producto "3" card en la categoria seleccionada
    And presiono el boton agregar
    And agrego el plu a la tirilla
    And yo ejecuto la accion de abandonar compra y respondo si
    Then visualizo mensaje "Por favor contacte a un asesor"
    When Presiono el boton magico
    Then ingreso de nuevo y visualizo la tirilla con valor pagar en cero
      | tipodoc     | cedula     | nombre y puntos                   |
      | por defecto | 0123456789 | RUPERTA HERNANDEZ \| Puntos: 1940 |

  @tag5
  Scenario: Ingresar al Home de app Kiosco con NIT y cambiar cliente puntos col sin registrar productos
    Given que yo me encuentre en el Home de app Kiosco
    When yo ingrese el numero de nit de JuanValdez
      | tipodoc | cedula     | nombre y puntos             |
      | NIT     | 9889128822 | JUAN VALDEZ \| Puntos: 2040 |
    When presione en el boton salir de categorias
    And deseo cambiar el usuario de puntos colombia
      | tipodoc     | cedula     | nombre y puntos                   |
      | por defecto | 0123456789 | RUPERTA HERNANDEZ \| Puntos: 1940 |
    And yo seleciono categoria "3"

  @tag6
  Scenario: Ingresar al Home de app Kiosco con NIT y cambio cliente puntos col registrando productos
    Given que yo me encuentre en el Home de app Kiosco
    When yo ingrese el numero de nit de JuanValdez
      | tipodoc | cedula     | nombre y puntos             |
      | NIT     | 9889128822 | JUAN VALDEZ \| Puntos: 2040 |
    And yo seleciono categoria "3"
    And selecciono producto "4" card en la categoria seleccionada
    And presiono el boton agregar
    And agrego el plu a la tirilla
    And deseo cambiar el usuario de puntos colombia
      | tipodoc     | cedula     | nombre y puntos                   |
      | por defecto | 0123456789 | RUPERTA HERNANDEZ \| Puntos: 1940 |
    Then selecciono el medio de pago tarjeta debito
    And yo visualizo el proceso de pago con datafono exitoso

  @tag7
  Scenario: Ingresar al menu del administrador y recargar la app
    Given que yo me encuentre en el Home de app Kiosco
    When yo presiono el boton sin puntos colombia
    And yo seleciono categoria "4"
    And selecciono producto "1" card en la categoria seleccionada
    And presiono el boton agregar
    And agrego el plu a la tirilla
    And presiono seis veces la imagen exito
    And ingreso la clave del supervisor
    Then visualizo el menu y recargo la pagina para actualizar la app

  @tag8
  Scenario: Ingresar al Home de app Kiosco y comprar un producto sin acumular puntos
    Given que yo me encuentre en el Home de app Kiosco
    When yo presiono el boton sin puntos colombia
    And yo seleciono categoria "6"
    And selecciono producto "0" card en la categoria seleccionada
    And presiono el boton agregar
    And agrego el plu a la tirilla
    Then yo debo visualizar la tirilla con los items registrados
    When selecciono el medio de pago tarjeta debito
    Then yo visualizo el proceso de pago con datafono exitoso

  @tag9
  Scenario: Ingresar al Home de app Kiosco y comprar comprar producto 1 de la categoria 1
    Given que yo me encuentre en el Home de app Kiosco
    When yo presiono el boton sin puntos colombia
    And yo seleciono categoria "1"
    And selecciono producto "1" card en la categoria seleccionada
    And presiono el boton agregar
    And selecciono la composicion
      | termino | acompa              | ensalada         |
      | Azul    | Papas a la francesa | Ensalada del dia |
    And agrego el plu a la tirilla
    Then yo debo visualizar la tirilla con los items registrados
    And selecciono el medio de pago tarjeta debito
    And yo visualizo el proceso de pago con datafono exitoso

  @tag10
  Scenario: Ingresar al Home de app Kiosco y comprar producto 2 de la categoria 1
    Given que yo me encuentre en el Home de app Kiosco
    When yo presiono el boton sin puntos colombia
    And yo seleciono categoria "1"
    And selecciono producto "2" card en la categoria seleccionada
    And presiono el boton agregar
    And selecciono la composicion
      | termino         | acompa             | ensalada         |
      | Un Cuarto (1/4) | Yuca a la francesa | Ensalada del dia |
    And agrego el plu a la tirilla
    Then yo debo visualizar la tirilla con los items registrados
    And selecciono el medio de pago tarjeta debito
    And yo visualizo el proceso de pago con datafono exitoso

  @tag11
  Scenario: Ingresar al Home de app Kiosco y comprar producto 3 de la categoria 1
    Given que yo me encuentre en el Home de app Kiosco
    When yo presiono el boton sin puntos colombia
    And yo seleciono categoria "1"
    And selecciono producto "3" card en la categoria seleccionada
    And presiono el boton agregar
    And selecciono la composicion
      | termino         | acompa            | ensalada         |
      | Un Cuarto (1/4) | Casquitos de papa | Ensalada del dia |
    And agrego el plu a la tirilla
    Then yo debo visualizar la tirilla con los items registrados
    And selecciono el medio de pago tarjeta debito
    And yo visualizo el proceso de pago con datafono exitoso

  @tag12
  Scenario: Ingresar al Home de app Kiosco y comprar producto 4 de la categoria 1
    Given que yo me encuentre en el Home de app Kiosco
    When yo presiono el boton sin puntos colombia
    And yo seleciono categoria "1"
    And selecciono producto "4" card en la categoria seleccionada
    And presiono el boton agregar
    And selecciono la composicion
      | termino         | acompa             | ensalada         |
      | Un Cuarto (1/4) | Sin acompañamiento | Ensalada del dia |
    And agrego el plu a la tirilla
    Then yo debo visualizar la tirilla con los items registrados
    And selecciono el medio de pago tarjeta debito
    And yo visualizo el proceso de pago con datafono exitoso

  @tag13
  Scenario: Ingresar al Home de app Kiosco y comprar producto 5 de la categoria 1
    Given que yo me encuentre en el Home de app Kiosco
    When yo presiono el boton sin puntos colombia
    And yo seleciono categoria "1"
    And selecciono producto "5" card en la categoria seleccionada
    And presiono el boton agregar
    And selecciono la composicion
      | termino     | acompa             | ensalada         |
      | Medio (1/2) | Yuca a la francesa | Ensalada del dia |
    And agrego el plu a la tirilla
    Then yo debo visualizar la tirilla con los items registrados
    And selecciono el medio de pago tarjeta debito
    And yo visualizo el proceso de pago con datafono exitoso

  @tag14
  Scenario: Ingresar al Home de app Kiosco y comprar producto 1 de la categoria 2
    Given que yo me encuentre en el Home de app Kiosco
    When yo presiono el boton sin puntos colombia
    And yo seleciono categoria "1"
    And selecciono producto "2" card en la categoria seleccionada
    And presiono el boton agregar
    And selecciono la composicion de la hamburguesa
      | termino            | acompa    | ensalada     |
      | Tres cuartos (3/4) | Sin queso | Sin ensalada |
    And agrego el plu a la tirilla
    Then yo debo visualizar la tirilla con los items registrados
    And selecciono el medio de pago tarjeta debito
    And yo visualizo el proceso de pago con datafono exitoso

  @tag15
  Scenario: Ingresar al Home de app Kiosco y comprar comprar producto 2 de la categoria 2
    Given que yo me encuentre en el Home de app Kiosco
    When yo presiono el boton sin puntos colombia
    And yo seleciono categoria "2"
    And selecciono producto "2" card en la categoria seleccionada
    And presiono el boton agregar
    And selecciono la composicion
      | termino            | acompa              | ensalada     |
      | Tres cuartos (3/4) | Papas a la francesa | Sin ensalada |
    And agrego el plu a la tirilla
    Then yo debo visualizar la tirilla con los items registrados
    And selecciono el medio de pago tarjeta exito
    And yo visualizo el proceso de pago con datafono exitoso
   

  @tag16
  Scenario: Ingresar al Home de app Kiosco y comprar producto 3 de la categoria 2
    Given que yo me encuentre en el Home de app Kiosco
    When yo presiono el boton sin puntos colombia
    And yo seleciono categoria "2"
    And selecciono producto "3" card en la categoria seleccionada
    And presiono el boton agregar
    And selecciono la composicion de la hamburguesa
      | termino            | acompa       | ensalada     |
      | Tres cuartos (3/4) | Sin tocineta | Sin ensalada |
    And agrego el plu a la tirilla
    Then yo debo visualizar la tirilla con los items registrados
    And selecciono el medio de pago tarjeta debito
    And yo visualizo el proceso de pago con datafono exitoso
    
  @tag17
  Scenario: Ingresar al Home de app Kiosco comprar  producto 2 de la categoria 2 y aumentar cantidad
    Given que yo me encuentre en el Home de app Kiosco
    When yo presiono el boton sin puntos colombia
    And yo seleciono categoria "3"
    And selecciono producto "1" card en la categoria seleccionada
    And presiono el boton agregar
    And agrego el plu a la tirilla
    Then aumento a "2" la cantidad del producto y agrego a tirilla
    And yo debo visualizar la tirilla con los items registrados
    
    
    
    
    
 # @tag21
 # Scenario: Ingresar al Home de app Kiosco y comprar varios productos
 #   Given que yo me encuentre en el Home de app Kiosco
 #   When yo presiono el boton sin puntos colombia
 #   And yo seleciono categoria "3"
 #   And selecciono producto y composicion
 #     | producto | termino          | acompa            | ensalada     |
 #     |        0 | Bien Asada (4/4) | Papa cocida       | Sin ensalada |
 #     |        1 | Bien Asada (4/4) | Casquitos de papa | Sin ensalada |
 #     |        2 | Bien Asada (4/4) | Casquitos de papa | Sin ensalada |
 #     |        3 | Azul (1/4)       | Papa cocida       | Sin ensalada |
 #   Then yo debo visualizar la tirilla con los items registrados
 #   And selecciono el medio de pago tarjeta debito
 #   And yo visualizo el proceso de pago con datafono exitoso
