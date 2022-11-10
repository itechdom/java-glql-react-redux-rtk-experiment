import { useQuery } from '@apollo/client';
import { GET_BOOKS_BY_ID } from '../queries';

interface Book {
    id: number;
    name: String;
}

interface Books {
    books: Book[];
}

interface BookById {
    bookById: Book
}

interface BookParams {
    id: String;
}

export const useBookById = (id: String): { book: Book | undefined, error: any, loading: Boolean } => {
    const { loading, data, error } = useQuery<BookById, BookParams>(GET_BOOKS_BY_ID, { variables: { id } });
    // useEffect(() => {
    //     console.log("id changed", id);
    //     setBook(data?.bookById);
    //     setError(error);
    //     setLoading(loading);
    // }, [data]);
    return { book: data?.bookById, error, loading };
}