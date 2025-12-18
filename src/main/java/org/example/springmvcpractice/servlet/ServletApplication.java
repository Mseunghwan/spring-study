package org.example.springmvcpractice.servlet;

import org.example.springmvcpractice.SpringMvcPracticeApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan // 서블릿 자동 등록 -> 스프링은 기본적으로 서블릿 클래스를 자동 인식 X, 이때 이 어노테이션을 사용하면 현재 패키지 및 하위 패키지를 훑고 @WebServlet이 붙은 클래스를 찾아 서블릿 컨테이너(내장 톰캣)에 자동 등록
@SpringBootApplication
public class ServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcPracticeApplication.class, args);
    }
}
