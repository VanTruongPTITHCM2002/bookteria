package com.devteria.profile.service.impl;

import com.devteria.profile.dto.request.UserProfileRequest;
import com.devteria.profile.dto.response.UserProfileResponse;
import com.devteria.profile.entity.UserProfile;
import com.devteria.profile.mapper.UserProfileMapper;
import com.devteria.profile.repository.UserProfileRepository;
import com.devteria.profile.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileServiceImpl implements UserProfileService {
        UserProfileRepository userProfileRepository;
        UserProfileMapper userProfileMapper;

        @Override
        public List<UserProfileResponse> getProfiles() {
                return this.userProfileRepository.findAll().stream().map(userProfileMapper::toUserProfileResponse).toList();
        }

        @Override
        public UserProfileResponse createProfile(UserProfileRequest userProfileRequest) {

                UserProfile userProfile = this.userProfileMapper.toUserProfile(userProfileRequest);
                userProfile = this.userProfileRepository.save(userProfile);
                return userProfileMapper.toUserProfileResponse(userProfile);
        }

        @Override
        public UserProfileResponse getProfile(String profileId) {
                UserProfile userProfile = this.userProfileRepository.findById(profileId)
                        .orElseThrow(
                                () -> new RuntimeException("Profile not found")
                        )
                        ;

                return userProfileMapper.toUserProfileResponse(userProfile);
        }
}
