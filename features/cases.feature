# language: en
# namespace: Cases
@cases
Feature: Ügyekhez tartozó tesztek

@cases-2-1 @cases-2-2 @cases-2-6 @cases-2-7
Scenario: Jövőbeni érvényességi dátummal egy új ügy sikeresen rögzíthető
Alap adatok: megnevezés, érvényesség, személy.

Cím adatok: város, irányítószám, közterület, házszám
	Given Cases: a felhasználó az új ügy rögzítési felületen van
	And Cases: a felhasználó kitöltötte az összes adatot
	When Cases: a felhasználó a holnapi napot adja meg érvényességi időnek
	And Cases: a felhasználó elmenti az új ügyet
	Then Cases: a felhasználó visszatér az ügyek oldalra
	And Cases: az új ügy egyedi azonosítóval megjelenik az ügyek táblázatban

@cases-1-1
Scenario: Ügyek lista - megjelenő adatok helyesen jelenek meg
Megjelenített adatok: azonosító, állapot, megnevezés, személy, érvényesség, felelős.
	Given Cases: legalább egy ügy van a rendszerben
	And Cases: a felhasználó az ügyek oldalon van
	When Cases: a felhasználó ellenőrzi a megjelent ügyek adatait
	Then Cases: minden ügy megjelenik egy táblában
	And Cases: megjelenik az ügy azonosítója
	And Cases: megjelenik az ügy állapota
	And Cases: megjelenik az ügy megnevezése
	And Cases: megjelenik az ügy személye
	And Cases: megjelenik az ügy érvényessége
	And Cases: megjelenik az ügy felelőse

@cases-1-2 @cases-2-3 @cases-2-4
Scenario: Ügy létrehozása - generált adatok megjelennek
	Given Cases: a felhasználó az ügyek oldalon van
	When Cases: a felhasználó kezdeményezi egy új ügy létrehozását
	Then Cases: az új ügy oldal megjelenik
	And Cases: az ügy állapota új
	And Cases: az állapot nem szerkeszthető
	And Cases: az ügy felelőse ki van töltve

@cases-2-5
Scenario: Ügyfelvétel megszakítása sikeres
	Given Cases: a felhasználó az új ügy rögzítési felületen van
	And Cases: a felhasználó kitöltötte az összes adatot
	When Cases: a felhasználó megszakítja az ügy létrehozását
	Then Cases: a felhasználó visszatér az ügyek oldalra
	And Cases: új ügy nem jelenik meg a listában

@cases-1-3 @cases-3-1 @cases-3-4
Scenario: Meglévő ügy szerkesztése lehetséges
	Given Cases: legalább egy ügy van a rendszerben
	And Cases: a felhasználó az ügyek oldalon van
	When Cases: a felhasználó megnyitja szerkesztésre az ügyet
	Then Cases: a felhasználó az ügy oldalára jut
	And Cases: az ügy azonosítója megjelenik
	And Cases: az ügy felelőse megjelenik
	And Cases: a két érték nem módosítható

@cases-3-5
Scenario: Meglévő ügy sikertelen szerekesztése
Ügy alapadatai: megnevezés, érvényesség, személy.
	Given Cases: a felhasználó egy meglévő ügy oldalán van
	When Cases: a felhasználó módosítja az ügy alapadatait
	Then Cases: a felhasználó megszakítja az ügy létrehozását
	And Cases: a felhasználó visszatér az ügyek oldalra
	And Cases: az ügy módosítás nélkül jelenik meg

@cases-3-2 @cases-3-3 @cases-3-6
Scenario: Meglévő ügy sikeres szerkesztése
Alap adatok: megnevezés, érvényesség, személy.

Cím adatok: város, irányítószám, közterület, házszám.
	Given Cases: a felhasználó egy meglévő ügy oldalán van
	When Cases: a felhasználó módosítja az ügy cím adatait
	And Cases: a felhasználó módosítja az ügy alapadatait
	And Cases: a felhasználó elmenti az ügyet
	Then Cases: a felhasználó visszatér az ügyek oldalra
	And Cases: az ügy módosításai megjelenek az ügyek táblázatban
