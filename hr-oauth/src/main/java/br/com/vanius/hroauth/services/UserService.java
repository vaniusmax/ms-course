package br.com.vanius.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vanius.hroauth.entities.User;
import br.com.vanius.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	@Autowired
	private UserFeignClient userFeignClient;
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		
		if(user == null) {
			logger.error("Usuário não encontrado");
			throw new IllegalArgumentException("Usuário não encontrado "+ email);
		}
		logger.info("Usuário encontrado "+ email);
		return user;
	}
}
