import {Injectable} from "@angular/core";
import {environment} from "../../environments/environment";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

const api = `${environment.apiUrl}category/`;

@Injectable({providedIn: "root"})
export class CategoryService {

  constructor(private _http: HttpClient) {
  }

  fetch(): Observable<any> {
    return this._http.get(`${api}fetch`, {withCredentials: true});
  }

  create(category: any): Observable<any> {
    const param = new HttpParams().append("category", `${category}`);
    return this._http.post(`${api}create`, param, {withCredentials: true});
  }

  delete(cateid: any): Observable<any> {
    const param = new HttpParams().append("categoryid", `${cateid}`);
    return this._http.post(`${api}delete`, param, {withCredentials: true});
  }

}
