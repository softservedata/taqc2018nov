package com.softserve.edu.data;

public class Appl {
    public static void main(String[] args) {
        //
        // 1. Use Classic Constructor
//        User user = new User("login1", "password1", "email1",
//             "surname1", "address1");
//        System.out.println("email = " + user.getEmail());
        //
        // 2. Use Default Constructor and Setters
//        User user = new User();
//        user.setLogin("login2");
//        user.setPassword("password2");
//        user.setEmail("email2");
//        user.setSurname("surname2");
//        user.setAddress("address2");
//        System.out.println("email = " + user.getEmail());
        //
        // 3. Use Fluent Interface
//        User user = new User()
//            .setLogin("login3")
//            .setPassword("password3")
//            .setEmail("email3")
//            .setSurname("surname3")
//            .setAddress("address3");
//        System.out.println("email = " + user.getEmail());
        //
        // 4. Use Static Factory
//        User user = User.get()
//            .setLogin("login4")
//            .setPassword("password4")
//            .setEmail("email4")
//            .setSurname("surname4")
//            .setAddress("address4");
//        System.out.println("email = " + user.getEmail());
        //
        // 5. Use Builder
//        User user = User.get()
//                .setLogin("login5")
//                .setPassword("password5")
//                .setEmail("email5")
//                .setAddress("address5")
//                .setSurname("surname")
//                .build();
//        System.out.println("email = " + user.getEmail());
//        System.out.println("email = " + user.setEmail("aaa")); // Defect
//        System.out.println("email = " + user.getEmail());
        //
        // 6. Dependency Inversion
//        IUser user = User.get()
//                .setLogin("login5")
//                .setPassword("password5")
//                .setEmail("email5")
//                .setAddress("address5")
//                .setSurname("surname5")
//                .build();
//        System.out.println("email = " + user.getEmail());
//        //System.out.println("email = " + user.setEmail("aaa")); // Compile Error
//        System.out.println("email = " + ((User) user).setEmail("aaa")); // Code Smell
//        System.out.println("email = " + user.getEmail());
        // 7. Add Repository
        // 8. Add Singletone
        IUser user = UserRepository.get().valid();
        System.out.println("email = " + user.getEmail());
    }
}
