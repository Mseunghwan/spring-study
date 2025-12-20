package org.example.springmvcpractice.servlet.web.frontcontroller.v4;

import org.example.springmvcpractice.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV4 {
    /**
     * @param paramMap 파라미터 맵
     * @param model 모델 맵 (값을 담을 빈 그릇을 미리 넘겨줌)
     * @return viewName 뷰의 논리 이름
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
