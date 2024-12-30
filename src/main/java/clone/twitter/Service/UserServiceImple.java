package clone.twitter.Service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import clone.twitter.Exceptions.ResourceNotFoundException;
import clone.twitter.Exceptions.UserException;
import clone.twitter.Repository.UserRepo;
import clone.twitter.config.JwtTokenProvider;
import clone.twitter.entity.User;
import clone.twitter.paylouts.UserDto;
import io.jsonwebtoken.Jwt;

public class UserServiceImple implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private JwtTokenProvider jwtprovider;
	
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public UserDto findUserById(Integer userId){
		
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		return this.modelmapper.map(user, UserDto.class);
		
	}


	@Override
	public UserDto findUserProfileByJwt(String jwt){
		String email = jwtprovider.getEmailFromJwtToken(jwt);	
		System.out.println("email"+email);
		User user = userRepo.findByEmail(email);
		return this.modelmapper.map(user, UserDto.class);
		
	}


	@Override
	public UserDto createUser(UserDto userdto) {
		User user = this.dtoToUser(userdto);
		User save = this.userRepo.save(user);
		return this.userToDto(save);
	}


	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Usen", "Id", userId));
		user.setFullname(userDto.getFullname());
		user.setLastname(userDto.getLastname());
		user.setEmail(userDto.getEmail());
		user.setBio(userDto.getBio());
		user.setId(userId);
		user.setDOB(userDto.getDOB());
		
		User updateUser = userRepo.save(user);
		
		UserDto dto = this.userToDto(updateUser);
		
		return dto;
	}


	@Override
	public UserDto findUserByEmail(String email) {
		User user = userRepo.findByEmail(email);
		
		return null;
	}


	@Override
	public UserDto followUser(Integer userId, Integer UserId2) {
		return null;
	}


	@Override
	public List<UserDto> searchUser(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private User dtoToUser(UserDto userDto) {
		User user = this.modelmapper.map(userDto, User.class);
		return user;
		
	

}
	private UserDto userToDto(User user) {
		UserDto userDto = this.modelmapper.map(user, UserDto.class);
		return userDto;
	}

}
