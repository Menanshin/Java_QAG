package hw.hw4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HW_QAG_4 {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void testForm() {
        //вводимые значения
        String firstName = "Evgeniy";
        String lastName = "Maslov";
        String email = "qaguru@qa.gu";
        String gender = "Male";
        String birthMonth = "August";
        String birthYear = "1988";
        String birthDay = "8";
        String mobileNumber = "8900123456";
        String subjects = "English";
        String Address = "Russian,Moscow";
        String hobbies = "Sports";
        String state = "NCR";
        String city = "Noida";
        String picture = "test_qa.jpeg";

        //открываем сайт и убираем банер
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        // заполнение полей
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobileNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__month").$(byText(birthDay)).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(Address).pressTab();
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#city").click();
        $("#submit").pressEnter();

        //проверки
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").
                shouldHave(text(firstName),
                        text(lastName),
                        text(email),
                        text(gender),
                        text(mobileNumber),
                        text(birthMonth),
                        text(birthYear),
                        text(birthDay),
                        text(hobbies),
                        text(picture),
                        text(Address),
                        text(state),
                        text(city));
    }

}
