package org.example.springmvcpractice.servlet.web.frontcontroller.v2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.springmvcpractice.servlet.web.frontcontroller.MyView;
import org.example.springmvcpractice.servlet.web.frontcontroller.v2.ControllerV2;

import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 복잡한 로직 없이 뷰 객체만 쿨하게 던진다.
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
