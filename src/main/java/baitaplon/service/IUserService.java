package baitaplon.service;

import org.springframework.stereotype.Service;

import baitaplon.dto.UserDTO;

@Service
public interface IUserService {
	UserDTO save(UserDTO user);
}