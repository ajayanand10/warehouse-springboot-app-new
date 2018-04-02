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


import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(WarehouseSearch.class)
public abstract class WarehouseSearchResults_ {

    // Raw attributes
	// Raw attributes
    public static volatile SingularAttribute<WarehouseSearchResults, Integer> id;
    public static volatile SingularAttribute<WarehouseSearchResults, String> name;
    public static volatile SingularAttribute<Warehouse, String> type;
    public static volatile SingularAttribute<WarehouseSearchResults, Double> rating;
    public static volatile SingularAttribute<Warehouse, Double> storagePrice;
    public static volatile SingularAttribute<Warehouse, String> storagePriceUom;
    public static volatile SingularAttribute<Warehouse, Integer> storageSize;
    public static volatile SingularAttribute<Warehouse, String> storageSizeUom;
    public static volatile SingularAttribute<Warehouse, Integer> facilitySize;
    public static volatile SingularAttribute<Warehouse, String> facilitySizeUom;
    
    
}