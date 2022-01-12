Feature: Carrito de Compra
  Como usuario
  quiero agregar productos al carrito para hacer una compra

  Background: Agregar producto
    Given que estoy en la url "https://www.paris.cl/iphone-11-64gb-negro%C2%A0%C2%A0-486146999.html#q=iphone&start=1"
    When agrego al carrito
    And click en continuar
    And click en ir al carrito

@01
  Scenario: CA-01 - Límite de Stock de un producto
  #Given que el cliente está el en carrito de compras con un producto
  Then el cliente aumenta la cantidad a pedir del producto haciendo click en el botón mas del producto a un número mayor de limite de stock
  When el botón mas se deshabilita.

  @03
 Scenario: CA-03 - Código promocional inválido
 # Given que el cliente está en el carrito con varios productos a comprar
  When el cliente introduce un número de cupón inválido y hace clic en el botón aplicar
  Then se muestra un mensaje de error cerca del campo que dice Código de Cupón Inválido

