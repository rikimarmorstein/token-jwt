package app.core.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByName(String name);
}
