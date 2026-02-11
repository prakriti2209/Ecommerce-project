package com.authdemo;

import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;


@Data
public class UserDto {
    @NonNull
    private String Pname;
    @NonNull
    private String password;

}
