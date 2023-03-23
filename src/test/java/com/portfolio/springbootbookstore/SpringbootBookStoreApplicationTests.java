package com.portfolio.springbootbookstore;

import com.portfolio.springbootbookstore.model.User;
import com.portfolio.springbootbookstore.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootBookStoreApplicationTests {

	@Autowired
	private IUserRepository userRepository;

	@Test
	void save_auto_test() {
		User currUser = new User();
		currUser.setName("Pablo");

		userRepository.save(currUser);
	}

}
