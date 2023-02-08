package hw.hw6;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultModal {
    private SelenideElement
            modalExample = $("#example-modal-sizes-title-lg"),
            tableResponsive = $(".table-responsive");

    public void verifyModal() {
        modalExample.shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String value) {
        tableResponsive.$(byText(key)).parent().shouldHave(text(value));
    }
}
