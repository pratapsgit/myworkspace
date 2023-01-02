package com.pratap.rest.webservices.restfulwebservices.socialmedia.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService userDaoService) {
		this.service = userDaoService;
	}

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return this.service.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public User retrieveAnUser(@PathVariable int id) {
		return this.service.findOne(id);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = this.service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
