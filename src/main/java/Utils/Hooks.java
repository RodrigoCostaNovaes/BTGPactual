package Utils;

import Pages.BasePage;
import com.itextpdf.text.DocumentException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class Hooks extends BasePage {


    public WebDriver setUp() throws DocumentException, FileNotFoundException {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        ChromeOptions op = new ChromeOptions();
        op.addArguments("disable-infobars");
        op.addArguments("--headless");
        driver = new ChromeDriver(op);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com.br");
        return driver;
    }

    public void tearDown() {
        driver.quit();
    }
}
