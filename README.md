"# Web-Scraping" 

Firstly I used for scraping jsoup library so you should download jsoup core library jar file from https://jsoup.org/download. 
When you downloaded jar file you should add to project this library to External Libraries in your project. 

After that I used MySql database for inserting the data. You should mysql connector jar file to External Libraries in your project. I did my db settings in DbHelper.class so you must do your db settings this file. 

My Schema name -> koton
My table name -> products(id,title,description,imageUri,datePublished,productCategory,color,price,discount,oldprice) 

My columns settings
id - VARCHAR(150)
title - VARCHAR(150)
description - VARCHAR(150)
imageUri - VARCHAR(1250)
datePublished - VARCHAR(45)
productCategory - VARCHAR(45
color - VARCHAR(45)
price - DOUBLE
discount - INT
oldprice - DOUBLE
 

 
