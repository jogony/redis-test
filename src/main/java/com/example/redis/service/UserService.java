package com.example.redis.service;

import com.example.redis.dto.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class UserService {
    private final ExternalApiService externalApiService;
    private final StringRedisTemplate redisTemplate;

    public UserProfile getUserProfile(String userId) {

        
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String cacheName = ops.get("nameKey" + userId);
        String userName;
        if(cacheName != null) {
            userName = cacheName;
        } else {
            userName = externalApiService.getUserName(userId);
            System.out.println("야");
            ops.set("nameKey" + userId, userName, 5, TimeUnit.SECONDS);
        }
        //String userName = externalApiService.getUserName(userId);
        int userAge = externalApiService.getUserAge(userId);

        return new UserProfile(userName, userAge);
    }
}
