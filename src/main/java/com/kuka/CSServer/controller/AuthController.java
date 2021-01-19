package com.kuka.CSServer.controller;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestParam;

import com.kuka.CSServer.common.util.Result;
import com.kuka.CSServer.model.LoginRequest;
import com.kuka.CSServer.model.RegisterRequest;
import com.kuka.CSServer.service.AuthService;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private AuthService authService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Result> register (
        @Valid @RequestBody RegisterRequest register
        // BindingResult bindingResult
    ) {
        // if (bindingResult.hasErrors()) {
        //     Result res1 = MiscUtil.getValidateError(bindingResult);
        //     return new ResponseEntity<Result>(res1, HttpStatus.UNPROCESSABLE_ENTITY);
        // }

        Result res = new Result(HttpStatus.OK, "ok");
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<Result> login(@Valid @RequestBody LoginRequest authRequest) throws AuthenticationException{
		final String token = authService.login(authRequest.getAccount(), authRequest.getPassword());
        // Return the token
        Result res = new Result(HttpStatus.OK, "ok");
        res.putData("token", token);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Result> refresh(HttpServletRequest request, @RequestParam String token) throws AuthenticationException{
    	
    	Result res = new Result(HttpStatus.OK, "ok");
        String refreshedToken = authService.refresh(token);
        
        if(refreshedToken == null) {
        	res.setStatus(HttpStatus.BAD_REQUEST);
        	res.setMessage("Invalid token");
            return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);
        } 
        
        res.putData("token", token);
        return ResponseEntity.ok(res);
    }
}
