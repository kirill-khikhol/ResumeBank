import React, {Component}from 'react';
import Header from '../common/header';
import './SeachEmployee.css';
import {NavLink,withRouter}from 'react-router-dom';



class SearchEmployee extends Component{

    Employee ={};
    state={};
    constructor(){
        super();
       this.Employee={login:"my@Email.com",downloadType:"doc",
            curriculumVitae:[{login:"my@Email.com",yearsInWork:1,skillsType:["java"],companyName:["myCompany1"],
                verification:{date:"2017-12-06",verificationStatus:"yes"},cvType:"backEnd",
                dateOfEnable:"2017-12-06",enable:true,minSalary:45}],
            personData:{firstName:"name",lastName:"surname",birthDate:"2017-12-07",phone:1234567,
                location:"rehovot",photoUrl:"http://photoUrl"},
            professionalData:{aboutMySelf:"aboutMySelf",linkedinUrl:"http://linkedinUrl",
                educations:[{nameUniversity:"university",nameSpeciality:"speciality",educationDegree:"master",
                    startDate:"2017-12-06",endDate:"2017-12-06"}],
                languages:[{languageName:"english",languageLevel:"basic"}],
                coursesAndCertificates:[{nameOfCourse:"course",endDate:"2017-12-06"}],
                recomendations:[{firstName:"name",lastName:"surname",
                    companyName:"company",position:"position",phone:1234567}],
                experiences:[{companyName:"company",position:"position",startDate:"2017-12-06",
                    endDate:"2017-12-06",projects:[{nameProject:"project",endDate:"2017-12-06",
                        descriptionProject:"descriptionProject"}]}]},
            fieldsVisibility:{login:"my@Email.com",email:true,firstName:true,lastName:true,
                birthDate:true,phone:true,"location":true,photo:true,aboutMyself:true,
                linkedin:true,educations:true,languages:true,coursesAndCertificates:true,
                recomendations:true,experiences:true,projects:true}};

        this.state = {
            resume:[],
            formData:{
                yearsInWork:0,
                skillsType:[],
                verification:{verificationStatus:""},
                cvType:"doc",
                minSalary:0
            }
        };
        this.state.resume.push(this.Employee);
        this.state.resume.push(this.Employee);
        this.state.resume.push(this.Employee);
    };



    showCustomer(event){
       console.log(event.target.value);
    }
    findResume=(data)=>{
        console.log('action');
        console.log(data);
    };
    directionChooseHandler(event){}
    verificationChooseHandler(event){}
    experienceChooseHandler(event){}

    checkBoxHandler=(event)=>{
        let skillsType;
        let FormData = {...this.state.formData};
        if(event.target.checked){
           skillsType =[...this.state.formData.skillsType];
            skillsType.push(event.target.value);
        }else{
             skillsType =[...this.state.formData.skillsType];
            let index = skillsType.indexOf(event.target.value);
            skillsType.splice(index,1);
        }
        FormData.skillsType=skillsType;
        this.setState({"formData":FormData})
    };


  render(){
     let wasFound = this.state.resume.map((item,index)=>{
          return(
              <div>
                  <NavLink key ={index}
                           to ={{pathname:"/Resume",'state':item}}
                           activeClassName={"active"}>
                      {index+". "}{item.personData.firstName +' '+item.personData.lastName}
                  </NavLink>
                   <br/>
              </div> )
          });



      const myForm = ( <div className="MyForm container">
          <h1>SEARCH EMPLOYEE</h1>
          <form onSubmit={this.findResume} className="form-horizontal form-group">
            <hr/>
             <div className="row">
                 <div className="form-group ">
                     <lable for ="selectDirection" className="control-label col-sm-2">Direction of work:</lable>
                         <select name="direction" id = "selectDirection"
                                 onChange={this.directionChooseHandler} className="col-sm-3">
                             <option value="">Select a direction:</option>
                             <option value="BackEnd">BackEnd Developer</option>
                             <option value="FrontEnd">FrontEnd Developer</option>
                             <option value="FullStack">FullStack Developer</option>
                             <option value="Android">Android Developer</option>
                             <option value="QA">QA Manual testing</option>
                             <option value="QA">QA Automat testing</option>
                         </select>
                 <lable for ="Verification" className="control-label col-sm-2">Verification:</lable>
                 <select className="col-sm-3" id ="Verification" name="verification" onChange={this.verificationChooseHandler}>
                     <option value="">Select a verification:</option>
                     <option value="yes">Yes</option>
                     <option value="3">No</option>
                 </select>
                </div>
                 <div className="form-group">
                     <lable for ="Verification" className="control-label col-sm-2">Experience:</lable>
                     <select className="col-sm-3" id ="Experience" name="experience" onChange={this.experienceChooseHandler}>
                         <option value="">Select a Experience:</option>
                         <option value="2">0-2 years</option>
                         <option value="3">3-5 years</option>
                         <option value="5">More than 5 years</option>
                     </select>
                     <lable for ="Programming_language" className="control-label col-sm-2">Language&Technologies:</lable>
                     <div className="col-sm-4" id ="Programming_language">
                          <div className="col-sm-9 pull-left">
                             <label>
                                 Java <input type="checkbox" name="language"
                                             value="Java" onChange={this.checkBoxHandler}/>
                             </label>
                             <label>JavaScript<input type="checkbox" name="language" value="JS"
                                                     onChange={this.checkBoxHandler}/></label>
                             <label>C++<input type="checkbox" name="language" value="C++"
                                              onChange={this.checkBoxHandler}/></label>
                             <label>SQL<input type="checkbox" name="language" value="SQL"
                                              onChange={this.checkBoxHandler}/></label>
                             <label>PHP<input type="checkbox" name="language" value="PHP"
                                              onChange={this.checkBoxHandler}/></label>
                             <label>RUBY<input type="checkbox" name="language" value="RUBY"
                                               onChange={this.checkBoxHandler}/></label>
                             <label>Angular<input type="checkbox" name="language" value="Angular"
                                                  onChange={this.checkBoxHandler}/></label>
                             <label>React<input type="checkbox" name="language" value="React"
                                                onChange={this.checkBoxHandler}/></label>
                              <hr/>
                              <label>Java <input type="checkbox" name="language" value="Java"/></label>
                              <label>JavaScript<input type="checkbox" name="language" value="JS"/></label>
                              <label>C++<input type="checkbox" name="language" value="C++"/></label>
                              <label>SQL<input type="checkbox" name="language" value="SQL"/></label>
                              <label>PHP<input type="checkbox" name="language" value="PHP"/></label>
                              <label>RUBY<input type="checkbox" name="language" value="RUBY"/></label>
                              <label>Angular<input type="checkbox" name="language" value="Angular"/></label>
                              <label>React<input type="checkbox" name="language" value="React"/></label>
                          </div>
                     </div>
                 </div>
             </div>
              <button type="submit" className="btn btn-primary"> Submit </button>
              <fieldset>
                  <legend>Results:</legend>
                  <div className="SearchResult">
                      {wasFound}
                  </div>

              </fieldset>
          </form>

      </div>);

    return (
        <div>
          <Header/>
            <div>
                {myForm}
            </div>

        </div>
             );
  }
}

export default withRouter(SearchEmployee);
