const languages=['Hebrew','Chinese','English','Hindustani','Spanish','Arabic','Malay','Russian','Bengali','Portuguese','French','Hausa',
    'Punjabi','German','Japanese','Persian','Swahili', 'Telugu',
    'Javanese', 'Korean','Tamil','Marathi','Turkish', 'Vietnamese','Italian'];
const languagesSelect=languages.map((lang)=><option>{lang}</option>);
function seekerRegistration(){
    function addLanguage() {
    }
    return <form>
        <label>First name:<br/>
            <input required maxlength="50"/></label><br/>
        <label>Last name:<br/>
            <input required maxlength="50"/></label><br/>
        <label>Birth date:<br/>
            <input required type="date"/></label><br/>
        <label>Location:<br/>
            <select defaultValue='' required>
                <option disabled></option>
                <option>North</option>
                <option>South</option>
            </select></label><br/>
        <label>Download photo: <br/>
            <input type='file'/></label><br/>
        <label>Phone:<br/>
            <input required type="tel" maxlength="20"/></label><br/>
        <label>LinkedIn page:<br/>
            <input type="url"/></label><br/>
        <select defaultValue='Choose language' required>
            <option disabled>Choose language</option>
            {languagesSelect}
        </select>
        <select defaultValue="level">
            <option disabled>level</option>
            <option>Low</option>
            <option>Middle</option>
            <option>High</option>
        </select>
        <button id='addLanguageButton'>Add language</button>
        <br/>
        <fieldset>
            <legend>Education</legend>
            <input placeholder="enter university's name"/>
            <input placeholder="enter speciality"/>
            <select defaultValue="degree">
                <option disabled>degree</option>
                <option>bachelor</option>
                <option>master</option>
            </select><br/>
            <select></select>
            <select></select><br/>
            <button>Add education</button>
        </fieldset>
        <fieldset>
            <legend>Courses and sertifications</legend>
            <input placeholder="input course's name"/>
            <select>
            </select>
            <button>Add course</button>
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
            <textarea placeholder="something about you (optional)" maxlength="1000"></textarea>
        </fieldset>
        <button type="submit">Submit</button>
    </form>;
}