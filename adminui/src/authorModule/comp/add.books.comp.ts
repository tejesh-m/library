import {format} from "date-fns";
import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from "@angular/core";
import {AbstractControl, FormBuilder, FormGroup, ValidationErrors, Validators} from "@angular/forms";
import {BookService, CategoryService} from "../service";
import {ToastrService} from "ngx-toastr";
import {HttpParams, HttpUrlEncodingCodec} from "@angular/common/http";
import {BsDatepickerConfig} from "ngx-bootstrap/datepicker";

const bsDateConfig: Partial<BsDatepickerConfig> = {
  showClearButton: true, selectWeekDateRange: false,
  selectWeek: false, adaptivePosition: true,
  containerClass: 'theme-blue', showWeekNumbers: false,
  selectFromOtherMonth: true, showPreviousMonth: false,
  dateInputFormat: 'YYYY-MM-DD', useUtc: false
};

@Component({
  templateUrl: "./html/add.books.page.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AddBooksComp implements OnInit {

  frmBook!: FormGroup;
  catedalist: any[] = [];
  loading: boolean = false;
  imageBase64: string = "";
  bsConfig: Partial<BsDatepickerConfig> = bsDateConfig;

  constructor(private _formBuilder: FormBuilder, private _categoryService: CategoryService,
              private _change: ChangeDetectorRef, private _toast: ToastrService,
              private _bookService: BookService) {
  }

  ngOnInit(): void {
    this.frmBook = this._formBuilder.group({
      tsbktitle: ["", [Validators.required]],
      tsbkcategorid: ["0", [greaterThanZero]],
      tsbkimage: ["", [Validators.required]],
      tsbkimagedataref: ["", [Validators.required]],
      tsbkprice: ["", [Validators.required]],
      tsbkpublisher: ["", [Validators.required]],
      tsbkleasedate: ["", [Validators.required]],
      tsbkactive: ["Y", [Validators.required]],
      tsbkcontent: ["", [Validators.required]]
    });

    this._categoryService.fetch().subscribe(res => {
      this.catedalist = res;
      this._change.markForCheck();
    });
  }

  public uploadImage(fileInput: any): any {
    if (fileInput.target.files && fileInput.target.files[0]) {
      const allowed_types = ['image/png', 'image/jpeg'];
      const fileType: string = fileInput.target.files[0].type;

      if (!allowed_types.includes(fileType)) {
        this._toast.error('Only Images are allowed ( JPG | PNG )');
        return false;
      }

      const reader = new FileReader();
      reader.onload = (e: any) => {
        const imagedata = e.target.result;
        this.imageBase64 = imagedata;
        this.frmBook.patchValue({tsbkimage: imagedata});
        this._change.markForCheck();
      };
      reader.readAsDataURL(fileInput.target.files[0]);
    }
  }

  saveEvent() {
    this.loading = true;
    const leasedate = format(this.frmBook.controls["tsbkleasedate"].value, "yyyy-MM-dd");
    const data = new HttpParams({encoder: new HttpUrlEncodingCodec()})
      .append("title", `${this.frmBook.controls["tsbktitle"].value}`)
      .append("categoryid", `${this.frmBook.controls["tsbkcategorid"].value}`)
      .append("imagedata", `${this.frmBook.controls["tsbkimage"].value}`)
      .append("price", `${this.frmBook.controls["tsbkprice"].value}`)
      .append("leasedate", `${leasedate}`)
      .append("publisher", `${this.frmBook.controls["tsbkpublisher"].value}`)
      .append("active", `${this.frmBook.controls["tsbkactive"].value}`)
      .append("content", `${this.frmBook.controls["tsbkcontent"].value}`)
      .append("authorid", `${localStorage.getItem("authorid")}`);

    this._bookService.addBooks(data).subscribe(res => {
        this.clr();
        this._toast.success(res.message, res.title);
        this.frmBook.reset({
          tsbktitle: "", tsbkcategorid: "0",
          tsbkimage: "", tsbkprice: "",
          tsbkpublisher: "", tsbkactive: "Y",
          tsbkcontent: "", tsbkimagedataref: ""
        });
        this.imageBase64 = "";
      },
      err => {
        this.clr();
        this._toast.error(err.error.message, err.error.time);
      },
      () => this.clr());
  }

  clr() {
    this.loading = false;
    this._change.markForCheck();
  }

}

function greaterThanZero(formControl: AbstractControl): ValidationErrors | null {
  const value: number = parseFloat(formControl.value);
  if (value > 0) {
    return null;
  } else {
    return {"greaterthanzero": true};
  }
}
