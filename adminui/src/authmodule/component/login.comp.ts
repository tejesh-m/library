import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {AuthService} from "../service";
import {HttpParams} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  templateUrl: "./html/login.page.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class LoginComp implements OnInit {

  loading: boolean = false;
  frmLogin!: FormGroup;

  constructor(private _formBuilder: FormBuilder,
              private _toast: ToastrService, private _router: Router,
              private _authService: AuthService, private _change: ChangeDetectorRef) {
  }

  ngOnInit(): void {
    this.frmLogin = this._formBuilder.group({
      txusername: [""],
      txpassword: [""]
    })
  }

  loginEvent() {
    this.loading = true;

    const param = new HttpParams()
      .append("username", `${this.frmLogin.controls["txusername"].value}`)
      .append("password", `${this.frmLogin.controls["txpassword"].value}`);

    this._authService.signIn(param).subscribe(res => {
        this._toast.success(res.message, res.title);
        localStorage.setItem("jwttoken", res.jwttoken);
        localStorage.setItem("username", res.username);
        localStorage.setItem("authorid", res.authorid);
        localStorage.setItem("authorname", res.authorname);
        this._router.navigate(["/author", "addbook"]);
      },
      err => {
        this.clear();
        this._toast.error(err.error.message, err.error.title);
      },
      () => this.clear());
  }

  clear() {
    this.loading = false;
    this._change.markForCheck();
  }

}
