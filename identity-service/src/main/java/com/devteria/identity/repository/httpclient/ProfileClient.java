package com.devteria.identity.repository.httpclient;

import com.devteria.identity.configuration.AuthenticationRequestInterceptor;
import com.devteria.identity.dto.request.UserProfileRequest;
import com.devteria.identity.dto.response.UserProfileResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "profile-service", url = "${app.service.internal-profile}", configuration = AuthenticationRequestInterceptor.class)
public interface ProfileClient {
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    UserProfileResponse createProfile (@RequestBody UserProfileRequest userProfileRequest);

}
