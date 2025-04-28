package baitaplon.service;

import java.util.List;
import org.springframework.stereotype.Service;
import baitaplon.dto.LopDTO;

public interface ILopService {
	LopDTO save(LopDTO lopDTO);

	LopDTO addLop(LopDTO lop);

	List<String> getAllID();

	List<LopDTO> findAll();

	LopDTO editLop(LopDTO lopDTO);

	LopDTO findById(String id);
}