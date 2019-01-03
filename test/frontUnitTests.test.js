const valUtil = require('../util/uiValidator');
const assert = require('assert');
const bcrypt = require('bcrypt');
const db = require("../util/database");


describe('Frontend tests', ()=>{

    it('Positive test for validate validatepassword', () => {
        assert.equal(valUtil.validatePassword("zxccxz"), true);
    });

    it('Negative test for validate validatepassword', () => {
        assert.equal(valUtil.validatePassword("zxc"), false);
    });

    it('Positive test for validate validateusername', () => {
        assert.equal(valUtil.validateUsername("Maxim"), true);
    });

    it('Negative test for validate validateusername', () => {
        assert.equal(valUtil.validateUsername("Ma"), false);
    });

    it('crypt testing should be ok', () => {
        bcrypt.compare('zxccxz', '$2b$10$x1Q5W/y4xSDLhPBIDdxcSeflKoGC0NnndyBZUZ8OKcNg6Emmx6G/y', (err, res)=>{
            assert.equal(res,true);
        })
    });

    it('crypt testing should be failed', () => {
        bcrypt.compare('zxccxz', '$2b$31$x1Q5W/y4xasddgdfhgLhPBIDdxcSeflKoGC0NnndyBZUZ8OKcNg6Emmx6G/y', (err, res)=>{
            assert.equal(res,false);
        })
    });

    it('find user by id testing should be found', () => {
        new db.Database().query('SELECT * FROM users WHERE id=1').then(data=>{
            assert.equal(data.length > 0, true)
        })

    });

    it('find user by id testing should not be found', () => {
        new db.Database().query('SELECT * FROM users WHERE id=-1').then(data=>{
            assert.equal(data.length > 0, false)
        })
    });

    it('find right user by id', () => {
        new db.Database().query('SELECT * FROM users WHERE id=1').then(data=>{
            assert.equal(data[0].id, 1)
        })
    });

    it('find user by username testing should be ok', () => {
        new db.Database().query('SELECT * FROM users WHERE username=\'andrey\'').then(data=>{
            assert.equal(data[0].username, 'andrey');
        })
    });

    it('find user by username testing should not be found', () => {
        new db.Database().query('SELECT * FROM users WHERE username=\'Person which not in base\'').then(data=>{
            assert.equal(data[0], undefined)
        })
    });

});
//node_modules/mocha/bin/mocha test/frontUnitTests.test.js