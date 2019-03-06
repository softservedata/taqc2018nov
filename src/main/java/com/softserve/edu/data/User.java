package com.softserve.edu.data;

//5. Use Builder
interface ILogin {
    IPassword setLogin(String login);
}

interface IPassword {
    IEmail setPassword(String password);
}

interface IEmail {
    IUserBuild setEmail(String email);
}

interface IUserBuild {
    IUserBuild setSurname(String surname);

    IUserBuild setAddress(String address);

    // 5. Use Builder
    //User build();
    // 6. Dependency Inversion
    IUser build();
}

public class User implements ILogin, IPassword,
        IEmail, IUserBuild, IUser {

    private String login; // Required
    private String password; // Required
    private String email; // Required
    private String surname;
    private String address;

    // 1. Use Classic Constructor
//    public User(String login, String password, String email) {
//        this.login = login;
//        this.password = password;
//        this.email = email;
//        this.surname = "";
//        this.address = "";
//    }

    // 1. Use Classic Constructor
//    public User(String login, String password, String email,
//            String surname, String address) {
//        this.login = login;
//        this.password = password;
//        this.email = email;
//        this.surname = surname;
//        this.address = address;
//    }

    // 2. Use Default Constructor and Setters
    // public User() {
    // 4. Use Static Factory
    //private User() {
    private User() {
        //this.login = "";
        //this.password = "";
        //this.email = "";
        // 5. Use Builder
        this.surname = "";
        this.address = "";
    }

    // 4. Use Static Factory
    //public static User get() {
    // 5. Use Builder
    public static ILogin get() {
        return new User();
    }

    // setters

    // 2. Use Default Constructor and Setters
    // public void setLogin(String login) {
    // 3. Use Fluent Interface
    //public User setLogin(String login) {
    // 5. Use Builder
    public IPassword setLogin(String login) {
        this.login = login;
        return this;
    }

    public IEmail setPassword(String password) {
        this.password = password;
        return this;
    }

    public IUserBuild setEmail(String email) {
        this.email = email;
        return this;
    }

    public IUserBuild setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public IUserBuild setAddress(String address) {
        this.address = address;
        return this;
    }

    // 5. Use Builder
    //public User build() {
    // 6. Dependency Inversion
    public IUser build() {
        return this;
    }
    
    // getters

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

}
