import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Epic(value ="Тесты для сайта https://www.pobeda.aero/")
public class Tests {

    @Test
    @Description(value ="Проверка всплывающего окна с заголовками")
    @Feature(value ="Базовые проверки")
    public void Test1() throws InterruptedException {
        Selenide.open("https://www.pobeda.aero/");
        StartPage startPage=new StartPage();
        Assertions.assertTrue(startPage.verifySiteIsOpen());
        startPage.moveToButtonInformation();
        InformationHoverMenu informationHoverMenu=new InformationHoverMenu();
        Assertions.assertTrue(informationHoverMenu.verifyHeaders());
    }

    @Test
    @Description("Проверка красной обводки для поля «Туда»")
    @Feature(value ="Базовые проверки")
    public void Test2() throws InterruptedException {
        Selenide.open("https://www.pobeda.aero/");
        StartPage startPage=new StartPage();
        Assertions.assertTrue(startPage.verifySiteIsOpen());
        TicketSearchBlock ticketSearchBlock=new TicketSearchBlock();
        Assertions.assertTrue(ticketSearchBlock.verifyInputs());
        ticketSearchBlock.scrollToSearchTicketBlock();
        ticketSearchBlock.fillInputFrom("Москва");
        ticketSearchBlock.fillInputTo("Санкт-Петербург");
        ticketSearchBlock.clickSearchButton();
        Assertions.assertTrue(ticketSearchBlock.verifyInputDateFromErrorBorderColor());
    }

    @Test
    @Description("Проверка ошибки «Заказ с указанными параметрами не найден»")
    @Feature(value ="Базовые проверки")
    public void Test3() throws InterruptedException {
        Selenide.open("https://www.pobeda.aero/");
        StartPage startPage=new StartPage();
        Assertions.assertTrue(startPage.verifySiteIsOpen());
        BookingManagementBlock bookingManagementBlock=new BookingManagementBlock();
        bookingManagementBlock.scrollToBookingManagementBlock();
        Assertions.assertTrue(bookingManagementBlock.verifyInputs());
        bookingManagementBlock.fillInputClientName("Qwerty");
        bookingManagementBlock.fillInputBookingNumber("XXXXXX");
        bookingManagementBlock.clickSearchButton();
        bookingManagementBlock.switchToNewTab();
        Assertions.assertTrue(bookingManagementBlock.verifyBookingErrorMessage());
    }

    @Test
    @Description("Явно непроходящий тест, чтобы увидеть в отчёте его падение")
    @Feature(value ="Базовые проверки")
    public void Test4() throws InterruptedException {
        Selenide.open("https://www.ya.ru/");
        StartPage startPage=new StartPage();
        Assertions.assertTrue(startPage.verifySiteIsOpen());
    }
}