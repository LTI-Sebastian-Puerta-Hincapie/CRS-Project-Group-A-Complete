import React from 'react';
import EmployeeName from './MycomponentOne.jsx';

class Employee extends React.Component {

	render() {
    return(
        // <div>
        //     <h1>City: {this.props.emp.city}</h1>
        //     <EmployeeName empname={this.props.emp.name} />
        // </div>
        <div>
            <EmployeeId empid={this.props.emp.id} />
            <EmployeeName empname={this.props.emp.name} />
            <EmployeeAge empage={this.props.emp.age} />
            <EmployeeAddress empaddress={this.props.emp.address} />
        </div>
     );
  }
}
export default Employee;





