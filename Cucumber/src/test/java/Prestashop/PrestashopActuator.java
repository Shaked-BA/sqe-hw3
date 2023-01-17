package Prestashop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrestashopActuator {
    private WebDriver driver;
    private WebDriverWait driverWait;

    public void initSession(String path){
        WebDriverManager.chromedriver().setup();
        // new chrome driver object
        this.driver = new ChromeDriver();
        this.driverWait = new WebDriverWait(driver, 60);

        // launch website -> localhost
        driver.get(path);

        // maximize the window - some web apps look different in different sizes
        driver.manage().window().maximize();

        System.out.println("Driver setup finished for - " + driver.getTitle());
    }

    public void navigateToItemsPage() {

    }

    public void pressAddReview() {

    }

    public void submitReview() {

    }

    public void checkSuccessfullyReviewed(){

    }

    public void logIn(String username, String password) {

    }

    public void mavigatesToCommentingModule() {

    }

    public void turnGuestCommentingOff(){
    }

    public void checkSuccessfullyTurnedOff(){

    }
}
