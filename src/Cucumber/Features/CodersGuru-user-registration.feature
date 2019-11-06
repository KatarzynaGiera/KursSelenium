Feature: CodersGuru user registration

  Scenario: user can register with proper data (mass registration available)

    Given user open the main page (https://tester.codersguru.pl)
    When user go to registration page (https://tester.codersguru.pl/register/)
    And user enter all data (E-mail, Imię, Nazwisko, Hasło, Powtórz hasło, Miasto, Kod pocztowy, Ulica, Numer domu/lokalu)
    And user confirm to read the regulations
    And user use registration button
    Then user is logged in the store
