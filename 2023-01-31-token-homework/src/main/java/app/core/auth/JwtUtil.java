package app.core.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import app.core.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;

@Component
public class JwtUtil extends JwtUtilAbstract<User, Integer> {

	@Override
	public String generateToken(User user) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("name", user.getName());
		String token = this.createToken(claims, user.getId());
		return token;
	}

	@Override
	public User extractUser(String token) throws JwtException {
		Claims claims = this.extractAllClaims(token);
		int id = Integer.parseInt(claims.getSubject());
		String name = claims.get("name", String.class);
		User user = new User(id, name, null);
		return user;
	}

}
