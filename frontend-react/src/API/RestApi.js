import axios from 'axios';
import { API_URL } from '../Constant/Constant';

class RestApi
{
    //retrive all data from the database
    retrieveAll() {
       // console.log("done")
        return axios.get(`${API_URL}`);
    }

    // detele data from the database as per id
    deleteData(id){
      //  console.log("it has been called form restapi calss")
        return axios.delete(`${API_URL}/`+id);
    }

    // get the data as per id from the database
    retriveById(id){
        return axios.get(`${API_URL}/`+id);
    }    

    // get sngle data into the database
    putData(id,employee){
        return  axios.put(`${API_URL}/`+id,employee);
    }

    //save single data into the database
    saveData(empoyee){
        return axios.post(`${API_URL}/`, empoyee);
    }
}

export default new RestApi();