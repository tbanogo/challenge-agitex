import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {environment} from "../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, catchError, map, Observable, of} from "rxjs";
import {MessageService} from "primeng/api";
import {UploadService} from "../../../@core/services/upload.service";

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss'],
  providers: [MessageService]
})

export class UploadComponent implements OnInit {
  pageTitle = "Nouvelle demande";
  selectedFile: File | null = null;
  message = "";
  isMessage: boolean = false;
  alert: boolean = false;
  isLoading: boolean = false;
  isSelect: boolean = false;

  constructor(private uploadService: UploadService) {}

  ngOnInit(): void {
    console.log("=====================CALLING API=====================");
  }

  onFileSelect(event: any): void {
    this.isSelect = true;
    this.selectedFile = event.target.files[0] as File;
  }

  onUpload(): void {
    if (!this.selectedFile) {
      console.error('Aucun fichier sélectionné');
      return;
    }

    const extension = this.selectedFile.name.split('.').pop();
    const formData = new FormData();
    formData.append('file', this.selectedFile);

    if(extension == 'txt'){
      console.log("<<<<<<<<<< text >>>>>>>>>>");
      this.isLoading = true;
      this.isMessage = false;
      setTimeout(() => {
        this.uploadService.uploadTextFile(formData).subscribe(
          (response) => {
            console.log('Response : ' + response.data);
            if(response.success == true){
              if(response.data == true){
                this.isMessage = true;
                this.alert = true;
                this.message = "Félicitation, votre fichier à été bien enregistrer.";
              }else{
                this.isMessage = true;
                this.alert = false;
                this.message = "Attention, votre fichier contient des erreurs.";
              }
            }
            this.isLoading = false;
          },
          (error) => {
            console.error("Une erreur est survenu lors de l'envoi.");
          },
        );
        }, 5000
      );
    }else if(extension == 'csv'){
      console.log("<<<<<<<<<< csv >>>>>>>>>>");
      this.isLoading = true;
      this.isMessage = false;
      setTimeout(() => {
          this.uploadService.uploadCsvFile(formData).subscribe(
            (response) => {
              console.log('Response : ' + response.data);
              if(response.success == true){
                if(response.data == true){
                  this.isMessage = true;
                  this.alert = true;
                  this.message = "Félicitation, votre fichier à été bien enregistrer.";
                }else{
                  this.isMessage = true;
                  this.alert = false;
                  this.message = "Attention, votre fichier contient des erreurs.";
                }
              }
              this.isLoading = false;
            },
            (error) => {
              console.error("Une erreur est survenu lors de l'envoi.");
            },
          );
        }, 5000
      );
    }else if(extension == 'json'){
      console.log("<<<<<<<<<< json >>>>>>>>>>");
      this.isLoading = true;
      this.isMessage = false;
      setTimeout(() => {
          this.uploadService.uploadJsonFile(formData).subscribe(
            (response) => {
              console.log('Response : ' + response.data);
              if(response.success == true){
                if(response.data == true){
                  this.isMessage = true;
                  this.alert = true;
                  this.message = "Félicitation, votre fichier à été bien enregistrer.";
                }else{
                  this.isMessage = true;
                  this.alert = false;
                  this.message = "Attention, votre fichier contient des erreurs.";
                }
              }
              this.isLoading = false;
            },
            (error) => {
              console.error("Une erreur est survenu lors de l'envoi.");
            },
          );
        }, 5000
      );
    }else if(extension == 'xml'){
      console.log("<<<<<<<<<< xml >>>>>>>>>>");
      this.isLoading = true;
      this.isMessage = false;
      setTimeout(() => {
          this.uploadService.uploadXmlFile(formData).subscribe(
            (response) => {
              console.log('Response : ' + response.data);
              if(response.success == true){
                if(response.data == true){
                  this.isMessage = true;
                  this.alert = true;
                  this.message = "Félicitation, votre fichier à été bien enregistrer.";
                }else{
                  this.isMessage = true;
                  this.alert = false;
                  this.message = "Attention, votre fichier contient des erreurs.";
                }
              }
              this.isLoading = false;
            },
            (error) => {
              console.error("Une erreur est survenu lors de l'envoi.");
            },
          );
        }, 5000
      );
    }else{
      this.isMessage = true;
      this.alert = false;
      this.message = "Attention, fichier non pris en charge actuellement.";
    }
  }
}
