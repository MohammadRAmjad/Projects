const Pool = require("pg").Pool;

const pool = new Pool({
    user : "mohammadrezaamjad",
    database: "form_database",
    host: "localhost",
    port: 5432
});

module.exports = pool;