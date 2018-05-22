import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ChangePasssword} from '../model';

@Injectable()
export class UserService {

  constructor(private http: HttpClient) { }

  changePassword(chp: ChangePasssword) {
    return this.http.post('api/change-password', chp);
  }

  resetPasswordReq(email: string) {
    return this.http.post('api/reset-password-req', email);
  }
  resetPassword(code: string, chp: ChangePasssword) {
    const url = 'api/reset-password/' + code;
    return this.http.post( url, chp);
  }
}