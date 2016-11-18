package task15.ATM;

import task15.ATM.money.Nominal;

public class Person {

    private String firstName;
    private String secondName;
    private String age;
    private Photo photo;
    private String securityWord;

    public Person(String firstName, String secondName, String age, String securityWord) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.securityWord = securityWord;
        photo = new Photo(firstName+secondName+age);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getAge() {
        return age;
    }

    public Photo getPhoto() {
        return photo;
    }

    public String getSecurityWord() {
        return securityWord;
    }

}
