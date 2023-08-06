import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import { UploadComponent } from './upload/upload.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {DropdownModule} from "primeng/dropdown";
import {ToastModule} from "primeng/toast";
import {ButtonModule} from "primeng/button";
import {RippleModule} from "primeng/ripple";
import {FlexModule} from "@angular/flex-layout";

const routes: Routes = [
  {
    path: '',
    component: UploadComponent
  }
];

@NgModule({
  declarations: [
    UploadComponent
  ],
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    NgbModule,
    DropdownModule,
    ToastModule,
    ButtonModule,
    RippleModule,
    FlexModule
  ],
  exports: [RouterModule]
})
export class ActivationModule { }
