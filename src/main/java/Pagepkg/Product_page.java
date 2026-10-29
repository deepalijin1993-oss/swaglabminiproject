package Pagepkg;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Product_page {

    WebDriver driver;

    // Locators using @FindBy
    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement logo;

    @FindBy(xpath = "//button[text()='Add to cart']")
    List<WebElement> cartbutton;

    @FindBy(xpath = "//div[@class='inventory_item_label']")
    List<WebElement> productdetails;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement dropdown;

    // Constructor
    public Product_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to verify logo
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

    // Method to select Z to A from dropdown 
    public void selectZtoA() {
        Select sel = new Select(dropdown);
        sel.selectByValue("za");  
    }

    // Method to get product details list
    public List<WebElement> productdtls() {
        return productdetails;
    }
}