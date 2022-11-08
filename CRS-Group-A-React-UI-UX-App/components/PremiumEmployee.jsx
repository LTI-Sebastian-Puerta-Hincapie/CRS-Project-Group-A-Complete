import React from 'react';
import EmployeeService from '../services/EmployeeService.jsx'

class PremiumEmployee extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            employees: [],
            employee: []
        }
        this.addEmployee = this.addEmployee.bind(this);
        this.editEmployee = this.editEmployee.bind(this);
        this.deleteEmployee = this.deleteEmployee.bind(this);
    }

    deleteEmployee(id){
        console.log("Delete Employee");
        EmployeeService.deleteEmployee(id);
    }

    viewEmployee(id){
        console.log("View Employee");
        EmployeeService.getEmployee(id).then((res) => {
            this.setState({ employee: res.data});
        });
    }

    editEmployee(id){
        console.log("Edit Employee");

        const employeeFormData = {};
        for (const field in this.refs) {
            console.log(field);
            employeeFormData[field] = this.refs[field].value;
        }
        EmployeeService.updateEmployee(id, employeeFormData);
    }

    componentDidMount(){
        EmployeeService.getEmployees().then((res) => {
            this.setState({ employees: res.data});
        });
    }

    addEmployee(e){
        console.log("Add Employee");
        e.preventDefault();

        const employeeFormData = {};
        for (const field in this.refs) {
            console.log(field);
            employeeFormData[field] = this.refs[field].value;
        }

        console.log('-->', employeeFormData);

        EmployeeService.createEmployee(employeeFormData)
    }

    handleRefresh() {
        console.log("Refresh");
        EmployeeService.getEmployees().then((res) => {
            this.setState({ employees: res.data});
        });
    }

  render() {

    let style = {
        margin: 50,
        background: "#ffa500",
        padding: 25
    }

    let input = {
        margin: 10
    }

    let item = {
        padding: 10
    }
    let button  ={
        margin: 5
    }

    return (
        <div style={style}>
          <h1> PREMIUM EMPLOYEE </h1>
          <form id="employee-form">
            <label> Id: </label>
            <input style={input} ref="employeeId" className="employeeId" type='id' name="employeeId"/><br/>
            <label> Name: </label>
            <input style={input} ref="employeeName" className="employeeName" type='name' name="employeeName"/><br/>
            <label> Age: </label>
            <input style={input} ref="employeeAge" className="employeeAge" type='age' name="employeeAge"/><br/>
            <label> Address: </label>
            <input style={input} ref="employeeAddress" className="employeeAddress" type='address' name="employeeAddress"/><br/>
            <input style={input} type="button" value="Save" onClick={this.addEmployee}/>
            <input style={input} type="button" value="Cancel"/>
          </form><br/> 
          <h2> List of employees </h2>
            <input type="button" value="Refresh" onClick={this.handleRefresh.bind(this)}/>    
            <h5> Total: {this.state.employees.length} </h5>
            <ol>
                {this.state.employees.map((employee, index) => (
                    <div style={item}>
                        <li key={index}>
                            (ID: {employee.employeeId},
                            NAME: {employee.employeeName},
                            AGE: {employee.employeeAge},
                            ADDRESS: {employee.employeeAddress})
                            <input style={button} type="button" value="Edit" onClick={() => this.editEmployee(employee.employeeId)}/>
                            <input style={button} type="button" value="Delete" onClick={() => this.deleteEmployee(employee.employeeId)}/>   
                        </li>
                    </div>
                ))}
            </ol>
        </div>
    );
  }
}

export default PremiumEmployee;


