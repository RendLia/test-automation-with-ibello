# language: en
# namespace: User
@user
Feature: Felhasználókhoz tartozó teszetek

@user-1-1 @user-1-2 @testrun
Scenario: Felhasználó név adatai helyesen jelenek meg
	Given User: a felhasználó a felhasználói oldalon van
	When User: a felhasználó ellenőrzi a név adatokat
	Then User: a felhasználói név csak olvasható módon jelenik meg
	And User: a teljes név csak olvasható módon jelenik meg

@user-2-1 @user-2-2 @user-2-3 @testrun
Scenario: Jelszó módosítása sikeres
	Given User: a felhasználó a felhasználói oldalon van
	When User: a felhasználó helyesen megadja a jelenlegi jelszavát
	And User: a felhasználó kétszer megadja az új érvényes jelszavát
	And User: a felhasználó menti a módosítást
	Then User: a jelszó módosítása sikeres

@user-2-2 @testrun
Scenario: Jelszó módosítása hibás jelenlegi jelszóval sikertelen
	Given User: a felhasználó a felhasználói oldalon van
	When User: a felhasználó hibásan megadja a jelenlegi jelszavát
	And User: a felhasználó kétszer megadja az új érvényes jelszavát
	And User: a felhasználó menti a módosítást
	Then User: a jelenlegi jelszóval kapcsolatos hiba üzenet jelenik meg
	And User: a jelszó módosítása sikertelen

@user-2-3
Scenario: Jelszó módosítása új jelszó egyszeri helyes megadásával sikertelen
	Given User: a felhasználó a felhasználói oldalon van
	When User: a felhasználó helyesen megadja a jelenlegi jelszavát
	And User: a felhasználó csak egyszer adja meg helyesen az új érvényes jelszavát
	And User: a felhasználó menti a módosítást
	Then User: az új jelszóval kapcsolatos hiba üzenet jelenik meg
	And User: a jelszó módosítása sikertelen
