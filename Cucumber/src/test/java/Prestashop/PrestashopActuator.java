package Prestashop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PrestashopActuator {
    private WebDriver driver;
    private WebDriverWait driverWait;

    public void initSession(String path){
        WebDriverManager.chromedriver().setup();
        // new chrome driver object
        this.driver = new ChromeDriver();
        this.driverWait = new WebDriverWait(driver, 10);

        // launch website -> localhost
        driver.get(path);

        // maximize the window - some web apps look different in different sizes
        driver.manage().window().maximize();

        System.out.println("Driver setup finished for - " + driver.getTitle());
    }

    public void navigateToItemsPage() {
        driver.findElement(By.xpath("//*[@id='content']/section[1]/div/div[1]/article/div/div[2]/h3/a")).click();
    }

    public void pressAddReview() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-or-refresh']/div[3]/div[2]/div[2]/a[2]")).click();

    }

    public void writeReview() {
        driverWait.until(ExpectedConditions.elementToBeClickable(By.name("comment_title"))).click();
        driver.findElement(By.name("comment_title")).sendKeys("Favorite clothes, sir!");
        driverWait.until(ExpectedConditions.elementToBeClickable(By.name("customer_name"))).click();
        driver.findElement(By.name("customer_name")).sendKeys("Dobby");
        driverWait.until(ExpectedConditions.elementToBeClickable(By.name("comment_content"))).click();
        driver.findElement(By.name("comment_content")).sendKeys("Master Has Presented Dobby With Clothes! Dobby Is Free!");
    }

    public void submitReview() {
        driver.findElement(By.xpath("//*[@id='post-product-comment-form']/div[6]/div[2]/button[2]")).click();
    }

    public boolean checkSuccessfullyReviewed(){
        try {
            driver.findElement(By.xpath("//*[@id='product-comment-posted-modal-message']"));
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean checkNotSuccessfullyReviewed(){
        try {
            driver.findElement(By.xpath("//*[contains(text(),'Your review cannot be sent')]"));
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public void logIn(String username, String password) {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("submit_login")).click();
    }

    public void navigatesToCommentingModule() {
        driverWait.until(ExpectedConditions.elementToBeClickable(By.id("subtab-AdminParentModulesSf"))).click();
        driver.findElement(By.id("subtab-AdminParentModulesSf")).click();
        driverWait.until(ExpectedConditions.elementToBeClickable(By.id("subtab-AdminModulesSf"))).click();
        driver.findElement(By.id("subtab-AdminModulesSf")).click();
//        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='subtab-AdminModulesSf']/a"))).click();
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='search-input-group']/div[1]/div[2]/input"))).click();
        driver.findElement(By.xpath("//*[@id='search-input-group']/div[1]/div[2]/input")).sendKeys("comment");
        //*[@id="search-input-group"]/div[1]/div[2]/input
        driverWait.until(ExpectedConditions.elementToBeClickable(By.id("module-search-button"))).click();
        driver.findElement(By.id("module-search-button")).click();
    }

    public void turnGuestCommentingOff(){
        driver.findElement(By.xpath("//*[@id='modules-list-container-theme_modules']/div/div/div/div[2]/div[4]/div[2]/a")).click();
        driver.findElement(By.id("PRODUCT_COMMENTS_ALLOW_GUESTS_off")).click();
        driver.findElement(By.id("productcomments_form_submit_btn")).click();
    }

    public boolean checkSuccessfullyTurnedOff(){
        try {
            driver.findElement(By.xpath("//*[contains(text(),'Settings updated')]"));
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
}
