import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs/Rx";
import {map} from "rxjs/internal/operators";

@Injectable({
  providedIn: 'root'
})
export class UserService{

  private USER_PATH = "/user";

  constructor(private apiService: ApiService ){
  }

  getAll(page) : Observable<any>{
    return this.apiService.get(this.USER_PATH+'/pagination',page).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          console.log(res);
          return {};
        }
      }
    ));
  }

  getById(id) : Observable<any>{
    return this.apiService.get(this.USER_PATH,id).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          console.log(res);
          return {};
        }
      }
    ));
  }

  createProject(user) : Observable<any>{
    return this.apiService.post(this.USER_PATH,user).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          console.log(res);
          return {};
        }
      }
    ));
  }

  delete(id) : Observable<any>{
    return this.apiService.delete(this.USER_PATH+'/'+id).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          console.log(id);
          return {};
        }
      }
    ));
  }
}
