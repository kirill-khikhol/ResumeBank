import React from 'react';
import $ from 'jquery';

function SignUp(){

    function submitFirstRegistration(e) {
        e.preventDefault();
        var form = document.forms[0];
        var element=form.elements;
        var json={};
        for(let i=0; i<element.length-2;i++){
            json[element[i].name]=element[i].value;
        }console.log(json);

        $.ajax({crossDomain: true,
            url: 'http://localhost:8080/account/registration',
            method: 'POST',
            // data: {"login":login,"password": password},
            dataType: 'json',
            contentType: 'application/json',
            headers:{ "Access-Control-Allow-Origin": "*"},
            //     "Access-Control-Allow-Methods: ": "GET",
            //     "Access-Control-Allow-Headers: ": "Authorization",},
            // })
        })
            .done(function (resp) {
                console.log(resp);
            })
            .fail(function (xhr, status, error) {
                for (let i of arguments)
                    console.log(i);
            })
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
        <input name="login" type="email" required maxLength="15" id="login"/></label><br/>
    <label>Password:<br/>
        <input name="password" type="password" required maxLength="30" minLength="8" id="password1" onChange={passwordValidate}/>
    </label><br/>
    <label>Confirm password:<br/>
        <input name="password" type="password" required maxLength="30" minLength="8" id="password2" onChange={passwordValidate}/>
    </label><br/>
    <select name="role" defaultValue='Account`s type:' required>
        <option disabled>Account`s type:</option>
        <option value=''>Jobseeker</option>
        <option value=''>Company</option>
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