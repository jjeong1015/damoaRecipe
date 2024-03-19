package com.example.damoa.login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@ToString
public class LoginDTO {

    @NotNull
    private String memberEmail;
    @NotNull
    private String memberPassword;

    public LoginDTO() {
    }

    public LoginDTO(String memberEmail, String memberPassword) {
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
    }
}
