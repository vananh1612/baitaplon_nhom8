package baitaplon.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import baitaplon.dto.LopDTO;
import baitaplon.model.lop;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface ILopMapper {
	ILopMapper INSTANCE = Mappers.getMapper(ILopMapper.class);

	@Mapping(source = "ID", target = "ID")
	@Mapping(source = "ten_lop", target = "tenLop")
	@Mapping(source = "ID_nganh", target = "ID_nganh")

	lop toEntity(LopDTO lopDTO);
}
