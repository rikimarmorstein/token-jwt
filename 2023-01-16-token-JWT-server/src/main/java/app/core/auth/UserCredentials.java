package app.core.auth;

import app.core.entities.User.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentials {

	private String email;
	private String password;
	private Role role;

}
