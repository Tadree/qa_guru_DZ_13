package ru.jiehk.pages;

import com.codeborne.selenide.SelenideElement;
import ru.jiehk.pages.components.Calendar;
import ru.jiehk.pages.components.ResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormPage {

    Calendar calendar = new Calendar();
    ResultsModal resultsModal = new ResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyRadioButton = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelector = $("#state"),
            stateList = $("#stateCity-wrapper"),
            citySelector = $("#city"),
            cityList = $("#stateCity-wrapper"),
            submitButton = $("#submit");


    public RegistrationFormPage openPage() {
        step("Открываем главную страницу", () -> {
            open("/automation-practice-form");
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");
        });
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        step("Заполняем имя", () -> {
            firstNameInput.setValue(value);
        });
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        step("Заполняем фамилию", () -> {
            lastNameInput.setValue(value);
        });
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        step("Заполняем email", () -> {
            emailInput.setValue(value);
        });
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        step("Выбираем пол", () -> {
            genderRadioButton.$(byText(value)).click();
        });
        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        step("Заполняем номер телефона", () -> {
            numberInput.setValue(value);
        });
        return this;
    }

    public RegistrationFormPage setBirthDate(String year, String month, String day) {
        step("Выбираем дату рождения", () -> {
            dateOfBirthInput.click();
            calendar.setDate(year, month, day);
        });
        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        step("Выбираем предметы", () -> {
            subjectInput.setValue(value).pressEnter();
        });
        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        step("Выбираем хобби", () -> {
            hobbyRadioButton.$(byText(value)).click();
        });
        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        step("Загружаем изображение", () -> {
            uploadPicture.uploadFile(new File(value));
        });
        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        step("Заполняем адрес", () -> {
            addressInput.setValue(value);
        });
        return this;
    }

    public RegistrationFormPage setState(String value) {
        step("Выбираем штат", () -> {
            stateSelector.click();
            stateList.$(byText(value)).click();
        });
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        step("Выбираем город", () -> {
            citySelector.click();
            cityList.$(byText(value)).click();
        });
        return this;
    }

    public RegistrationFormPage submitForm() {
        step("Отправляем форму", () -> {
            submitButton.click();
        });
        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        step("Проверяем отображениие результирующей таблицы", () -> {
            resultsModal.checkVisible();
        });
        return this;
    }

    public RegistrationFormPage checkResults(String key, String value) {
        step("Проверяем значение результирующей таблицы в строке " + key, () -> {
            resultsModal.checkResult(key, value);
        });
        return this;
    }
}
