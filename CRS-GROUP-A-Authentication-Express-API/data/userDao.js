const mysql = require('mysql');  // External module for Node/Express
const User=require('../model/user.js');
const dbConn = require('../config/db.js');

class UserDao {

    constructor() {
    }

    getUsers(callback) {

        var GET_CUSTOMERS = "SELECT * FROM users";
        dbConn.query(GET_CUSTOMERS, function (err, result) {
            if (err) throw err;
            console.log("RESULT FROM DAO: ", result);
            return callback(null, result);
            });
    }

    getUserById(id, callback) {

        var GET_CUSTOMER = "SELECT * FROM users WHERE Id = ?";
        dbConn.query(GET_CUSTOMER, [id], function (err, result) {
            if (err) throw err;
            console.log("RESULT FROM DAO: ", result);
            return callback(null, result);
        });
    }

    userLogin(username, password, roleId, callback) {

        var GET_USER = "SELECT * FROM users WHERE Username = ? AND Password = ? AND RoleId = ?";
        dbConn.query(GET_USER, [username, password, roleId], function (err, result) {
              if (err) throw err;
              console.log("RESULT FROM DAO: ", result);
              return callback(null, result);
        });
      }
}

module.exports = UserDao;