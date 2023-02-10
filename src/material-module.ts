import{NgModule} from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import{MatPaginatorModule} from '@angular/material/paginator';
import{MatSortModule} from '@angular/material/sort';
import{MatTableModule} from '@angular/material/table';
import{MatInputModule} from '@angular/material/input';
import {MatSlideToggle, MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {
    NgxMatDatetimePickerModule, 
    NgxMatNativeDateModule, 
    NgxMatTimepickerModule 
} from '@angular-material-components/datetime-picker';

@NgModule({
    exports:[
        MatTableModule,
        MatPaginatorModule,
        MatSortModule,
        MatFormFieldModule,
        MatInputModule,
        MatSlideToggleModule,
        MatButtonToggleModule,
        NgxMatDatetimePickerModule, 
    NgxMatNativeDateModule, 
    NgxMatTimepickerModule 
    ]
})
export class MaterialModule{}