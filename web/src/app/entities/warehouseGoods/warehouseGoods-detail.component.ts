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
import {WarehouseGoods} from './warehouseGoods';
import {WarehouseGoodsService} from './warehouseGoods.service';
import {Goods} from '../goods/goods';
import {Warehouse} from '../warehouse/warehouse';

@Component({
    moduleId: module.id,
	templateUrl: 'warehouseGoods-detail.component.html',
	selector: 'warehouseGoods-detail',
})
export class WarehouseGoodsDetailComponent implements OnInit, OnDestroy {
    warehouseGoods : WarehouseGoods;

    private params_subscription: any;


    @Input() sub : boolean = false;
    @Input() // used to pass the parent when creating a new WarehouseGoods
    set typeOfGoods(typeOfGoods : Goods) {
        this.warehouseGoods = new WarehouseGoods();
        this.warehouseGoods.typeOfGoods = typeOfGoods;
        // special hack for composite key with x-to-one relation...
        this.warehouseGoods.id.typeOfGoodsId = typeOfGoods.id;
    }

    @Input() // used to pass the parent when creating a new WarehouseGoods
    set warehouse(warehouse : Warehouse) {
        this.warehouseGoods = new WarehouseGoods();
        this.warehouseGoods.warehouse = warehouse;
        // special hack for composite key with x-to-one relation...
        this.warehouseGoods.id.warehouseId = warehouse.id;
    }

    @Output() onSaveClicked = new EventEmitter<WarehouseGoods>();
    @Output() onCancelClicked = new EventEmitter();

    constructor(private route: ActivatedRoute, private router: Router, private messageService: MessageService, private warehouseGoodsService: WarehouseGoodsService) {
    }

    ngOnInit() {
        if (this.sub) {
            return;
        }

        this.params_subscription = this.route.params.subscribe(params => {
            let id = params['id'];
            console.log('ngOnInit for warehouseGoods-detail ' + id);

            if (id === 'new') {
                this.warehouseGoods = new WarehouseGoods();
            } else {
                this.warehouseGoodsService.getWarehouseGoods(id)
                    .subscribe(warehouseGoods => {
                            this.warehouseGoods = warehouseGoods;
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

    gotoTypeOfGoods() {
        this.router.navigate(['/goods', this.warehouseGoods.typeOfGoods.id]);
    }

    clearTypeOfGoods() {
        this.warehouseGoods.typeOfGoods = null;
        // special hack for composite key with x-to-one relation...
        this.warehouseGoods.id.typeOfGoodsId = null;
    }

    gotoWarehouse() {
        this.router.navigate(['/warehouse', this.warehouseGoods.warehouse.id]);
    }

    clearWarehouse() {
        this.warehouseGoods.warehouse = null;
        // special hack for composite key with x-to-one relation...
        this.warehouseGoods.id.warehouseId = null;
    }

    onSave() {
        // special hack for composite key with x-to-one relation...
        this.warehouseGoods.id.warehouseId = this.warehouseGoods.warehouse.id;

        // special hack for composite key with x-to-one relation...
        this.warehouseGoods.id.typeOfGoodsId = this.warehouseGoods.typeOfGoods.id;

        this.warehouseGoodsService.update(this.warehouseGoods).
            subscribe(
                warehouseGoods => {
                    this.warehouseGoods = warehouseGoods;
                    if (this.sub) {
                        this.onSaveClicked.emit(this.warehouseGoods);
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
