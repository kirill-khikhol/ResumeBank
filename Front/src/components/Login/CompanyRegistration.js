const companyRegistration=<form>
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
    <button type="submit">Send</button>
</form>;
