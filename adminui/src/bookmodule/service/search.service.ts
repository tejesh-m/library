import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";

const api = `${environment.apiUrl}book/`;

@Injectable({providedIn: "any"})
export class SearchService {

  constructor(private _http: HttpClient) {
  }

  fetch(param: HttpParams): Observable<any> {
    return this._http.get(`${api}search`, {params: param, withCredentials: true});
  }

}
