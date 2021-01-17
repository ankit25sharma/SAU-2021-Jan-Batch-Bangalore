import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { TodoComponentComponent } from './todo-component/todo-component.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Route[] = [
  {path: 'todo-api', component: TodoComponentComponent },
  {path: '**', component:  PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
