# FileUploadDownload

This project is to download and upload file from your local directory

first you need to give dir location path in application.properties file

if you want to change auth key then you can change from application.properties file

To upload/download file 

Import this project in eclipse and run

Make request from any get/post request client postman is recommended

To upload file----
url - http://localhost:8090/uploadfile
body select form data and pass 2 parameters
 [{"key":"file","description":"","type":"file","enabled":true,"value":["D:\\BLB_Post\\224918-supreme-court.jpg"]}]
 [{"key":"AuthKey","value":"techolution_123","description":"","type":"text","enabled":true}]
 Response := {"Status":"SUCCESS","Message":"File 224918-supreme-court.jpg uploaded successfully"}
 
 To Download file-------
 http://localhost:8090/downloadfile
 body select form data and pass 2 parameters
 key file value file name 
 key AuthKey value password 
 {"Status":"FAILED","Message":"File not found"}

