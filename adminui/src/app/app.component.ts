import {filter} from "rxjs/operators";
import {Title} from "@angular/platform-browser";
import {Component, OnInit} from "@angular/core";
import {ChildActivationEnd, Router} from "@angular/router";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {

  title = "Admin Panel";

  constructor(private _router: Router, private _title: Title) {
  }

  ngOnInit(): void {
    this._router.events
      .pipe(filter(event => event instanceof ChildActivationEnd))
      .subscribe(subs => {
        let snapshot = (subs as ChildActivationEnd).snapshot;
        while (snapshot.firstChild !== null) {
          snapshot = snapshot.firstChild;
        }
        let subtitle = `${snapshot.data["title"]} | ${this.title}`;
        this._title.setTitle(subtitle || this.title);
      });
  }

}
