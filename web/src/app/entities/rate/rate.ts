//
// Project home: https://github.com/jaxio/celerio-angular-quickstart
// 
// Source code generated by Celerio, an Open Source code generator by Jaxio.
// Documentation: http://www.jaxio.com/documentation/celerio/
// Source code: https://github.com/jaxio/celerio/
// Follow us on twitter: @jaxiosoft
// This header can be customized in Celerio conf...
// Template pack-angular:web/src/app/entities/entity.ts.e.vm
//
import {Warehouse} from '../warehouse/warehouse';

export class Rate {
    // Raw attributes
    id : number;
    description : string;
    storage : string;
    labor : number;
    loading : string;
    unloading : string;
    creationDate : Date;
    creationAuthor : string;
    lastModificationDate : Date;
    lastModificationAuthor : string;
    version : number;
    // x-to-one
    warehouse : Warehouse;


    constructor(json? : any) {
        if (json != null) {
            this.id = json.id;
            this.description = json.description;
            this.storage = json.storage;
            this.labor = json.labor;
            this.loading = json.loading;
            this.unloading = json.unloading;
            if (json.creationDate != null) {
                this.creationDate = new Date(json.creationDate);
            }
            this.creationAuthor = json.creationAuthor;
            if (json.lastModificationDate != null) {
                this.lastModificationDate = new Date(json.lastModificationDate);
            }
            this.lastModificationAuthor = json.lastModificationAuthor;
            this.version = json.version;

            if (json.warehouse != null) {
                this.warehouse = new Warehouse(json.warehouse);
            }
        }
    }

    // Utils

    static toArray(jsons : any[]) : Rate[] {
        let rates : Rate[] = [];
        if (jsons != null) {
            for (let json of jsons) {
                rates.push(new Rate(json));
            }
        }
        return rates;
    }
}