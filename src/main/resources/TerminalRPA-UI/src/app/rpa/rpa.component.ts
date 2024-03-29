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


  setGridData() {
    this.gridData = [
      {'id': 0, 'port': 'Charleston', 'terminal': 'North Charleston Terminal', 'results': '', 'terminalId': 'NCT'},
      {'id': 1, 'port': 'Charleston', 'terminal': 'Wando Welch Terminal', 'results': '', 'terminalId': 'WWT'},
      {'id': 2, 'port': 'Houston', 'terminal': 'Barbours', 'results': '', 'terminalId': 'barboursHOU'},
      {'id': 3, 'port': 'Houston', 'terminal': 'Bayport', 'results': '', 'terminalId': 'bayportHOU'},
      {'id': 4, 'port': 'Jacksonville', 'terminal': 'TraPac Jacksonville', 'results': '', 'terminalId': 'trapavJAX'},
      {'id': 5, 'port': 'Long Beach', 'terminal': 'Long Beach Container Terminal', 'results': '', 'terminalId': 'LBCT'},
      {'id': 6, 'port': 'Long Beach', 'terminal': 'Pacific Long Beach', 'results': '', 'terminalId': 'pacificLB'},
      {'id': 7, 'port': 'Long Beach', 'terminal': 'TTI Long Beach', 'results': '', 'terminalId': 'ttiLB'},
      {'id': 8, 'port': 'Los Angeles', 'terminal': 'APM Los Angeles', 'results': '', 'terminalId': 'apmLA'},
      {'id': 9, 'port': 'Los Angeles', 'terminal': 'Evergreen Los Angeles', 'results': '', 'terminalId': 'evergreenLA' },
      {'id': 10, 'port': 'Los Angeles', 'terminal': 'TraPac Los Angeles', 'results': '', 'terminalId': 'trapacLA' },
      {'id': 11, 'port': 'Los Angeles', 'terminal': 'WBCT Los Angeles', 'results': '', 'terminalId': 'wbctLA' },
      {'id': 12, 'port': 'Miami', 'terminal': 'South Florida', 'results': '', 'terminalId': 'Miami'},
      // {'id': 4, 'port': 'Los Angeles', 'terminal': 'Yang Ming Los Angeles', 'results': '', 'terminalId': 'ymLA' },
      {'id': 13, 'port': 'Newark', 'terminal': 'Newark Container', 'results': '', 'terminalId': 'newark'},
      {'id': 14, 'port': 'New York', 'terminal': 'Maher', 'results': '', 'terminalId': 'Maher'},
      {'id': 15, 'port': 'New York', 'terminal': 'Packer', 'results': '', 'terminalId': 'packer'},
      {'id': 16, 'port': 'Oakland', 'terminal': 'Evergreen Oakland', 'results': '', 'terminalId': 'evergreenOAK' },
      {'id': 17, 'port': 'Oakland', 'terminal': 'TraPac Oakland', 'results': '', 'terminalId': 'trapacOAK' },
      {'id': 18, 'port': 'Seattle', 'terminal': 'Terminal 18', 'results': '', 'terminalId': 'seattle18' },
      {'id': 19, 'port': 'Seattle', 'terminal': 'Terminal 30', 'results': '', 'terminalId': 'seattle30' },
      {'id': 20, 'port': 'Seattle', 'terminal': 'Terminal 46', 'results': '', 'terminalId': 'seattle46' },
      {'id': 21, 'port': 'Tacoma', 'terminal': 'Evergreen Tacoma', 'results': '', 'terminalId': 'evergreenTAC' },
      {'id': 22, 'port': 'Tacoma', 'terminal': 'Husky Tacoma', 'results': '', 'terminalId': 'huskyTAC' }
    ];
  }

  onSubmit(terminalData: any) {
    console.log('here');
    if (terminalData.terminalId !== '') {
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

