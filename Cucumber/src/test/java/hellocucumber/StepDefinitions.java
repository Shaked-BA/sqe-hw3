package hellocucumber;

import Prestashop.PrestashopActuator;
import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {

//    // $$TODO explain what this step does$$
//    @Given("an example scenario")
//    public void anExampleScenario() {
//    }
//
//    // $$TODO explain what this step does$$
//    @When("all step definitions are implemented")
//    public void allStepDefinitionsAreImplemented() {
//    }
//
//    // $$TODO explain what this step does$$
//    @Then("the scenario passes")
//    public void theScenarioPasses() {
//    }

    private final String ADMIN_USERNAME = "Shop";
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

    @Given("User is in the shops home page")
    public void userIsInTheShopSHomePage() {
        prestashopInit(USER_PATH);
    }

    @When("User navigates to an items page")
    public void userNavigatesToAnItemsPage() {
        prestashop.navigateToItemsPage();
    }

    @And("User presses the Add Review button")
    public void userPressesTheAddReviewButton() {
        prestashop.pressAddReview();
    }

    @And("User submits the review")
    public void userSubmitsTheReview() {
        prestashop.submitReview();
    }

    @Then("User successfully reviewed")
    public void userSuccessfullyReviewed() {
        prestashop.checkSuccessfullyReviewed();
    }

    /*
    User Scenario
     */

    @Given("Admin logs in")
    public void adminLogsIn() {
        prestashopInit(ADMIN_PATH);
        prestashop.logIn(ADMIN_USERNAME, ADMIN_PASSWORD);
    }

    @When("Admin navigates to the commenting module")
    public void adminNavigatesToTheCommentingModule() {
        prestashop.mavigatesToCommentingModule();
    }

    @And("Admin turns guest commenting off")
    public void adminTurnsGuestCommentingOff() {
        prestashop.turnGuestCommentingOff();
    }

    @Then("Admin successfully turned commenting off")
    public void adminSuccessfullyTurnedCommentingOff() {
        prestashop.checkSuccessfullyTurnedOff();
    }
}