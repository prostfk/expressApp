const valUtil = require('../util/uiValidator');
const assert = require('assert');


describe('TDD tests', ()=>{

    it('add description testing should be false', () => {
        assert.equal(valUtil.validateContent("content"), false);
    });

    it('add description testing should be ok', () => {
        assert.equal(valUtil.validateContent("content" +
            "contentcontentcontentcontentcontentcontentcontentcontentcontent" +
            "contentcontentcontentcontentcontentcontentcontentcontentcontent"), true);
    });

    it('add title testing should be false', () => {
        assert.equal(valUtil.validateTitle("title"), false);
    });

    it('add title testing should be ok', () => {
        assert.equal(valUtil.validateTitle("titletitletitletitletitletitle"), true);
    });

    it('add genre testing should be false', () => {
        assert.equal(valUtil.validateGenre("Drama"), true);
    });

    it('add genre testing should be false', () => {
        assert.equal(valUtil.validateGenre("drama"), false);
    });




});