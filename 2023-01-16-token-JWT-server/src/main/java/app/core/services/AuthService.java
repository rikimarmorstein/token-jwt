package app.core.services;

import javax.security.auth.login.LoginException;
import javax.security.auth.message.AuthException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.auth.JwtUtil;
import app.core.auth.UserCredentials;
import app.core.entities.User;
import app.core.repositories.UserRepo;

@Transactional
@Service
public class AuthService {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserRepo userRepo;

	public String register(User user) throws LoginException {
		if (user.getUserName().length() < 3) {
			throw new AuthException("userName must be at list of 3 characters");
		}
		user = this.userRepo.save(user);
		String token = this.jwtUtil.generateToken(user);
		return token;
	}

	public String login(UserCredentials userCredentials) throws LoginException {
		User user = this.userRepo.findByEmail(userCredentials.getEmail())
				.orElseThrow(() -> new AuthException("user not found"));
		if (userCredentials.getPassword().equals(user.getPassword())) {
			return this.jwtUtil.generateToken(user);
		} else {
			throw new LoginException("bad credentials");
		}
	}
}
