import { IBook } from './../../shared/classes/book';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { faTimes } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css'],
})
export class BookComponent implements OnInit {
  @Input()
  book!: IBook;
  @Output() onBookClick: EventEmitter<IBook> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  onClickBook(book: IBook) {
    this.onBookClick.emit(book);
  }
}
