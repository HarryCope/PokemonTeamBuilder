# PokemonTeamBuilder

This involved creating an API to provide CRUD functionality to be used in a webpage to be able to create, update, read and delete pokemon and have a list of them on the screen. It uses fetch apis in order to call the java functions into the javascript file.

## Getting Started

In order to connect to your data base you will need to edit the db.properties file. Change the base URL to match that of your SQl server whether local or otherwise and for the regular url make sure to add "/ims" to the end in order to connect to this database specifically. The username and password need to match that of your detatils for MySQL. An oversight on my part that I would have chnged in the future would have been to change the customer ID variable name from just id to customerId to improve the projets readability, but just for your benefit if you see id refered to at any point it will always be the customer id.

### Prerequisites

You will need some kind of Java IDE Eclipse was used for this program and MySQL for the database control. Maven will also need to be intalled in order to package the file. The front end HTML, CSS and JavaScript are embedded in the Eclipse code but if you need to edit them for whatever reason VSCode would be recommended for this.

## Deployment

Open the command line in the file where this project is saved and run the following commands:

```
mvn clean
mvn package
```
When I tested packaging this file it flagged a whole series of errors that me and trainers could not resolve. I did however ask others to test my code on a different device and they assured me that it worked and packaged correctly.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Harry Cope** - *Building off of the original program* - [Harry Cope](https://github.com/HarryCope)
