/**
 * Project. Our League for D3S Hackathon (Team 4)
 * File Description : League Manager for API
 * User: MR.LEE(leeshoon1344@gmail.com)
 * Date: 2017. 2. 4
 * Time: PM 10:02
 */

var monk = require('monk');
var crypto = require('crypto'),
    algorithm = 'aes-256-ctr',
    password = 'd6F3Efeq';

var db = monk('userleague:8bdc24e289d44a52942d910b698cf758~@localhost:58712/OurLeague');

function OLLeague() {

}

OLLeague.prototype.createLeague = function createLeague(req, res) {
    res.setHeader('Content-Type', 'application/json');

    if(req.query.latitude == null || req.query.longitude == null || req.query.school == null || req.query.sport == null ||
        req.query.members == null || req.query.date == null || req.query.king == null ||
        req.query.latitude == "null" || req.query.longitude == "null" || req.query.school == "null" || req.query.sport == "null" ||
        req.query.members == "null" || req.query.date == "null" || req.query.king == "null") {
        res.status(500);
        res.send(JSON.stringify({status : "500 Bad Request"}));
        return;
    }

    var data = {
        latitude: req.query.latitude,
        longitude: req.query.longitude,
        school: encrypt(req.query.school),
        sport: encrypt(req.query.sport),
        members: encrypt(req.query.members),
        date: req.query.date,
        king: encrypt(req.query.king),
        winSchool: encrypt(req.query.school),
        isEnd: false
    };

    var collection = db.get("schoolCompetition");

    collection.insert(data, function(err, result){
        res.status(200);
        res.send(JSON.stringify({status : "create competition successfully"}));
    });
};

OLLeague.prototype.modifyLeague = function modifyLeague(req, res) {
    res.setHeader('Content-Type', 'application/json');

    var originalData = {
        latitude: req.query.latitude,
        longitude: req.query.longitude,
        school: encrypt(req.query.school),
        sport: encrypt(req.query.sport)
    };

    var collection = db.get("schoolCompetition");

    collection.update(originalData, {$set: { winSchool: encrypt(req.query.winSchool), isEnd: true }},function(err,doc) {
        if(err){
            console.log(err);
            res.status(500);
            res.send(JSON.stringify({status : "500 Bad Request"}));
            return;
        } else {
            res.status(200);
            res.send(JSON.stringify({status: "Update Successfully"}));
        }
    });
};

OLLeague.prototype.getLeague = function getLeague(req, res) {
    res.setHeader('Content-Type', 'application/json');

    var originalData = {
        latitude: req.query.latitude,
        longitude: req.query.longitude,
        school: encrypt(req.query.school),
        sport: encrypt(req.query.sport)
    };

    var collection = db.get("schoolCompetition");

    collection.findOne(originalData, {}, function(err, doc) {
        if(err) {
            console.log(err);
            res.status(500);
            res.send(JSON.stringify({status : "500 Bad Request"}));
            return;
        } else {
            res.status(200);

            console.log(doc);

            var decryptData = {
                "latitude": "31.254",
                "longitude": "125.147",
                "school": decrypt(doc.school),
                "sport": decrypt(doc.sport),
                "members": decrypt(doc.members),
                "date": doc.date,
                "king": decrypt(doc.king),
                "winSchool": decrypt(doc.winSchool),
                "isEnd": doc.isEnd
            };

            res.send(JSON.stringify(decryptData));
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

module.exports = OLLeague;