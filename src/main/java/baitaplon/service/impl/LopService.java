package baitaplon.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baitaplon.dto.LopDTO;
import baitaplon.mapper.ILopMapper;
import baitaplon.mapper.INganhMapper;
import baitaplon.model.lop;
import baitaplon.model.nganh;
import baitaplon.reponsitory.ILopReponsitory;
import baitaplon.service.ILopService;

@Service

public class LopService implements ILopService {
	@Autowired
	private ILopReponsitory lopReponsitory;

	@Override
	public LopDTO save(LopDTO lopDTO) {
		lop entity = ILopMapper.convertToEntity(lopDTO);
		lop saved = lopReponsitory.save(entity);
		return ILopMapper.convertToDTO(saved);
	}

	@Override
	public LopDTO addLop(LopDTO lop) {
		lop entity = ILopMapper.convertToEntity(lop);
		lop saved = lopReponsitory.save(entity);
		return ILopMapper.convertToDTO(saved);
	}

	@Override
	public List<String> getAllID() {
		return lopReponsitory.findAll().stream().map(lop::getID).collect(Collectors.toList());

	}

	@Override
	public List<LopDTO> findAll() {
		if (lopReponsitory == null) {
			System.err.println("lop chưa được khởi tạo!");
			return Collections.emptyList(); // Tránh NullPointerException
		}

		return lopReponsitory.findAll().stream().map(ILopMapper::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public LopDTO editLop(LopDTO lopDTO) {
		if (!lopReponsitory.existsById(lopDTO.getID())) {
			throw new IllegalArgumentException("Không tìm thấy khoa với ID '" + lopDTO.getID() + "'.");
		}
		// Chuyển DTO -> Entity
		lop entity = ILopMapper.convertToEntity(lopDTO);
		lop updated = lopReponsitory.save(entity);
		return ILopMapper.convertToDTO(updated);
	}

	@Override
	public LopDTO findById(String id) {
		return lopReponsitory.findById(id).map(ILopMapper::convertToDTO)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy lớp với ID: " + id));
	}

	public void deleteLop(String id) {
		// Kiểm tra nếu khoa tồn tại trong DB
		if (!lopReponsitory.existsById(id)) {
			throw new IllegalArgumentException("Khoa với ID '" + id + "' không tồn tại.");
		}

		// Xóa khoa
		lopReponsitory.deleteById(id);
	}

}
