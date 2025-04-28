package baitaplon.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import baitaplon.dto.LopDTO;
import baitaplon.dto.NganhDTO;
import baitaplon.model.lop;
import baitaplon.model.nganh;

public interface ILopMapper {
	public static lop convertToEntity(LopDTO dto) {
		lop entity = new lop();
		entity.setID(dto.getID());
		entity.setTenLop(dto.getTen_lop());
		entity.setID_nganh_thuocDB(dto.getID_nganh());

		return entity;
	}

	public static LopDTO convertToDTO(lop entity) {
		LopDTO dto = new LopDTO();
		dto.setID(entity.getID());
		dto.setTen_lop(entity.getTenLop());

		// lấy từ object khoa nếu cần (khi hiển thị)
		if (entity.getID_nganh() != null) {
			dto.setID_nganh(entity.getID_nganh().getID());
		} else if (entity.getID_nganh_thuocDB() != null) {
			dto.setID_nganh(entity.getID_nganh_thuocDB());
		}
		return dto;
	}
}
