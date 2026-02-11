package com.authdemo;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/public")
public class UserController {
    private UserService userservice;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody UserDto user){
        String token=this.userservice.register(user);
        return ResponseEntity.ok(new ResponseMessage(token));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userdto){
       String token=this.userservice.login(userdto);
       return ResponseEntity.ok(new ResponseMessage(token));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
      public ResponseEntity<?> sqlIntegritiConstraintException(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("username already exist"));
   }
//
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<> noSuchElementfound(){
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseMessage("username not found"));
//    }

}
