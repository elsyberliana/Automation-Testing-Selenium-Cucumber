package stepDef;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.env_target;
import java.time.Duration;

public class LoginBDD extends env_target {
    @Given("User is on Login Page")
    public void userIsOnLoginPage() {
        //set driverlocation path
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //Maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Set url
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
    }

    @When("User fill username and password")
    public void userFillUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("User fill invalid username and password")
    public void userFillInvalidUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("User asal");
        driver.findElement(By.id("password")).sendKeys("PasswordSalah");
    }

    @And("User click Login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
    }

    @Then("User will redirect to Products page")
    public void userWillRedirectToProductsPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Products')]"))
        );

        driver.quit();
    }
    //Invalid Login
    @Then("User will get error message")
    public void UserWillGetErrorMessage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3"))
        );

        driver.quit();
    }

    @And("User should be on Products page")
    public void UserShouldBeOnProductsPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Products')]"))
        );
    }


    @Then("User click Add to cart button")
    public void userClickAddToCartButton() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @And("User click Cart icon")
    public void userClickCartIcon() {
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
    }


    @Then("User click remove button")
    public void userClickRemoveButton() {
        driver.findElement(By.xpath("//*[@id='remove-sauce-labs-backpack']")).click();
    }


    @When("User click Checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
    }

    @Then("User will be redirect to Your Information page")
    public void userWillBeRedirectToYourInformationPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Checkout: Your Information')]"))
        );
    }

    @When("User fill firstname and lastname and PostalCode")
    public void userFillFirstnameAndLastnameAndPostalCode() {
        driver.findElement(By.id("first-name")).sendKeys("Elsy");
        driver.findElement(By.id("last-name")).sendKeys("Berlin");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
    }

    @And("User click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.xpath("//*[@id='continue']")).click();
    }

    @Then("User will be redirect to Overview page")
    public void userWillBeRedirectToOverviewPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Checkout: Overview')]"))
        );
    }


    @When("User click Finish button")
    public void userClickFinishButton() {
        driver.findElement(By.xpath("//*[@id='finish']")).click();
    }

    @Then("User will be redirect to Complete page")
    public void userWillBeRedirectToCompletePage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Checkout: Complete!')]"))
        );
    }


}

