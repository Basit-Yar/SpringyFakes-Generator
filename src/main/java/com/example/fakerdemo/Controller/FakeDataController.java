package com.example.fakerdemo.Controller;

import com.example.fakerdemo.Service.FakeDataService;
import com.example.fakerdemo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FakeDataController {

    @Autowired
    FakeDataService fakeDataSevice;

    @GetMapping("/fake-items")
    public ResponseEntity<Item> getFakePerson() {
        Item item = fakeDataSevice.generateFakeData();
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
}
