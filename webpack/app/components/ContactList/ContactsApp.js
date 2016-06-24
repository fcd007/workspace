import React, {Component, PropTypes} from 'react';

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



class SearchBar extends Component{
	handleChange(event){
		this.props.onUserInput(event.target.value);
	}
	render(){
		console.log("ola");
		return (
			<input  type="search" placeholder="search"
							onChange={this.handleChange.bind(this)}
							value={this.props.filterText} />
		);
	}
}

SearchBar.propTypes = {
	onUserInput: PropTypes.func.isRequired,
	filterText: PropTypes.string.isRequired
}

class ContactList extends Component{
	render(){
		let filteredContacts = this.props.contacts.filter(
			(contact) => contact.name.indexOf(this.props.filterText) !== -1
		);
		return(
			<ul>
				{filteredContacts.map(
					(contact) => <ContactItem key={contact.email}
																		name={contact.name}
																		email={contact.email}
																		/>)
				}
			</ul>
			);
	}
}

ContactList.propTypes = {
	contacts: PropTypes.arrayOf(PropTypes.object)
}

class ContactItem extends Component{
	render(){
		return (<li>{this.props.name} - {this.props.email}</li>);
	}
}

ContactItem.propTypes = {
	name: PropTypes.string.isRequired,
	email: PropTypes.string.isRequired
}



export default ContactsApp;