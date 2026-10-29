package Pagepkg;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_page {
    
    WebDriver driver;

    // Locators using @FindBy
    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement logo;

    @FindBy(xpath = "//button[text()='Add to cart']")
    List<WebElement> cartbutton;

    @FindBy(xpath = "//div[@class='inventory_item_label']")
    List<WebElement> productdetails;

    // Constructor
    public Product_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to verify logo (Duplicate method removed)
    public WebElement logoverify() {
        return logo;
    }

    // Method to add items to cart
    public void additems() throws InterruptedException {
        for (WebElement items : cartbutton) {
            Thread.sleep(3000); 
            System.out.println(items.getText());
            items.click();
        }
    }

    // Method to get product details list
    public List<WebElement> productdtls() {
        return productdetails;
    }
}