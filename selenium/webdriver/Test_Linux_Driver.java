package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_Linux_Driver {
    WebDriver driver;

    @Test
    public void TC_01_Firefox() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/browserDrivers/geckodriver_linux");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.cssSelector("button.login_")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.cssSelector("div#modal-login-v1[style] div.modal-content")).isDisplayed());

        driver.findElement(By.cssSelector("div#modal-login-v1[style] input#account-input")).sendKeys("automation fc");
        driver.findElement(By.cssSelector("div#modal-login-v1[style] input#password-input")).sendKeys("automation fc");
        driver.findElement(By.cssSelector("div#modal-login-v1[style] button[data-text='Đăng nhập']")).click();
        Thread.sleep(1000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#modal-login-v1[style] div.error-login-panel")).getText(), "Tài khoản không tồn tại!");

        driver.findElement(By.cssSelector("div#modal-login-v1[style] button.close")).click();
        Thread.sleep(1000);

        Assert.assertFalse(driver.findElement(By.cssSelector("div#modal-login-v1[style] div.modal-content")).isDisplayed());

        driver.quit();
    }

    @Test
    public void TC_02_Chrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browserDrivers/chromedriver_linux");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.cssSelector("button.login_")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.cssSelector("div#modal-login-v1[style] div.modal-content")).isDisplayed());

        driver.findElement(By.cssSelector("div#modal-login-v1[style] input#account-input")).sendKeys("automation fc");
        driver.findElement(By.cssSelector("div#modal-login-v1[style] input#password-input")).sendKeys("automation fc");
        driver.findElement(By.cssSelector("div#modal-login-v1[style] button[data-text='Đăng nhập']")).click();
        Thread.sleep(1000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#modal-login-v1[style] div.error-login-panel")).getText(), "Tài khoản không tồn tại!");

        driver.findElement(By.cssSelector("div#modal-login-v1[style] button.close")).click();
        Thread.sleep(1000);

        Assert.assertFalse(driver.findElement(By.cssSelector("div#modal-login-v1[style] div.modal-content")).isDisplayed());

        driver.quit();
    }

    @Test
    public void TC_03_Edge() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/browserDrivers/msedgedriver_linux");

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.cssSelector("button.login_")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.cssSelector("div#modal-login-v1[style] div.modal-content")).isDisplayed());

        driver.findElement(By.cssSelector("div#modal-login-v1[style] input#account-input")).sendKeys("automation fc");
        driver.findElement(By.cssSelector("div#modal-login-v1[style] input#password-input")).sendKeys("automation fc");
        driver.findElement(By.cssSelector("div#modal-login-v1[style] button[data-text='Đăng nhập']")).click();
        Thread.sleep(1000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#modal-login-v1[style] div.error-login-panel")).getText(), "Tài khoản không tồn tại!");

        driver.findElement(By.cssSelector("div#modal-login-v1[style] button.close")).click();
        Thread.sleep(1000);

        Assert.assertFalse(driver.findElement(By.cssSelector("div#modal-login-v1[style] div.modal-content")).isDisplayed());

        driver.quit();
    }
}
