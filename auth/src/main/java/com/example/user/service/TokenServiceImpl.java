package com.example.user.service;

import com.example.user.domain.request.TeamRequest;
import com.example.user.domain.response.UserResponse;
import com.example.user.global.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final RestTemplate restTemplate;
    @Override
    public UserDto getUserInfoFromToken(String token) {
        TeamRequest request = new TeamRequest("박현서", "9390");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", token);
        HttpEntity<TeamRequest> requestEntity = new HttpEntity<>(
                request,
                httpHeaders
        );
        System.out.println("hihihihihihi====================");

        Map res = restTemplate
                .postForEntity(
                        "http://192.168.0.12:8080/api/v1/auth/token"
                        , requestEntity
                        , Map.class
                ).getBody();


        System.out.println("byebybyebyebyyebe====================");
        return UserDto.from(res);

    }
}
