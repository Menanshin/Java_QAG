package hw.hw6;

import org.junit.jupiter.api.Test;

public class HW_QAG_6 extends TestConfig {


    String firstName = "Evgeniy";
    String lastName = "Maslov";
    String email = "qaguru@qa.gu";
    String gender = "Male";
    String month = "August";
    String year = "1988";
    String day = "8";
    String mobileNumber = "8900123456";
    String subjects = "English";
    String address = "Russian,Moscow";
    String hobbies = "Sports";
    String stateValue = "NCR";
    String cityValue = "Noida";
    String picture = "test_qa.jpeg";
    String keyName = "Student Name";
    String keyEmail = "Student Email";
    String keyGender = "Gender";
    String keyMobile = "Mobile";
    String keyDateOfBirth = "Date of Birth";
    String keySubjects = "Subjects";
    String keyHobbies = "Hobbies";
    String keyPicture = "Picture";
    String keyAddress = "Address";
    String keyStateAndCity = "State and City";


    @Test
    void testForm() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setUserGender(gender)
                .setUserNumber(mobileNumber)
                .setBirthDate(day, month, year)
                .setUserSubjects(subjects)
                .setUserHobbies(hobbies)
                .uploadPicture(picture)
                .setUserAddress(address)
                .setUserState(stateValue)
                .setUserCity(cityValue)
                .pressSubmit();

        //проверки
        registrationPage.verifyModalAppers()
                .verifyResult(keyName, firstName + " " + lastName)
                .verifyResult(keyEmail, email)
                .verifyResult(keyGender, gender)
                .verifyResult(keyMobile, mobileNumber)
                .verifyResult(keyDateOfBirth, day + " " + month + "," + year)
                .verifyResult(keySubjects, subjects)
                .verifyResult(keyHobbies, hobbies)
                .verifyResult(keyPicture, picture)
                .verifyResult(keyAddress, address)
                .verifyResult(keyStateAndCity, stateValue + " " + cityValue);

    }

}
