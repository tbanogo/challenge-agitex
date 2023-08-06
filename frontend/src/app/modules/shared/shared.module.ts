import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HeaderComponent} from './header/header.component';
import {SidebarComponent} from './sidebar/sidebar.component';
import {TopbarComponent} from './topbar/topbar.component';
import {RouterModule} from "@angular/router";
import {AppModule} from "../../app.module";
import {FlexLayoutModule} from "@angular/flex-layout";
import {SplitButtonModule} from "primeng/splitbutton";

@NgModule({
  declarations: [
    HeaderComponent,
    SidebarComponent,
    TopbarComponent
  ],
  exports: [
    HeaderComponent,
    SidebarComponent,
    TopbarComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FlexLayoutModule,
    SplitButtonModule,
  ]
})
export class SharedModule {
}
