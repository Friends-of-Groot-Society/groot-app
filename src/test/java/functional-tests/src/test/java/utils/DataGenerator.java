package utils;

import com.github.javafaker.Faker;
import net.minidev.json.JSONObject;

public class DataGenerator {
    public static String getRandomEmail(){
        Faker faker = new Faker();
        String email = faker.name().firstName().toLowerCase() + faker.random().nextInt(1,200);
        return email;
    }

    public static String getRandomusername(){
        Faker faker = new Faker();
        String username = faker.name().username();
        return username;
    }

    public static JSONObject getRandomUser(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String username = faker.name().username();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String body = faker.gameOfThrones().quote();
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("email", email);
        json.put("password", password);
        json.put("body", body);
        json.put("firstName", firstName);
        json.put("lastName", lastName);
        return json;
    }
}