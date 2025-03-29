package Login_Orage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000); // Nghỉ 2 giây để xem kết quả
        if (driver != null) {
            driver.quit(); // Đóng trình duyệt sau mỗi test
        }
    }
}

