package com.ke.web;

import com.ke.entity.User;
import com.ke.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

    //定义存放到值栈中的对象
    private User user;
    private String userCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private String userPassword;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //依赖service
    @Resource
    private UserService userService;

    public String m1(){
        user =  userService.getUser(9L);
        System.out.println(user.getUserCode());
        return SUCCESS;
    }

    //属性驱动
    public String saveUser1(){
        user.setUserName("ke3");
        user.setUserState("2");
        String msg = userService.saveUser(user);
        User serviceUser = userService.getUser(10L);
        if (serviceUser == null) {
            ServletActionContext.getRequest().setAttribute("error_msg","错误了");
            return ERROR;
        }
        ServletActionContext.getRequest().setAttribute("msg",serviceUser.getUserName());
        return SUCCESS;
    }

    public String saveUser2(){
        User user1 = new User();
        String userCode = ServletActionContext.getRequest().getParameter("userCode");
        String userPassword = ServletActionContext.getRequest().getParameter("userPassword");
        user1.setUserCode(userCode);
        user1.setUserPassword(userPassword);
        user1.setUserName("ke3");
        user1.setUserState("2");
        String msg = userService.saveUser(user1);
        User serviceUser = userService.getUser(10L);
        if (serviceUser == null) {
            ServletActionContext.getRequest().setAttribute("error_msg","错误了");
            return ERROR;
        }
        ServletActionContext.getRequest().setAttribute("msg",serviceUser.getUserName());
        return SUCCESS;
    }


}
