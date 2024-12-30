package clone.twitter.Service;

import java.util.List;

import clone.twitter.paylouts.UserDto;

import clone.twitter.Exceptions.UserException;
import clone.twitter.entity.User;

public interface UserService{
	
	public UserDto createUser(UserDto userdto);
	
	public UserDto updateUser(UserDto userDto, Integer userId);
	
	public UserDto findUserByEmail(String email);
	
	public UserDto followUser(Integer userId, Integer UserId2);
	
	public List<UserDto> searchUser(String query);
	
	public UserDto findUserById(Integer userId)throws UserException;
	
	public UserDto findUserProfileByJwt(String jwt)throws UserException;
	
	
	
	
	

	

}
