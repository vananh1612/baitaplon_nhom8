package baitaplon.mapper;

import baitaplon.dto.KhoaDTO;
import baitaplon.model.khoa;

public interface IKhoaMapper {
	public static khoa convertToEntity(KhoaDTO dto) {
		khoa entity = new khoa();
		entity.setID(dto.getID());
		entity.setTenKhoa(dto.getTen_khoa());
		return entity;
	}

	public static KhoaDTO convertToDTO(khoa entity) {
		KhoaDTO dto = new KhoaDTO();
		dto.setID(entity.getID());
		dto.setTen_khoa(entity.getTenKhoa());

		return dto;
	}
}
