package baitaplon.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baitaplon.dto.SinhVienDTO;
import baitaplon.mapper.ISinhVienMapper;
import baitaplon.model.sinhvien;
import baitaplon.reponsitory.ISinhVienReponsitory;
import baitaplon.service.ISinhVienService;

@Service

public class SinhVienService implements ISinhVienService {
	@Autowired
	private ISinhVienReponsitory sinhVienReponsitory;

	
	@Override
	public List<String> getAllID() {
		return sinhVienReponsitory.findAll().stream().map(sinhvien::getID).collect(Collectors.toList());

	}

	
	public void deleteSinhVien(String id) {
		if (!sinhVienReponsitory.existsById(id)) {
			throw new IllegalArgumentException("Sinh vien với ID '" + id + "' không tồn tại.");
		}

		sinhVienReponsitory.deleteById(id);
	}

	@Override
	public SinhVienDTO save(SinhVienDTO sv) {
		sinhvien entity = ISinhVienMapper.convertToEntity(sv);
		sinhvien saved = sinhVienReponsitory.save(entity);
		return ISinhVienMapper.convertToDTO(saved);
	}

	@Override
	public SinhVienDTO addSinhVien(SinhVienDTO sv) {
		sinhvien entity = ISinhVienMapper.convertToEntity(sv);
		sinhvien saved = sinhVienReponsitory.save(entity);
		return ISinhVienMapper.convertToDTO(saved);
	}

	@Override
	public SinhVienDTO editSinhVien(SinhVienDTO sinhVienDTO) {
		if (!sinhVienReponsitory.existsById(sinhVienDTO.getID())) {
			throw new IllegalArgumentException("Không tìm thấy khoa với ID '" + sinhVienDTO.getID() + "'.");
		}
		// Chuyển DTO -> Entity
		sinhvien entity = ISinhVienMapper.convertToEntity(sinhVienDTO);
		sinhvien updated = sinhVienReponsitory.save(entity);
		return ISinhVienMapper.convertToDTO(updated);
	}


	@Override
	public List<SinhVienDTO> findAll() {
		if (sinhVienReponsitory == null) {
			System.err.println("lop chưa được khởi tạo!");
			return Collections.emptyList(); // Tránh NullPointerException
		}

		return sinhVienReponsitory.findAll().stream().map(ISinhVienMapper::convertToDTO).collect(Collectors.toList());
	}


	@Override
	public SinhVienDTO findById(String id) {
		return sinhVienReponsitory.findById(id).map(ISinhVienMapper::convertToDTO)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy lớp với ID: " + id));
	}

}
