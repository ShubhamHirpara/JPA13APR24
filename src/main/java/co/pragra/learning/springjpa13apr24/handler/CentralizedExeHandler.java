package co.pragra.learning.springjpa13apr24.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CentralizedExeHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String,String>> userExceptionHandler(){
        Map<String, String> objectMap = new HashMap<>();
        objectMap.put("1508","User Service Not Available, Please Contact App Support");
        return ResponseEntity.status(502).body(objectMap);
    }
}
