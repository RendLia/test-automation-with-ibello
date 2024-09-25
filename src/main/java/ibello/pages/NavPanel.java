package ibello.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Navigation panel")
public class NavPanel extends PageObject {

    @Find(by = By.CSS_SELECTOR, using = "a[href='#']")
    private WebElement demoLink;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#/cases']")
    private WebElement casesLink;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#/new-case']")
    private WebElement newCaseLink;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#/user']")
    private WebElement userLink;

    /*
    @Find(by = By.CSS_SELECTOR, using = "${0}")//a[href='#${0}']
    private WebElement link;

    public void click_on_user_name2() {
        doWith(link.applyParameters("a[href='#/user']")).click();
    } másik megoldás
    */

    public void click_on_user_name() {
        doWith(userLink).click();
    }



}
