package app.core.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.User;

@CrossOrigin
@RestController
@RequestMapping("/api/app")
public class AppController {

	@GetMapping(headers = { HttpHeaders.AUTHORIZATION })
	public String greet(HttpServletRequest req) {
		User user = (User) req.getAttribute("user");
		return "Hello " + user.getFirstName() + " " + user.getLastName() + " - " + user.getRole();
	}

	@GetMapping
	public String getCoupons() {
		return "Here are you coupons";
	}

}
