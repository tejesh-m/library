import {ChangeDetectionStrategy, Component, OnInit} from "@angular/core";
import {BookService} from "../service";
import {Observable} from "rxjs";

@Component({
  templateUrl: "./html/book.list.da.page.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class BookListDaComp implements OnInit {

  bookdata$: Observable<any> = this._bookService.fetch();

  constructor(private _bookService: BookService) {
  }

  ngOnInit(): void {
  }

}
