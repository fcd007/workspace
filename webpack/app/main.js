import React from 'react';
import {render} from 'react-dom';
import KanbanBoard from './KanbanBoard.js';
import styles from './dist/style.css';

let cardsList= [
  {
    id: 1,
    title: "Read the Book",
    description: "Please, read this book",
    status: "in-progress",
    color: '#BD8D31',
    tasks: [

    ]
  },
  {
    id: 2,
    title: "Second Thing",
    description: "Thing to do",
    status: "todo",
    color: '#f5f5f5',
    tasks: [
      {
        id: 1,
        name: "Make the contact list",
        done: true
      },
      {
        id: 2,
        name: "Make the table",
        done: false
      }
    ]
  },
  {
    id: 3,
    title: "Do the rest",
    description: "...",
    status: "in-progress",
    color: "blue",
    tasks: [
      {
        id: 1,
        name: "The rest",
        done: false
      },
      {
        id: 2,
        name: "i don'known",
        done: false
      }
    ]
  }
];

render(<KanbanBoard cards={cardsList} />, document.getElementById('root'));
