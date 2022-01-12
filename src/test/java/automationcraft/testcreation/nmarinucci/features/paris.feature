Feature: Carrito de Compras
  Como usuario
  Quiero agregar productos al carrito
  Para hacer una compra

  Background:
    Given estoy en la url "https://www.paris.cl/iphone-11-64gb-negro%C2%A0%C2%A0-486146999.html#q=iphone&start=1"
    When presiono el boton añadir al carro
    And el producto se debe agregar correctamente al carro
    Then ver el carro de compra en pantalla

  Scenario: CA-01 Limite de Stock de un producto
    Given el cliente esta en el carrito de compras
    When el cliente aumenta la cantidad del producto a un numero mayor de 20
    Then el boton + se deshabilita

