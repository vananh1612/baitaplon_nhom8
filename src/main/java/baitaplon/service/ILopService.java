package baitaplon.service;

import org.springframework.stereotype.Service;

import baitaplon.dto.LopDTO;

@Service
public interface ILopService {
	LopDTO save(LopDTO lop);
}