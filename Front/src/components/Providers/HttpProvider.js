/**
 * Created by Lamdan on 12/28/2017.
 */
import axios from 'axios'
axios.defaults.baseURL ="https://requestb.in/";
 const HttpProvider ={
    searchResume : (data,success)=>{
        console.log("In searchResume");
      let  jsonData = JSON.stringify(data);
        axios.post("113nzyo1",jsonData).then((response)=>{
            console.log("searchResume---SUCCESS");
            success(response.data);
        }).catch(function (error) {
            console.log("searchResume---ERROR");
            console.log(error);
            return null;
        });
    }

};
  export default HttpProvider;
