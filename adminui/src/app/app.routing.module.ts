import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {LoginComp, RegisterUserComp} from "../authmodule/component";

const routes: Routes = [
  {path: "", pathMatch: "full", redirectTo: "/book/search"},
  {path: "auth", component: LoginComp, data: {title: "Author Login"}},
  {path: "register", component: RegisterUserComp, data: {title: "Register Author"}},
  {path: "book", loadChildren: () => import("../bookmodule").then(m => m.BookModule)},
  {path: "author", loadChildren: () => import("../authorModule").then(m => m.AuthorModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
