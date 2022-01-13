Feature: Carrito de Compra
  Como usuario
  quiero agregar productos al carro para hacer una compra

  Background: Agregar producto
    Given que entro a la url "https://www.paris.cl/iphone-11-64gb-negro%C2%A0%C2%A0-486146999.html#q=iphone&start=1"
    When presiono el boton Añadir al carro
    Then se debe agregar correctamente el producto al carro
    And ver el carro de compra en pantalla

  Scenario: CA-01 - Límite de Stock de un producto
    Given el cliente está el en carrito de compras con 1 producto
    When el cliente aumenta la cantidad a pedir del producto haciendo click en el botón "+" del producto a un número mayor de [limite stock]
    Then Entonces el botón "+" se deshabilita.

