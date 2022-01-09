@FiltrarBusquedaEstrellas
Feature: Test Filtrar Por Estrellas (3)
  Scenario: As User search some destiny, without a date, using star filters.
    Given i'm on the modules Alojamientos in the page Viajes Falabella
    When i set a destiny to arrive and i search it
    And i filter the results by stars
    Then i click on the hotel thar appears on the top of the list