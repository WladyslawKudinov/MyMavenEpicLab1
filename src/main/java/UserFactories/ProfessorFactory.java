package UserFactories;

import Users.AbstractUser;
import Users.Professor;

public class ProfessorFactory extends AbstractUserFactory{

    @Override
    public AbstractUser createUser() {
        AbstractUser professor = new Professor();
        professor.setStatus("professor");
        return professor;
    }
}
