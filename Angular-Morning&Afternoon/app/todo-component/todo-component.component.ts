import { Component, OnInit } from '@angular/core';
import { ApiFetchService } from '../api-fetch.service';

@Component({
  selector: 'app-todo-component',
  templateUrl: './todo-component.component.html',
  styleUrls: ['./todo-component.component.scss']
})
export class TodoComponentComponent implements OnInit {

  obs: any;
  todos: any;
  todoDetails: any;
  id: any;
  constructor(private fetchData: ApiFetchService) {
    this.obs = fetchData.fetchData();
    this.obs.subscribe((response) => {
      this.todos = response;
    });
   }

  getDetails(todoData: any) {
    this.id = todoData;
    this.fetchData.fetchTodoURLwithId(this.id).subscribe((response) => {
      //console.log(response);
      this.todoDetails = response;
    });
  }

  ngOnInit(): void {
  }

}
