Feature: Carrito de Compra
  Como usuario
  quiero poder agregar productos al carrito
  para hacer una compra online de productos

  Background: Agregar producto
    Given que estoy en la url "https://www.farmaciasahumada.cl/catalogsearch/result/?q=bromex"
    When presiono el boton guardar
    Then se debe agregar correctamente el producto al carrito
    And ver el carrito de compra en pantalla

  Scenario: CA-01 - Límite de Stock de un producto
    Given que el cliente está el en carrito de compras con al menos 1 producto
    When el cliente aumenta la cantidad a pedir del producto a un número mayor de 10
    And hace clic en "Actualizar la Compra"
    Then se debe mostrar un popup que dice "Has excedido el número máximo de unidades que puedes solicitar."

  Scenario: CA-02 - Producto con Receta Médica
    Given que el cliente está el en carrito de compras con al menos 1 producto
    Then en cada artículo que esté asociado a un producto con receta médica debe aparecer un mensaje de alerta "Este medicamento requiere receta médica. Es necesario subirla en el paso siguiente."

  Scenario: CA-03 - Tarjeta CMR
    Given que el cliente está el en carrito de compras con al menos 1 producto
    When el cliente introduce un número de tarjeta CMR inválido
    And  hace clic en "Aplicar"
    Then se despliega un mensaje de error en el carrito que dice "El número ingresado no es válido, recuerda ingresar los 6 primeros dígitos de tu CMR o Débito Banco Falabella para poder acceder al 25% de descuento."