Feature: Carrito de Compra - Apple
  Como usuario
  quiero poder agregar productos al carrito de compras

  Background: Agregar producto
    Given que estoy en la url "https://www.paris.cl/iphone-11-64gb-negro%C2%A0%C2%A0-486146999.html#q=iphone&start=1"
    Then se debe agregar correctamente el producto al carrito

  Scenario: CA-01 - Límite de Stock de un producto
    When Cuando el cliente aumenta la cantidad a pedir del producto haciendo click en el botón "+" del producto a un número mayor de [limite stock]
    Then Entonces el botón "+" se deshabilita.
