package com.devteria.identity.mapper;


import com.devteria.identity.dto.request.UserCreationRequest;
import com.devteria.identity.dto.request.UserProfileRequest;
import com.devteria.identity.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    UserProfileRequest toUserProfileRequest (UserCreationRequest userCreationRequest);
}
