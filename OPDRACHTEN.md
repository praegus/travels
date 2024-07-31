# Opdrachten

Hierbij de opdrachten bijpassend bij de workshop.

## Opdracht 1 - Onze allereerste UI-test

1. Ga in je project folder naar de spec file die zojuist aangemaakt is.
2. Vervang de test door de onderstaande:

```
describe('Praegus Travels', () => {
  it('search the campings', () => {
    cy.visit('http://localhost:1237/');
    cy.contains('Camping Zeezicht').should('be.visible');
    cy.contains('Camping Parkweide').should('be.visible');
    cy.contains('Camping Zonzicht').should('be.visible');
  });
});
```

3. Ga weer terug naar Cypress en kijk hoe de nieuwe test gedraaid wordt.

## Opdracht 2

Speel eerst de CSS Selector game om te leren hoe je elementen kunt vinden op een pagina: https://flukeout.github.io doe een aantal levels en zorg dat je begrijpt hoe je HTML elementen kunt selecteren.

Probeer de onderstaande scenario's te automatiseren. Hou daarbij de cleancode principes aan. Gebruik de Cypress docs om te kijken welke acties je kunt gebruiken: https://docs.cypress.io

1. Open http://localhost:1237/
2. Controleer of het Praegus travels logo zichtbaar is.
3. Open het menu
4. Klik op "Voeg nieuwe camping toe."
5. Vul alle velden in.
6. Klik op opslaan.
7. Ga naar de homepage.
8. Controleer of de nieuwe camping zichtbaar is.

## Opdracht 3

Draai de test een aantal keer achter elkaar. Wat valt je op? Is dit een goede test? Discusieer en implementeer een verbeterde versie.

## Opdracht 4

We gaan nu beginnen met de API

1. Ga naar http://localhost:1237/v3/api-docs/public
2. Download dit bestand als travels.json
3. Open Bruno en importeer deze als OpenAPI V3 Spec
4. Bekijk alle requesten die er zijn en probeer ze uit
5. Probeer het scenario van opdracht 2 na te maken maar dan via de API.
6. Draai deze test in Bruno.
7. Bekijk via de frontend of de test echt geslaagd is.

## Opdracht 5

1. Ga naar https://beta.cyber-dojo.org/creator/home
2. Create a new practice. “closest to zero.”
3. Kies voor Java 21, JUnit 5
4. Draai de test en maak deze groen

## Opdracht 6

Hernoem nu de bestanden in dit project:

Hiker.java > Camping.java
HikerTest.java > CampingTest.java

In deze repository staan deze files ook, plak de inhoud hiervan in je Cyber Dojo omgeving en run de testen.
Er is een maximum van 5 sterren die je kunt toewijzen aan een camping. Implementeer dit in de Camping class en schrijf enkele unittesten om dit aan te tonen. Denk aan grenswaarden en equivalentieklassen.
