import { gql } from '@apollo/client';

export const GET_BOOKS_BY = gql`query {bookById(id:"book-1"){
    name
    id
  }}`;

//allow you to pass parameters
export const GET_BOOKS_BY_ID = gql`
  query bookById($id: ID) {
    bookById(id: $id) {
      id
      name
      author{
        firstName
        lastName
      }
    }
  }
`;