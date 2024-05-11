package Users;
import com.github.javafaker.Faker;

import java.util.Locale;

public abstract class AbstractUser {
    Faker faker = new Faker(Locale.forLanguageTag("ru-RU"));
    String fullName = faker.name().fullName();
    int personalID = faker.number().numberBetween(0, 10000000);
    String status = "";
    int spaceCount = 0;
    AbstractUser() {
        for (int i = 0; i < fullName.length(); i++) {
            if (fullName.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        while (spaceCount < 2) {
            fullName = faker.name().fullName();
            spaceCount = 0;
            for (int i = 0; i < fullName.length(); i++) {
                if (fullName.charAt(i) == ' ') {
                    spaceCount++;
                }
            }
        }
    }

    public String getFullName() {
        return this.fullName;
    }
    public String getStatus(){
        return this.status;
    }
    public int getPersonalID(){
        return this.personalID;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getName() {
        return this.fullName;
    }
}
