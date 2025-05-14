package com.devteria.profile.controller;


import com.devteria.profile.dto.request.UserProfileRequest;
import com.devteria.profile.dto.response.UserProfileResponse;
import com.devteria.profile.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileController {

    UserProfileService userProfileService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    List<UserProfileResponse> getProfiles (){
        return this.userProfileService.getProfiles();
    }
    @GetMapping("/{profileId}")
    UserProfileResponse getProfile (@PathVariable String profileId){
        log.info("Get Profile have been called");
        return this.userProfileService.getProfile(profileId);
    }
}
