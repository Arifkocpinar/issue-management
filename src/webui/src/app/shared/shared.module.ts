import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {TranslateModule} from "@ngx-translate/core";
import {BsModalRef, ModalModule} from "ngx-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ConfirmationComponent } from './confirmation/confirmation.component';
import { NotfoundComponent } from './notfound/notfound.component';

@NgModule({
  imports:[
    CommonModule,
    FormsModule,
    ModalModule.forRoot()
  ],
  providers:[BsModalRef],
  declarations:[ConfirmationComponent],
  entryComponents:[ConfirmationComponent],
  exports:[
    TranslateModule,
    ModalModule,
    ReactiveFormsModule,
    ConfirmationComponent

  ]

})
export class SharedModule { }
