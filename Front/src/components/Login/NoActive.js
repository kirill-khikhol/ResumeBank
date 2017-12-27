import React from 'react';
import $ from 'jquery';
function NoActive() {
    var login=
    function resent() {
        $.ajax({crossDomain:true,
        url:'http:localhost:8080/account/reActivation',
            method:'POST',
            data: login,
            contentType: 'application/json',
            headers:{ "Access-Control-Allow-Origin": "*"},
        })
            .done(function (resp) {
                console.log(resp);
            })
            .fail(function (xhr,status,error) {
                for(let i of arguments)
                    console.log(i);
            })
    };
    return <div>
        <p>This account is haven't been activated. Please, check your e-mail for letter</p>
        <p><a href="" onClick={resent}>I sure that don't recived your letter. Please, send again</a></p>
    </div>;
}
export default noActive;