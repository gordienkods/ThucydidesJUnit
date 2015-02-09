package net.gordi.steps;

import net.gordi.pages.DictionaryPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {

    DictionaryPage dictionaryPage;

    @Step
    public void go_to_main_page() {
        dictionaryPage.open();
    }
    
    @Step
    public void logo_should_contains_text (String textOnPage){
        String actualResult = null, expectedResult = textOnPage;
        actualResult = dictionaryPage.get_logo_text();
        Assert.assertEquals("Expected text under the logo 'Google' doesn't match actual text",expectedResult,actualResult);
    }
    
    @Step
    public void button_should_be_present(String buttonTitle){
        dictionaryPage.find_button_by_title(buttonTitle);
    }
    
    @Step
    public void type_search_request(String textOfRequest){
        dictionaryPage.type_search_request(textOfRequest);
    }
    
    @Step
    public void click_button_by_title(String buttonTitle){
        dictionaryPage.find_button_by_title(buttonTitle).click();
    }
    
    @Step
    public void text_should_appear(String necessaryText){
        Boolean actualResult = true, expectedResult = false;
        expectedResult = dictionaryPage.get_text_of_search_result().contains(necessaryText);
        Assert.assertEquals("Expected text didn't appear", actualResult, expectedResult);
    }
}