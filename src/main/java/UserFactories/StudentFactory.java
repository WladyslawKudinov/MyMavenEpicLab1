package UserFactories;

import Users.AbstractUser;
import Users.Student;

public class StudentFactory extends AbstractUserFactory{
    @Override
    public AbstractUser createUser() {
        AbstractUser student = new Student();
        student.setStatus("student");
        return student;
    }
}
