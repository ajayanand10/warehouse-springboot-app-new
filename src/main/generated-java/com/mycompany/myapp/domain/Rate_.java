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

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Rate.class)
public abstract class Rate_ {

    // Raw attributes
    public static volatile SingularAttribute<Rate, Integer> id;
    public static volatile SingularAttribute<Rate, String> description;
    public static volatile SingularAttribute<Rate, String> storage;
    public static volatile SingularAttribute<Rate, Integer> labor;
    public static volatile SingularAttribute<Rate, String> loading;
    public static volatile SingularAttribute<Rate, String> unloading;
    public static volatile SingularAttribute<Rate, Instant> creationDate;
    public static volatile SingularAttribute<Rate, String> creationAuthor;
    public static volatile SingularAttribute<Rate, Instant> lastModificationDate;
    public static volatile SingularAttribute<Rate, String> lastModificationAuthor;
    public static volatile SingularAttribute<Rate, Integer> version;

    // Many to one
    public static volatile SingularAttribute<Rate, Warehouse> warehouse;
}