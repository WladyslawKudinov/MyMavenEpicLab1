package Tools;

import UserFactories.AbstractUserFactory;
import UserFactories.ProfessorFactory;
import UserFactories.StudentFactory;
import Users.AbstractUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserGenerator {
    public List<AbstractUser> generateUsers(int amount){
        List<AbstractUser> users = new ArrayList<>();
        Random random = new Random();
        String[] statuses = {"student", "professor"};
        AbstractUserFactory studentFactory = new StudentFactory();
        AbstractUserFactory professorFactory = new ProfessorFactory();

        for(int i = 0; i < amount; i++){
            int randint = random.nextInt(statuses.length);
            if (statuses[randint].equals("student")){
                users.add(studentFactory.createUser());
            } else if (statuses[randint].equals("professor")){
                users.add(professorFactory.createUser());
            }
        }
        return users;
    }
}
