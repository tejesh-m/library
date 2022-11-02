import {Injectable} from "@angular/core";
import {HTTP_INTERCEPTORS, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({providedIn: "any"})
export class AuthInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const tokenRef: any = localStorage.getItem("jwttoken");
    let authReq = req.clone({
      headers: req.headers.set("Authorization", `Bearer ${tokenRef}`),
      withCredentials: true
    });
    return next.handle(authReq);
  }
}

export const authProvider: any[] = [
  {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
];

