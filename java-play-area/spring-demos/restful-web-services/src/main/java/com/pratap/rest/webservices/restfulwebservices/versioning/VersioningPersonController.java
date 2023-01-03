package com.pratap.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping(path = "/v1/person")
	public PersonV1 getPersonDetailsV1() {
		return new PersonV1("Boris Becker");
	}

	@GetMapping(path = "/v2/person")
	public PersonV2 getPersonDetailsV2() {
		return new PersonV2("Boris", "Becker");
	}

	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getPersonDetailsWithParamV1() {
		return new PersonV1("Boris Becker");
	}

	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getPersonDetailsWithParamV2() {
		return new PersonV2("Boris", "Becker");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getPersonDetailsWithHeaderV1() {
		return new PersonV1("Boris Becker");
	}

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getPersonDetailsWithHeaderV2() {
		return new PersonV2("Boris", "Becker");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/in.mycomp.app-v1+json")
	public PersonV1 getPersonDetailsWithAcceptV1() {
		return new PersonV1("Boris Becker");
	}

	@GetMapping(path = "/person/accept", produces = "application/in.mycomp.app-v2+json")
	public PersonV2 getPersonDetailsWithAcceptV2() {
		return new PersonV2("Boris", "Becker");
	}
}
