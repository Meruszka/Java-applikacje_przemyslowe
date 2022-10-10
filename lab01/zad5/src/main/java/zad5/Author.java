package zad5;

public class Author {
    private String name;
    private String email;
    private Gender gender;

    public Author(String name, String email, Gender gender){
        this.name = name;
        this.email = email;
        this.gender = gender;

    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Gender getGender(){
        return gender;
    }
    public String toString(){
        return "Author[" + name + "," + email +"," + gender + "]";
    }
}

