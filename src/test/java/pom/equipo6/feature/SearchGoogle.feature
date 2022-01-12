# gherkin -> lenguaje de especificacion
# sintaxis, semantica

  #Historia de usuario
Feature: Busqueda en Google
  Como usuario web,
  Quiero buscar en Google
  Para reponder mis dudas.

  @test @regresion
  Scenario: Busqueda Simple con barra Google
    #dado
    Given estoy en un navegador con la pagina inicial de google
    #cuando
    When introduzco la palabra "arbol" en la barra
    #Y
    And realizo la busqueda con Enter
    #Entonces
    Then el navegador me muestra los resultados

  @test2
  Scenario: Busqueda Simple con barra Google
    Given estoy en un navegador con la pagina inicial de google
    When introduzco la palabra "arbol" en la barra
    And realizo la busqueda con Enter
    Then el navegador me muestra los resultados
  @test3
  Scenario: Busqueda Simple con barra Google
    Given estoy en un navegador con la pagina inicial de google
    When introduzco la palabra "arbol" en la barra
    And realizo la busqueda con Enter
    Then el navegador me muestra los resultados