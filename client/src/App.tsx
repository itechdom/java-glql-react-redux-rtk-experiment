import React from 'react';
import { gql, useQuery } from '@apollo/client';
import logo from './logo.svg';
import { Counter } from './features/counter/Counter';
import './App.css';
import { useGetBookByIdQuery } from './features/api/apiSlice';
import { GET_BOOKS_BY, GET_BOOKS_BY_ID } from './graphql/queries';

function App() {
  // const { data, isLoading, error } = useGetBookByIdQuery('test');
  const { loading, error, data } = useQuery(GET_BOOKS_BY_ID, { variables: { id: "book-1" } });
  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error :(</p>;
  console.log(data, loading, error);
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <Counter />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <span>
          <span>Learn </span>
          <a
            className="App-link"
            href="https://reactjs.org/"
            target="_blank"
            rel="noopener noreferrer"
          >
            React
          </a>
          <span>, </span>
          <a
            className="App-link"
            href="https://redux.js.org/"
            target="_blank"
            rel="noopener noreferrer"
          >
            Redux
          </a>
          <span>, </span>
          <a
            className="App-link"
            href="https://redux-toolkit.js.org/"
            target="_blank"
            rel="noopener noreferrer"
          >
            Redux Toolkit
          </a>
          ,<span> and </span>
          <a
            className="App-link"
            href="https://react-redux.js.org/"
            target="_blank"
            rel="noopener noreferrer"
          >
            React Redux
          </a>
        </span>
      </header>
    </div>
  );
}

export default App;
