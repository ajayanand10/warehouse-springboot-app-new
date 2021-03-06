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
public abstract class WarehouseSearch_ {

    // Raw attributes
    public static volatile SingularAttribute<Warehouse, String> location;
    public static volatile SingularAttribute<Warehouse, String> type;
    public static volatile SingularAttribute<Warehouse, Integer> minStorageSize;
    public static volatile SingularAttribute<Warehouse, Integer> maxStorageSize;
    
}