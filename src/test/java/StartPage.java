import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Epic("Домашняя страница сайта")
public class StartPage {
    private SelenideElement buttonInformation = $(By.xpath("//a[@href='/information']"));
    private SelenideElement logo = $(By.xpath("(//img[@alt='«Авиакомпания «Победа», Группа «Аэрофлот»'])[1]"));
    public StartPage ()
    {
    }
    @Step("Проверка загрузки домашней страницы сайта")
    public boolean verifySiteIsOpen() {
        if(Selenide.title().equals("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками")&&$(logo).isDisplayed())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @Step(value="Наведение курсора на кнопку Информация")
    public void moveToButtonInformation() {
        $(buttonInformation).hover();
    }
}
