package com.example.demo.executor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
@Data
public class ExecutorService {
    private List<Integer> numbers = new ArrayList<>();

    @SneakyThrows
    //Tarda 10 segundos en agregar cada número
    public boolean addNumber(Integer n){
        Thread.sleep(10000);
        numbers.add(n);
        return true;
    }




}
