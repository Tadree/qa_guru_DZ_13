package ru.jiehk.utils;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static List<String> monthsList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December");

    public static String getRandomGender() {
        List<String> gendersList = Arrays.asList("Male", "Female", "Other");
        int randomIndex = ThreadLocalRandom.current().nextInt(gendersList.size());
        return gendersList.get(randomIndex);
    }

    public static String getRandomMonth() {
        int randomIndex = ThreadLocalRandom.current().nextInt(monthsList.size());
        return monthsList.get(randomIndex);
    }

    public static String getRandomDay(String year, String month) {
        YearMonth yearMonthObject = YearMonth.of(Integer.parseInt(year), monthsList.indexOf(month) + 1);
        int newDay = ThreadLocalRandom.current().nextInt(1, yearMonthObject.lengthOfMonth() + 1);
        return String.format("%02d", newDay);
    }

    public static String getRandomHobby() {
        List<String> hobbiesList = Arrays.asList("Sports", "Reading", "Music");
        int randomIndex = ThreadLocalRandom.current().nextInt(hobbiesList.size());
        return hobbiesList.get(randomIndex);
    }

    public static String getRandomSubject() {
        List<String> subjectsList = Arrays.asList("Maths", "Chemistry", "Computer Science", "Commerce", "Economics",
                "Accounting", "Arts", "Social Studies", "History", "Civics", "Physics", "English");
        int randomIndex = ThreadLocalRandom.current().nextInt(subjectsList.size());
        return subjectsList.get(randomIndex);
    }

    public static String getRandomState() {
        List<String> statesList = Arrays.asList("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        int randomIndex = ThreadLocalRandom.current().nextInt(statesList.size());
        return statesList.get(randomIndex);
    }

    public static String getRandomCity(String value) {
        List<String> citiesList = null;
        switch (value) {
            case "NCR":
                citiesList = Arrays.asList("Delhi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh":
                citiesList = Arrays.asList("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana":
                citiesList = Arrays.asList("Karnal", "Panipat");
                break;
            case "Rajasthan":
                citiesList = Arrays.asList("Jaipur", "Jaiselmer");
                break;
        }
        int randomIndex = ThreadLocalRandom.current().nextInt(citiesList.size());
        return citiesList.get(randomIndex);
    }
}
