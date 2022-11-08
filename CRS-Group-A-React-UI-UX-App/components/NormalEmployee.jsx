import React from 'react';

class NormalEmployee extends React.Component {

    constructor(props) {
    super(props);
    this.state = {
        employees: []
    }
    this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(e) {
        e.preventDefault();

        const employeeFormData = {};
        for (const field in this.refs) {
            console.log(field);
            employeeFormData[field] = this.refs[field].value;
        }

        console.log('-->', employeeFormData);

        var myArray = this.state.employees;
        myArray.push(employeeFormData);
        this.setState({employees: myArray});
        console.log("Employee List: ", this.state.employees);
    }

    handleEdit(id) {
        console.log("Edit");

        const employeeFormData = {};
        for (const field in this.refs) {
            console.log(field);
            employeeFormData[field] = this.refs[field].value;
        }

        let user = this.state.employees.filter(x => x.employeeId == id);
        console.log("Current:", user);

        if(employeeFormData != undefined) {
            if(employeeFormData.employeeId != 0 || employeeFormData.employeeId != undefined) {
                user.employeedId = employeeFormData.employeeId;
            }
            if(employeeFormData.employeeName != '' || employeeFormData.employeeName != undefined) {
                user.employeeName = employeeFormData.employeeName;
            }
            if(employeeFormData.employeeAge != 0 || employeeFormData.employeeAge != undefined) {
                user.employeeAge = employeeFormData.employeeAge;
            }
            if(employeeFormData.employeeAddress != '' || employeeFormData.employeeAddress != undefined) {
                user.employeeAddress = employeeFormData.employeeAddress;
            }
        }
        console.log("Updated: ", user);
    }

    handleDelete(id) {
        console.log("Delete");

        var index = this.state.employees.map(x => {
            return x.employeeId;
          }).indexOf(id);
        
        if(index == undefined) return;

        this.state.employees.splice(index, 1);
        console.log("Employee List: ", this.state.employees);
    }

    handleRefresh() {
        console.log("Refresh");
        this.setState({employees: this.state.employees});
    }

    resetForm() {
        document.getElementById("employee-form").reset();
    }

  render() {

    let style = {
        margin: 50,
        background: "#6a5acd",
        padding: 25
    }

    let input = {
        margin: 10
    }

    let item = {
        padding: 10
    }

    return (
        <div style={style}>
          <h1> NORMAL EMPLOYEE </h1>
          <form>
            <label> Id: </label>
            <input style={input} ref="employeeId" className="employeeId" type='id' name="employeeId"/><br/>
            <label> Name: </label>
            <input style={input} ref="employeeName" className="employeeName" type='name' name="employeeName"/><br/>
            <label> Age: </label>
            <input style={input} ref="employeeAge" className="employeeAge" type='age' name="employeeAge"/><br/>
            <label> Address: </label>
            <input style={input} ref="employeeAddress" className="employeeAddress" type='address' name="employeeAddress"/><br/>
            <input style={input} type="submit" value="Save" onClick={this.handleSubmit}/>
            <input style={input} type="button" value="Cancel" onClick={() => this.resetForm}/>
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
                            <input type="button" value="Edit" onClick={this.handleEdit.bind(this, employee.employeeId)}/>
                            <input type="button" value="Delete" onClick={this.handleDelete.bind(this, employee.employeeId)}/>   
                        </li>
                    </div>
                ))}
            </ol>
        </div>
    );
  }
}

export default NormalEmployee;


