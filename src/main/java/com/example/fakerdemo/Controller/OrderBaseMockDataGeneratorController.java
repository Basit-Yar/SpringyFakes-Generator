package com.example.fakerdemo.Controller;

import com.example.fakerdemo.Service.OrderBaseService;
import com.example.fakerdemo.model.OrderBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderBaseMockDataGeneratorController {

    @Autowired
    OrderBaseService orderBaseService;

    @GetMapping("/order-base")
    public ResponseEntity<List<OrderBase>> getFakePerson(@RequestParam(defaultValue = "10") int limit) {
        List<OrderBase> orderBases = orderBaseService.generateMockDataList(limit);
        return new ResponseEntity<>(orderBases, HttpStatus.OK);
    }
}
