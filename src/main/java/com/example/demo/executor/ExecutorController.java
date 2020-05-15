package com.example.demo.executor;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Future;

@RequestMapping("api/executor")
@RestController
@AllArgsConstructor
public class ExecutorController {
    private  final ExecutorService service;


    @SneakyThrows
    @GetMapping("/run")
    @Async
    public Future<String> execute(){
        for (int i = 0; i <  5; i++) {
            service.addNumber(i);
        }
        return new AsyncResult<String>("Running process");
    }

    @GetMapping("/numbers")
    public List<Integer> getNumbersList(){
        return service.getNumbers();
    }
}
