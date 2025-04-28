package baitaplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import baitaplon.dto.NganhDTO;

public interface INganhService {
	NganhDTO save(NganhDTO nganhDTO);

	NganhDTO addNganh(NganhDTO nganh);

	List<String> getAllID();

	List<NganhDTO> findAll();

	NganhDTO editNganh(NganhDTO nganhDTO);

	NganhDTO findById(String id);
}