import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AccessModule } from './access/access.module';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AccessModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
