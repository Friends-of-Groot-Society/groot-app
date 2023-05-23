package app.mapl.service;

import app.mapl.dto.RegisterDto;
import app.mapl.dto.UserDto;
import app.mapl.models.User;

import java.util.List;
import java.util.Optional;


public interface UsersService {

	UserDto registerUser(RegisterDto rDto);

	UserDto loginUser(String username, String password);
	public UserDto createUser(UserDto user);

	User createUserCLI(User user);

	public Optional<UserDto> getUser(int id);
	public Optional<UserDto>  getUser(String username );
	public List<UserDto> getUsers();

	public UserDto updateUser(UserDto change);

	UserDto getUserByEmailAndPassword(String email, String pw);

	public UserDto getUserByPassword(String username, String password);
	public boolean deleteUser(String username);

	boolean deleteUser(UserDto user);

}
