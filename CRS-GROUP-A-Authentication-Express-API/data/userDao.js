var mysql = require('mysql');  // External module for Node/Express
var User=require('../model/user.js');

class UserDao {

    constructor() {
    }

    getUsers(callback) {

      var GET_CUSTOMERS = "SELECT * FROM users";

      var con = mysql.createConnection({
        host: "localhost",  // local host / ip address of your machine
        user: "root",
        password: "root",
        database: "crs-group-a"
      });
      con.connect(function(err) {
          if (err) throw err;
          con.query(GET_CUSTOMERS, function (err, result) {
            if (err) throw err;
            console.log("RESULT FROM DAO: ", result);
            return callback(null, result);
          });
        });
    }

    getUserById(id, callback) {

      var GET_CUSTOMER = "SELECT * FROM users WHERE Id = ?";
      var con = mysql.createConnection({
        host: "localhost",  // local host / ip address of your machine
        user: "root",
        password: "root",
        database: "crs-group-a"
      });
      con.connect(function(err) {
          if (err) throw err;
          con.query(GET_CUSTOMER, [id], function (err, result) {
            if (err) throw err;
            console.log("RESULT FROM DAO: ", result);
            return callback(null, result);
          });
        });
    }

    userLogin(username, password, role, callback) {

        var GET_USER = "SELECT * FROM users WHERE Username = ? AND Password = ? AND RoleId = ?";

        let roleId = 0;
        switch(role) {
            case "admin": roleId = 1; break;
            case "professor": roleId = 2; break;
            case "student": roleId = 3; break;
            default: roleId = 1;
        }
        
        var con = mysql.createConnection({
          host: "localhost",  // local host / ip address of your machine
          user: "root",
          password: "root",
          database: "crs-group-a"
        });
        con.connect(function(err) {
            if (err) throw err;
            con.query(GET_USER, [username, password, roleId], function (err, result) {
              if (err) throw err;
              console.log("RESULT FROM DAO: ", result);
              return callback(null, result);
            });
          });
      }
}

module.exports = UserDao;