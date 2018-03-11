//
// Project home: https://github.com/jaxio/celerio-angular-quickstart
// 
// Source code generated by Celerio, an Open Source code generator by Jaxio.
// Documentation: http://www.jaxio.com/documentation/celerio/
// Source code: https://github.com/jaxio/celerio/
// Follow us on twitter: @jaxiosoft
// This header can be customized in Celerio conf...
// Template pack-angular:web/src/app/entities/compositepk.ts.cpk.vm
//

export class UseCase3Pk {
    id1 : Date;
    id2 : string;

    constructor(json? : any) {
        if (json != null) {
            if (json.id1 != null) {
                this.id1 = new Date(json.id1);
            }
            this.id2 = json.id2;
        }
    }
}