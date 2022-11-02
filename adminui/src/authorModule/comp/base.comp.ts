import {ChangeDetectionStrategy, Component, OnInit} from "@angular/core";
import {ToastrService} from "ngx-toastr";

@Component({
  templateUrl: "./html/base.page.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class BaseComp implements OnInit {

  fullname: any = "";

  constructor(private _toast: ToastrService) {
    this.fullname = localStorage.getItem("authorname");
  }

  ngOnInit(): void {
  }

  clearAuth() {
    this._toast.success("Logout Successful", "Logout");
    localStorage.removeItem("username");
    localStorage.removeItem("jwttoken");
    localStorage.removeItem("authorid");
    localStorage.removeItem("authorname");
  }

}
