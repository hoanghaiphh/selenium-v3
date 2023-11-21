package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Run_On_Opera {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Window")) {
            System.setProperty("webdriver.opera.driver", projectPath + "\\browserDrivers\\operadriver.exe");
        }
        driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        Thread.sleep(3000);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
