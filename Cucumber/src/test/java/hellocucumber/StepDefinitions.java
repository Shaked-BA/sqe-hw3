package hellocucumber;

import Prestashop.PrestashopActuator;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {

    private final String ADMIN_USERNAME = "shaked.benaharon@gmail.com";
    private final String ADMIN_PASSWORD = "sqproject3";
    private final String USER_PATH = "http://localhost:8080/";
    private final String ADMIN_PATH = "http://localhost:8080/admin-demo-appendix";
    private static List<PrestashopActuator> allPrestashops;
    private static PrestashopActuator prestashop;

    /*
    User Scenario
     */

    public void prestashopInit(String path) {
        System.out.println("--------------- INITIALIZING PRESTASHOP TEST - OPENING WEBPAGE ---------------");
        if(allPrestashops == null){
            allPrestashops = new ArrayList<>();
        }
        prestashop = new PrestashopActuator();
        allPrestashops.add(prestashop);
        prestashop.initSession(path);
    }

    // Initialize users scenario and its first step- navigate user to the shop's home page
    @Given("User is in the shops home page")
    public void userIsInTheShopSHomePage() {
        prestashopInit(USER_PATH);
    }

    // Navigate user to the item that will be reviewed later
    @When("User navigates to an items page")
    public void userNavigatesToAnItemsPage() {
        prestashop.navigateToItemsPage();
    }

    // User presses the 'Write Your Review' button that will allow him to review
    @And("User presses the Write Your Review button")
    public void userPressesTheWriteYourReviewButton() {
        prestashop.pressAddReview();
    }

    // The user enters a name and the reviews title and text
    @And("User writes a review")
    public void userWritesAReview() {
        prestashop.writeReview();
    }

    // The user submits the review that was written
    @And("User submits the review")
    public void userSubmitsTheReview() {
        prestashop.submitReview();
    }

    // Checks if the 'Review Sent' message appears
    @Then("User successfully reviewed")
    public void userSuccessfullyReviewed() {
        Assertions.assertTrue(prestashop.checkSuccessfullyReviewed());
    }

    /*
    User Scenario
     */

    // Initialize admins scenario and its first step- log in
    @Given("Admin logs in")
    public void adminLogsIn() {
        prestashopInit(ADMIN_PATH);
        prestashop.logIn(ADMIN_USERNAME, ADMIN_PASSWORD);
    }

    // Navigate admin to the commenting module, where the commenting module can be found
    @When("Admin navigates to the commenting module")
    public void adminNavigatesToTheCommentingModule() {
        prestashop.navigatesToCommentingModule();
    }

    // Commenting module is searched and found, then modified to disable guests comments
    @And("Admin turns guest commenting off")
    public void adminTurnsGuestCommentingOff() {
        prestashop.turnGuestCommentingOff();
    }

    // Checks if the 'Settings updated' message appears
    @Then("Admin successfully turned commenting off")
    public void adminSuccessfullyTurnedCommentingOff() {
        Assertions.assertTrue(prestashop.checkSuccessfullyTurnedOff());
    }

    // Checks if the 'Your review cannot be sent' message appears
    @Then("User did not successfully reviewed")
    public void userDidNotSuccessfullyReviewed() {
        Assertions.assertTrue(prestashop.checkNotSuccessfullyReviewed());
    }
}