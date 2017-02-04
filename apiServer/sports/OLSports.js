/**
 * Project. Our League for D3S Hackathon (Team 4)
 * File Description : Get Sports List for API
 * User: MR.LEE(leeshoon1344@gmail.com)
 * Date: 2017. 2. 4
 * Time: PM 9:50
 */

var monk = require('monk');
var db = monk('userleague:8bdc24e289d44a52942d910b698cf758~@localhost:58712/OurLeague');

function OLSports() {

}

OLSports.prototype.getAllSportList = function getAllSportList(req, res) {
    var collection = db.get("sports");
    collection.find({}, { fields : { _id: 0, code: 1, sports: 1 }}, function(e,docs){
        res.setHeader('Content-Type', 'application/json');
        res.send(JSON.stringify(docs));
    });
};

module.exports = OLSports;