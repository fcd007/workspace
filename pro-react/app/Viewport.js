import React, {Component} from 'react';
import {render} from 'react-dom';
import { Router, Route, IndexRoute, hashHistory } from "react-router";
import ContactsApp from './pages/ContactsApp.js';
import KanbanBoard from './pages/KanbanBoard.js';
import styles from './components/kanban/dist/style.css';


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
    title: "Do the restn",
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


class Viewport extends Component{
  handleClick(event){
    let id = event.target.id;
    switch (id) {
      case "kanban":
        console.log("kanban");
        break;
      case "contacts":
        console.log("contacts");
        break;
      default:
        // statements_def
        break;
    }
  }
  // render(){
  //   let style = "display: none; !important";
  //   return(
  //     <div>
  //       <div onClick={this.handleClick.bind(this)}>
  //         <button id="kanban">KanbanBoard</button>
  //         <button id="contacts">Contacts</button>
  //       </div>
  //       <KanbanBoard cards={cardsList}/>
  //       <ContactsApp />
  //     </div>
  //   );
  // }

  render(){
    let style = "display: none; !important";
    return(
      <Router history={hashHistory}>
        <Route path="/" component={Layout}>
          <IndexRoute component={Featured}></IndexRoute>
          <Route path="archives(/:article)" name="archives" component={Archives}></Route>
          <Route path="settings" name="settings" component={Settings}></Route>
        </Route>
      </Router>,
    );
  }
}


ReactDOM.render;




render(<Viewport />, document.getElementById('root'));
