package com.example.fakerdemo.Service;

import com.example.fakerdemo.model.Currency;
import com.example.fakerdemo.model.CustomDateTime;
import com.example.fakerdemo.model.OrderBase;
import com.example.fakerdemo.model.Quantity;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderBaseService {

    @Autowired
    Faker faker;

    public List<OrderBase> generateMockDataList(int limit){
        List<OrderBase> orderBaseList = new ArrayList<>();

        for(int i=0; i<limit; i++){
            OrderBase orderBase = generateFakeData();
            orderBaseList.add(orderBase);
        }
        return orderBaseList;
    }
    public OrderBase generateFakeData() {
        OrderBase orderBase = new OrderBase();

        orderBase.setOrderBaseXid(faker.idNumber().valid());
        orderBase.setPaymentMethodCodeGid(faker.code().isbn13());
        orderBase.setIncoTermGid(faker.number().digits(5));
        orderBase.setOrderTypeGid(faker.idNumber().valid());
        orderBase.setIsTemplate(faker.bool().bool());

        Quantity totalWeight = new Quantity();
        totalWeight.setValue(faker.number().randomDouble(7,200, 800));
        totalWeight.setUnit("LB");
        orderBase.setTotalWeight(totalWeight);

        Quantity totalVolume = new Quantity();
        totalVolume.setValue(faker.number().randomDouble(3,105, 1200));
        totalVolume.setUnit("CUMTR");
        orderBase.setTotalVolume(totalVolume);

        orderBase.setMustShipDirect(faker.bool().bool());
        orderBase.setMustShipThruXDock(faker.bool().bool());
        orderBase.setMustShipThruPool(faker.bool().bool());
        orderBase.setIsKnownShipper(faker.bool().bool());
        orderBase.setReleaseMethodGid(faker.letterify("???-????-???", true));

        orderBase.setTotalNetWeight(new Quantity(faker.number().randomDouble(1,0,100), "LB"));
        orderBase.setTotalNetVolume(new Quantity(faker.number().randomDouble(1,0,100), "CUMTR"));

        orderBase.setBundlingType(faker.letterify("??????", true));

//        item.setTotalDeclaredValue(new Currency(faker.number().randomDouble(1, 0, 500),"USD"));
        orderBase.setTotalDeclaredValue(new Currency(faker.number().randomDouble(1, 0, 500),faker.currency().code()));
        orderBase.setCustomerUnitizationRequest(faker.bool().bool());
        orderBase.setPriority(faker.number().numberBetween(1,4));

        orderBase.setDomainName(faker.letterify("TW/???/???", true));
        orderBase.setAttribute1(faker.letterify("TW.???", true));
        orderBase.setAttribute2(faker.letterify("TW.???", true));
        orderBase.setAttribute3(faker.letterify("TW.???", true));
        orderBase.setAttribute4(faker.letterify("TW.???", true));
        orderBase.setAttribute5(faker.letterify("TW.???", true));
        orderBase.setAttribute6(faker.letterify("TW.???", true));
        orderBase.setAttribute7(faker.letterify("TW.???", true));
        orderBase.setAttribute8(faker.letterify("TW.???", true));
        orderBase.setAttribute9(faker.letterify("TW.???", true));
        orderBase.setAttribute19(faker.letterify("TW.???", true));

        orderBase.setAttributeNumber1(faker.number().randomDouble(2,0,2500));
        orderBase.setAttributeNumber2(faker.number().randomDouble(2,0,2500));
        orderBase.setAttributeNumber10(faker.number().randomDouble(2,0,2500));

        orderBase.setAttributeDate1(new CustomDateTime(dateTimeFormatter()));

        orderBase.setAttributeCurrency3(new Currency(faker.number().randomDouble(2,0,2000), faker.currency().code()));

        LocalDateTime insertDate = dateTimeFormatter();
        orderBase.setInsertDate(new CustomDateTime(insertDate));
        orderBase.setUpdateDate(
                new CustomDateTime(
                        insertDate.plusHours(faker.number().numberBetween(0,240))
                                .plusMinutes(faker.number().numberBetween(0, 60))
                                .plusSeconds(faker.number().numberBetween(0, 60))

                )
        );

        return orderBase;
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
