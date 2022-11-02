import {NgModule} from "@angular/core";
import {ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule, Routes} from "@angular/router";
import {AddBooksComp, authorComp, BaseComp, BookListDaComp, CategoryDaComp} from "./comp";
import {BookService, CategoryService} from "./service";
import {AuthGuard} from "../authmodule/service";
import {authProvider} from "../authmodule/service/auth.interceptor";
import {BsDatepickerModule} from "ngx-bootstrap/datepicker";

const routes: Routes = [
  {
    path: "", component: BaseComp, data: {title: "Author Dashboard"}, canActivate: [AuthGuard],
    children: [
      {path: "addbook", component: AddBooksComp, data: {title: "Add Book"}},
      {path: "categories", component: CategoryDaComp, data: {title: "Create Category"}},
      {path: "mybooks", component: BookListDaComp, data: {title: "All My Books"}}
    ]
  }
];

@NgModule({
  imports: [
    BsDatepickerModule.forRoot(),
    HttpClientModule, RouterModule.forChild(routes),
    ReactiveFormsModule, CommonModule
  ],
  providers: [
    CategoryService, AuthGuard, authProvider, BookService
  ],
  declarations: [
    ...authorComp
  ],
  exports: [
    RouterModule,
  ]
})
export class AuthorModule {
}
