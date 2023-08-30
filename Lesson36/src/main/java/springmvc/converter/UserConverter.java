package springmvc.converter;

import org.mapstruct.Mapper;
import springmvc.dto.CreateUserDto;
import springmvc.model.User;

@Mapper
public interface UserConverter {
  CreateUserDto toDto(User user);
}
