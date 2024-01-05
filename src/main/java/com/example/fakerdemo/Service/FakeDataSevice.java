package com.example.fakerdemo.Service;

import com.example.fakerdemo.model.Item;
import com.example.fakerdemo.model.Quantity;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.PropertyEditor;


@Service
public class FakeDataSevice {

    @Autowired
    Faker faker;
    public Item generateFakeData() {
        Item item = new Item();

        item.setOrderBaseXid(faker.idNumber().valid());
        item.setPaymentMethodCodeGid(faker.code().isbn13());
        item.setIncoTermGid(faker.number().digits(5));
        item.setOrderTypeGid(faker.idNumber().valid());
        item.setIsTemplate(faker.bool().bool());

        Quantity totalWeight = new Quantity();
        totalWeight.setValue(faker.number().randomDouble(2,300, 1500));
        totalWeight.setUnit("LB");
        item.setTotalWeight(totalWeight);

        Quantity totalVolume = new Quantity();
        totalVolume.setValue(faker.number().randomDouble(3,150, 1200));
        totalVolume.setUnit("CUMTR");
        item.setTotalVolume(totalVolume);

        item.setMustShipDirect(faker.bool().bool());
        item.setMustShipThruXDock(faker.bool().bool());
        item.setMustShipThruPool(faker.bool().bool());
        item.setIsKnownShipper(faker.bool().bool());
        item.setReleaseMethodGid("");

        return item;
    }


}
