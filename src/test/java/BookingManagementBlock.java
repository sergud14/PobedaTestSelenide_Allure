import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import java.util.ArrayList;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Epic("Блок управления бронированием")
public class BookingManagementBlock {
    private SelenideElement tabBookingManagement = $(By.xpath("(//div[text()='Управление бронированием']//parent::button)[1]"));
    private SelenideElement inputClientName = $(By.xpath("(//input[@placeholder='Фамилия клиента'])[1]"));
    private SelenideElement inputBookingNumber = $(By.xpath("(//input[@placeholder='Номер бронирования или билета'])[1]"));
    private SelenideElement buttonSearch = $(By.xpath("//button[text()='Поиск']//parent::div"));
    private SelenideElement bookingErrorMessage = $(By.xpath("//div[@ng-if='vm.errorMessage'][text()='Заказ с указанными параметрами не найден']"));

    public BookingManagementBlock ()
    {
    }

    @Step("Проверка наличия элементов интерфейса на странице")
    public boolean verifyInputs() {
        if ($(inputClientName).isDisplayed()&&
            $(inputBookingNumber).isDisplayed()&&
            $(buttonSearch).isDisplayed()
        )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @Step("Скролл к блоку управления бронированием")
    public void scrollToBookingManagementBlock() {
        $(tabBookingManagement).scrollIntoView(true).click();
    }
    @Step("Заполнение поля Фамилия клиента")
    public void fillInputClientName(String name) {
        $(inputClientName).setValue(name);
    }

    @Step("Заполнение поля Номер бронирования или билета")
    public void fillInputBookingNumber(String number) {
        $(inputBookingNumber).setValue(number);
    }
    @Step("Клик по кнопке Поиск")
    public void clickSearchButton() {
        $(buttonSearch).click();
    }

    @Step("Переключение на новую вкладку браузера")
    public void switchToNewTab(){
        ArrayList<String> newTab = new ArrayList<String>(getWebDriver().getWindowHandles());
        Selenide.switchTo().window(newTab.get(1));
    }
    @Step("Проверка отображения сообщения об ошибке")
    public boolean verifyBookingErrorMessage() {
        if($(bookingErrorMessage).isDisplayed())
        {
            return true;
        }
        else {
            return false;
        }
    }
}