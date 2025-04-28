package baitaplon.service;

import java.util.List;
import baitaplon.dto.KhoaDTO;

public interface IKhoaService {
    
    // Lưu thông tin khoa (có thể dùng cho cập nhật)
    KhoaDTO save(KhoaDTO khoa);

    // Thêm mới khoa, kiểm tra trùng ID
    KhoaDTO addKhoa(KhoaDTO khoa);

    // Lấy danh sách tất cả ID của khoa
    List<String> getAllID();
    // lấy tất cả danh sách khoa
    List<KhoaDTO> findAll();
 // Thêm vào interface
    KhoaDTO editKhoa(KhoaDTO khoaDTO);
    KhoaDTO findById(String id);
}
