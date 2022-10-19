export interface Query {
    bookById(id: Number): Book
}

export type Book = {
    id: Number
    name: String
    pageCount: Number
    author: Author
}

export type Author = {
    id: Number
    firstName: String
    lastName: String
}