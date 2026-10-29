package Testpkg;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import Basepkg.Base_class;
import Pagepkg.Checkout_page;
import Pagepkg.Login_page;
import Pagepkg.Product_page;

public class Checkout_test extends Base_class {

    @Test
    public void iconclick() throws InterruptedException {
        // open website url
        driver.get("https://www.saucedemo.com/");

        Login_page log = new Login_page(driver);
        Product_page pdt = new Product_page(driver);
        Checkout_page checkout_page = new Checkout_page(driver);

        ExtentTest test = extent.createTest("checkout test");
        
        // login
        log.setvalue("standard_user", "secret_sauce");
        log.login_button();

        // adding product to cart
        pdt.additems();

        // 1. moving to check clicking carticon
        checkout_page.cartclick();

        // 2. continue using customer details
        checkout_page.enterCustomerDetails("Deepamol", "Deepamol", "691572");

        // 3. finish order
        checkout_page.finishOrder();

        // 4. return to home page
        checkout_page.clickBackHome();

        test.pass("Checkout Flow completed successfully");
    }
}