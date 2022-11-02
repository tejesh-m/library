import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {bookComp, SearchBookComp, SearchResultViewComp} from "./component";
import {BsDatepickerModule} from "ngx-bootstrap/datepicker";
import {SearchService} from "./service";

const routes: Routes = [
  {path: "", component: SearchBookComp, data: {title: "Search Book"}},
  {path: "search", component: SearchBookComp, data: {title: "Search Book"}},
  {path: "searchdata", component: SearchResultViewComp, data: {title: " Book Search Result"}}
];

@NgModule({
  imports: [
    RouterModule.forChild(routes), ReactiveFormsModule,
    CommonModule, HttpClientModule, BsDatepickerModule.forRoot()
  ],
  providers: [
    SearchService
  ],
  declarations: [
    ...bookComp
  ],
  exports: [RouterModule]
})
export class BookModule {
}
