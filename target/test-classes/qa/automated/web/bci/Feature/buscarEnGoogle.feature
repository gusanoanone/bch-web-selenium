Feature: Buscar en google

Background:
	Given Estoy en la pagina "http://www.google.com"
    
Scenario: Buscar en google tsoft
	When busco "tsoft"
    Then aparece "tsoft"

Scenario: Buscar en google tsoft
	When busco "banco de chile"
    Then aparece "banco de chile"

Scenario: Buscar en google tsoft
	When busco "cafe"
    Then aparece "cafe"

Scenario: Buscar en google tsoft
	When busco "tequila"
    Then aparece "tequila"
