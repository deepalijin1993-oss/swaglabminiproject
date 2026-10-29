package Pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout_page {

WebDriver driver;
    
    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    WebElement carticon;
    
    @FindBy(id = "checkout")
    WebElement checkout;
    
    public Checkout_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    
    }
    
 // Method to click the cart link directly and go to checkout page
    public void cartclick() {
        try {
            Thread.sleep(2000); // Wait for products to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Directly click the cart link (<a> tag) to ensure page navigation works
        WebElement cartLink = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartLink.click();

        // Wait until the checkout button is visible on the cart page and click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        checkoutBtn.click();
     }
        @FindBy(id = "first-name")
        WebElement firstname;

        @FindBy(id = "last-name")
        WebElement lastname;

        @FindBy(id = "postal-code")
        WebElement postalcode;

        @FindBy(id = "continue")
        WebElement continuebtn;

        @FindBy(id = "finish")
        WebElement finishbtn;

        @FindBy(id = "react-burger-menu-btn")
        WebElement hamburgermenu;

        @FindBy(id = "logout_sidebar_link")
        WebElement logoutbtn;

        // Method to enter First Name, Last Name, and Postal Code and click Continue
        public void enterCustomerDetails(String fName, String lName, String pCode) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(firstname));

            firstname.sendKeys(fName);
            lastname.sendKeys(lName);
            postalcode.sendKeys(pCode);
            
            continuebtn.click();
        }

        // Method to finish the order
        public void finishOrder() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(finishbtn));
            finishbtn.click();
        }
     // Method to click hamburger menu and logout
        public void logoutProcess() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            //  click hampberg menu
            WebElement menuBtn = wait.until(ExpectedConditions.elementToBeClickable(hamburgermenu));
            menuBtn.click();
            Thread.sleep(2000); 
            
            //  click logout button
            WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(logoutbtn));
            logoutLink.click();
        }
        
        }
    
    


