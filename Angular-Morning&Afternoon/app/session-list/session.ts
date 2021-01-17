export class Session {
    public name:string;
    public trainer:string;
    public date:Date;
    public editable:boolean;
    constructor(public sname:string,
            public trainername:string,
            public sdate:Date,
            public edit:boolean){
            this.name = sname;
            this.trainer=trainername;
            this.date = sdate;
            this.editable = edit;
        }
}
