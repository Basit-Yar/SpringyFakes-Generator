package com.example.fakerdemo;

import com.example.fakerdemo.Service.FakeDataService;
import com.example.fakerdemo.model.Item;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootTest
public class DemoTest {

    @Autowired
    Faker faker;

    @Autowired
    FakeDataService fakeDataService;

    @Test
    public void demo_test(){

        // ============ to generate the currency code ============
            // String c = faker.currency().code();
            // System.out.println(c);
        // ============ to generate the currency code ============

//        LocalDateTime date = fakeDataService.dateTimeFormatter();
//        System.out.println(date);

        List<Item> items = fakeDataService.generateMockDataList(5);
        System.out.println(items);

    }
}