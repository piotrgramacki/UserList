import java.util.Date;

/**
 * Created by Piotrek on 2018-03-15.
 */

public class User {
    private String name;
    private String surname;
    private Date birthDate;

    public User(String name, String surname, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }
}
