import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Epic("Всплывающее меню - при наведении на кноку Информация")
public class InformationHoverMenu {
    private SelenideElement headerFlight = $(By.xpath("//a[@href='/information#flight']"));
    private SelenideElement headerUseful = $(By.xpath("//a[@href='/information#useful']"));
    private SelenideElement headerCompany = $(By.xpath("//a[@href='/information#company']"));
    public InformationHoverMenu ()
    {
    }

    @Step("Проверка заголовков")
    public boolean verifyHeaders() {
        if ($(headerFlight).getText().equals("Подготовка к полёту") &&
            $(headerUseful).getText().equals("Полезная информация") &&
            $(headerCompany).getText().equals("О компании"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}

