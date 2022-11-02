import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

const apiUrl = `${environment.apiUrl}author/`;

@Injectable({providedIn: "root"})
export class AuthService {

  constructor(private _http: HttpClient) {
  }

  signUp(param: HttpParams): Observable<any> {
    return this._http.post(`${apiUrl}signup`, param, {withCredentials: true});
  }

  signIn(param: HttpParams): Observable<any> {
    return this._http.post(`${apiUrl}login`, param, {withCredentials: true});
  }

}
