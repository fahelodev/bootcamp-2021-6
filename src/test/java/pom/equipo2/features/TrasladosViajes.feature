@ViajesTraslados
Feature: Test Viajes Traslados Change Dolar

  Scenario: As a user Change of Peso chileno to Dolar

    Given I am on the modules Traslados page Viajes Falabella
    When I click in card traslado auto
    And I change option of moneda of peso to dolar
    Then the text moneda change