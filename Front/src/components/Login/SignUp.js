import React from 'react';
import ReactDOM from 'react-dom';
import $ from 'jquery';
import afterRegistration from './After';
import WrongCredentials from './WrongCredentials';
import NotSent from './NotSent';
function SignUp(){

    function submitFirstRegistration(e) {
        e.preventDefault();
        var form = document.forms[0];
        var element=form.elements;
        var json={};
        for(let i=0; i<element.length-2;i++){
            json[element[i].name]=element[i].value;
        }

        console.log("Результат:"+json);
        console.log(JSON.stringify(json));


        $.ajax({
            'async': true,
            'crossDomain': true,
            'url': 'http://localhost:8080/account/registration',
            'method': 'POST',
            'headers': {
                'content-type': 'application/json',
                'cache-control': 'no-cache',
                'postman-token': 'b412df5a-439f-28b6-10b4-1c5b81b407fe'
            },
            'processData': false,
            'data': JSON.stringify(json)
        })
            .done(function (resp) {
                console.log(resp);
                switch (resp){
                    case "notActivated": ReactDOM.render(afterRegistration, document.getElementById('root'));
                        break;
                    case "wrongCredentials": ReactDOM.render(<WrongCredentials/>, document.getElementById('root'));
                    break;
                    case "noSendEmail": break;
                    case "false": break;
                }
            })
            .fail(function (xhr, status, error) {
                for (let i of arguments)
                    console.log(i);
                console.log(json);
            })
    }
    function mailValidate() {
        let mail=$('#login');
            let sendMail={};
            sendMail['login']=$('#login')[0].value;
        console.log(sendMail);
        // console.log("mail[0].value);
        $.ajax({
            "async": true,
            "crossDomain": true,
            "url": "http://localhost:8080/account/isExist",
            "method": "POST",
            "headers": {
                "content-type": "application/json",
                "cache-control": "no-cache",
                "postman-token": "e9187d34-6acb-965f-0ae9-ab9140ebbb1f"
            },
            "processData": false,
          'data':JSON.stringify(sendMail)
        })
            .done(function (resp) {
                switch (resp){
                    case "ok":
                        if(mail.hasClass('error')) mail.removeClass('error');
                        mail.addClass('correct');
                        mail.attr('title','');
                        break;
                    case "false": case "wrongRequest":
                        if(mail.hasClass('correct')) mail.removeClass('correct');
                        mail.addClass('error');
                        mail.attr('title','try another login');
                }
            })
            .fail(function (xhr,status, error) {
                for (let i of arguments)
                    console.log(i);
            });
    }
    function passwordValidate() {
        let pas1 = $('#password1');
        let pas2 = $('#password2');
        if (pas1.val() !== pas2.val()) {
            if (pas1.hasClass('correct')) {
                pas1.removeClass('correct');
                pas2.removeClass('correct');
            }
            pas1.addClass('error');
            pas2.addClass('error');
        } else {
            if (pas1.hasClass('error')) {
                pas1.removeClass('error');
                pas2.removeClass('error');
            }
            pas1.addClass('correct');
            pas2.addClass('correct');
        }
    }
return <form action="registration2.html" method="post" name="firstRegistration">
    <label>E-mail:<br/>
        <input name="login" type="email" required maxLength="50" id="login" onBlur={mailValidate}/></label><br/>
    <label>Password:<br/>
        <input name="password" type="password" required maxLength="30" minLength="8" id="password1" onChange={passwordValidate}/>
    </label><br/>
    <label>Confirm password:<br/>
        <input name="password" type="password" required maxLength="30" minLength="8" id="password2" onChange={passwordValidate}/>
    </label><br/>
    <select name="role" defaultValue='Account`s type:' required>
        <option disabled>Account`s type:</option>
        <option value='JOB_SEEKER'>Jobseeker</option>
        <option value='COMPANY'>Company</option>
    </select><br/><br/>
    <label>Choose your secret question:<br/>
        <select name="typeQuestion" defaultValue='' required>
            <option disabled></option>
            <option value='question1'>Q1</option>
            <option value='question2'>Q2</option>
        </select></label><br/>
    <label>Answer:<br/>
        <input name="question" type="text" id="answer" required/></label><br/>
    <label>Telephone number(optional):<br/>
        <input name="phone" type="tel" id="telephoneNumber" pattern="^[0-9]+$" defaultValue='' maxLength='20'/></label><br/>
    <label><input name="agree" type="checkbox" id="agree" required/>I have read <a href="">something</a> and
        agree</label><br/>
    <button type="submit" id="send" onClick={submitFirstRegistration}>Send</button>
</form>;
}
export default SignUp;