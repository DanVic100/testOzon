package step;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import page.CartPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartStep {

    CartPage cartPage = new CartPage();


   @Step("Проверка продуктов в корзине")
    public boolean booleanProductCart()
    {
        //товары в корзине
        List<String> productsCart = new ArrayList<>();
        //товары из меню выбора
        List<String> addProductsCart =new ArrayList<>();

        for (WebElement productCart:cartPage.productCart)
        {
            addProductsCart.add(productCart.getText());
        }

        for (WebElement oldProductCart:cartPage.productCart)
        {
            productsCart.add(oldProductCart.getText().toLowerCase());
        }

        Collections.sort(productsCart);
        Collections.sort(addProductsCart);
        Assert.assertTrue("Товары не совпадают",productsCart.equals(addProductsCart));
        if(productsCart.equals(addProductsCart)) {return true;}else{return false;}
    }

    @Step("Удаление продуктов из карзины")
    public void deleteProducts(){

       cartPage.removeAll();
    }

    @Step("проверка пустоты корзины")
    public boolean isEmpty()
    {
        if (cartPage.emptyCart.isDisplayed()){return false;}else{return true;}
    }

  /*  @Step("Удаление продуктов из карзины")
    public void deleteProducts()
    {
        WebDriverWait wait = new WebDriverWait(BaseStep.getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(cartPage.deleteAll));
        cartPage.deleteAll.click();
        wait.until(ExpectedConditions.visibilityOf(cartPage.closeButton));
        cartPage.closeButton.click();
        List<WebElement> getsProdduct = BaseStep.getDriver().findElements(By.xpath("//*[@id=\"PageCenter\"]//div[class='eCartItem_name']"));
        Assert.assertTrue("Корзина не пуста",(getsProdduct.size() == 0));
    }*/
}
