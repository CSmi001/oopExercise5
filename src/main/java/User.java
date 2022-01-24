import java.time.LocalDateTime;

public class User {
    String name;
    String lastName;
    Boolean status;
    LocalDateTime registrationDateTime;

    public User(String name, String lastName) throws EmptyFieldException {
        setName(name);
        setLastName(lastName);
        this.status = true;
        this.registrationDateTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws EmptyFieldException {
        if (name == "" || name == null){
            this.name = "anonymous";
            //throw new NullPointerException("Empty Name detected - Assigned 'anonymous' as new value\n" + this.toString());
            throw new EmptyFieldException("Empty Name detected - Assigned 'anonymous' as new value\n" + this.toString());
        } else {
            this.name = name;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName){
        if (lastName == "" || lastName == null){
            this.lastName = "anonymous";
            //throw new NullPointerException("Empty LastName detected - Assigned 'anonymous' as new value\n" + this.toString());
            try {
                throw new EmptyFieldException("Empty LastName detected - Assigned 'anonymous' as new value\n" + this.toString());
            } catch (EmptyFieldException e) {
                e.printStackTrace();
            }
        } else {
            this.lastName = lastName;
        }
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(LocalDateTime registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", registrationDateTime=" + registrationDateTime +
                '}';
    }
}
