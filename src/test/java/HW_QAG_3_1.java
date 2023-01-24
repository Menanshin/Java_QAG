import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class HW_QAG_3_1 {
    @Test
    void checkDragAndDropUseAction() {
        Configuration.holdBrowserOpen = true;
        //открываем сайт https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //переносим прямоугольник А на место В с помощью команды Selenide.action
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(550, 190).release().perform();
        //проверяем, что прямоуголник переместился
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        // тест не стабилен, тк напрямую завист от расширения окна
    }

    @Test
    void chekDragAndDropUseDragAndDrop() {
        Configuration.holdBrowserOpen = true;
        //открываем сайт https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //переносим прямоугольник А на место В с помощью команды .dragAndDrop
        $("#column-a").dragAndDropTo($("#column-b"));
        //проверяем, что прямоуголник переместился
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
