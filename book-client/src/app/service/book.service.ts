import { IBook } from './../shared/classes/book';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { BehaviorSubject, map, Observable, startWith } from 'rxjs';

// const state = {
//   books: JSON.parse(localStorage['books'] || '[]'),
// };

@Injectable({
  providedIn: 'root',
})
export class BookService {
  public Books: any;
  bookURL = environment.apiUrl + 'books';
  book: IBook[] = [
    {
      id: 1,
      title: 'Harry Potter',
      authorName: 'J.K. Rowling',
      description:
        'Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling. The novels chronicle the lives of a young wizard, Harry Potter, and his friends Hermione Granger and Ron Weasley, all of whom are students at Hogwarts School of Witchcraft and Wizardry',
      publication: '2007-06-21',
      numberOfBooks: 10,
    },
    {
      id: 1,
      title: 'The Lord of the Rings: The Fellowship of the Ring',
      authorName: ' J. R. R. Tolkien',
      description:
        'A young hobbit, Frodo, who has found the One Ring that belongs to the Dark Lord Sauron, begins his journey with eight companions to Mount Doom, the only place where it can be destroyed.',
      publication: '2001-12-19',
      numberOfBooks: 10,
    },
  ];

  book$ = new BehaviorSubject<any>(this.book);

  constructor(private http: HttpClient) {}

  /**
   * Add a new book to the system
   * @param book book to be added
   */
  addbook(book: IBook) {
    this.http.post<IBook>(this.bookURL, book).subscribe({
      next: (book) => {
        this.getAllBooks();
      },
      error: (err: HttpErrorResponse) => {
        if (err.error instanceof Error) {
          console.log('Client-side error occured.');
        } else {
          console.log('Server-side error occured.');
        }
      },
      complete: () => console.info('complete'),
    });
  }

  /**
   * Delete book from system by ID
   * @param book book to be deleted
   */
  deleteBook(book: IBook) {
    const URL = this.bookURL + `/${book.id}`;
    this.http.delete(URL).subscribe({
      next: (brand) => {
        this.getAllBooks();
      },
      error: (err: HttpErrorResponse) => {
        if (err.error instanceof Error) {
          console.log('Client-side error occured.');
        } else {
          console.log('Server-side error occured.');
        }
      },
    });
  }

  /**
   * Find book from system by title
   * @param title book to be searched
   */
  findBookByTitle(title: string) {
    const URL = this.bookURL + `/byTitle/${title}`;
    this.http.get(URL).subscribe({
      next: (brand) => {
        this.getAllBooks();
      },
      error: (err: HttpErrorResponse) => {
        if (err.error instanceof Error) {
          console.log('Client-side error occured.');
        } else {
          console.log('Server-side error occured.');
        }
      },
    });
  }
  /**
   * Update book from system by ID
   * @param book book to be updated
   */
  updateBook(book: IBook) {
    const URL = this.bookURL + `/${book.id}`;
    this.http.put(URL, book).subscribe({
      next: (brand) => {
        this.getAllBooks();
      },
      error: (err: HttpErrorResponse) => {
        if (err.error instanceof Error) {
          console.log('Client-side error occured.');
        } else {
          console.log('Server-side error occured.');
        }
      },
    });
  }

  /**
   * Get all books from the system
   */
  getAllBooks() {
    this.http.get<IBook[]>(this.bookURL).subscribe({
      next: (book) => {
        this.book$.next(book);
      },
      error: (err: HttpErrorResponse) => {
        if (err.error instanceof Error) {
          console.log('Client-side error occured.');
        } else {
          console.log('Server-side error occured.');
        }
      },
      complete: () => console.info('complete'),
    });
  }
}
