package com.dd.selenium.util;

import net.datafaker.Faker;

import java.util.Random;

public class RandomPersonalInfo {

    Faker faker =new Faker();
    private String firstname;
    private String lastname;
    private String zipCode;

    public RandomPersonalInfo() {
        this.firstname = faker.name().firstName();
        this.lastname = faker.name().lastName();
        this.zipCode = faker.address().zipCode();
    }


//    public static String getFirstname() {
//       // return faker.name().firstName();
//    }
//
//    public static String getLastname() {
//      //  return faker.name().lastName();
//    }
//
//    public static String getZipCode() {
//        return faker.address().zipCode();
//    }
}


