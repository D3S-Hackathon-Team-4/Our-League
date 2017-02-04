/**
 * Project. Our League for D3S Hackathon (Team 4)
 * File Description : User Management for API
 * User: MR.LEE(leeshoon1344@gmail.com)
 * Date: 2017. 2. 4
 * Time: PM 7:29
 */

var monk = require('monk');
var crypto = require('crypto'),
    algorithm = 'aes-256-ctr',
    password = 'd6F3Efeq';
var olCryptoModule = require("../crypto/OLCryptoManager");

var olCryptoManager = new olCryptoModule();

var db = monk('userleague:8bdc24e289d44a52942d910b698cf758~@localhost:58712/OurLeague');

function OLUsers() {

}

OLUsers.prototype.createUser = function createUser(req, res) {
    /*console.log("id :  " + req.params.id);
    console.log("name : " + req.body.name);
    console.log("password : " + req.body.password);
    console.log("school : " + req.body.school);
    console.log("grade : " + req.body.grade);
    console.log("class : " + req.body.klass);*/

    res.setHeader('Content-Type', 'application/json');

    if(req.body.password == null || req.body.school == null || req.body.grade == null || req.body.klass == null ||
        req.body.password == "null" || req.body.school == "null" || req.body.grade == "null" || req.body.klass == "null") {
        res.status(500);
        res.send(JSON.stringify({status : "500 Bad Request"}));
        return;
    }

    var data;

    olCryptoManager.hashPassword(req.body.password, function(hash) {
        data = {
            id : encrypt(req.params.id),
            hash: hash,
            school: encrypt(req.body.school),
            name: encrypt(req.body.name),
            grade: req.body.grade,
            class: req.body.klass
        };

        var collection = db.get("users");

        collection.findOne({id: data.id},function(err,doc){
            if(doc == null || doc == "null") {
                collection.insert(data, function(err, result){
                    res.status(200);
                    res.send(JSON.stringify({status : "create account successfully"}));
                });
            } else {
                res.status(400);
                res.send(JSON.stringify({status : "exists account"}));
            }
        });
    });
};

OLUsers.prototype.getUserInformation = function getUserInformation(req, res) {
    res.setHeader('Content-Type', 'application/json');

    var collection = db.get("users");

    collection.findOne({id: encrypt(req.params.id)}, {fields : { _id: 0, id: 1, school: 1, name: 1, grade: 1, class: 1 }}, function(err,doc){
        if(doc == null || doc == "null") {
            res.status(404);
            res.send(JSON.stringify({status : "404 Not Found"}));
        } else {
            res.status(200);

            var decryptDoc = {
                id: decrypt(doc.id),
                school: decrypt(doc.school),
                name: decrypt(doc.name),
                grade: doc.grade,
                class: doc.class
            };

            res.send(JSON.stringify(decryptDoc));
        }
    });
};

OLUsers.prototype.auth = function auth(req, res) {
    res.setHeader('Content-Type', 'application/json');
    var collection = db.get("users");

    collection.findOne({id: encrypt(req.params.id)}, {}, function(err,doc){
        if(doc == null || doc == "null") {
            res.status(404);
            res.send(JSON.stringify({status : "404 Not Found"}));
        } else {
            olCryptoManager.isPasswordCorrect(doc.hash, req.body.password, function(correct) {
                if(correct) {
                    res.status(200);

                    var decryptDoc = {
                        loginStatus: "Success",
                        id: decrypt(doc.id),
                        school: decrypt(doc.school),
                        name: decrypt(doc.name),
                        grade: doc.grade,
                        class: doc.class
                    };

                    res.send(JSON.stringify(decryptDoc));
                } else {
                    res.status(200);

                    var decryptDoc = {
                        loginStatus: "Failed"
                    };

                    res.send(JSON.stringify(decryptDoc));
                }
            });
        }
    });
};

function encrypt(text){
    var cipher = crypto.createCipher(algorithm, password);
    var crypted = cipher.update(text,'utf8','hex');
    crypted += cipher.final('hex');
    return crypted;
}

function decrypt(text){
    var decipher = crypto.createDecipher(algorithm, password);
    var dec = decipher.update(text,'hex','utf8');
    dec += decipher.final('utf8');
    return dec;
}

module.exports = OLUsers;