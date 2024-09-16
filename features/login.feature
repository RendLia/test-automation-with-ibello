# language: en
# namespace: Login
@login
Feature: Bejelentkezés tesztek

@login-1-1 @login-1-2
Scenario: Érvényes felhasználói adatokkal a bejelentkezés sikeres
	Given Login: a felhasználó a bejelentkezési felületen van
	When Login: a felhasználó érvényes felhasználói nevet ad meg
	And Login: a felhasználó érvényes jelszót ad meg
	And Login: a felhasználó megpróbál bejelentkezni
	Then Login: a bejelentkezés sikeres
	And Login: a felhasználó a főoldalra érkezik

@login-2-1
Scenario: Érvénytelen jelszóval a bejelentkezés sikertelen
	Given Login: a felhasználó a bejelentkezési felületen van
	When Login: a felhasználó érvényes felhasználói nevet ad meg
	And Login: a felhasználó érvénytelen jelszót ad meg
	And Login: a felhasználó megpróbál bejelentkezni
	Then Login: a bejelentkezés sikertelen
	And Login: a felhasználó érvénytelen felhasználói adatokkal kapcsolatos hibaüzenetet kap

@login-2-2
Scenario: Sikertelen belépés után újra próbálkozás sikeres
	Given Login: sikertelen belépés után, a felhasználó még a belépés oldalon van
	When Login: a felhasználó érvényes adatokkal próbál meg belépni
	Then Login: a bejelentkezés sikeres
	And Login: a felhasználó a főoldalra érkezik
