package net.gordi;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.gordi.requirements.Application;
import net.gordi.steps.EndUserSteps;

@Story(Application.Search.EnterSearchRequest.class)
@RunWith(ThucydidesRunner.class)

public class EnterSearchRequestTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://www.google.com.ua/")
    public Pages pages;

    @Steps
    public EndUserSteps user;

    @Test
    public void search_request(){
        user.go_to_main_page();
        user.logo_should_contains_text("Украина");
        user.button_should_be_present("Поиск в Google");
        user.type_search_request("request");
        user.click_button_by_title("Поиск в Google");
        user.text_should_appear("Результатов: примерно");
    }
}
