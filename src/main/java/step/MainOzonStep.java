package step;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ElectronicPage;
import page.MainOzonPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

public class MainOzonStep {

    MainOzonPage mainOzonPage = new MainOzonPage();

    @Step("Закрываем рекламу")
    public void catchPopup() {
        try {
            new WebDriverWait(BaseStep.getDriver(), 2).until(ExpectedConditions.visibilityOf(mainOzonPage.closeReklama));
            if (mainOzonPage.closeReklama.isDisplayed()) {
                mainOzonPage.closeReklama.click();
            }
        } catch (Exception e) {
            System.out.println("Not popup");
        } finally {
            BaseStep.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

    }

    @Step("Выбираем пунт меню {0}")
    public void getMenu(String arg1) {

        String[] type = arg1.split(",");
        for (String t:type) {
            switch (t) {
                case "Электроника":
                    mainOzonPage.electronic.click();
                    break;
                case "Телефоны":
                    new ElectronicPage().smartPhone.click();
                    break;
                case "Зеркальные фотоаппарты":
                    new Actions(BaseStep.getDriver()).moveToElement(new ElectronicPage().zerkCamera);
                    new ElectronicPage().zerkCamera.click();
                    break;
                default:
                    Assert.fail("Нет такой кнопки " + arg1);
            }
        }
    }


}

