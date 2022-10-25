package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent{

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Laptops']")
    private WebElement Laptops;

    @FindBy(xpath = "//*[text()='Sony vaio i5']")
    public WebElement sonyIfive;

    @FindBy(xpath = "//*[text()='Add to cart']")
    public WebElement addToCart;

    @FindBy(xpath = "//a[contains(text(),'Dell i7 8gb')]")
    public WebElement DellIseven;

    @FindBy(xpath = "//*[text()='Cart']")
    public WebElement linkCart;

    @FindBy(xpath = "//tr[1]/td[4]/a")
    public WebElement deleteIseven;

    @FindBy(xpath = "//*[text()='Place Order']")
    public WebElement PlaceOrder;

    @FindBy(css = "[id='name']")
    public WebElement name;

    @FindBy(css = "[id='country']")
    public WebElement country;

    @FindBy(css = "[id='city']")
    public WebElement city;

    @FindBy(css = "[id='card']")
    public WebElement card;

    @FindBy(css = "[id='month']")
    public WebElement month;

    @FindBy(css = "[id='year']")
    public WebElement year;

    @FindBy(xpath = "//button[text()='Purchase']")
    public WebElement Purchase;

    @FindBy(css = "[id='totalp']")
    public WebElement totalText;

    @FindBy(xpath = "//*[contains(@class,'lead text-muted ')]")
    public WebElement productInfo;

    @FindBy(xpath = "//*[text()='OK']")
    public WebElement OKbtn;


    WebElement myElement;

    public void findAndClick(String strElement){

        switch (strElement){

            case "Laptops" : myElement = Laptops;break;
            case "sonyIfive" : myElement = sonyIfive;break;
            case "addToCart" : myElement = addToCart;break;
            case "DellIseven" : myElement = DellIseven;break;
            case "linkCart" : myElement = linkCart;break;
            case "deleteIseven" : myElement = deleteIseven;break;
            case "PlaceOrder" : myElement = PlaceOrder;break;
            case "Purchase" : myElement = Purchase;break;
            case "OKbtn" : myElement = OKbtn;break;


        }
        clickFunction(myElement);


}
    public void findAndSend(String strElement, String value){

        switch (strElement){

           case "name" : myElement = name;break;
           case "country" : myElement = country;break;
           case "city" : myElement = city;break;
           case "card" : myElement = card;break;
           case "month" : myElement = month;break;
           case "year" : myElement = year;break;

        }
        sendKeysFunction(myElement,value);
    }

    public void findAndContainsText(String strElement, String text) {

        switch (strElement) {

           case "totalText": myElement = totalText;
           case "productInfo": myElement = productInfo;

        }
        verifyContainsText(myElement, text);
    }
}