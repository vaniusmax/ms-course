package br.com.vanius.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vanius.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
