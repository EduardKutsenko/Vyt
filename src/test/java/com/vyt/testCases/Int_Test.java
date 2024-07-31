package com.vyt.testCases;

import com.vyt.pageObjects.*;
import com.vyt.pageObjects.goals.Goals_Page;
import com.vyt.pageObjects.PlanningEssentials_Page;
import com.vyt.pageObjects.goals.Pre_RetirementGoals_Page;
import com.vyt.pageObjects.income.Employment_Page;
import com.vyt.pageObjects.income.Income_Page;
import com.vyt.pageObjects.insurance.Insurance_Page;
import com.vyt.pageObjects.insurance.TermLife_Page;
import com.vyt.testData.TestData;
import com.vyt.utilities.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Int_Test extends BaseClass {
    Clients_Page clients_page;
    Login_Page login_page;
    NewClient_Page nc_page;
    Dashboard_Page dsb_page;
    PlanningEssentials_Page pe_page;
    Goals_Page goals_page;
    Pre_RetirementGoals_Page pre_retirementGoals_page;
    Income_Page income_page;
    Employment_Page employment_page;

    Insurance_Page insurance_page;
    TermLife_Page termLife_page;


@BeforeClass
    public void initPages(){
        clients_page = new Clients_Page(driver);
        login_page = new Login_Page(driver);
        nc_page = new NewClient_Page(driver);
        dsb_page = new Dashboard_Page(driver);
        pe_page = new PlanningEssentials_Page(driver);
        goals_page = new Goals_Page(driver);
        pre_retirementGoals_page = new Pre_RetirementGoals_Page(driver);
        income_page= new Income_Page(driver);
        employment_page = new Employment_Page(driver);
        insurance_page = new Insurance_Page(driver);
        termLife_page = new TermLife_Page(driver);
    }


    @Test
    public void loginWithValidCredential(){
        login_page.loginWithUserNameAndPassword("voyant-exercise", "password100");
        assertEqual(clients_page.getPageTitle(), "Clients");

        clients_page.closeReleaseNotes();
        clients_page.clickAddButton();
        nc_page.fillInForm(TestData.getNewRandomTestName(), TestData.getNewRandomTestLastName(), "2000", "08",
                "09", "No", "65" );
        dsb_page.clickAddButton();
        pe_page.clickGoalsButton();
        goals_page.clickGoalsButton();
        pre_retirementGoals_page.setAmount("10000");
        pre_retirementGoals_page.clickDoneButton();
        dsb_page.clickAddButton();
        pe_page.clickIncomeButton();
        income_page.clickEmploymentButton();
        employment_page.setEmploymentName("Test_Employment");
        employment_page.setSalary("5000");
        employment_page.clickDoneButton();
        dsb_page.clickAddButton();
        pe_page.clickInsuranceButton();
        insurance_page.clickTermLifeButton();
        termLife_page.setForm("test_policy", "Test_Employment");

        assertTrue(dsb_page.isListContainsValue("Goals"));
        assertTrue(dsb_page.isListContainsValue("Income"));
        assertTrue(dsb_page.isListContainsValue("Insurance"));
    }



}
