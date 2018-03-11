//
// Project home: https://github.com/jaxio/celerio-angular-quickstart
// 
// Source code generated by Celerio, an Open Source code generator by Jaxio.
// Documentation: http://www.jaxio.com/documentation/celerio/
// Source code: https://github.com/jaxio/celerio/
// Follow us on twitter: @jaxiosoft
// This header can be customized in Celerio conf...
// Template pack-angular:web/src/app/entities/entity-detail.component.ts.e.vm
//
import {Component, OnInit, OnDestroy, Input, Output, EventEmitter} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { SelectItem } from 'primeng/primeng';
import { MessageService} from '../../service/message.service';
import {WarehouseServiceProvider} from './warehouseServiceProvider';
import {WarehouseServiceProviderService} from './warehouseServiceProvider.service';
import {User} from '../user/user';
import {Warehouse} from '../warehouse/warehouse';

@Component({
    moduleId: module.id,
	templateUrl: 'warehouseServiceProvider-detail.component.html',
	selector: 'warehouseServiceProvider-detail',
})
export class WarehouseServiceProviderDetailComponent implements OnInit, OnDestroy {
    warehouseServiceProvider : WarehouseServiceProvider;

    private params_subscription: any;


    @Input() sub : boolean = false;
    @Input() // used to pass the parent when creating a new WarehouseServiceProvider
    set user(user : User) {
        this.warehouseServiceProvider = new WarehouseServiceProvider();
        this.warehouseServiceProvider.user = user;
        // special hack for composite key with x-to-one relation...
        this.warehouseServiceProvider.id.userId = user.id;
    }

    @Input() // used to pass the parent when creating a new WarehouseServiceProvider
    set warehouse(warehouse : Warehouse) {
        this.warehouseServiceProvider = new WarehouseServiceProvider();
        this.warehouseServiceProvider.warehouse = warehouse;
        // special hack for composite key with x-to-one relation...
        this.warehouseServiceProvider.id.warehouseId = warehouse.id;
    }

    @Output() onSaveClicked = new EventEmitter<WarehouseServiceProvider>();
    @Output() onCancelClicked = new EventEmitter();

    constructor(private route: ActivatedRoute, private router: Router, private messageService: MessageService, private warehouseServiceProviderService: WarehouseServiceProviderService) {
    }

    ngOnInit() {
        if (this.sub) {
            return;
        }

        this.params_subscription = this.route.params.subscribe(params => {
            let id = params['id'];
            console.log('ngOnInit for warehouseServiceProvider-detail ' + id);

            if (id === 'new') {
                this.warehouseServiceProvider = new WarehouseServiceProvider();
            } else {
                this.warehouseServiceProviderService.getWarehouseServiceProvider(id)
                    .subscribe(warehouseServiceProvider => {
                            this.warehouseServiceProvider = warehouseServiceProvider;
                        },
                        error =>  this.messageService.error('ngOnInit error', error)
                    );
            }
        });
    }

    ngOnDestroy() {
        if (!this.sub) {
            this.params_subscription.unsubscribe();
        }
    }

    gotoUser() {
        this.router.navigate(['/user', this.warehouseServiceProvider.user.id]);
    }

    clearUser() {
        this.warehouseServiceProvider.user = null;
        // special hack for composite key with x-to-one relation...
        this.warehouseServiceProvider.id.userId = null;
    }

    gotoWarehouse() {
        this.router.navigate(['/warehouse', this.warehouseServiceProvider.warehouse.id]);
    }

    clearWarehouse() {
        this.warehouseServiceProvider.warehouse = null;
        // special hack for composite key with x-to-one relation...
        this.warehouseServiceProvider.id.warehouseId = null;
    }

    onSave() {
        // special hack for composite key with x-to-one relation...
        this.warehouseServiceProvider.id.warehouseId = this.warehouseServiceProvider.warehouse.id;

        // special hack for composite key with x-to-one relation...
        this.warehouseServiceProvider.id.userId = this.warehouseServiceProvider.user.id;

        this.warehouseServiceProviderService.update(this.warehouseServiceProvider).
            subscribe(
                warehouseServiceProvider => {
                    this.warehouseServiceProvider = warehouseServiceProvider;
                    if (this.sub) {
                        this.onSaveClicked.emit(this.warehouseServiceProvider);
                        this.messageService.info('Saved OK and msg emitted', 'Angular Rocks!')
                    } else {
                        this.messageService.info('Saved OK', 'Angular Rocks!')
                    }
                },
                error =>  this.messageService.error('Could not save', error)
            );
    }

    onCancel() {
        if (this.sub) {
            this.onCancelClicked.emit("cancel");
            this.messageService.info('Cancel clicked and msg emitted', 'Angular Rocks!')
        }
    }

}
