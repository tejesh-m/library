import {CategoryDaComp} from "./category.da.comp";
import {BaseComp} from "./base.comp";
import {AddBooksComp} from "./add.books.comp";
import {BookListDaComp} from "./book.list.da.comp";

export const authorComp: any[] = [
  CategoryDaComp, BaseComp,
  AddBooksComp, BookListDaComp
]

export * from "./category.da.comp";
export * from "./base.comp";
export * from "./add.books.comp";
export * from "./book.list.da.comp";
