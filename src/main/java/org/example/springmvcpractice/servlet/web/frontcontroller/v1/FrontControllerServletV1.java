package org.example.springmvcpractice.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.springmvcpractice.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import org.example.springmvcpractice.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import org.example.springmvcpractice.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// /frontcontroller/v1/ 포함한 모든 하위 요청을 이 서블릿이 받는다.
@WebServlet(name="frontControllerServletV1", urlPatterns = "/frontcontroller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        // 생성될 때 매핑 정보를 미리 담아둔다.
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("FrontControllerServletV1.service");
        String requestURI = request.getRequestURI(); // 요청온 URI를 조회한다.

        // Map에서 URI에 맞는 컨트롤러를 찾는다.
        ControllerV1 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 없으면 404 에러
            return;
        }

        // 다형성 덕분에 인터페이스의 process()만 호출하면 실제 구현체의 로직이 실행된다.
        controller.process(request, response);
    }
}