package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private String email;
    private String password;

    public static User getRandomUser() {
        String name = RandomStringUtils.randomAlphanumeric(10);
        String email = RandomStringUtils.randomAlphanumeric(10) + "@" + RandomStringUtils.randomAlphabetic(10) + ".ru";
        String password = RandomStringUtils.randomAlphanumeric(10);

        return new User(name, email, password);
    }

    public static String getRandomEmail() {
        String email = RandomStringUtils.randomAlphanumeric(10) + "@" + RandomStringUtils.randomAlphabetic(10) + ".ru";
        return email;
    }

    public static String getRandomPassword() {
        String password = RandomStringUtils.randomAlphanumeric(10);
        return password;
    }

    public static String getRandomName() {
        String name = RandomStringUtils.randomAlphanumeric(10);
        return name;
    }
}