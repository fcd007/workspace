import React, {Component, PropTypes} from 'react';
import SearchBar from './SearchBar.js';
import ContactList from './ContactList.js';
import TutorialComponent from './TutorialComponent.js';

class ContactsApp extends TutorialComponent{

	handleUserInput(searchTerm){
		this.setState({filterText: searchTerm});
	}
	
	/*render the components*/
	render(){
		console.log("ContactsApp render called");
		return (
			<div>
				<SearchBar	filterText={this.state.filterText}
									 	onUserInput={this.handleUserInput.bind(this)} />

				<ContactList  filterText={this.state.filterText}
											contacts={this.props.contacts} />
			</div>
		);
	}
}

ContactsApp.propTypes = {
	contacts: PropTypes.arrayOf(PropTypes.object)
}

ContactsApp.defaultProps = {
  contacts: [
		{name: "Juliano Grams", email: "julianograms@gmail.com"},
		{name: "Roberto", email: "roberto@teste.com"},
		{name: "Joao", email: "joao@gmail.com"}
	]
};

export default ContactsApp;