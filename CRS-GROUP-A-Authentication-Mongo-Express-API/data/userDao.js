var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/test";
// const dbConn = require('../config/db.js');

class UserDao {

    constructor() {
    }

  getUsers(callback) {
      console.log("get users dao method");
      MongoClient.connect(url, function(err, db) {
          if (err) throw err;
          var dbo = db.db("crs-group-a");
          dbo.collection("users").find().toArray(function(err, result) {
              if (err) throw err;
              console.log(result);
              db.close();
              return callback(err, result);
          });
      });
  }

  getUserById(id, callback) {
      console.log("get user by Id dao method");
      MongoClient.connect(url, function(err, db) {
          if (err) throw err;
          var query = { Id: id };
          var dbo = db.db("crs-group-a");
          dbo.collection("users").find(query).toArray(function(err, result) {
            if (err) throw err;
            console.log(result);
            db.close();
            return callback(err, result);
          });
      });
  }

  getUserByUsername(username, callback) {
    console.log("get user by username dao method");
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var query = { username: username };
        var dbo = db.db("crs-group-a");
        dbo.collection("users").find(query).toArray(function(err, result) {
          if (err) throw err;
          console.log(result);
          db.close();
          return callback(err, result);
        });
    });
  }

  userLogin(username, password, roleId, callback) {
      console.log("get login dao method");
      MongoClient.connect(url, function(err, db) {
          if (err) throw err;
          var query = { username: username, password: password, roleId: parseInt(roleId) };
          var dbo = db.db("crs-group-a");
          dbo.collection("users").find(query).toArray(function(err, result) {
            if (err) throw err;
            console.log(result);
            db.close();
            return callback(err, result);
          });
      });
  }
  
  updatePassword(user, callback) {
    console.log("get login dao method");
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var query = { username: user.username};
        var update = { $set: {password: user.newPassword } };
        var dbo = db.db("crs-group-a");
        dbo.collection("users").updateOne(query, update, function(err, result) {
          if (err) throw err;
          console.log(result);
          db.close();
          return callback(err, result);
        });
    });
}
}

module.exports = UserDao;