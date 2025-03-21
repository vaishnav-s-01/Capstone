package com.ecom.StepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;
import com.ecom.main.ContactUsPage;

public class ContactUsSteps {

    ContactUsPage contactUsPage = new ContactUsPage();

    @Given("User navigates to the Contact Us page")
    public void user_navigates_to_the_contact_us_page() {
        contactUsPage.navigateToContactUsPage();
    }

    @When("User enters valid details and submits the form")
    public void user_enters_valid_details_and_submits_the_form() {
        contactUsPage.fillContactForm("Vaishnav", "Vaishnav@gmail.com", "Feedback", "This is a test message.");
        contactUsPage.submitForm();
    }

    @Then("Success message {string} should be displayed")
    public void success_message_should_be_displayed(String message) {
        Assert.assertTrue(contactUsPage.verifySuccessMessage(), "Success message not displayed!");
    }

    @When("User submits the form without filling the email field")
    public void user_submits_the_form_without_filling_the_email_field() {
        contactUsPage.fillContactForm("Vaishnav", "", "Feedback", "This is a test message.");
        contactUsPage.submitForm();
    }

    @Then("Error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMessage) {
        String actualMessage = contactUsPage.verifyEmailErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch!");
    }
    
    @Then("Error message {string} should be displayed for {string}")
    public void error_message_should_be_displayed_for(String expectedMessage, String string2) {
    	  String actualMessage = contactUsPage.verifyEmailErrorMessage();
          Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch!");
    }
}
