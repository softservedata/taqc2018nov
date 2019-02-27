package com.softserve.edu.poclassic.data;

import java.util.List;

import com.softserve.edu.poclassic.tools.CSVReader;

public final class UserRepository {

	private UserRepository() {
	}

	public static User getExist() {
		return new User("work", "qwerty");
	}

	public static User getInvalid() {
		return new User("hahaha", "hahaha");
	}

    public static List<User> fromCsv(String filename) {
        return User.getByLists(new CSVReader(filename).getAllCells());
    }

    public static List<User> fromCsv() {
        return fromCsv("users.csv");
    }

	
}
