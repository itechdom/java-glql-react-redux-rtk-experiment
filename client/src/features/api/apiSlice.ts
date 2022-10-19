// Define a service using a base URL and expected endpoints
import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react'
import type { Book } from './types'

export const bookApi = createApi({
    reducerPath: 'bookApi',
    baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080' }),
    endpoints: (builder) => ({
        getBookById: builder.query<Book, string>({
            query: (name) => `/`,
        }),
    }),
})

export const { useGetBookByIdQuery } = bookApi
