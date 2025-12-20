package org.example.springmvcpractice.servlet.web.frontcontroller.v3.controller;

import org.example.springmvcpractice.servlet.web.frontcontroller.ModelView;
import org.example.springmvcpractice.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;


public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}