const request = require('supertest');
const app = require('../app');
const chai = require('chai');
const expect = chai.expect;


describe('index router', () => {

    it('test server', () => {
        request(app).get('/')
            .expect(200);
    });

    it('test find film by id should be 200', () => {
        request(app).get('/film/1')
            .expect(200);
    });

    it('test find film by id should be 404', () => {
        request(app).get('/film/9999')
            .expect(404);
    });

    it('test admin auth', () => {
        request(app).get('/admin/')
            .expect(403);
    });

    it('test edit', () => {
        request(app).get('/admin/edit/1')
            .expect(403);
    });

    it('test admin/1', () => {
        request(app).post('/admin/1')
            .expect(403);
    });

    it('test adding film', () => {
        let data = {
            title: 'ashdfsgfajkdfdsjfsf',
            description: 'asdsdfgdsdgsfdgjkfdbgdfbgkdfjgjdfkgbdfjkgbdjkfg',
            genre: 'Drama',
            pathToFile: '/img/dram123.jpg'
        };
        request(app).post('/admin/addFilm')
            .send(data)
            .expect(403);
    });

    it('test path to image', () => {
        request(app).get('/images/Screenshot from 2018-12-23 20-00-34.png')
            .expect(200);
    });

    it('Without image', () => {
        request(app).get('/images/NonExistingImage.png')
            .expect(404);
    });

    it('search test should be 200', () => {
        request(app).get('/search?type=genre&string=Drama')
            .expect(200);
    });

    it('search test should be 200', () => {
        request(app).get('/search?type=unknown&string=unknown')
            .expect(404);
    });


});