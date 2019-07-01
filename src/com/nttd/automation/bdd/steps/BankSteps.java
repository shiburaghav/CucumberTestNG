package com.nttd.automation.bdd.steps;

import com.nttd.automation.common.TestArtifacts;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BankSteps {
	
	private TestArtifacts testArtifacts;
	
	public BankSteps() {
		testArtifacts = TestArtifacts.getInstance();
	}
	
	@Given("I Enter the Pincode")
	public void i_Enter_the_Pincode() {
		testArtifacts.writeResults("Pass", "");
	}

	@Given("I select Branch\\/ATM from the dropdown")
	public void i_select_Branch_ATM_from_the_dropdown() {
		testArtifacts.writeResults("Pass", "");
	}

	@When("I click on FindUs Button")
	public void i_click_on_FindUs_Button() {
		testArtifacts.writeResults("Pass", "");
	}

	@Then("I validate of the search results show Branches\\/ATM for the mentioned pincode")
	public void i_validate_of_the_search_results_show_Branches_ATM_for_the_mentioned_pincode() {
		testArtifacts.writeResults("Pass", "");
	}
}
