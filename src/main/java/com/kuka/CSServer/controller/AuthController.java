package com.kuka.CSServer.controller;

import javax.validation.Valid;

import com.kuka.CSServer.common.util.MiscUtil;
import com.kuka.CSServer.common.util.Result;
import com.kuka.CSServer.model.RegisterRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Result> register (@Valid @RequestBody RegisterRequest register, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Result res1 = MiscUtil.getVAlidateError(bindingResult);
            return new ResponseEntity<Result>(res1, HttpStatus.UNPROCESSABLE_ENTITY);
        }

        Result res = new Result(HttpStatus.OK, "ok");
        return ResponseEntity.ok(res);
    }
}
