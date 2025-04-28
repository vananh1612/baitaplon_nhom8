package baitaplon.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import baitaplon.dto.UserDTO;
import baitaplon.mapper.IUserMapper;
import baitaplon.model.khoa;
import baitaplon.model.user;
import baitaplon.reponsitory.IUserReponsitory;
import baitaplon.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserReponsitory userRepository;

	public boolean registerUser(String username, String password, String confirmPassword) {
		if (!password.equals(confirmPassword)) {
			return false; // Xác nhận mật khẩu không khớp
		}

		if (userRepository.existsByUserName(username)) {
			return false; // Username đã tồn tại
		}

		user user = new user(username, password); // Có thể mã hoá mật khẩu ở đây nếu cần
		userRepository.save(user);
		return true;
	}
	public user loginUser(String username, String password) {
	    Optional<user> optionalUser = userRepository.findByUserName(username);
	    if (optionalUser.isPresent() && optionalUser.get().getPassWord().equals(password)) {
	        return optionalUser.get();
	    }
	    return null;
	}
	@Override
	public UserDTO save(UserDTO userDTO) {
		user user = IUserMapper.INSTANCE.toEntity(userDTO);
		user savedEntity = userRepository.save(user);
		UserDTO response = IUserMapper.INSTANCE.toDto(savedEntity);
		return response;
	}
}