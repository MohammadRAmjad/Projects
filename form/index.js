const express = require("express");
const app = express();
const pool = require("./db")
const path = require('path')
//const index = require("./index.html")
app.use(express.json()) // request body


app.use(express.static(path.join(__dirname)))


app.get('/',(req,res)=>{
    res.sendFile(path.join(__dirname, 'index.html'));
})
//create form 
app.post("/forms", async(req,res)=>{
    try{
        const{user_Fname, user_Lname, user_Uname, user_Uemail} = req.body;
        const newForm = await pool.query("INSERT INTO form (user_Fname, user_Lname, user_Uname, user_Uemail) VALUES($1, $2, $3, $4) RETURNING *",
        [user_Fname, user_Lname, user_Uname, user_Uemail]);

       // res.json(newForm);
       res.json(newForm.rows[1]);

    }catch(err){
        console.error(err.message)
    }
});

app.listen(3000, () =>{
    console.log("server is listening at port 3000");
});
