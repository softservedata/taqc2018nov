package com.softserve.edu.data;

public final class UserRepository {
    
    private static volatile UserRepository instance = null;
    
    private UserRepository() {
    }
    
    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }
    
    public IUser valid() {
        return User.get()
                .setLogin("login67")
                .setPassword("password67")
                .setEmail("email67")
                .setAddress("address67")
                .setSurname("surname67")
                .build();
    }
    
}
