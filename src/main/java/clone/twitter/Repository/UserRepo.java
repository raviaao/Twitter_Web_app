package clone.twitter.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import clone.twitter.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	public User findByEmail(String email);
	
	

}
