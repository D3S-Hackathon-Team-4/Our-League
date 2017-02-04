/**
 * Project. Our League for D3S Hackathon (Team 4)
 * File Description : API server main entry
 * User: MR.LEE(leeshoon1344@gmail.com)
 * Date: 2017. 2. 4
 * Time: PM 5:37
 */

const csv = require("csvtojson");
var monk = require('monk');
var express = require("express");
var bodyParser = require('body-parser');
var olSchoolsModule = require("./schools/OLSchools");
var olUsersModule = require("./users/OLUsers");
var olSportsModule = require("./sports/OLSports");
var olLeagueModule = require("./league/OLLeague");
var olRankingModule = require("./ranking/OLRanking");

var olSchools = new olSchoolsModule();
var olUsers = new olUsersModule();
var olSports = new olSportsModule();
var olLeague = new olLeagueModule();
var olRanking = new olRankingModule();

var app = express();

app.listen(3055, function() {
    console.log("Our League API Server has started on http://localhost:3055");
});

app.disable('x-powered-by');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
}));

app.get("/", function(req, res) {
    res.status(500);
    res.setHeader('Content-Type', 'application/json');
    res.setHeader('X-Powered-By', 'Awesome App v0.0.1' );
    res.send(JSON.stringify({ status: "500 Bad Request" }));
});

app.get('/api', function(req, res) {
    res.status(500);
    res.setHeader('Content-Type', 'application/json');
    res.send(JSON.stringify({ status: "500 Bad Request" }));
});

app.get('/api/v1', function(req, res) {
    res.status(500);
    res.setHeader('Content-Type', 'application/json');
    res.send(JSON.stringify({ status: "500 Bad Request" }));
});

app.get('/api/v1/schools', function(req, res) {
    olSchools.getAllSchoolList(req, res);
});

app.get('/api/v1/users', function(req, res) {
    res.status(500);
    res.setHeader('Content-Type', 'application/json');
    res.send(JSON.stringify({ status: "500 Bad Request" }));
});

app.get('/api/v1/users/create/:id', function(req, res) {
    res.status(500);
    res.setHeader('Content-Type', 'application/json');
    res.send(JSON.stringify({ status: "500 Bad Request" }));
});

app.post('/api/v1/users/create/:id', function(req, res) {
    olUsers.createUser(req, res, "", "", "", "", "", "");
});

app.get('/api/v1/users/:id', function(req, res) {
    olUsers.getUserInformation(req, res);
});

app.post('/api/v1/auth/:id', function(req, res) {
    olUsers.auth(req, res);
});

app.get('/api/v1/sports', function(req, res) {
    olSports.getAllSportList(req, res)
});

app.get('/api/v1/competition/create', function(req, res) {
    olLeague.createLeague(req, res);
});

app.get('/api/v1/competition/update', function(req, res) {
    olLeague.modifyLeague(req, res);
});

app.get('/api/v1/competition/', function(req, res) {
    olLeague.getLeague(req, res);
});

app.get('/api/v1/ranking/', function(req, res) {
    olRanking.getRanking(req, res);
});

app.use(function(req, res, next) {
    var err = new Error('Not Found');
    err.status = 404;
    next(err);
});

app.use(function(err, req, res, next) {
    // set locals, only providing error in development
    res.locals.message = err.message;
    res.locals.error = req.app.get('env') === 'development' ? err : {};

    // render the error page
    res.status(err.status || 500);
    res.send(JSON.stringify({ status: err.status }));
});

/*var db = monk('userleague:8bdc24e289d44a52942d910b698cf758~@localhost:58712/OurLeague');
var collection = db.get('ranking');
const data = "data/2015 유치원,초,중,고,특수.csv";

csv().fromFile(data).on('json', function(jsonObj) {
    var school = {
            school: jsonObj.학교명,
            winCount: 0,
            loseCount: 0
    };

    collection.insert(school, function(err, result){
        console.log("INSERT SUCCESSFULLY");
    });
}).on('done', function(error) {
    console.log('end');
});*/