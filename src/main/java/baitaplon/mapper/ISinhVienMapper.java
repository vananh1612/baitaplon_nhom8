package baitaplon.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import baitaplon.dto.SinhVienDTO;
import baitaplon.model.sinhvien;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface ISinhVienMapper {
	ISinhVienMapper INSTANCE = Mappers.getMapper(ISinhVienMapper.class);

	@Mapping(source = "ID", target = "ID")
	@Mapping(source = "ho_ten", target = "hoTen")
	@Mapping(source = "ngay_sinh", target = "ngaySinh")
	@Mapping(source = "email", target = "email")
	@Mapping(source = "sdt", target = "sdt")
	@Mapping(source = "dia_chi", target = "diaChi")
	@Mapping(source = "hedt", target = "heDT")
	@Mapping(source = "nam_hoc", target = "namHoc")
	@Mapping(source = "ID_nganh", target = "ID_nganh")
	@Mapping(source = "ID_lop", target = "ID_lop")
	@Mapping(source = "ID_khoa", target = "ID_khoa")

	sinhvien toEntity(SinhVienDTO sinhVienDTO);
}
