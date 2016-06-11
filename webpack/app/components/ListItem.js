import React, {Component} from 'react';

class ListItem extends Component{
  render(){
    /*
      this.props.children is used to get the his content, that was defined in the parent
    */
    return (
      <li>
        {this.props.quantity}x{this.props.children}
      </li>
    );
  }
}
export default ListItem
