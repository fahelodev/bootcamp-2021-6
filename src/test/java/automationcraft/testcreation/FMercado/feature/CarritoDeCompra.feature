Feature: Carrito de Compra
  Como usuario
  quiero agregar productos al carrito para hacer una compra


  Background: Agregar producto
    Given que estoy en la url "https://www.paris.cl/iphone-11-64gb-negro%C2%A0%C2%A0-486146999.html#q=iphone&start=1"
    When presiono agregar producto al carrito
    Then se debe agregar correctamente el producto al carrito
    And ver el carrito de compra en pantalla

  Scenario: Límite de Stock de un producto
    #dado
    Given que el cliente está el en carrito de compras con 1 producto
    #cuando
    When el cliente aumenta la cantidad a pedir del producto haciendo click en el botón "+" del producto a un número mayor de [limite stock]
    #entonces
    Then el botón "+" se deshabilita.
