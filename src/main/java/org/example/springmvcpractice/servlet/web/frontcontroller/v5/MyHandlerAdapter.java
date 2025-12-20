package org.example.springmvcpractice.servlet.web.frontcontroller.v5;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.springmvcpractice.servlet.web.frontcontroller.ModelView;

import java.io.IOException;


public interface MyHandlerAdapter {
    // 1. 이 어댑터가 해당 컨트롤러(핸들러)를 처리할 수 있는지 확인
    boolean supports(Object handler);

    // 2. 실제 컨트롤러를 호출하고, 결과는 무조건 ModelView로 맞춰서 반환
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
