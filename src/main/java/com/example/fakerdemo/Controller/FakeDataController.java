package com.example.fakerdemo.Controller;

import com.example.fakerdemo.Service.FakeDataService;
import com.example.fakerdemo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class FakeDataController {

    @Autowired
    FakeDataService fakeDataService;

    @GetMapping("/order-base")
    public ResponseEntity<List<Item>> getFakePerson(@RequestParam int limit) {
        List<Item> items = fakeDataService.generateMockDataList(limit);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
