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

Draai de test een aantal keer achter elkaar. Wat valt je op? Is dit een goede test? Discusieer en implementeer een verbeterde versie

## Opdracht 4

We gaan nu beginnen met de API

1. Ga naar http://localhost:1237/v3/api-docs/public
2. Download dit bestand als travels.json
3. Open Bruno en importeer deze als OpenAPI V3 Spec
4. Bekijk alle requesten die er zijn en probeer ze uit

## Opdracht 5

1. Probeer het scenario van opdracht 2 na te maken maar dan via de API.
2. Draai deze test in Bruno.
3. Bekijk via de frontend of de test echt geslaagd is.
