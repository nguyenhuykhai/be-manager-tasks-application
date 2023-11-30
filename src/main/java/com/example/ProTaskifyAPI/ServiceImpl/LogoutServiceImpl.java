package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.Repositories.TokensRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class LogoutServiceImpl implements LogoutHandler {
    private final TokensRepo tokensRepo;

    @Override
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Authentication authentication
    ) {
        final String authHeader = request.getHeader("Authorization");
        final String token;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        token = authHeader.substring(7);
        var storageToken = tokensRepo.findByToken(token).orElse(null);
        if(storageToken != null) {
            storageToken.setExpired(true);
            storageToken.setRevoke(true);
            tokensRepo.save(storageToken);
        }
    }
}
