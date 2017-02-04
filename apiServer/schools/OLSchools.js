/**
 * Project. Our League for D3S Hackathon (Team 4)
 * File Description : Get School List for API
 * User: MR.LEE(leeshoon1344@gmail.com)
 * Date: 2017. 2. 4
 * Time: PM 7:02
 */

var monk = require('monk');
var db = monk('userleague:8bdc24e289d44a52942d910b698cf758~@localhost:58712/OurLeague');

function OLSchool() {

}

OLSchool.prototype.getAllSchoolList = function getAllSchoolList(req, res) {
    var collection = db.get("schools");
    collection.find({}, { fields : { _id: 0, schoolName: 1 }}, function(e,docs){
        res.setHeader('Content-Type', 'application/json');
        res.send(JSON.stringify(docs));
    });
};

module.exports = OLSchool;




