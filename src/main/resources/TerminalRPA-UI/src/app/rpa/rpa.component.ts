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
      'terminal': ''
    });
    this.gridState = {
      skip: 0,
      take: 200
      };
      this.setGridData();
  }


  setGridData(){
    this.gridData = [
      {'id': 0, 'port': 'Los Angeles', 'terminal': 'Evergreen Los Angeles', 'results': '', 'terminalId': 'evergreen' },
      {'id': 1, 'port': 'Oakland', 'terminal': 'Evergreen Oakland', 'results': '', 'terminalId': 'evergreenOAK' },
      {'id': 2, 'port': 'Tacoma', 'terminal': 'Evergreen Tacoma', 'results': '', 'terminalId': 'evergreenTAC' },
      {'id': 3, 'port': 'Seattle', 'terminal': 'Terminal 18', 'results': '', 'terminalId': 'seattle18' },
      {'id': 4, 'port': 'Seattle', 'terminal': 'Terminal 30', 'results': '', 'terminalId': 'seattle30' },
      {'id': 5, 'port': 'Seattle', 'terminal': 'Terminal 46', 'results': '', 'terminalId': 'seattle46' }
    ];
  }

  onSubmit(terminalData: any){
    console.log('here');
    if (terminalData.terminalId !== ''){
        this.runRPA(terminalData.terminalId).subscribe(data => {
            this.gridData[terminalData.id].results = JSON.stringify(data);
            console.log(this.gridData[terminalData.id].message);
        });
    } else {
      alert('please select a terminal');
    }
  }


  runRPA(terminalId: any): Observable<any[]> {
    const url = 'https://localhost:8502/' + terminalId;
    console.log(url);
    return this.http.get<any[]>(url);
  }

}

