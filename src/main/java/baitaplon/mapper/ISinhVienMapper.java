package baitaplon.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import baitaplon.dto.SinhVienDTO;
import baitaplon.model.sinhvien;

public interface ISinhVienMapper {
	public static sinhvien convertToEntity(SinhVienDTO dto) {
		sinhvien entity = new sinhvien();
		entity.setID(dto.getID());
		entity.setMaSinhVien(dto.getMa_sinh_vien());
		entity.setHoTen(dto.getHo_ten());
		entity.setNgaySinh(dto.getNgay_sinh());
		entity.setEmail(dto.getEmail());
		entity.setSdt(dto.getSdt());
		entity.setDiaChi(dto.getDia_chi());
		entity.setHeDT(dto.getHedt());
		entity.setNamHoc(dto.getNam_hoc());
		entity.setID_lop_thuocDB(dto.getID_lop());
		return entity;
	}

	public static SinhVienDTO convertToDTO(sinhvien entity) {
		SinhVienDTO dto = new SinhVienDTO();
		dto.setID(entity.getID());
		dto.setMa_sinh_vien(entity.getMaSinhVien());
		dto.setHo_ten(entity.getHoTen());
		dto.setNgay_sinh(entity.getNgaySinh());
		dto.setEmail(entity.getEmail());
		dto.setSdt(entity.getSdt());
		dto.setDia_chi(entity.getDiaChi());
		dto.setHedt(entity.getHeDT());
		dto.setNam_hoc(entity.getNamHoc());
		// lấy từ object khoa nếu cần (khi hiển thị)
		if (entity.getID_lop() != null) {
			dto.setID_lop(entity.getID_lop().getID());
		} else if (entity.getID_lop_thuocDB() != null) {
			dto.setID_lop(entity.getID_lop_thuocDB());
		}
		return dto;
	}

}