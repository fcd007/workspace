import React, {Component, PropTypes} from 'react';

class SearchBar extends Component{
	handleChange(event){
		this.props.onUserInput(event.target.value);
	}
	render(){
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

export default SearchBar