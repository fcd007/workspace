import React, {Component} from 'react';

class TutorialComponent extends Component{
	//Mounting Phase

	/*First method to be called on maunting phase*/
	constructor(){
		console.log("Mounting Phase started.\n","ContactsApp constructor called");
		super();
		this.state={
			filterText: ''
		};
	}

	/*Invoked once, immediately before the initial rendering occurs.
		Set state on this phase will not trigger a re-rendering*/
	componentWillMount(){
		console.log("ContactsApp componentWillMount called");
	}

	/*Invoked once, immediately after the initial rendering occurs. At this time of
	the component lifecycle, this already has a DOM representation that can be accessed*/
	componentDidMount(){
		console.log("ContactsApp componentDidMount called\n", "Mounting phase finished.");
	}

	//Unmounting Phase

	/*Invoked Immediately before a component is unmounted from the DOM.*/
	componentWillUnmount(){
		console.log("ContactsApp componentWillUnmount called");
	}

	//Prop Changes Phase

	/*Invoked when a component is receiving new props.
		setState will not trigger a new re-render*/
	componentWillReceiveProps(){
		console.log("ContactsApp componentWillReceiveProps called");
	}

	/*Special fuction called before the render function and gives the opportunity
		to define if a rendering is needed or can be skipped
		@return boolean
		*/
	shouldComponentUpdate(){
		console.log("ContactsApp shouldComponentUpdate called");
		return true;
	}

	/*Invoked immediately before rendering when new pros or state are being received
		Any state  changes made by setState are not allowed in this function, because
		this sould be strictly used to prepare for a upcoming update, and not trigger
		and update itself.
		NOTE - The render method is called after this function*/
	componentWillUpdate(){
		console.log("ContactsApp componentWillUpdate called");
	}

	/*Invoked immediately after component's updates are flushed to the DOM*/
	componentDidUpdate(){
		console.log("ContactsApp componentDidUpdate called");
	}
}

export default TutorialComponent;