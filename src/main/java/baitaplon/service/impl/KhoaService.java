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

	public List<String> getAllID() {
		return khoaReponsitory.findAll().stream().map(khoa::getID) // Lấy tên khoa từ mỗi đối tượng
				.collect(Collectors.toList());

	}

	@Override
	public KhoaDTO save(KhoaDTO khoaDTO) {
		khoa khoa = IKhoaMapper.convertToEntity(khoaDTO);
		khoa savedEntity = khoaReponsitory.save(khoa);
		KhoaDTO response = IKhoaMapper.convertToDTO(savedEntity);
		return response;
	}

}