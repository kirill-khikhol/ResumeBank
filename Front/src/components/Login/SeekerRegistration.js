import React from 'react';
import $ from 'jquery';

const languages = ['Hebrew', 'Chinese', 'English', 'Hindustani', 'Spanish', 'Arabic', 'Malay', 'Russian', 'Bengali', 'Portuguese', 'French', 'Hausa',
    'Punjabi', 'German', 'Japanese', 'Persian', 'Swahili', 'Telugu',
    'Javanese', 'Korean', 'Tamil', 'Marathi', 'Turkish', 'Vietnamese', 'Italian'];
const years=[];
let data=new Date();
for(let i=data.getFullYear()-20; i<data.getFullYear()+5; i++){
    years.push(i.toString());
}
console.log(years);
console.log(languages)
function makeSelect(list) {
    return list.map((option)=><option>{option}</option>)
}
// const languagesSelect = languages.map((lang) => <option>{lang}</option>);

function SeekerRegistration() {
    function addLanguage() {
    }

    function submitSeekerRegistration() {
        $.ajax({
            async: true,
            crossDomain: true,
            url: 'http://localhost:8080/jobSeeker/createProfile',
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
        {/*person data*/}
        <label>First name:<br/>
            <input required maxLength="50" name="firstName"/></label><br/>
        <label>Last name:<br/>
            <input required maxLength="50" name="lastName"/></label><br/>
        <label>Birth date:<br/>
            <input required type="date" name="birthDate" placeholder="XX-XX-XXXX"/></label><br/>
        <label>Location:<br/>
            <select defaultValue='' required name="location">
                <option disabled></option>
                <option value='north'>North</option>
                <option value='south'>South</option>
            </select></label><br/>
        <label>Photo's url: <br/>
            <input type='url' name="photoUrl"/></label><br/>

        {/*professional data*/}
        <textarea placeholder="something about you (optional)" maxLength="1000" name="aboutMySelf"></textarea><br/>
        <label>LinkedIn page:<br/>
            <input type="url" name="linkedinUrl"/></label><br/>

        {/*educations*/}
        <fieldset>
            <legend>Education</legend>
            <input placeholder="enter university's name"/>
            <input placeholder="enter speciality"/>
            <select defaultValue="degree">
                <option disabled>degree</option>
                <option>bachelor</option>
                <option>master</option>
            </select><br/>
            <select defaultValue="" required>
                {/*<option disabled>year</option>*/}
                {makeSelect(years.slice(0,years.length-4))}</select>
            <select>{makeSelect(years.slice(5,years.length))}</select><br/>
            <button>Add education</button>
        </fieldset>
        <fieldset>
            <legend>Courses and sertifications</legend>
            <input placeholder="input course's name"/>
            <select>
            </select>
            <button>Add course</button>
            <select defaultValue='Choose language' required>
                <option disabled>Choose language</option>
                {makeSelect(languages)}
            </select>
            <select defaultValue="level">
                <option disabled>level</option>
                <option>Low</option>
                <option>Middle</option>
                <option>High</option>
            </select>
            <button id='addLanguageButton'>Add language</button>
            <br/>
        </fieldset>
        <fieldset>
            <legend>Experience</legend>
            <input placeholder="company's name"/>
            <input placeholder="position"/>
            <select></select>
            <select></select><br/>
            <input placeholder="project's name"/>
            <select></select>
            <input placeholder="project's description"/><br/>
            <button>add project</button>
            <button>add experience</button>
        </fieldset>
        <fieldset>
            <legend>Recomendations</legend>
            <input placeholder="First name"/>
            <input placeholder="Surname"/>
            <input placeholder="Phone number"/>
            <input placeholder="Company name"/>
            <input placeholder="Position"/>
            <button>add recomendation</button>
        </fieldset>
        <fieldset>
            <legend>About me</legend>
        </fieldset>
        <button type="submit">Submit</button>
    </form>;
}

export default SeekerRegistration;