package com.np.wearound.service;

import java.util.Set;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TokenBlacklistService {
	private final RedisTemplate<String, String> redisTemplate;
    private static final String BLACKLIST_KEY = "blackToken";

    public TokenBlacklistService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void blacklistToken(String token) {
        redisTemplate.opsForSet().add(BLACKLIST_KEY, token);
    }

    public boolean isTokenBlacklisted(String token) {
        return redisTemplate.opsForSet().isMember(BLACKLIST_KEY, token);
    }

    public Set<String> getBlacklistedTokens() {
        return redisTemplate.opsForSet().members(BLACKLIST_KEY);
    }
}
