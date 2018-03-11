/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Source code: https://github.com/jaxio/celerio/
 * Follow us on twitter: @jaxiosoft
 * This header can be customized in Celerio conf...
 * Template pack-angular:src/main/java/domain/EntityMeta_.java.e.vm
 */
package com.mycompany.myapp.domain;

import java.time.Instant;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Warehouse.class)
public abstract class Warehouse_ {

    // Raw attributes
    public static volatile SingularAttribute<Warehouse, Integer> id;
    public static volatile SingularAttribute<Warehouse, String> name;
    public static volatile SingularAttribute<Warehouse, Double> rating;
    public static volatile SingularAttribute<Warehouse, String> type;
    public static volatile SingularAttribute<Warehouse, String> description;
    public static volatile SingularAttribute<Warehouse, String> address;
    public static volatile SingularAttribute<Warehouse, String> phone1;
    public static volatile SingularAttribute<Warehouse, String> phone2;
    public static volatile SingularAttribute<Warehouse, String> fulfilmentType;
    public static volatile SingularAttribute<Warehouse, Double> storagePrice;
    public static volatile SingularAttribute<Warehouse, String> storagePriceUom;
    public static volatile SingularAttribute<Warehouse, String> minHirePeriod;
    public static volatile SingularAttribute<Warehouse, Double> deposit;
    public static volatile SingularAttribute<Warehouse, String> depositUom;
    public static volatile SingularAttribute<Warehouse, Integer> facilitySize;
    public static volatile SingularAttribute<Warehouse, String> facilitySizeUom;
    public static volatile SingularAttribute<Warehouse, Integer> storageSize;
    public static volatile SingularAttribute<Warehouse, String> storageSizeUom;
    public static volatile SingularAttribute<Warehouse, String> operatingDays;
    public static volatile SingularAttribute<Warehouse, String> operatingHours;
    public static volatile SingularAttribute<Warehouse, Integer> noOfReceivingDoors;
    public static volatile SingularAttribute<Warehouse, Integer> noOfShippingDoors;
    public static volatile SingularAttribute<Warehouse, String> wmsVendor;
    public static volatile SingularAttribute<Warehouse, String> racking;
    public static volatile SingularAttribute<Warehouse, Double> maxStorageHeight;
    public static volatile SingularAttribute<Warehouse, String> maxStorageHeightUom;
    public static volatile SingularAttribute<Warehouse, Double> maxStorageWeight;
    public static volatile SingularAttribute<Warehouse, String> maxStorageWeightUom;
    public static volatile SingularAttribute<Warehouse, String> handlingEquipment;
    public static volatile SingularAttribute<Warehouse, String> temperatureRange;
    public static volatile SingularAttribute<Warehouse, String> structureType;
    public static volatile SingularAttribute<Warehouse, Integer> yearOfConstruction;
    public static volatile SingularAttribute<Warehouse, String> fleetAccess;
    public static volatile SingularAttribute<Warehouse, String> powerSanctioned;
    public static volatile SingularAttribute<Warehouse, String> waterConnection;
    public static volatile SingularAttribute<Warehouse, String> powerBackup;
    public static volatile SingularAttribute<Warehouse, String> craneServices;
    public static volatile SingularAttribute<Warehouse, String> fireSystems;
    public static volatile SingularAttribute<Warehouse, String> security;
    public static volatile SingularAttribute<Warehouse, String> lift;
    public static volatile SingularAttribute<Warehouse, String> toilet;
    public static volatile SingularAttribute<Warehouse, String> parking;
    public static volatile SingularAttribute<Warehouse, Double> distanceFromMainRoad;
    public static volatile SingularAttribute<Warehouse, String> yard;
    public static volatile SingularAttribute<Warehouse, String> facilityCertification;
    public static volatile SingularAttribute<Warehouse, String> faciltiyInsurance;
    public static volatile SingularAttribute<Warehouse, String> importExport;
    public static volatile SingularAttribute<Warehouse, String> inboundServices;
    public static volatile SingularAttribute<Warehouse, String> outboundServices;
    public static volatile SingularAttribute<Warehouse, String> valueAddedServices;
    public static volatile SingularAttribute<Warehouse, String> laborServices;
    public static volatile SingularAttribute<Warehouse, Double> totalLabor;
    public static volatile SingularAttribute<Warehouse, String> distributionServices;
    public static volatile SingularAttribute<Warehouse, Instant> creationDate;
    public static volatile SingularAttribute<Warehouse, String> creationAuthor;
    public static volatile SingularAttribute<Warehouse, Instant> lastModificationDate;
    public static volatile SingularAttribute<Warehouse, String> lastModificationAuthor;
    public static volatile SingularAttribute<Warehouse, Integer> version;
    
    // Many to many
    public static volatile ListAttribute<Warehouse, Goods> goods;
}