package com.ke.web;

import com.ke.entity.User;
import com.ke.service.UserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 版本一
 */
@Controller("userAction3")
@Scope("prototype")
public class UserActionByModel implements ModelDriven<User>,Action {

    //定义存放到值栈中的对象
    private User user = new User();
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    //依赖service
    @Resource
    private UserService userService;

    //模型驱动
    public String saveUser(){
        user.setUserName("ke6");
        user.setUserState("2");
        String msg = userService.saveUser(user);
        User serviceUser = userService.getUser(14L);
        if (serviceUser == null) {
            ServletActionContext.getRequest().setAttribute("error_msg","错误了");
            return ERROR;
        }
        ServletActionContext.getRequest().setAttribute("msg",serviceUser.getUserName());
        return SUCCESS;
    }


    @Override
    public User getModel() {
        return user;
    }

    @Override
    public String execute() throws Exception {
        return null;
    }
}
