import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {DefaultModule} from "./modules/default/default.module";
import {ActivationModule} from "./modules/activation/activation.module";
import {AuthModule} from "./modules/auth/auth.module";
import {DashboardModule} from "./modules/dashboard/dashboard.module";
import {SharedModule} from "./modules/shared/shared.module";
import {ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    ActivationModule,
    AuthModule,
    DashboardModule,
    DefaultModule,
    SharedModule,
    NgbModule
  ],
  providers: [],
  exports: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
