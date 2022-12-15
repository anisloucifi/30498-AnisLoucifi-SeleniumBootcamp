import base.BasePage;
import org.apache.batik.apps.svgbrowser.JSVGViewerFrame;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(){
        PageFactory.initElements(driver,this);
    }


@FindBy(xpath = "//h3[@class='item-title text-truncate-multiline black-link lines-2']")
public List<WebElement> itemsInCart;


@FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
public WebElement removeButton;


@FindBy(id = "page-alerts")
public WebElement itemRemovedAlert;


@FindBy(id = "dropdown-1818638927-f43bae94-0b1d-4455-9a3e-7ee012999165")
public WebElement selectQuantity;








//method region


public int getNumberItemInCart() {
        return itemsInCart.size();
        }


public void clickOnRemoveButton() {
        safeClickOnElement(removeButton);
        }


public boolean isAlertVisible() {
        return isElementVisible(itemRemovedAlert);
        }


public void setSelectQuantity(String quantity) {
        selectFromDropdownByVisibleText(selectQuantity, quantity);
        }




        }



