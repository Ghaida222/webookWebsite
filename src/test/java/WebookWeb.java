import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class WebookWeb {
    private static WebDriver driver;
    private static WebDriverWait wait;
    public static boolean isEmailUniuqe;
    public static void main(String[] args) {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahaf\\IdeaProjects\\webookweb\\Drivers\\chromedriver.exe");

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // Initialize WebDriver and WebDriverWait
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            navigate();
            isEmailUniuqe=createAccount();

            while (!isEmailUniuqe){
                isEmailUniuqe=retryEmail();
            }
            search();
            filter();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Wait for a specific duration before quitting the driver
            try {
                Thread.sleep(10000); // Wait for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit(); // Close the browser
        }
    }

    private static void navigate() {
        driver.get("https://webook.com/en");
        // Accept Cookie
        driver.findElement(By.xpath("//*[@id=\"cookie_consent\"]/div/button[1]")).click();
    }

    private static boolean createAccount() {
        try {
            // Click on the "login / sign up" button
            driver.findElement(By.xpath("//*[@id=\"root\"]/header/nav/ul/li[4]/a/p")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/section/div/div[2]/div/div[2]/form/div[5]/button")));

            // Click on "create an account" button
            driver.findElement(By.xpath("/html/body/div[1]/main/section/div/div[2]/div/div[2]/form/div[5]/button")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"first_name\"]")));

            // Generate a unique email using a random integer
            Random random = new Random();
            int randomNumber = random.nextInt(1000);
            String uniqueEmail = "testuser" + randomNumber + "@gmail.com";

            // Fill in the registration form

            String firstName="Ghaida";
            String lastName="Bin Muharib";
            String mobileNumber="580616216";
            String password="Password123!";
            driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys(firstName);
            driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys(lastName);
            driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(uniqueEmail);
            driver.findElement(By.xpath("//*[@id=\"confirm_email\"]")).sendKeys(uniqueEmail);
            driver.findElement(By.xpath("//*[@id=\"signup-form-info\"]/fieldset[4]/div/div[2]/div/div/input")).sendKeys(mobileNumber);
            driver.findElement(By.xpath("/html/body/div[1]/main/section/div/div[2]/div/div/div/div[2]/form/fieldset[3]/div[1]/div/input")).sendKeys(password);
            driver.findElement(By.xpath("//*[@id=\"signup-wrapper\"]/div[3]/div[1]/label/input")).click();
            driver.findElement(By.xpath("//*[@id=\"signup-wrapper\"]/div[3]/div[3]/button/span")).click();

            // Wait for the new page to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/section[1]/form/div/div/input")));

            return true; // page is loaded
        } catch (Exception e) {
            e.printStackTrace();
            return false; // An error occurred or page did not load
        }
    }

    private static boolean retryEmail() {
        try {
            Random random = new Random();
            int randomNumber = random.nextInt(1000);
            String uniqueEmail = "testuser" + randomNumber + "@gmail.com";

            // Clear and set the email fields
            driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(uniqueEmail);
            driver.findElement(By.xpath("//*[@id=\"confirm_email\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"confirm_email\"]")).sendKeys(uniqueEmail);
            // Click the submit button
            driver.findElement(By.xpath("//*[@id=\"signup-wrapper\"]/div[3]/div[4]/button")).click();

            // Wait for the new page to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/section[1]/form/div/div/input")));
            return true; // page is loaded
        } catch (Exception e) {
            e.printStackTrace();
            return false; // An error occurred or page is not loaded
        }
    }

    private static void search() {
        // Wait for confirmation before search
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/section[1]/form/div/div/input")));
        // Step 3: Search
        driver.findElement(By.xpath("//*[@id=\"main\"]/section[1]/form/div/div/input")).sendKeys("Game");
        driver.findElement(By.xpath("//*[@id=\"main\"]/section[1]/form/button/img")).click();

        // Wait for confirmation before filtering
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/aside/div/div[2]/div[1]/div/button[2]/span")));
    }

    private static void filter() {
        // Step 4: Filtering
        //select date
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/aside/div/div[2]/div[1]/div/button[2]/span")).click();
        //select category
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/aside/div/div[2]/div[3]/ul/li[4]/div/div/label/p")).click();
        //select Arya
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/aside/div/div[2]/div[4]/ul/li[1]/div/div/label/input")).click();
    }
}