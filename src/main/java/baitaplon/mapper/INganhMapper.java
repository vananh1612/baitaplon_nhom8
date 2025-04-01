package baitaplon.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import baitaplon.dto.NganhDTO;
import baitaplon.model.nganh;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface INganhMapper {
	INganhMapper INSTANCE = Mappers.getMapper(INganhMapper.class);

	@Mapping(source = "ID", target = "ID")
	@Mapping(source = "ID_khoa", target = "ID_khoa")
	@Mapping(source = "tenNganh", target = "tenNganh")

	nganh toEntity(NganhDTO nganhDTO);
}
