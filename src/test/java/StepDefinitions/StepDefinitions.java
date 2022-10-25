package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import Utilities.GWDBasic;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.Duration;

public class StepDefinitions {

    DialogContent dc = new DialogContent();
    Actions actions = new Actions(GWD.getDriver());

    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));

    @Given("Customer navigation through product categories: Phones, Laptops and Monitors")
    public void customerNavigationThroughProductCategoriesPhonesLaptopsAndMonitors() {

        GWD.getDriver().get("https://www.demoblaze.com/index.html ");
        GWD.getDriver().manage().window().maximize();


    }

    @When("Navigate to -Laptop- → -Sony vaio iFive- and click on -Add to cart-. Accept pop up confirmation.")
    public void navigateToLaptopSonyVaioIFiveAndClickOnAddToCartAcceptPopUpConfirmation() {

        dc.findAndClick("Laptops");
        dc.findAndClick("sonyIfive");
        dc.findAndClick("addToCart");
        actions.keyDown(Keys.ENTER).build().perform();
        actions.keyUp(Keys.ENTER).build().perform();

    }

    @And("Navigate to -Laptop- → -Dell iFive eightgb- and click on -Add to cart-. Accept pop up confirmation.")
    public void navigateToLaptopDellIFiveGbAndClickOnAddToCartAcceptPopUpConfirmation() {


        GWD.getDriver().navigate().back();
        GWD.getDriver().navigate().back();

        dc.findAndClick("DellIseven");
        dc.findAndClick("addToCart");

    }

    @And("Navigate to -Cart- → Delete -Dell iSeven eightgb- from cart.")
    public void navigateToCartDeleteDellISevenGbFromCart() {

        GWD.Bekle(1);

        try {
            actions.keyDown(Keys.ENTER).build().perform();
            actions.keyUp(Keys.ENTER).build().perform();
        }catch (Exception e){

        }

        dc.findAndClick("linkCart");

        dc.findAndClick("deleteIseven");

        GWD.Bekle(4);
    }

    @And("Click on -Place order- and Fill in all web form fields.")
    public void clickOnPlaceOrderAndFillInAllWebFormFields() {



        dc.findAndClick("PlaceOrder");

        dc.findAndSend("name","Jo");
        dc.findAndSend("country","PapuaNewGinea");
        dc.findAndSend("city","muş");
        dc.findAndSend("card","600070005000");
        dc.findAndSend("month","02");
        dc.findAndSend("year","2022");
        dc.findAndClick("Purchase");

    }

    @And("Click on -Purchase- and Capture and log purchase Id and Amount.")
    public void clickOnPurchaseAndCaptureAndLogPurchaseIdAndAmount() {

        GWD.Bekle(5);

        WebElement productInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'lead text-muted ')]")));
        System.out.println("price.getText() = " + productInfo.getText());

        try{

            File dosya = new File("C:\\Users\\ASUS\\Desktop\\productInfo.txt");
            FileWriter yazici = new FileWriter(dosya,true);
            BufferedWriter yaz = new BufferedWriter(yazici);
            yaz.write("productInfo  :  " + productInfo.getText());
            yaz.close();
            System.out.println("Successfully");
        }
        catch (Exception hata){
            hata.printStackTrace();
        }
    }

    @And("Assert purchase amount equals expected")
    public void assertPurchaseAmountEqualsExpected() {

        dc.findAndContainsText("productInfo",dc.totalText.getText());
    }

    @Then("Click on -Ok-")
    public void clickOnOk() {

        dc.findAndClick("OKbtn");
    }
}
