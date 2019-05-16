import { Component } from '@angular/core';
import {ProjectService} from "./services/shared/project.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(private  projectService:ProjectService){}


}

