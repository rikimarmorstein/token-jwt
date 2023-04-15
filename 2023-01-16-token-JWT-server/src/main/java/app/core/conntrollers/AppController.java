package app.core.conntrollers;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app")
@CrossOrigin
public class AppController {

	@GetMapping(headers = { HttpHeaders.AUTHORIZATION })
	public String greet() {
		return "hello";
	}
}
