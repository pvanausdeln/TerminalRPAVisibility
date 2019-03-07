import { Component, OnInit, NgModule } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-rpa',
  templateUrl: './rpa.component.html',
  styleUrls: ['./rpa.component.scss']
})

export class RpaComponent implements OnInit {
  public sform: FormGroup;
  public results: any;
  constructor(private frmBld: FormBuilder, private http: HttpClient) { }

  ngOnInit() {
    this.sform = this.frmBld.group({
      'terminal': ""
    });
  }

  onSubmit(){
    console.log("here");
    if (this.sform.value.terminal != ""){
        this.runRPA().subscribe(data => {
            this.results = data;
            console.log(this.results);
        });
    } else {
      alert("please select a terminal");
    }
  }


  runRPA(): Observable<any[]> {
    let url = "https://localhost:8502/";
    if (this.sform.value.terminal == "SE"){
       url = "https://localhost:8502/seattle";
    } else {
       url = "https://localhost:8502/evergreen";
    }
    return this.http.get<any[]>(url).pipe(
      map((data: any[]) => {
        return data;
      })
    );
  }

}

