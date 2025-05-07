package com.devteria.profile.service;

import com.devteria.profile.dto.request.UserProfileRequest;
import com.devteria.profile.dto.response.UserProfileResponse;

public interface UserProfileService {
    UserProfileResponse createProfile (UserProfileRequest userProfileRequest);
    UserProfileResponse getProfile (String profileId);
}
