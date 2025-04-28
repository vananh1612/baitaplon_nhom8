package baitaplon.service;


import java.util.List;

import baitaplon.dto.SinhVienDTO;

public interface ISinhVienService {
	SinhVienDTO save(SinhVienDTO sv);

	SinhVienDTO addSinhVien(SinhVienDTO sv);

	List<String> getAllID();

	List<SinhVienDTO> findAll();

	SinhVienDTO editSinhVien(SinhVienDTO sinhVienDTO);

	SinhVienDTO findById(String id);
}