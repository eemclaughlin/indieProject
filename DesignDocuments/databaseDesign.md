# Database Design

### Current Database ERD
v1.8

![Database ERD](LayoutPictures/DatabaseERDv1.8.png)

### Notes
* Database Name: RecipeTracker
* Two junction tables.  
  * One for tags which will have shared FK PK
  * One for Cookbook and Recipe connections.  This requires an extra page number column so will have and designated PK Id
* I believe Users will be done using AWS but have included it for now.
* Cookbooks may also change since it will use an API and I don't know how that works yet.

#### Previous Database ERDs
v1.7 (note picture says 1.6 but it is 1.7) [Database ERD](LayoutPictures/DatabaseERDv1.7.png)

v1.5 [Database ERD](LayoutPictures/DatabaseERDv1.5.png)

v1.0 [Database ERD](LayoutPictures/Database%20ERD%20v1.0.png)