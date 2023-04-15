package app.core.controllers;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.auth.UserCredentials;
import app.core.entity.User;
import app.core.services.AuthService;

@RestController
public class UserController {

	@Autowired
	private AuthService authService;

	@PostMapping("/register")
	public String register(@RequestBody User user) {
		try {
			return this.authService.register(user);
		} catch (LoginException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}

	@PostMapping("/login")
	public String login(@RequestBody UserCredentials userCredentials) {
		try {
			return this.authService.login(userCredentials);
		} catch (LoginException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}

}
