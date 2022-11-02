import {format} from "date-fns";
import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {BsDatepickerConfig} from "ngx-bootstrap/datepicker";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";

const bsDateConfig: Partial<BsDatepickerConfig> = {
  showClearButton: true, selectWeekDateRange: false,
  selectWeek: false, adaptivePosition: true,
  containerClass: 'theme-blue', showWeekNumbers: false,
  selectFromOtherMonth: true, showPreviousMonth: false,
  dateInputFormat: 'YYYY-MM-DD', useUtc: false
};

@Component({
  templateUrl: "./html/search.book.page.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SearchBookComp implements OnInit {

  frmSearch!: FormGroup;
  loading: boolean = false;
  bsConfig: Partial<BsDatepickerConfig> = bsDateConfig;

  constructor(private _formBuilder: FormBuilder, private _router: Router,
              private _change: ChangeDetectorRef, private _toast: ToastrService) {
  }

  ngOnInit(): void {
    this.frmSearch = this._formBuilder.group({
      txbltitle: ["", [Validators.required]],
      txbkauthor: ["", [Validators.required]],
      txblpublisher: ["", [Validators.required]],
      txbkrealesedate: ["", [Validators.required]],
    });
    localStorage.removeItem("seractdataref");
  }

  searchData() {
    this.loading = true;
    const seldate = this.frmSearch.controls["txbkrealesedate"].value === "" ? "" : format(this.frmSearch.controls["txbkrealesedate"].value, "yyyy-MM-dd");
    const title = this.frmSearch.controls["txbltitle"].value;
    const author = this.frmSearch.controls["txbkauthor"].value;
    const publisher = this.frmSearch.controls["txblpublisher"].value;

    localStorage.setItem("seractdataref", JSON.stringify({
      title: title, author: author, date: seldate, publisher: publisher
    }));
    this._router.navigate(["/book/searchdata"]);
  }

}
