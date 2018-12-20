const mysql = require('mysql');

let connection = mysql.createConnection({
    host: 'localhost',
    user: 'prostrmk',
    password: '0',
    database: 'maxpeep'
});

const executeQuery = (sql) => {
    connection.connect((err)=>{
        if (err) console.log(err);
        connection.query(sql, (err, result) => {
            if (err) console.log(err);
            console.log(sql);
            return result;
        })
    });
};

const execute = (sql) => {
    connection.connect((err)=>{
        if (err) console.log(err);
        connection.query(sql, (err)=>{
            if (err) console.log(err);
            console.log(sql);
        })
    })
};
module.exports.execute = execute;
module.exports.executeQuery = executeQuery;