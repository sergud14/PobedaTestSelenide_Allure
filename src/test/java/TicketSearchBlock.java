import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;


@Epic("Блок поиска билетов")
public class TicketSearchBlock {
    private SelenideElement tabSearchTicket = $(By.xpath("(//div[text()='Поиск билета']//parent::button)[1]"));
    private SelenideElement inputFrom = $(By.xpath("(//input[@placeholder='Откуда'])[1]"));
    private SelenideElement inputTo = $(By.xpath("(//input[@placeholder='Куда'])[1]"));
    private SelenideElement inputDateFrom = $(By.xpath("(//input[@placeholder='Туда'])[1]"));
    private SelenideElement inputDateTo = $(By.xpath("(//input[@placeholder='Обратно'])[1]"));
    private SelenideElement buttonSearch = $(By.xpath("//button[text()='Поиск']//parent::div"));
    private SelenideElement inputDateFromError = $(By.xpath("(//*[@placeholder='Туда']//parent::div[@class='dp-1bgth1z-root'][@data-empty='true'][@data-errored='true'])[2]"));

    public TicketSearchBlock ()
    {
    }
    @Step("Проверка инпутов Откуда, Куда,Туда, Обратно")
    public boolean verifyInputs() {
        if ($(inputFrom).isDisplayed()&&
            $(inputTo).isDisplayed()&&
            $(inputDateFrom).isDisplayed()&&
            $(inputDateTo).isDisplayed()
        )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @Step("Скролл к блоку поиска билетов")
    public void scrollToSearchTicketBlock() {
        $(inputFrom).scrollTo();
    }
    @Step("Заполнение поля Откуда")
    public void fillInputFrom(String nameFrom) {
        $(inputFrom).setValue(nameFrom).click();
        $(By.xpath("//div[text()='"+nameFrom+"']")).click();
    }
    @Step("Заполнение поля Куда")
    public void fillInputTo(String nameTo){
        $(inputTo).setValue(nameTo).click();
        $(By.xpath("//div[text()='"+nameTo+"']")).click();
    }
    @Step("Клик по кнопке Поиск")
    public void clickSearchButton() {
        $(buttonSearch).click();
    }

    @Step("Проверка наличия красной рамки у инпута Туда")
    public boolean verifyInputDateFromErrorBorderColor() {
        if($(inputDateFromError).getCssValue("border-bottom-color").equals("rgba(213, 0, 98, 1)"))
        {
            return true;
        }
        else {
            return false;
        }
    }
}
