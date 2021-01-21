package com.kuka.springtemplate.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class MiscUtil {
    static public Result getValidateError(BindingResult bindingResult) {
        if(bindingResult.hasErrors() == false) return null;
        Map<String, String> fieldErrors = new HashMap<String, String>();
        for(FieldError error : bindingResult.getFieldErrors()) {
            fieldErrors.put(error.getField(), error.getCode() + "|" + error.getDefaultMessage());
        }
        Result ret = new Result(HttpStatus.UNPROCESSABLE_ENTITY, "Input error");
        ret.putData("fieldErrors", fieldErrors);
        return ret;
    }

    public static String toHexString(byte[] array) {
        return DatatypeConverter.printHexBinary(array);
    }

    public static byte[] toByteArray(String s) {
        return DatatypeConverter.parseHexBinary(s);
    }
}
