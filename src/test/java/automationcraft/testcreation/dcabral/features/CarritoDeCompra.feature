Feature: Carrito de Compra
  Como usuario
  quiero agregar productos al carrito para hacer una compra

  Background: Agregar producto
    Given que estoy en la url "https://www.paris.cl/iphone-11-64gb-negro%C2%A0%C2%A0-486146999.html#q=iphone&start=1"
    When presiono el boton añadir al carro
    And presiono el boton Continuar
    And presiono ir al carro
    Then se debe agregar correctamente el producto al carrito y ver el carrito de compra en pantalla


  Scenario: CA-03 - Código promocional inválido
    Given que el cliente está en el carrito con varios productos a comprar
    When el cliente introduce un número de cupón inválido y hace clic en el botón "Aplicar"
    Then se muestra un mensaje de error cerca del campo que dice "Código de Cupón Inválido"

