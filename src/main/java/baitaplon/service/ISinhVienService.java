package baitaplon.service;

import org.springframework.stereotype.Service;

import baitaplon.dto.SinhVienDTO;

@Service
public interface ISinhVienService {
	SinhVienDTO save(SinhVienDTO sv);
}