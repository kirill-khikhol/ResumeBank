import React from 'react';
import $ from 'jquery';

function CompanyRegistration(){
    function submitCompanyRegistration(e) {
        e.preventDefault();
        var elements=document.forms[0].elements;
        var json={};
        for(let i=0;i<elements.length-1;i++){
            // console.log(elements[i]);
            if(typeof document)json[elements[i].name]=elements[i].value;
        }
        console.log(json);
        $.ajax({
            async: true,
            crossDomain: true,
            // url: 'http://localhost:8080/company',
            method: 'POST',
            headers: {
                'content-type': 'application/json',
                'cache-control': 'no-cache',
                'postman-token': 'b412df5a-439f-28b6-10b4-1c5b81b407fe'
            },
            processData: false,
            data: JSON.stringify()
        });
    }
return <form>
    <label>Company name:<br/>
        <input required/></label><br/>
    <label>Company type:<br/>
        <select defaultValue='' required>
            <option disabled></option>
            <option>type 1</option>
            <option>type 2</option>
        </select></label><br/>
    <label>Company size:<br/>
        <select defaultValue='' required>
            <option disabled></option>
            <option>0-100</option>
            <option>100-1000</option>
        </select></label><br/>
    <label>Location:<br/>
        <select defaultValue='' required>
            <option disabled></option>
            <option>North</option>
            <option>South</option>
        </select></label><br/>
    <textarea maxLength='1000' placeholder='Enter here somenthing about your company' rows='3'/><br/>
    <label>Site:<br/>
        <input/></label><br/>
    <fieldset><legend>Contact person:</legend><br/>
        <label>First name:<br/>
            <input/></label><br/>
        <label>Surname name:<br/>
            <input/></label><br/>
        <label>Position:<br/>
            <input/></label><br/>
        <label required>Phone:<br/>
            <input type="tel"/></label><br/>
        <label required>E-mail:<br/>
            <input type='email'/></label><br/>
    </fieldset>
    <button onClick={submitCompanyRegistration}>Send</button>
</form>;
}
export default CompanyRegistration;