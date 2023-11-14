package orangehrlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-2 - ProjectName : com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */
public class Project_02_OrangeHr {
// multi browser
    static String browser = "Edge";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        // formula declaration for multi browser

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid Browser name");
        }

        //2 open url
        driver.get(baseUrl);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3 print the title of the page
        System.out.println("Page Title : " + driver.getTitle());

        //4 print the current url
        System.out.println("Current Url : " + driver.getCurrentUrl());

        //5 print source
        System.out.println("Page Source : \n" + driver.getPageSource());

        //6 click on forgot your password link
        driver.findElement(By.className("orangehrm-login-forgot-header")).click();

        // 7 print the current url
        System.out.println("Current Url : " + driver.getCurrentUrl());

        //8 navigate back to the login page
        driver.navigate().back();

        //9 page refresh
        driver.navigate().refresh();

        //10 email to enter
        driver.findElement(By.name("username")).sendKeys("Admin");

        //11 password to enter
        driver.findElement(By.name("password")).sendKeys("admin123");

        //12 click on login button
        WebElement loginLink = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginLink.click();

        // 13 browser close
        driver.quit();
    }
}