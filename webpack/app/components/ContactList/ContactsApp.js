import React, {Component, PropTypes} from 'react';
import SearchBar from './SearchBar.js';
import ContactList from './ContactList.js';

class ContactsApp extends Component{
	constructor(){
		super();
		this.state={
			filterText: ''
		};
	}

	handleUserInput(searchTerm){
		this.setState({filterText: searchTerm});
	}
	render(){
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