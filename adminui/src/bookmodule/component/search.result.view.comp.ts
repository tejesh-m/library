import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnDestroy, OnInit} from "@angular/core";
import {ToastrService} from "ngx-toastr";
import {HttpParams} from "@angular/common/http";
import {SearchService} from "../service";

@Component({
  templateUrl: "./html/search.result.view.page.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SearchResultViewComp implements OnInit, OnDestroy {

  loadedsata: any;
  searchdataresult: any[] = [];

  constructor(private _searchService: SearchService,
              private _change: ChangeDetectorRef, private _toast: ToastrService) {
    let refdata: any = localStorage.getItem("seractdataref");
    this.loadedsata = JSON.parse(refdata);
  }

  ngOnInit(): void {
    const data = new HttpParams()
      .append("title", `${this.loadedsata.title}`)
      .append("author", `${this.loadedsata.author}`)
      .append("publisher", `${this.loadedsata.publisher}`)
      .append("date", `${this.loadedsata.date}`);
    this._searchService.fetch(data).subscribe(res => {
      this.searchdataresult = res;
      this._change.markForCheck();
    });
  }

  ngOnDestroy(): void {
    localStorage.removeItem("seractdataref");
  }

}
