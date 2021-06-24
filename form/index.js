const express = require("express");
const app = express();
const pool = require("./db")

app.use(express.json()) // request body

app.listen(3000, () =>{
    console.log("server is listening at port 3000");
});




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