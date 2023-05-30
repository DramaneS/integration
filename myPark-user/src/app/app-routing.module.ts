import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './shared/pages/layout/layout.component';
import { full_content } from './shared/routes/full-content-router';

const routes: Routes = [
  { path : ''
  , component :LayoutComponent
  , children : full_content
  },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
