package com.example.fakerdemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
