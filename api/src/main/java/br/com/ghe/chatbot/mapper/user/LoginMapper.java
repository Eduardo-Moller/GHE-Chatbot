package br.com.ghe.chatbot.mapper.user;

import br.com.ghe.chatbot.controller.dto.response.user.LoginResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
public interface LoginMapper {

    LoginResponse toResponse(String accessToken);
}
