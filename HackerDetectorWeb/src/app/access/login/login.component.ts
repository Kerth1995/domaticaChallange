import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AccessService } from 'src/app/services/access.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private accessService: AccessService) {
    ;
  }

  dataAccess = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });

  ngOnInit(): void {

    
  }

  login(){
    //console.log(this.dataAccess);
    let accesos = {
      username: this.dataAccess.controls.username.value,
      password: this.dataAccess.controls.password.value,
      ipAddress: '192.165.0.1'
    }
    //console.log(accesos);
    this.accessService.login(accesos).subscribe(rpta => {
      console.log(rpta);

    });
  }

}
