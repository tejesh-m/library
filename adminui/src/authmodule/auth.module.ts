import {NgModule} from "@angular/core";
import {ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {LoginComp, RegisterUserComp} from "./component";
import {RouterModule} from "@angular/router";
import {AuthService} from "./service";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  imports: [
    ReactiveFormsModule, CommonModule,
    RouterModule, HttpClientModule
  ],
  providers: [
    AuthService
  ],
  declarations: [
    LoginComp, RegisterUserComp
  ],
  exports: [LoginComp, RegisterUserComp]
})
export class AuthModule {
}
