const mysql = require('mysql');

let config = {
    host: 'localhost',
    user: 'prostrmk',
    password: '0',
    database: 'maxpeep'
};

class Database {
    constructor() {
        this.connection = mysql.createConnection(config);
    }
    query(sql, args) {
        return new Promise((resolve, reject) => {
            this.connection.query(sql, args, (err, rows) => {
                if (err)
                    return reject(err);
                console.log(sql);
                resolve(rows);
            });
        });
    }

    execute(sql, args){
        this.connection.query(sql, args, (err)=>{
            if (err) console.log(err);
            console.log(sql);
        })
    }

    close() {
        return new Promise((resolve, reject) => {
            this.connection.end(err => {
                if (err)
                    return reject(err);
                resolve();
            });
        });
    }
}

module.exports.Database = Database;
// module.exports.execute = execute;
// module.exports.executeQuery = executeQuery;