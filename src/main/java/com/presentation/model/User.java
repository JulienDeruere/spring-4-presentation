package com.presentation.model;

import javax.persistence.*;
import java.util.Date;

/**
 * User
 */
@Entity
public class User extends GenericObject {

    private String login;
    private String nickname;

    @Column(nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(nullable = false)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}