import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RpaComponent } from './rpa/rpa.component';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'rpa', component: RpaComponent }
];
@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    RouterModule.forRoot(routes)
  ],
  declarations: []
})
export class AppRoutingModule { }
