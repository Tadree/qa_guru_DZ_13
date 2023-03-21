package ru.jiehk.tests;

import com.github.javafaker.Faker;

import static ru.jiehk.utils.RandomUtils.*;

public class TestData {

    static Faker faker = new Faker();

    static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomGender(),
            mobile = faker.phoneNumber().subscriberNumber(10),
            birthYear = String.valueOf(faker.number().numberBetween(1900, 2100)),
            birthMonth = getRandomMonth(),
            birthDay = getRandomDay(birthYear, birthMonth),
            subjects = getRandomSubject(),
            hobby = getRandomHobby(),
            pictureName = "test.jpeg",
            currentAddress = faker.address().fullAddress(),
            state = getRandomState(),
            city = getRandomCity(state);

}
