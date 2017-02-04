/**
 * Project. Our League for D3S Hackathon (Team 4)
 * File Description : Ranking for API
 * User: MR.LEE(leeshoon1344@gmail.com)
 * Date: 2017. 2. 5
 * Time: AM 2:05
 */

const csv = require("csvtojson");
var monk = require('monk');
var crypto = require('crypto'),
    algorithm = 'aes-256-ctr',
    password = 'd6F3Efeq';

var db = monk('userleague:8bdc24e289d44a52942d910b698cf758~@localhost:58712/OurLeague');
var i = 0;

function OLRanking() {

}

OLRanking.prototype.getRanking = function getRanking(req, res) {
    res.setHeader('Content-Type', 'application/json');

    const data = "./data/2015 유치원,초,중,고,특수.csv";

    csv().fromFile(data).on('json', function(jsonObj) {
        var school = {
            school: jsonObj.학교명,
            winCount: 0,
            loseCount: 0
        };

        db.get("ranking").insert(school, function(err, result){
            //console.log("INSERT SUCCESSFULLY");
        });
    }).on('done', function(error) {
        var collection = db.get("schoolCompetition");

        collection.find({}, {}, function(err, doc) {
            res.status(200);

            for(i = 0; i < doc.length; i++) {
                if(doc[i].isEnd) {
                    if(doc[i].winSchool == doc[i].school) { //WIN
                        var data = doc[i];
                        db.get("ranking").findOne({ school: decrypt(data.school) }, {}, function(err, doc) {
                            var winCount = doc.winCount + 1;

                            db.get("ranking").update({ school: decrypt(data.school) }, { $set: { school: decrypt(data.school), winCount: winCount } }, function(err, result){

                            });
                        });
                    } else {
                        var data = doc[i];
                        db.get("ranking").findOne({ school: decrypt(data.school) }, {}, function(err, doc) {
                            var loseCount = doc.loseCount + 1;

                            db.get("ranking").update({ school: decrypt(data.school) }, { $set: { school: decrypt(data.school), loseCount: loseCount } }, function(err, result){

                            });
                        });
                    }
                }
                /*

                 console("W");
                 collection.findOne({ school: doc[i].school }, {}, function(err, doc2) {
                 var winCount = doc2.winCount + 1;

                 collection.update({ schoolName: decrypt(doc[i].school) }, { $set: { schoolName: decrypt(doc[i].school), winCount: winCount } }, function(err, result){

                 });
                 });

                 } else { //LOSE
                 console("L");
                 collection.findOne({ school: doc[i].school }, {}, function(err, doc2) {
                 var loseCount = doc2.loseCount + 1;

                 collection.update({ schoolName: decrypt(doc[i].school) }, { $set: { lschoolName: decrypt(doc[i].school), oseCount: loseCount } }, function(err, result){

                 });
                 });
                 }*/
            }

            db.get("ranking").find({}, {}, function(err, doc2) {
                res.send(JSON.stringify(doc2));
                db.get("ranking").remove();
            });
        });
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

module.exports = OLRanking;