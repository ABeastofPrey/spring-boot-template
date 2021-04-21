package com.kuka.springtemplate.common.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import ch.qos.logback.classic.Logger;
import lombok.Getter;
import lombok.Setter;

public class Result implements Serializable {

    @SuppressWarnings("unused")
    private static final Logger log = (Logger) LoggerFactory.getLogger(Result.class);

    private static final long serialVersionUID = -1802122468331526708L;
    @Setter
    private HttpStatus status = HttpStatus.OK;
    @Setter
    @Getter
    private String message = "Handling...";
    @Setter
    @Getter
    private Map<String, Object> body = new HashMap<String, Object>();

    public Result() { }

    public Result(String message) {
        this.message = message;
    }

    public Result(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return this.status.value();
    }

    public Result putData(String key, Object value) {
        body.put(key, value);
        return this;
    }

    public Result removeData(String key) {
        body.remove(key);
        return this;
    }

    @Override
    public String toString() {
        return "Result{" + "status=" + status + ", message='" + message + '\'' + ", data=" + body + '}';
    }
}
