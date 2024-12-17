package com.example;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

    private String userName;  // 表单提交的用户名
    private String message;   // 展示的消息

    // 用于展示页面的逻辑
    public String showPage() {
        message = "Welcome to Struts2 Vulnerable Test!";
        return SUCCESS;
    }

    // 用于处理表单提交
    public String submitForm() {
        message = "Hello, " + userName + "!";
        return SUCCESS;
    }

    // Getter and Setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
