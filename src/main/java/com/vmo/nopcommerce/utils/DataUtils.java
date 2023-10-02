package com.vmo.nopcommerce.utils;
import com.github.javafaker.Faker;
import java.util.Locale;
public class DataUtils {
    private Faker faker;
    public static DataUtils getData() {
        return new DataUtils();
    }

    private DataUtils() {
        faker = new Faker();
    }

    public String getFirstName() {
        return faker.name().firstName();
    }
    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmailAddress() {
        return faker.internet().emailAddress();
    }

    public String getFirstNameAddress() {
        return faker.address().firstName();
    }

    public String getLastNameAddress() {

        return faker.address().lastName();
    }

    public String getCompanyName() {

        return faker.company().name();
    }

    public String getCityName() {
        return faker.address().cityName();
    }

    public String getFullAddress() {
        return faker.address().fullAddress();
    }

    public String getZipCode() {
        return faker.address().zipCode();
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }
    public static String generateEmail(){
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }
}
