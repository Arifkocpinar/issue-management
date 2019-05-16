import { Component, OnInit } from '@angular/core';
import {Page} from "../../common/page";
import {ProjectService} from "../../services/shared/project.service";
import {Project} from "../../common/project.model";

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {

  page = new Page();
  cols=[
    {prop:'id',name:'No'},
    {prop:'projectName',name:'Project Name:',sortable:false},
    {prop:'projectCode',name:'Project Code:',sortable:false}]
  rows = new Array<Project>();
  constructor(private  projectService:ProjectService) {
  }

  ngOnInit() {
    this.setPage({ offset: 0 });
  }
  setPage(pageInfo){
    this.page.page = pageInfo.offset;
    this.projectService.getAll(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page=pagedData.number;
      this.page.totalElements=pagedData.totalElements;
      this.page.totalPages=pagedData.totalPages;
      this.rows = pagedData.content;
    });
  }

}
