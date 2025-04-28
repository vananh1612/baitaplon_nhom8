package baitaplon.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import baitaplon.dto.UserDTO;
import baitaplon.model.user;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))public interface IUserMapper {
	IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

	@Mapping(source = "ID", target = "ID")
	@Mapping(source = "username", target = "userName")
	@Mapping(source = "password", target = "passWord")

	user toEntity(UserDTO userDTO);

	@Mapping(source = "ID", target = "ID")
	@Mapping(source = "userName", target = "username")
	@Mapping(source = "passWord", target = "password")
	UserDTO toDto(user user);
}