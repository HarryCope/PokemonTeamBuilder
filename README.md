# PokemonTeamBuilder

This involved creating an API to provide CRUD functionality to be used in a webpage to be able to create, update, read and delete pokemon and have a list of them on the screen. It uses fetch apis in order to call the java functions into the javascript file.

## Getting Started

In order to connect to your data base you will need to edit the application-dev.properties file. Change the base URL to match that of your SQl server whether local or otherwise and for the regular url make sure to add "/pokemon_teams" to the end in order to connect to this database specifically. The username and password need to match that of your detatils for MySQL. In order for the code to run you must first create the pokemon_teams database in MySQL to connect to. Within the database create the tables pokemon and teams.

### Prerequisites

You will need some kind of Java IDE Eclipse was used for this program and MySQL for the database control. Maven will also need to be intalled in order to package the file. The front end HTML, CSS and JavaScript are embedded in the Eclipse code but if you need to edit them for whatever reason VSCode would be recommended for this.

## Deployment

Open the command line in the file where this project is saved and run the following commands:

```
mvn clean
mvn package
```

## Things to add

In the future or if I had more time I would have liked to have added a library of images to correspont to each of the pokemon. Also the system of updating and removing pokemon is predicated of knowing the pokemon id which is not displayed so i would either present the id in the list or create some error messages to show a false input.



## Loading the web page

By default the webpage is hosted on port:8080 and so in order to access it open a web browser and enter:

```
localhost:8080
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Harry Cope** - [Harry Cope](https://github.com/HarryCope)
