import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AccessService {

  API_PATH = 'http://localhost:8080/login/';

  constructor(private httpClient: HttpClient) { }

  login(accesos: any){
    return this.httpClient.post(this.API_PATH, accesos);
  }
}
