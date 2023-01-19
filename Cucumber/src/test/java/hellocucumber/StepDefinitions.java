package hellocucumber;

import Prestashop.PrestashopActuator;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;


public class StepDefinitions {

    private final String ADMIN_USERNAME = "shaked.benaharon@gmail.com";
    private final String ADMIN_PASSWORD = "sqproject3";
    private final String USER_PATH = "http://localhost:8080/";
    private final String ADMIN_PATH = "http://localhost:8080/admin-demo-appendix";
    private static PrestashopActuator prestashopUser;
    private static PrestashopActuator prestashopAdmin;

    /*
    User Scenario
     */

    public void prestashopUserInit() {
        System.out.println("--------------- INITIALIZING PRESTASHOP TEST - OPENING USER WEBPAGE ---------------");
        prestashopUser = new PrestashopActuator();
        prestashopUser.initSession(USER_PATH);
    }

    // Initialize users scenario and its first step- navigate user to the shop's home page
    @Given("User is in the shops home page")
    public void userIsInTheShopSHomePage() {
        prestashopUserInit();
    }

    // Navigate user to the item that will be reviewed later
    @When("User navigates to an items page")
    public void userNavigatesToAnItemsPage() {
        prestashopUser.navigateToItemsPage();
    }

    // User presses the 'Write Your Review' button that will allow him to review
    @And("User presses the Write Your Review button")
    public void userPressesTheWriteYourReviewButton() {
        prestashopUser.pressAddReview();
    }

    // The user enters a name and the reviews title and text
    @And("User writes a review")
    public void userWritesAReview() {
        prestashopUser.writeReview();
    }

    // The user submits the review that was written
    @And("User submits the review")
    public void userSubmitsTheReview() {
        prestashopUser.submitReview();
    }

    // Checks if the 'Review Sent' message appears
    @Then("User successfully reviewed")
    public void userSuccessfullyReviewed() {
        Assertions.assertTrue(prestashopUser.checkSuccessfullyReviewed());
    }

    // Checks if the 'Your review cannot be sent' message appears
    @Then("User did not successfully reviewed")
    public void userDidNotSuccessfullyReviewed() {
        Assertions.assertTrue(prestashopUser.checkNotSuccessfullyReviewed());
    }

    /*
    Admin Scenario
     */

    public void prestashopAdminInit() {
        System.out.println("--------------- INITIALIZING PRESTASHOP TEST - OPENING ADMIN WEBPAGE ---------------");
        prestashopAdmin = new PrestashopActuator();
        prestashopAdmin.initSession(ADMIN_PATH);
    }

    // Initialize admins scenario and its first step- log in
    @Given("Admin logs in")
    public void adminLogsIn() {
        prestashopAdminInit();
        prestashopAdmin.logIn(ADMIN_USERNAME, ADMIN_PASSWORD);
    }

    // Navigate admin to the commenting module, where the commenting module can be found
    @When("Admin navigates to the commenting module")
    public void adminNavigatesToTheCommentingModule() {
        prestashopAdmin.navigatesToCommentingModule();
    }

    // Commenting module is searched and found, then modified to disable guests comments
    @And("Admin turns guest commenting off")
    public void adminTurnsGuestCommentingOff() {
        prestashopAdmin.turnGuestCommentingOff();
    }

    // Checks if the 'Settings updated' message appears
    @Then("Admin successfully turned commenting off")
    public void adminSuccessfullyTurnedCommentingOff() {
        Assertions.assertTrue(prestashopAdmin.checkSuccessfullyTurnedOff());
    }
}