/* Youssef Boujebha
* 11/22/25
* CSC 193 Assignment 8*/
'use strict';
const express = require('express');
const app = express();

app.use(express.static('public')); // serve static files

const PORT = process.env.PORT || 8000;
app.listen(PORT);
console.log(`Server running on http://localhost:${PORT}`);

// Splendid Circles exercise
// Go to http://localhost:8000/math/circle/4
app.get('/math/circle/:r', (req, res) => {
    let r = Number(req.params['r']);
    if (isNaN(r) || r <= 0) {
        res.type('text').status(400).send('Error: radius must be a positive number.');
    } else {
        let area = Math.PI * r * r;
        let circumference = 2 * Math.PI * r;
        res.json({
            area: area.toFixed(2),
            circumference: circumference.toFixed(2)
        });
    }
});

// Hello, You! Exercise
// Go to http://localhost:8000/hello/name?first=Youssef&last=Boujebha
app.get('/hello/name', (req, res) => {
    let first = req.query['first'];
    let last = req.query['last'];
    let missing = [];
    if (!first) missing.push('first');
    if (!last) missing.push('last');

    if (missing.length > 0) {
        res.type('text').status(400)
            .send(`Missing Required GET parameters: ${missing.join(', ')}`);
    } else {
        res.type('text').send(`Hello ${first} ${last}`);
    }
});