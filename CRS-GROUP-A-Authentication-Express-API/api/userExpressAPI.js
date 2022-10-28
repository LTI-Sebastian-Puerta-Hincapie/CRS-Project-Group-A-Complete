const express = require('express')
const cors = require('cors')
const UserDao = require('../data/userDao.js');
const User = require('../model/user.js');

const app = express()
const dao = new UserDao();
const user = new User();

app.use(cors());

// create server here  to expose the Express code
var server = app.listen(3001, function () { 
    var host = server.address().address
    var port = server.address().port
    console.log("Example app listening at http://%s:%s", host, port)
})

// GET USERS
app.get('/users', (req, res) => {
    console.log("GET users API");
    dao.getUsers(function(err, result) {
        console.log("RESULT FROM API: ", result);
        if(err) {
            return next(err);    // let express handle it
        } else {
            res.send(result);
        }
    });
})

// GET USER
app.get('/user/:id', (req, res) => {
    console.log("GET user API");
    dao.getUserById(req.params.id, function(err, result) {
        console.log("RESULT FROM API: ", result);  
        if(err) {
            return next(err);    // let express handle it
        } else {
            res.send(result);
        }
    });
})

// LOGIN
app.post('/user/login', express.json(), (req, res) => {
    console.log("User Login API");
    dao.userLogin(req.body.username, req.body.password, req.body.roleId, function(err, result) {
        console.log("RESULT FROM API: ", result);  
        result[0].Password = "********";
        if(err) {
            return next(err);    // let express handle it
        } else {
            res.send(result);
        }
    });
})
