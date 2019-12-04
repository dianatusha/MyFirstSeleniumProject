import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {
    private WebDriver driver;

    @Before
    public void initializeDriver() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void validSearchTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("[placeholder]")).sendKeys("jewelry");
        WebElement searchButton = driver.findElement(By.cssSelector(".search-button"));
        searchButton.click();

        WebElement searchResultMessageElement = driver.findElement(By.cssSelector("h1"));
        Assert.assertEquals(searchResultMessageElement.getText(),"SEARCH RESULTS FOR 'JEWELRY'");
    }
     @After
    public void closeDriver(){
        driver.quit();
     }


        }









