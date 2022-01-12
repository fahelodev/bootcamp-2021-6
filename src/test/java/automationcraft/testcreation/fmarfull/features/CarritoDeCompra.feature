Feature: Carrito de Compra
  Como usuario
  quiero agregar productos al carrito para hacer una compra

  Background: Agregar producto
    Given que estoy en la url "https://www.paris.cl/iphone-11-64gb-negro%C2%A0%C2%A0-486146999.html#q=iphone&start=1"
    When presiono el boton añadir al carro
    Then se debe agregar un producto al carro
    And presiono el boton ir al carro
    Then puedo ver el carrito de compra en pantalla

  Scenario: CA-01 - Límite de Stock de un producto
    Given que el cliente está el en carrito de compras con 1 producto
    When el cliente aumenta la cantidad a pedir del producto haciendo click en el botón "+" del producto a un número mayor de [limite stock]
    Then el botón "+" se deshabilita.

  Scenario: CA-02 - Total con la máxima garantía Daño Accidental - 3 años
    Given que el cliente está el en carrito de compras con al menos 1 producto SIN Garantía Extendida
    When el cliente agrega la garantia de daño accidental
    Then el total a pagar incluye el monto a pagar del producto + el valor de la garantía del producto

  Scenario: CA-03 - Código promocional inválido
    Given que el cliente está en el carrito con varios productos a comprar
    When el cliente introduce un número de cupón inválido y hace clic en el botón "Aplicar"
    Then se muestra un mensaje de error cerca del campo que dice "Código de Cupón Inválido"