import React from 'react';
import $ from 'jquery';
function NotSent(props) {
    var login=props.login;
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
        <p>Someone was wrong</p>
        <p><a href="#" onClick={resent}>To send again</a></p>
    </div>;
}
export default NotSent;