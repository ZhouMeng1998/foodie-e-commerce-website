package com.imooc.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserBO", description = "encapsulate the JSON data into a UserBO class")
public class UserBO {
    @ApiModelProperty(value = "username", notes = "username", example = "tuskAlpha", required = true)
    private String username;
    @ApiModelProperty(value = "password", notes = "password", example = "1232141", required = true)
    private String password;
    @ApiModelProperty(value = "confirmPassword", notes = "confirmPassword", example = "123213", required = false)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
