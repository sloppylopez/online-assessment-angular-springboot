import express from 'express';
import expressWsMiddleware from 'express-ws';
import cors from 'cors';

const axios = require('axios');
const app = expressWsMiddleware(express()).app;

app.use(cors());

app.get('/report', (req, res) => {
  axios.get('http://localhost:8081/report').then(resp => {
    res.send(resp.data);
  });
});

app.listen(3000, () => {
  console.log('Middleware listening on port 3000!');
});
