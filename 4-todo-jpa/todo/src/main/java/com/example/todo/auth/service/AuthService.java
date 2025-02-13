package com.example.todo.auth.service;

import com.example.todo.exception.CustomException;
import com.example.todo.exception.ExceptionType;
import com.example.todo.config.security.PasswordEncoder;
import com.example.todo.user.domain.User;
import com.example.todo.auth.dto.LoginUserRequest;
import com.example.todo.user.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * 로그인, 인증, 세션/쿠키 관리
 */
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    public void login(
            LoginUserRequest request,
            HttpServletRequest httpRequest,
            HttpServletResponse httpResponse
                      ) {
        User user = authenticate(request.getEmail(),request.getPassword());

        // 세션 생성
        HttpSession session = httpRequest.getSession(true);
        session.setAttribute("user",user.getId());

        // 세션 ID 쿠키로 전달 -> Spring Boot가 자동으로 추가해줌
//        Cookie sessionCookie = new Cookie("JSESSIONID", session.getId());
//        sessionCookie.setHttpOnly(true);
//        sessionCookie.setPath("/");
//        sessionCookie.setMaxAge(60 * 60);
//        httpResponse.addCookie(sessionCookie);
    }

    private User authenticate(String email, String password) {
        User user = userService.getUserByEmail(email);
        checkPasswordMatch(password,user.getPassword());
        return user;
    }

    private void checkPasswordMatch(String inputPassword, String storedPassword) {
        if(!passwordEncoder.matches(inputPassword, storedPassword)) {
            throw new CustomException(ExceptionType.INVALID_CREDENTIALS);
        }
    }

    public void logout(
            HttpServletRequest httpRequest,
            HttpServletResponse httpResponse
    ) {
        HttpSession session = httpRequest.getSession(false);
        if(session != null) {
            session.invalidate();
        }

        // delete sessionId cookie
        Cookie sessionCookie = new Cookie("JSESSIONID", null);
        sessionCookie.setMaxAge(0);
        sessionCookie.setPath("/");
        httpResponse.addCookie(sessionCookie);
    }
}
