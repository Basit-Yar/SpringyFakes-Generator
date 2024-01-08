package com.example.fakerdemo.Service;

import com.example.fakerdemo.model.Currency;
import com.example.fakerdemo.model.DateClass.DateClass;
import com.example.fakerdemo.model.Item;
import com.example.fakerdemo.model.Quantity;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class FakeDataService {

    @Autowired
    Faker faker;

    public List<Item> generateMockDataList(int limit){
        List<Item> items = new ArrayList<>();

        for(int i=0; i<limit; i++){
            Item item = generateFakeData();
            items.add(item);
        }
        return items;
    }
    public Item generateFakeData() {
        Item item = new Item();

        item.setOrderBaseXid(faker.idNumber().valid());
        item.setPaymentMethodCodeGid(faker.code().isbn13());
        item.setIncoTermGid(faker.number().digits(5));
        item.setOrderTypeGid(faker.idNumber().valid());
        item.setIsTemplate(faker.bool().bool());

        Quantity totalWeight = new Quantity();
        totalWeight.setValue(faker.number().randomDouble(7,200, 800));
        totalWeight.setUnit("LB");
        item.setTotalWeight(totalWeight);

        Quantity totalVolume = new Quantity();
        totalVolume.setValue(faker.number().randomDouble(3,105, 1200));
        totalVolume.setUnit("CUMTR");
        item.setTotalVolume(totalVolume);

        item.setMustShipDirect(faker.bool().bool());
        item.setMustShipThruXDock(faker.bool().bool());
        item.setMustShipThruPool(faker.bool().bool());
        item.setIsKnownShipper(faker.bool().bool());
        item.setReleaseMethodGid(faker.letterify("???-????-???", true));

        item.setTotalNetWeight(new Quantity(faker.number().randomDouble(1,0,100), "LB"));
        item.setTotalNetVolume(new Quantity(faker.number().randomDouble(1,0,100), "CUMTR"));

        item.setBundlingType(faker.letterify("??????", true));

//        item.setTotalDeclaredValue(new Currency(faker.number().randomDouble(1, 0, 500),"USD"));
        item.setTotalDeclaredValue(new Currency(faker.number().randomDouble(1, 0, 500),faker.currency().code()));
        item.setCustomerUnitizationRequest(faker.bool().bool());
        item.setPriority(faker.number().numberBetween(1,4));

        item.setDomainName(faker.letterify("TW/???/???", true));
        item.setAttribute1(faker.letterify("TW.???", true));
        item.setAttribute2(faker.letterify("TW.???", true));
        item.setAttribute3(faker.letterify("TW.???", true));
        item.setAttribute4(faker.letterify("TW.???", true));
        item.setAttribute5(faker.letterify("TW.???", true));
        item.setAttribute6(faker.letterify("TW.???", true));
        item.setAttribute7(faker.letterify("TW.???", true));
        item.setAttribute8(faker.letterify("TW.???", true));
        item.setAttribute9(faker.letterify("TW.???", true));
        item.setAttribute19(faker.letterify("TW.???", true));

        item.setAttributeNumber1(faker.number().randomDouble(2,0,2500));
        item.setAttributeNumber2(faker.number().randomDouble(2,0,2500));
        item.setAttributeNumber10(faker.number().randomDouble(2,0,2500));

        item.setAttributeDate1(new DateClass(dateTimeFormatter()));

        item.setAttributeCurrency3(new Currency(faker.number().randomDouble(2,0,2000), faker.currency().code()));

        LocalDateTime insertDate = dateTimeFormatter();
        item.setInsertDate(new DateClass(insertDate));
        item.setUpdateDate(
                new DateClass(
                        insertDate.plusHours(faker.number().numberBetween(0,240))
                                .plusMinutes(faker.number().numberBetween(0, 60))
                                .plusSeconds(faker.number().numberBetween(0, 60))

                )
        );

        return item;
    }

    public List<Item> setItemFields(){


        return null;
    }

    public LocalDateTime dateTimeFormatter(){

        // Generate individual components
        int year = faker.number().numberBetween(2023, 2024);
        int month = faker.number().numberBetween(1, 13);
        int day = faker.number().numberBetween(1, 29);
        int hour = faker.number().numberBetween(0, 24);
        int minute = faker.number().numberBetween(0, 60);
        int second = faker.number().numberBetween(0, 60);

        // Construct LocalDateTime object
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute, second);
        return localDateTime;

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
//        String formattedDateTime = formatter.format(localDateTime);
//        return formattedDateTime;

    }

}
