import { Component, OnInit } from '@angular/core';
import { Session } from './session';

@Component({
  selector: 'app-session-list',
  templateUrl: './session-list.component.html',
  styleUrls: ['./session-list.component.scss']
})
export class SessionListComponent implements OnInit {

  constructor() { }

  singleSession : Session;
  sessionList : Session[] = [
    new Session("Git","Devansh Sharma",new Date,false),
    new Session("Database","Sivagami",new Date,false),
    new Session("JavaScript","Anushree",new Date,false)
  ];

  addCheck:boolean =false;
  
  edit(index:any):void{
   this.sessionList[index].editable = true;
  }

   save(index:any):void { 
    console.log(this.sessionList);
    this.sessionList[index].editable = false;
    this.addCheck = true;     
   }
  
  add(){
     this.sessionList.push(new Session("","",new Date,true));
  }

   delete(index:any){
    this.sessionList.splice(index, 1);
   }


  ngOnInit(): void {
  }

}
