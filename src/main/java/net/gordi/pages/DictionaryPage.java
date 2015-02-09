package net.gordi.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import javax.print.attribute.standard.Destination;

public class DictionaryPage extends PageObject {

    public String get_logo_text(){
        String logoText = null;
        try {
            logoText = find(By.xpath("//div[@id='hplogo']/div")).getText();
            return logoText;
        } catch (org.openqa.selenium.NoSuchElementException e){
            throw e;
        }
    }
    
    public String get_text_of_search_result(){
        String text = null;
        try {
            waitABit(3000);
            text = find(By.id("resultStats")).getText();
            return text;
        } catch (org.openqa.selenium.NoSuchElementException e){
            throw e;
        }
    }
    
    public WebElementFacade find_button_by_title(String buttonTitle){
        try {
            WebElementFacade button = find(By.xpath("//button[@aria-label = '"+buttonTitle+"']"));
            return button;
        } catch (org.openqa.selenium.NoSuchElementException e){
            throw e;
        }
    }
    public void type_search_request(String textOfRequest){
        try {
            WebElementFacade requestLine = find(By.xpath("//input [@name='q']"));
            requestLine.type(textOfRequest);
        } catch (org.openqa.selenium.NoSuchElementException e){
            throw e;
        }
    }
    
    
}