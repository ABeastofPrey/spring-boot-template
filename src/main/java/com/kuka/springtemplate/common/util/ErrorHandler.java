package com.kuka.springtemplate.common.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ControllerAdvice
public class ErrorHandler {
    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    /**
	 * 输入参数校验异常
	 */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Result> NotValidExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException e) throws Exception {
        log.debug("MethodArgumentNotValidException Error details", e);
        BindingResult bindingResult = e.getBindingResult();
        Result res = MiscUtil.getValidateError(bindingResult);
        return new ResponseEntity<Result>(res, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    /**
	 * 404异常处理
	 */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseEntity<Result> NoHandlerFoundExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        log.debug("NoHandlerFoundException details", "Page not found!");
        Result res = new Result(HttpStatus.NOT_FOUND, "Page not found");
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
    /**
	 *  默认异常处理，前面未处理
	 */
	@ExceptionHandler(value = Throwable.class)
    public ResponseEntity<Result> defaultHandler(HttpServletRequest req, Exception e) throws Exception {
        Result res = new Result(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
        log.debug("INTERNAL_SERVER_ERROR details", e);
        return new ResponseEntity<Result>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
