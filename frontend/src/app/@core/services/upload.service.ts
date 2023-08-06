import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import { ApiresponseInterface } from '../interfaces/apiresponse.interface';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*'
  })
}

@Injectable({
  providedIn: 'root'
})
export class UploadService {
  uploadUrl = environment.apiRoot+'/api/file/upload';

  constructor(private http: HttpClient) { }

  public uploadTextFile(data: any): Observable<ApiresponseInterface>{
    return this.http.post<ApiresponseInterface>(this.uploadUrl+'/text', data);
  }

  public uploadCsvFile(data: any): Observable<ApiresponseInterface>{
    return this.http.post<ApiresponseInterface>(this.uploadUrl+'/csv', data);
  }

  public uploadJsonFile(data: any): Observable<ApiresponseInterface>{
    return this.http.post<ApiresponseInterface>(this.uploadUrl+'/json', data);
  }

  public uploadXmlFile(data: any): Observable<ApiresponseInterface>{
    return this.http.post<ApiresponseInterface>(this.uploadUrl+'/xml', data);
  }

}
