import {Component, OnInit} from '@angular/core';
import {UntypedFormBuilder, UntypedFormControl, FormGroup, Validators, FormBuilder} from "@angular/forms";
import {BehaviorSubject, Observable} from "rxjs";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  year = new Date().getFullYear();
  submitted: boolean = false;
  isLoading?: Observable<boolean>;
  isLoadingSubject = new BehaviorSubject<boolean>(false);

  //Login form
  loginForm = this.fb.group({
    username: new UntypedFormControl("", [Validators.required]),
    password: new UntypedFormControl("", [Validators.required]),
  });

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.isLoading = this.isLoadingSubject.asObservable();
  }

  handleLogin() {
  }

  get username() {
    return this.loginForm.get('username');
  }

  get password() {
    return this.loginForm.get('password');
  }

}
