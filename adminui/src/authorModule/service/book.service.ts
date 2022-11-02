import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

const api = `${environment.apiUrl}book/`;

@Injectable({providedIn: "any"})
export class BookService {

  constructor(private _http: HttpClient) {
  }

  addBooks(param: HttpParams): Observable<any> {
    return this._http.post(`${api}create`, param, {withCredentials: true});
  }

  fetch(): Observable<any> {
    const dataid: any = localStorage.getItem("authorid");
    const param = new HttpParams().append("authid", `${dataid}`);
    return this._http.get(`${api}fetch`, {params: param, withCredentials: true});
  }

}
