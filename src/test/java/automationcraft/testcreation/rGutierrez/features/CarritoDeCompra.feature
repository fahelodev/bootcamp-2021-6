Feature: Carrito de Compra
  Como usuario
  quiero poder agregar productos al carrito
  para hacer una compra

  Background: Agregar producto
    Given que estoy en la url "https://www.paris.cl/iphone-11-64gb-negro%C2%A0%C2%A0-486146999.html#q=iphone&start=1"
    When presiono el boton Añadir al carro
    And presiono continuar
    And presiono ir al carro
    Then se debe agregar correctamente el producto al carrito

  Scenario: CA-01 - Límite de Stock de un producto
    Given que el cliente está el en carrito de compras con al menos 1 producto
    When el cliente aumenta la cantidad a pedir del producto con el boton + a un numero mayor a 20
    Then se debe deshabilitar el boton +