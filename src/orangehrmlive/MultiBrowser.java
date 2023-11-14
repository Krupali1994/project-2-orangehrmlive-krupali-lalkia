package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {

    // 1. Setup Chrome browser
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;


    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("You have entered invalid browser");
        }

        // 2. Open URL
        driver.get(baseUrl);
        driver.manage().window().maximize(); // Maximise the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); ////Implicit wait timing to driver

        // 3. Print the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        // 4. Print the current url
        System.out.println("The current URL: " + driver.getCurrentUrl());

        // 5. Print the page source
        System.out.println(driver.getPageSource());

        // 6. Click on ‘Forgot your password?’ link
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p"));
        forgotPasswordLink.click();

        // 7. Print the current url
        System.out.println(" The current URL: " + driver.getCurrentUrl());

        // 8. Navigate back to the login page
        driver.navigate().back();

        // 9. Refresh the page
        driver.navigate().refresh();

        // 10. Enter the email to email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");

        // 11. Enter the password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");

        // 12. Click on Login Button
        WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        login.click();

        // 13. Close the browser
        driver.quit();


    }


}
