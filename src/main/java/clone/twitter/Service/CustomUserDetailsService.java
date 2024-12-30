package clone.twitter.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import clone.twitter.Repository.UserRepo;
import clone.twitter.entity.User;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User email = userRepo.findByEmail(username);
		if(email==null)
		{
			throw new UsernameNotFoundException("User not Found Exception"+ email);
		}
		
		List<GrantedAuthority> authorities=new ArrayList<>();
		
		return new org.springframework.security.core.userdetails.User(email.getEmail(),email.getPassword(),authorities);
	}
	
	

}
