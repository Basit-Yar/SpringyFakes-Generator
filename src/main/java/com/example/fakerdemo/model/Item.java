package com.example.fakerdemo.model;


import com.example.fakerdemo.model.DateClass.DateClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String orderBaseXid;
    private String paymentMethodCodeGid;
    private String incoTermGid;
    private String orderTypeGid;
    private Boolean isTemplate;

    private Quantity totalWeight;
    private Quantity totalVolume;

    private Boolean mustShipDirect;
    private Boolean mustShipThruXDock;
    private Boolean mustShipThruPool;
    private Boolean isKnownShipper;
    private String releaseMethodGid;

    private Quantity totalNetWeight;
    private Quantity totalNetVolume;

    private String bundlingType;

    private Currency totalDeclaredValue;
    private Boolean customerUnitizationRequest;

    private Integer priority;
    private String domainName;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String attribute6;
    private String attribute7;
    private String attribute8;
    private String attribute9;
    private String attribute19;

    private Double attributeNumber1;
    private Double attributeNumber2;
    private Double attributeNumber10;

    private DateClass attributeDate1;

    private Currency attributeCurrency3;

    private DateClass insertDate;
    private DateClass updateDate;

}
