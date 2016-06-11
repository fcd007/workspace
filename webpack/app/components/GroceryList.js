import React, {Component} from 'react';
import ListItem from './ListItem.js'

class GroceryList extends Component{
  render(){
    return (
      <ul>
        <ListItem quantity="1">Batatinha     </ListItem>
        <ListItem quantity="6">Alface        </ListItem>
        <ListItem quantity="3">Cebola        </ListItem>
        <ListItem quantity="4">Dente de alho </ListItem>
      </ul>
    );
  }
}

export default GroceryList
