import {Component, OnInit} from '@angular/core';
import {SearchService} from './services/crud.service';
import {Entry} from '../../api/entry-type';
import {Observable, of} from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  constructor(private searchService: SearchService) {}
  report: Observable<Array<Entry>>;
  caption: string = "Failed Transactions Report";
  ngOnInit(): void {
    this.searchService.getReport()
      .subscribe(report => this.report = of(Object.values(report)));
  }
}
