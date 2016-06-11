import React, {Component} from 'react';
import styles from './dist/Greeter.css';
import GroceryList from './components/GroceryList.js'

class Greeter extends Component{
  render(){
    return(
      <div className={styles.root}>
        {"Hello World"}
        <GroceryList />
      </div>
    );
  }
}
export default Greeter
