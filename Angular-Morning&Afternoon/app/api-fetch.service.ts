import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiFetchService {

  constructor(private http: HttpClient) { }
  apiUrl = 'https://jsonplaceholder.typicode.com/todos';
  fetchData() {
    return this.http.get(this.apiUrl);
  }
  fetchTodoURLwithId(id:any){
    const urlWithId = this.apiUrl + "/" + id;
    return this.http.get(urlWithId);
  }
}
