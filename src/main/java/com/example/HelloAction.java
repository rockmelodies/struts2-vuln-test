package com.example;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

    private String message;

    @Override
    public String execute() throws Exception {
        message = "Hello, Struts2!";
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }
}
