import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from "@angular/core";
import {AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators} from "@angular/forms";
import {AuthService} from "../service";
import {HttpParams} from "@angular/common/http";
import {ToastrService} from "ngx-toastr";

@Component({
  templateUrl: "./html/register.user.page.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class RegisterUserComp implements OnInit {

  loading: boolean = false;
  frmRegister!: FormGroup

  constructor(private _formBuilder: FormBuilder, private _toast: ToastrService,
              private _authService: AuthService, private _change: ChangeDetectorRef) {
  }

  ngOnInit(): void {
    this.frmRegister = this._formBuilder.group({
      txemailaddr: ["", [Validators.required, Validators.email]],
      txusername: ["", [Validators.required]],
      txfullname: ["", [Validators.required]],
      txpassword: ["", [Validators.required]],
      txconfpassword: ["", [Validators.required]]
    }, {validators: passwordMatch("txpassword", "txconfpassword")})
  }

  registerEvent() {
    this.loading = true;

    const param = new HttpParams()
      .append("fullname", `${this.frmRegister.controls["txfullname"].value}`)
      .append("username", `${this.frmRegister.controls["txusername"].value}`)
      .append("password", `${this.frmRegister.controls["txpassword"].value}`)
      .append("emailId", `${this.frmRegister.controls["txemailaddr"].value}`);

    this._authService.signUp(param).subscribe(res => {
        this._toast.success(res.message, res.title);
        this.frmRegister.reset({
          txemailaddr: "", txusername: "",
          txpassword: "", txconfpassword: ""
        });
        this.clear()
      },
      err => {
        this.clear()
        this._toast.error(err.error.message, err.error.title);
      },
      () => this.clear());
  }

  clear() {
    this.loading = false;
    this._change.markForCheck();
  }

}

function passwordMatch(newPassword: string, confirmPassword: string): ValidatorFn {
  return (formGroup: AbstractControl): ValidationErrors | null => {
    let pswd = formGroup.get(newPassword);
    let comfpswd = formGroup.get(confirmPassword);
    return pswd?.value === comfpswd?.value ? null : {notmatched: true};
  }
}
