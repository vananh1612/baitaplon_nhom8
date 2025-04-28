package baitaplon.service.impl;

import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baitaplon.dto.KhoaDTO;
import baitaplon.dto.NganhDTO;
import baitaplon.mapper.IKhoaMapper;
import baitaplon.mapper.INganhMapper;
import baitaplon.model.khoa;
import baitaplon.model.nganh;
import baitaplon.reponsitory.INganhReponsitory;
import baitaplon.service.INganhService;

@Service
public class NganhService implements INganhService {
	@Autowired
	private INganhReponsitory nganhReponsitory;
	
	@Override
	public NganhDTO save(NganhDTO nganhDTO) {
		nganh entity = INganhMapper.convertToEntity(nganhDTO);         
		nganh saved = nganhReponsitory.save(entity);          
		return INganhMapper.convertToDTO(saved);                    
	}
	
	@Override
	public List<NganhDTO> findAll() {
		if (nganhReponsitory == null) {
			System.err.println("nganhReponsitory chưa được khởi tạo!");
			return Collections.emptyList(); // Tránh NullPointerException
		}

		return nganhReponsitory.findAll()
				.stream()
				.map(INganhMapper::convertToDTO)
				.collect(Collectors.toList());
	}



	@Override
	public NganhDTO addNganh(NganhDTO nganh) {
		// Kiểm tra xem đã tồn tại ID trong database chưa
		if (nganhReponsitory.existsById(nganh.getID())) {
			throw new IllegalArgumentException("Ngành với ID '" + nganh.getID() + "' đã tồn tại.");
		}

		// Chuyển đổi DTO -> Entity
		nganh entity = INganhMapper.convertToEntity(nganh);

		// Lưu vào database
		nganh saved = nganhReponsitory.save(entity);

		// Trả về DTO sau khi lưu
		return INganhMapper.convertToDTO(saved);
	}

	@Override
	public List<String> getAllID() {
		return nganhReponsitory.findAll().stream().map(nganh::getID).collect(Collectors.toList());

	}

	@Override
	public NganhDTO editNganh(NganhDTO nganhDTO) {
		if (!nganhReponsitory.existsById(nganhDTO.getID())) {
			throw new IllegalArgumentException("Không tìm thấy khoa với ID '" + nganhDTO.getID() + "'.");
		}
		// Chuyển DTO -> Entity
		nganh entity = INganhMapper.convertToEntity(nganhDTO);
		nganh updated = nganhReponsitory.save(entity);
		return INganhMapper.convertToDTO(updated);	}

	@Override
	public NganhDTO findById(String id) {
		return nganhReponsitory.findById(id).map(INganhMapper::convertToDTO)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy khoa với ID: " + id));
	}

	public void deleteKhoa(String id) {
		// Kiểm tra nếu khoa tồn tại trong DB
		if (!nganhReponsitory.existsById(id)) {
			throw new IllegalArgumentException("Khoa với ID '" + id + "' không tồn tại.");
		}
		nganhReponsitory.deleteById(id);
	}
}
