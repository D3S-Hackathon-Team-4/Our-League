/**
 * Project. Our League for D3S Hackathon (Team 4)
 * File Description : User Management for API Private Framework
 * User: MR.LEE(leeshoon1344@gmail.com)
 * Date: 2017. 2. 4
 * Time: PM 7:59
 */

var crypto = require('crypto');
var argon2i = require('argon2-ffi').argon2i;
var Promise = require('bluebird');
var randomBytes = Promise.promisify(crypto.randomBytes);

function OLCryptoManager() {

}

OLCryptoManager.prototype.hashPassword = function hashPassword(password, callback) {
    var password = new Buffer(password);
    var options = { timeCost: 4, memoryCost: 1 << 14, parallelism: 2, hashLength: 64 };

    randomBytes(32).then(salt => argon2i.hash(password, salt, options)).then(callback);
};

OLCryptoManager.prototype.isPasswordCorrect = function isPasswordCorrect(hash, password, callback) {
    //console.log(hash);
    //console.log(password);
    argon2i.verify(hash, password)
        .then(callback);
};

module.exports = OLCryptoManager;