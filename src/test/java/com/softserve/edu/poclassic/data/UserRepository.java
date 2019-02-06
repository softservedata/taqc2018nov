package com.softserve.edu.poclassic.data;

public final class UserRepository {

	private UserRepository() {
	}

	public static User getExist() {
		return new User("work", "qwerty");
	}

}
