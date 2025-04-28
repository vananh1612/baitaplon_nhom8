package baitaplon.mapper;

import baitaplon.dto.NganhDTO;
import baitaplon.model.khoa;
import baitaplon.model.nganh;

public interface INganhMapper {

	public static nganh convertToEntity(NganhDTO dto) {
	    nganh entity = new nganh();
	    entity.setID(dto.getID());
	    entity.setTenNganh(dto.getTen_nganh());

	    entity.setID_khoa_thuocDB(dto.getID_khoa());

	    return entity;
	}


	public static NganhDTO convertToDTO(nganh entity) {
	    NganhDTO dto = new NganhDTO();
	    dto.setID(entity.getID());
	    dto.setTen_nganh(entity.getTenNganh());

	    // lấy từ object khoa nếu cần (khi hiển thị)
	    if (entity.getID_khoa() != null) {
	        dto.setID_khoa(entity.getID_khoa().getID());
	    } else if (entity.getID_khoa_thuocDB() != null) {
	        dto.setID_khoa(entity.getID_khoa_thuocDB());
	    }

	    return dto;
	}


}
