package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_Opera_Browser {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Window")) {
            System.setProperty("webdriver.opera.driver", projectPath + "\\browserDrivers\\operadriver.exe");
        } else if (osName.contains("Linux")) {
            System.setProperty("webdriver.opera.driver", projectPath + "/browserDrivers/operadriver_linux");
        } else if (osName.contains("Mac")) {
            System.setProperty("webdriver.opera.driver", projectPath + "/browserDrivers/operadriver_mac");
        }
        driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01() throws InterruptedException {
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
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
