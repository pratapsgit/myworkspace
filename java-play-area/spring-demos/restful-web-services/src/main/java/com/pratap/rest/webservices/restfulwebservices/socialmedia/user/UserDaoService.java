package com.pratap.rest.webservices.restfulwebservices.socialmedia.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int userCount = 0;
	static {
		users.add(new User(++userCount, "Samir",
				LocalDate.now().minusYears(40).minusDays(10)));
		users.add(new User(++userCount, "Janmeya",
				LocalDate.now().minusYears(30).minusDays(3)));
		users.add(new User(++userCount, "Koshar",
				LocalDate.now().minusYears(35).minusDays(9)));
		users.add(new User(++userCount, "Bahar",
				LocalDate.now().minusYears(39).minusDays(15)));
		users.add(new User(++userCount, "Milan",
				LocalDate.now().minusYears(27).minusDays(5)));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		User retUser = null;

//		for(User u : users) {
//			if(u.getId() == id) {
//				retUser = u;
//			}
//		}

		Predicate<? super User> isUserPresent = user -> user.getId().equals(id);
		retUser = users.stream().filter(isUserPresent).findFirst().orElse(null);

		if (retUser == null) {
			throw new UserNotFoundException(
					"User with id " + id + " not found");
		}

		return retUser;
	}

	public void deleteOne(int id) {
		Predicate<? super User> deletePredicate = user -> user.getId() == id;
		users.removeIf(deletePredicate);
	}
}
