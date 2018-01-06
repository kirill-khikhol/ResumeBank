import React from 'react';
import ReactDOM from 'react-dom';
import NoActivated from './NoActive';
import Wrong from './WrongCredentials';
import Remove from './Remove';
import $ from 'jquery';

function Logging() {
    function submitLogging(e) {
        e.preventDefault();

        var form = document.forms[0];
        var element = form.elements;
        var json = {};
        for (let i = 0; i < element.length - 1; i++) {
            json[element[i].name] = element[i].value;
        }
        console.log(json);


        $.ajax({
            'async': true,
            'crossDomain': true,
            'url': 'http://localhost:8080/account/login',
            'method': 'POST',
            'headers': {
                'content-type': 'application/json',
                // "origin": "http://localhost",
                'cache-control': 'no-cache',
                'postman-token': 'b412df5a-439f-28b6-10b4-1c5b81b407fe'
            },
            'processData': false,
            'data': '{"login":"resumeBankActivate+test@gmail.com","password":"UyuzVDU5IR"}'
        })
            .done(function (response) {
                    switch (response) {
                        case 'JOB_SEEKER':
                            break;
                        case 'COMPANY':
                            break;
                        case 'notActivated':
                            ReactDOM.render(
                                <NoActivated login={json['login']}/>,
                                document.getElementById('root'));
                            break;
                        case 'wrongCredentials':
                            ReactDOM.render(
<Wrong/>, document.getElementById('root'));
                            break;
                        case 'remove':ReactDOM.render(
                            <Remove/>, document.getElementById('root'));
                            break;
                    }
                }
            )
            .fail(function (xhr, status, error){
                ReactDOM.render(
                    <Wrong/>, document.getElementById('root'));
            });
    };

        function responseCases() {

        }
        return <form method='post' action="http://localhost:8080/account/login/Login.js" id='logging'
              name='logging'>
            <label>
                Login:<br/>
                <input type="email" required id="login" name="login"/>
            </label>
            <br/>
            <label>
                Password:<br/>
                <input type="password" required id="password" name="password"/>
            </label><br/>
            <button id='submit' type='submit' onClick={submitLogging}>Log In</button>
            <br/>
            <a>Forgot password?</a>
        </form>;
    }


    export default Logging;