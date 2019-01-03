const valUtil = require('../util/uiValidator');
const bcrypt = require('bcrypt');
const db = require("../util/database");


QUnit.test("registration form testing should be ok", assert => {
    assert.equal(valUtil.validatePassword("zxccxz"), true);
});

QUnit.test("registration form testing should be failed", assert => {
    assert.equal(valUtil.validatePassword("zxc"), false);
});

QUnit.test("registration form testing should be ok", assert => {
    assert.equal(valUtil.validateUsername("Maxim"), true);
});

QUnit.test("registration form testing should be failed", assert => {
    assert.equal(valUtil.validateUsername("Ma"), false);
});

QUnit.test("registration form testing should be failed", assert => {
    assert.equal(bcrypt.compare("zxc", 'zxc', (err, res) => {
        return res
    }), undefined);
});

QUnit.test("registration form testing should be failed", assert => {
    let done = assert.async();
    new db.Database().query('SELECT * FROM users WHERE id=1').then(data=>{
        assert.equal(data.length > 0, true);
        done();
    })
});

QUnit.test("registration form testing should be failed", assert => {
    let done = assert.async();
    new db.Database().query('SELECT * FROM users WHERE id=-1').then(data=>{
        assert.equal(data.length > 0, false);
        done();
    })
});

QUnit.test("registration form testing should be failed", assert => {
    let done = assert.async();
    new db.Database().query('SELECT * FROM users WHERE username=\'andrey\'').then(data => {
        assert.equal(data[0].username, 'andrey');
        done();
    })
});

QUnit.test("registration form testing should be failed", assert => {
    let done = assert.async();
    new db.Database().query('SELECT * FROM users WHERE username=\'Person which not in base\'').then(data => {
        assert.equal(data.length > 0, false);
        done();
    })
});




// node_modules/qunit/bin/qunit test/frontUiTestAltLib.test.js