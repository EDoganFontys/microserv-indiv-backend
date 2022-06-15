import http from 'k6/http';
import {sleep} from 'k6';

export let options = {
    insecureSkipTLSVerify: true,
    noConnectionReuse: false,
    stages:[
        { duration: '2m', target:100},
        { duration: '5m', target:100},
        { duration: '2m', target:200},
        { duration: '5m', target:200},
        { duration: '2m', target:300},
        { duration: '5m', target:300},
        { duration: '2m', target:400},
        { duration: '5m', target:400},
        { duration: '10m', target:0},
    ]
};
const api_url = 'http://localhost:4500/api/v1';
export default () => {
    let bodyLogin = JSON.stringify({ userId: 1, username: "Mark" , email: "email@email.nl"});

    let bodyRegister = JSON.stringify({ userId: 1, username: "Mark" , password : "password", email: "email@email.nl"});
    let params = "{headers: {'content-type': application/json}}";
    http.batch([
        ['POST', `${api_url}/auth/login`,bodyLogin,{headers: {'content-type': 'application/json'}}],
        ['POST',`${api_url}/auth/register`,bodyRegister,{headers: {'content-type': 'application/json'}}],
        ['GET',`${api_url}/auth/user/info`],
    ]);
    sleep(1);
};
