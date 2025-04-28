package baitaplon.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baitaplon.dto.KhoaDTO;
import baitaplon.mapper.IKhoaMapper;
import baitaplon.model.khoa;
import baitaplon.reponsitory.IKhoaReponsitory;
import baitaplon.service.IKhoaService;

@Service
public class KhoaService implements IKhoaService {

	@Autowired
	private IKhoaReponsitory khoaReponsitory;

	@Override
	public List<String> getAllID() {
		return khoaReponsitory.findAll().stream().map(khoa::getID).collect(Collectors.toList());
	}

	@Override
	public List<KhoaDTO> findAll() {
		return khoaReponsitory.findAll().stream().map(IKhoaMapper::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public KhoaDTO save(KhoaDTO khoaDTO) {
		khoa entity = IKhoaMapper.convertToEntity(khoaDTO);
		khoa saved = khoaReponsitory.save(entity);
		return IKhoaMapper.convertToDTO(saved);
	}

	@Override
	public KhoaDTO addKhoa(KhoaDTO khoaDTO) {
		// Kiểm tra xem đã tồn tại ID trong database chưa
		if (khoaReponsitory.existsById(khoaDTO.getID())) {
			throw new IllegalArgumentException("Khoa với ID '" + khoaDTO.getID() + "' đã tồn tại.");
		}

		// Chuyển đổi DTO -> Entity
		khoa entity = IKhoaMapper.convertToEntity(khoaDTO);

		// Lưu vào database
		khoa saved = khoaReponsitory.save(entity);

		// Trả về DTO sau khi lưu
		return IKhoaMapper.convertToDTO(saved);
	}

	@Override
	public KhoaDTO editKhoa(KhoaDTO khoaDTO) {
		if (!khoaReponsitory.existsById(khoaDTO.getID())) {
			throw new IllegalArgumentException("Không tìm thấy khoa với ID '" + khoaDTO.getID() + "'.");
		}
		// Chuyển DTO -> Entity
		khoa entity = IKhoaMapper.convertToEntity(khoaDTO);
		khoa updated = khoaReponsitory.save(entity);
		return IKhoaMapper.convertToDTO(updated);
	}

	@Override
	public KhoaDTO findById(String id) {
		return khoaReponsitory.findById(id).map(IKhoaMapper::convertToDTO)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy khoa với ID: " + id));
	}

	public void deleteKhoa(String id) {
		// Kiểm tra nếu khoa tồn tại trong DB
		if (!khoaReponsitory.existsById(id)) {
			throw new IllegalArgumentException("Khoa với ID '" + id + "' không tồn tại.");
		}

		// Xóa khoa
		khoaReponsitory.deleteById(id);
	}

}
