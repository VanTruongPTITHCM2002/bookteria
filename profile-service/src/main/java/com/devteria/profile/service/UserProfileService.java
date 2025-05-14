package com.devteria.profile.service;

import com.devteria.profile.dto.request.UserProfileRequest;
import com.devteria.profile.dto.response.UserProfileResponse;

import java.util.List;

public interface UserProfileService {
    List<UserProfileResponse> getProfiles();
    UserProfileResponse createProfile (UserProfileRequest userProfileRequest);
    UserProfileResponse getProfile (String profileId);
}
