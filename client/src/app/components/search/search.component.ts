import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  constructor() { this.user = {} }
  user = {}
  @Input() inputModel: string = '';
  @Output() searchFunction = new EventEmitter();


  submitSearch(value: string) {
    this.searchFunction.emit(value);
  }

  ngOnInit() {
  }

}
