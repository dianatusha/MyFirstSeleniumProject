import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void initializeDriver(){

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void validRegisterTest(){
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountButton=driver.findElement(By.cssSelector(".skip-link.skip-account"));
        accountButton.click();
        WebElement registerButton=driver.findElement(By.cssSelector("[title=Register]"));
        registerButton.click();
        WebElement firstNameField=driver.findElement(By.cssSelector("#firstname"));
        String firstNameRandom = RandomStringUtils.randomAlphabetic(7);
        firstNameField.sendKeys(firstNameRandom);
        WebElement middleNameField=driver.findElement(By.cssSelector("#middlename"));
        String middleNameRandom = RandomStringUtils.randomAlphabetic(6);
        middleNameField.sendKeys(middleNameRandom);
        WebElement lastNameField = driver.findElement(By.cssSelector("#lastname"));
        String lastNameRandom = RandomStringUtils.randomAlphabetic(5);
        lastNameField.sendKeys(lastNameRandom);
        WebElement emailAddressField = driver.findElement(By.cssSelector("#email_address"));
        String emailAddressRandom = RandomStringUtils.randomAlphanumeric(7)+ "@fastTrackIT.com";
        emailAddressField.sendKeys(emailAddressRandom);
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        String passawordRandom = RandomStringUtils.randomAlphanumeric(8);
        passwordField.sendKeys(passawordRandom);
        WebElement confirmPasswordField = driver.findElement(By.cssSelector("#confirmation"));
        confirmPasswordField.sendKeys(passawordRandom);
        WebElement registerValidationButton = driver.findElement(By.cssSelector("[title='Register'].button"));
        registerValidationButton.click();

        WebElement welcomeMessageElement = driver.findElement(By.cssSelector("li span"));
        Assert.assertEquals(welcomeMessageElement.getText(), "Thank you for registering with Madison Island." );

    }
    @After
    public void closeDriver(){
        driver.quit();
    }



}
