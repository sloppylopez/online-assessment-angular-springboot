import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  baseUrl = `http://localhost:3000/report/`;
  constructor(private http: HttpClient) {}
  getReport() {
    const _URL = this.baseUrl;
    return this.http.get(_URL);
  }
}
