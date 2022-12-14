import { IBook } from './../../shared/classes/book';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
})
export class BookListComponent implements OnInit {
  @ViewChild('fform') registerFormDirective: any;

  public bookFormGroup!: FormGroup;
  public book!: IBook;
  public books: IBook[] = [];

  constructor(private bookService: BookService, private fb: FormBuilder) {
    this.createBookForm();
  }

  ngOnInit() {
    this.bookService.getAllBooks();
    this.bookService.book$.subscribe((books) => {
      this.books = books;
    });
  }

  /**
   * Patch book to form field
   * @param book seleted book from list
   */
  onSelect(book: IBook): void {
    this.book = book;

    this.bookFormGroup.patchValue({
      title: this.book.title,
      authorName: this.book.authorName,
      publication: this.book.publication,
      description: this.book.description,
      numberOfBooks: this.book.numberOfBooks,
    });
  }

  /**
   * Add new book to the system
   */
  onSubmit(): void {
    const newBook = {
      title: this.bookFormGroup.value.title,
      authorName: this.bookFormGroup.value.authorName,
      description: this.bookFormGroup.value.description,
      publication: this.bookFormGroup.value.publication,
      numberOfBooks: this.bookFormGroup.value.numberOfBooks,
    };
    this.bookService.addbook(newBook);

    this.bookFormGroup.reset({
      title: '',
      authorName: '',
      description: '',
      publication: '',
      numberOfBooks: '',
    });
    this.registerFormDirective.reset();
  }

  /**
   * Method Delete Book form the system
   */
  onDelete() {
    this.bookService.deleteBook(this.book);
    this.registerFormDirective.reset();
  }

  /**
   * Edit book
   */
  onEdit() {
    const newBook = {
      id: this.book.id,
      title: this.bookFormGroup.value.title,
      authorName: this.bookFormGroup.value.authorName,
      description: this.bookFormGroup.value.description,
      publication: this.bookFormGroup.value.publication,
      numberOfBooks: this.bookFormGroup.value.numberOfBooks,
    };
    this.bookService.updateBook(newBook);

    this.bookFormGroup.reset({
      title: '',
      authorName: '',
      description: '',
      publication: '',
      numberOfBooks: '',
    });
    this.registerFormDirective.reset();
  }

  /**
   * Create book from with validations
   */
  createBookForm() {
    this.bookFormGroup = this.fb.group({
      title: [
        '',
        [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(50),
        ],
      ],
      authorName: [
        '',
        [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(50),
        ],
      ],
      description: [
        '',
        [
          Validators.required,
          Validators.minLength(20),
          Validators.maxLength(1000),
        ],
      ],
      publication: [<Date | null>null, [Validators.required]],
      numberOfBooks: [
        '',
        [
          Validators.required,
          Validators.minLength(1),
          Validators.maxLength(1000000),
        ],
      ],
    });

    this.bookFormGroup.valueChanges.subscribe((data) =>
      this.onValueChanged(data)
    );
    this.onValueChanged();
  }

  /**
   *
   * @param data inputed form data
   * @returns
   */
  onValueChanged(data?: any) {
    if (!this.bookFormGroup) {
      return;
    }

    const form = this.bookFormGroup;

    for (const field in this.formErrors) {
      if (this.formErrors.hasOwnProperty(field)) {
        // clear previous error message (if any)
        this.formErrors[field] = '';

        const control = form.get(field);

        if (control && control.dirty && !control.valid) {
          const messages = this.validationMessages[field];

          for (const key in control.errors) {
            if (control.errors.hasOwnProperty(key)) {
              this.formErrors[field] += messages[key] + ' ';
            }
          }
        }
      }
    }
  }

  // Clear error message
  formErrors: any = {
    title: '',
    authorName: '',
    description: '',
    publication: '',
    numberOfBooks: '',
  };

  /**
   * Validation messege
   */
  validationMessages: any = {
    title: {
      required: 'Title is required.',
      minlength: 'Title must be at least 2 characters long.',
      maxlength: 'Title cannot be more than 25 characters long.',
    },
    authorName: {
      required: 'Author name is required.',
      minlength: 'Name must be at least 2 characters long.',
      maxlength: 'Name cannot be more than 25 characters long.',
    },

    description: {
      required: 'Description is required.',
      minlength: 'Description must be at least 20 characters long.',
      maxlength: 'Description cannot be more than 500 characters long.',
    },

    publication: {
      required: 'Published date is required.',
    },

    numberOfBooks: {
      required: 'Amount of books is required.',
      minlength: 'Book must be at least 1 instance.',
      maxlength: 'Books cannot be more than 1000000 instance.',
    },
  };
}
