import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CategoryService} from "../service";
import {ToastrService} from "ngx-toastr";

@Component({
  templateUrl: "./html/category.da.page.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CategoryDaComp implements OnInit {

  frmCate!: FormGroup;
  catedalist: any[] = [];
  loading: boolean = false;

  constructor(private _formBuilder: FormBuilder, private _categoryService: CategoryService,
              private _change: ChangeDetectorRef, private _toast: ToastrService) {
  }

  ngOnInit(): void {
    this.frmCate = this._formBuilder.group({
      txcatename: ["", [Validators.required]]
    });
    this.fetchCate();
  }

  fetchCate() {
    this._categoryService.fetch().subscribe(res => {
      this.catedalist = res;
      this._change.markForCheck();
    });
  }

  createEvent() {
    this.loading = true;
    this._categoryService.create(this.frmCate.controls["txcatename"].value).subscribe(res => {
      this.loading = false;
      this._change.markForCheck();
      this.frmCate.reset({
        txcatename: ""
      });
      this._toast.success("Category was Successfully Created.", "Success");
      this.fetchCate();
    });
  }

  deleteDa(ref: any) {
    this._categoryService.delete(ref).subscribe(res => {
      this.fetchCate();
    });
  }

}
