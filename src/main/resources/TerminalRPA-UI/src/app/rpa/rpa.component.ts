import { Component, OnInit, NgModule } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { State, SortDescriptor } from '@progress/kendo-data-query';

@Component({
  selector: 'app-rpa',
  templateUrl: './rpa.component.html',
  styleUrls: ['./rpa.component.scss']
})

export class RpaComponent implements OnInit {
  public sform: FormGroup;
  public results: any;
  public gridData: any;
  public data: any;
  public gridState: State;
  private isNew: boolean;
  public sort: SortDescriptor[] = [{
    field: 'Location',
    dir: 'asc'
  }];
  constructor(private frmBld: FormBuilder, private http: HttpClient) { }

  ngOnInit() {
    this.sform = this.frmBld.group({
      'terminal': ""
    });
    this.gridState = {
      skip: 0,
      take: 200
      };
      this.setGridData();
  }


  setGridData(){
    this.gridData = [
      {'id': 0, 'port': 'Los Angeles', 'terminal': 'Evergreen', 'results': '', 'terminalId': 'LA' },
      {'id': 1, 'port': 'Seattle', 'terminal': 'Terminal 46', 'results': '', 'terminalId': 'SE' }
    ];
  }

  onSubmit(terminalData: any){
    console.log("here");
    if (terminalData.terminalId != ""){
        this.runRPA(terminalData.terminalId).subscribe(data => {
            this.gridData[terminalData.id].results = JSON.stringify(data);
            console.log(this.gridData[terminalData.id].message);
        });
    } else {
      alert("please select a terminal");
    }
  }


  runRPA(terminalId: any): Observable<any[]> {
    let url = "https://localhost:8502/";
    console.log(url);
    if (terminalId == "SE"){
       url = "https://localhost:8502/seattle";
    } else {
       url = "https://localhost:8502/evergreen";
    }
    return this.http.get<any[]>(url);
  }

}

