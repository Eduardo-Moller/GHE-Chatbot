package br.com.ghe.chatbot.mapper.user;

import br.com.ghe.chatbot.controller.dto.request.user.RegisterUserRequest;
import br.com.ghe.chatbot.controller.dto.response.user.UserResponse;
import br.com.ghe.chatbot.domain.UserDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
public interface RegisterUserMapper {

    @Mapping(target = "id", ignore = true)
    UserDomain toEntity(RegisterUserRequest request);

    UserResponse toResponse(UserDomain user);
}
