package hw.hw6;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    private final String TITLE_TEXT = "Practice Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            state = $("#state"),
            stateCityInput = $("#stateCity-wrapper"),
            city = $("#city"),
            cityInput = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            birthDateInput = $("#dateOfBirthInput"),
            picture = $("#uploadPicture");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".main-header").shouldHave(text(TITLE_TEXT));

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserGender(String value) {
        genterWrapperInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setUserHobbies(String value) {
        hobbiesWrapperInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserAddress(String value) {
        currentAddressInput.setValue(value).pressTab();

        return this;
    }

    public RegistrationPage setUserState(String value) {
        state.click();
        stateCityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserCity(String value) {
        city.click();
        cityInput.$(byText(value)).click();
        city.click();

        return this;
    }

    public RegistrationPage pressSubmit() {
        submitButton.pressEnter();

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        picture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage verifyModalAppers() {
        registrationResultModal.verifyModal();

        return this;
    }

    public RegistrationPage verifyResult (String key,String value) {
        registrationResultModal.verifyResult(key, value);

        return this;
    }

}
