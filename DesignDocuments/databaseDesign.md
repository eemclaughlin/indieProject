# Database Design
#### [Back to main README](../README.md)

### Current Database ERD
v2.0

![Database ERD](LayoutPictures/DatabaseERDv3.0.png)

### Notes
* Database Name: RecipeTracker
* One junction tables.  
  * One for tags which will have shared FK PK
* I believe Users will be done using AWS but have included it for now.
* Cookbooks may also change since it will use an API and I don't know how that works yet.

### SQL Scripts
* [SQL Full Refresh Script](SqlScripts/Databasev3.0FullRefresh.sql)) 
* [SQL Create Script](SqlScripts/Databasev3.0Create.sql)
* [SQL Drop Script](SqlScripts/Databasev3.0Drop.sql)

#### Previous Database ERDs
v1.9 [Database ERD](LayoutPictures/DatabaseERDv1.9.png)

v1.8 [Database ERD](LayoutPictures/DatabaseERDv1.8.png)

v1.7 (note picture says 1.6 but it is 1.7) [Database ERD](LayoutPictures/DatabaseERDv1.7.png)

v1.5 [Database ERD](LayoutPictures/DatabaseERDv1.5.png)

v1.0 [Database ERD](LayoutPictures/Database%20ERD%20v1.0.png)

v2.0 [Database ERD](LayoutPictures/DatabaseERDv2.0.png)