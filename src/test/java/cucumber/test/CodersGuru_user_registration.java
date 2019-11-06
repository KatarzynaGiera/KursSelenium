package cucumber.test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import przyklad1.MailGenerator;

public class CodersGuru_user_registration {

    public WebDriver driver;

    @Given("^user open the main page \\(https://tester\\.codersguru\\.pl\\)$")
    public void userOpenTheMainPageHttpsTesterCodersguruPl() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do CodersGuru
        driver.get("https://tester.codersguru.pl/");
    }

    @When("^user go to registration page \\(https://tester\\.codersguru\\.pl/register/\\)$")
    public void userGoToRegistrationPageHttpsTesterCodersguruPlRegister() {
        //Kliknij przycisk "zarejestruj"
        driver.findElement(By.xpath("/html/body/section[3]/div/form/input[2]")).click();
    }

    @And("^user enter all data \\(E-mail, Imię, Nazwisko, Hasło, Powtórz hasło, Miasto, Kod pocztowy, Ulica, Numer domu/lokalu\\)$")
    public void userEnterAllDataEMailImięNazwiskoHasłoPowtórzHasłoMiastoKodPocztowyUlicaNumerDomuLokalu() {
        MailGenerator mailGenerator = new MailGenerator();
        String Imie= "Anna";
        String Nazwisko = "Jakas";
        String mail=mailGenerator.MailGenerator(Imie, Nazwisko);
        String Haslo= "haslo123";
        String Miasto = "Warszawa";
        String Kod = "09-200";
        String Ulica = "Wielka";
        String Numer = "1/2";

        //wprowadź e-mail
        WebElement email = driver.findElement(By.name("fos_user_registration_form[email]"));
        email.clear();
        email.sendKeys(mail);

        //wprowadź imię
        WebElement imie = driver.findElement(By.name("fos_user_registration_form[name]"));
        imie.clear();
        imie.sendKeys(Imie);


        //wprowadź nazwisko
        WebElement nazwisko = driver.findElement(By.name("fos_user_registration_form[lastname]"));
        nazwisko.clear();
        nazwisko.sendKeys(Nazwisko);

        //wprowadź hasło
        WebElement haslo1 = driver.findElement(By.name("fos_user_registration_form[plainPassword][first]"));
        haslo1.clear();
        haslo1.sendKeys(Haslo);

        //powtórz hasło
        WebElement haslo2 = driver.findElement(By.name("fos_user_registration_form[plainPassword][second]"));
        haslo2.clear();
        haslo2.sendKeys(Haslo);

        //wpisz miasto
        WebElement miasto = driver.findElement(By.name("form[city]"));
        miasto.clear();
        miasto.sendKeys(Miasto);

        //wpisz kod pocztowy
        WebElement kod = driver.findElement(By.name("form[postal_code]"));
        kod.clear();
        kod.sendKeys(Kod);

        //wpisz ulicę
        WebElement ulica = driver.findElement(By.name("form[street]"));
        ulica.clear();
        ulica.sendKeys(Ulica);

        //wpisz numer domu
        WebElement numer = driver.findElement(By.name("form[number]"));
        numer.clear();
        numer.sendKeys(Numer);
    }

    @And("^user confirm to read the regulations$")
    public void userConfirmToReadTheRegulations() {
        //zaznacz checkbox "Zapoznałem się z regulaminem"
        driver.findElement(By.xpath("/html/body/div/div/div/form/div[12]/input")).click();
    }

    @And("^user use registration button$")
    public void userUseRegistrationButton() {
        //kliknij "Zarejestruj"
        driver.findElement(By.xpath("//*[@id=\"register-submit-btn\"]")).click();
    }

    @Then("^user is logged in the store$")
    public void userIsLoggedInTheStore() {
        Assert.assertTrue(driver.findElement(By.id("user-name")).getText().contains("Anna"));

    }


}
