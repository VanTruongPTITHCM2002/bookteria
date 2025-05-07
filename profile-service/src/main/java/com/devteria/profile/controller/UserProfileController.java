package com.devteria.profile.controller;


import com.devteria.profile.dto.request.UserProfileRequest;
import com.devteria.profile.dto.response.UserProfileResponse;
import com.devteria.profile.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {

    UserProfileService userProfileService;


    @PostMapping
    UserProfileResponse createProfile(@RequestBody UserProfileRequest userProfileRequest){
        return this.userProfileService.createProfile(userProfileRequest);
    }

    @GetMapping("/{profileId}")
    UserProfileResponse getProfile (@PathVariable String profileId){
        return this.userProfileService.getProfile(profileId);
    }
}
