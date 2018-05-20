package step;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ItemMenuPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

public class ItemMenuStep  {
    ItemMenuPage itemMenuPage = new ItemMenuPage();
    ItemStep itemStep = new ItemStep();

    @Step ("Заполняем {0} значением {1}")
        public void sendKeyValue(String name, String value) {

        WebDriverWait wait = new WebDriverWait(BaseStep.getDriver(),10);

        switch (name){
                case "минимальная цена":
                    itemMenuPage.minPrice.clear();
                    itemMenuPage.minPrice.sendKeys(value);
                    itemMenuPage.minPrice.sendKeys(Keys.ENTER);
                    try{
                        wait.until(ExpectedConditions.visibilityOf(itemMenuPage.done));
                        itemMenuPage.done.click();
                    }catch(Exception e){
                        System.out.println("кнопка не найдена");
                    }

                    break;
                default:
                    Assert.fail("Нет такого поля " + name);
            }
    }

    @Step("Выбираем производител {0}")
    public void getMaker(String name) {
        for (String n : name.split(",")) {
            System.out.println(n);
            switch (n) {
                case "Apple":
                    itemMenuPage.appleButton.click();
                    break;
                case "Canon":
                    itemMenuPage.canonButton.get(0).click();
                    break;
                case "Nikon":
                    itemMenuPage.niconButton.get(0).click();
                    break;
                default:
                    Assert.fail("Нет такого производителя " + n);
            }

        }
    }

    @Step("Заходим в корзину")
    public void getCart()  {
       itemMenuPage.cart.click();
    }


    private List<String> getNechet() {

        List<WebElement> tempProducts = new ArrayList<>();
        List<String> addProducts = new ArrayList<>();

        for (WebElement p:itemMenuPage.nameProduct) {
            tempProducts.add(p);
        }

        for (int i =0; i<tempProducts.size();i++)
        {
            if(i%2 == 0) addProducts.add(tempProducts.get(i).getText());
        }
        System.out.println("выбранные продукты");
        System.out.println(addProducts);

        return addProducts;
    }
    @Step("Обходим элементы")
    public void goElement()
    {
        List<String> mustItem = getNechet();
        for(String str:mustItem)
            {
             WebElement button = BaseStep.getDriver().findElement(By.linkText(str));
             button.click();
             itemStep.goBack();
             }

        System.out.println("Закончили обходить элементы");
    }

}

