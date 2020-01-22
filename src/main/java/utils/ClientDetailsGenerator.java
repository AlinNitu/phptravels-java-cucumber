package utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class ClientDetailsGenerator {

    public static Faker faker = new Faker();

    public static String getClientName() {

        return faker.name().firstName();
    }

    public static String getClientSurname() {

        return faker.name().lastName();
    }

    public static String getClientEmail() {

        return RandomStringUtils.randomAlphanumeric(8, 20) + "@example.com";
    }

    public static String getClientPhone() {

        return faker.phoneNumber().cellPhone();
    }

    public static String getClientPassportNumber() {

        return RandomStringUtils.randomNumeric(8);
    }

    public static String getClientNationality() {

        //return faker.country().name();  =)
        return "ROMANIA";
    }

    public static String getCardNumber() {

        return RandomStringUtils.randomNumeric(16);
    }

    public static String getCardCvv() {

        return RandomStringUtils.randomNumeric(3);
    }
}
