# Stroke Timing Criteria
## Objective:
Provide a tool that offers insight into various line-ups and their boat speed.  Supplies an environment to look at water pieces across different boat lineups and boats.  Essentially a seat-racing data analysis tool.
## Audience:
Competitive rowing coaches and their crews.
## Team:
Severiano Badajoz, Kenia Rioja-Naranjo
## UI-Design:
### ![Starting scene](https://github.com/S33V/StrokeTiming/blob/master/img/JavaFX%20Scene%20Builder%201.1_2017-05-02_13-36-11.png?raw=true)  Starting scene
### ![Boat Lineup Creation Scene](https://github.com/S33V/StrokeTiming/blob/master/img/JavaFX%20Scene%20Builder%201.1_2017-05-02_13-35-31.png?raw=true)  Boat Lineup Creation Scene
### ![Add Boat Scene](https://github.com/S33V/StrokeTiming/blob/master/img/JavaFX%20Scene%20Builder%201.1_2017-05-02_13-35-14.png?raw=true)  Add Boat Scene
### ![Add Person Scene](https://github.com/S33V/StrokeTiming/blob/master/img/JavaFX%20Scene%20Builder%201.1_2017-05-02_13-36-22.png?raw=true)  Add Person Scene
### ![Day View Scene](https://github.com/S33V/StrokeTiming/blob/master/img/JavaFX%20Scene%20Builder%201.1_2017-05-02_13-36-35.png?raw=true)  Day View Scene
### ![Specific Day View Scene](https://github.com/S33V/StrokeTiming/blob/master/img/JavaFX%20Scene%20Builder%201.1_2017-05-02_13-36-58.png?raw=true) Specific Day View Scene
### ![Raw view/Add Workout Scene](https://github.com/S33V/StrokeTiming/blob/master/img/JavaFX%20Scene%20Builder%201.1_2017-05-02_13-35-43.png?raw=true)  Raw view/Add Workout Scene

## Activities:

* Creating the database tables
* Adding a workout through importing a .csv file
* Finding accelerations by using the data that was imported from the .csv file
* Storing the processed data in the appropriate database tables

## Database Tables:
* Boat Lineups
  * id INTEGER PRIMARY KEY,
  * coxswain_id INTEGER,	
  * stroke_seat_id INTEGER,
  * seat_two_id INTEGER,
  * seat_three_id INTEGER,
  * seat_four_id INTEGER,
  * seat_five_id INTEGER,
  * seat_six_id INTEGER,
  * seat_seven_id INTEGER,
  * bow_seat_id INTEGER
  
* Boats
  * id INTEGER PRIMARY KEY,
  * name TEXT,
  * type TEXT,
  * weight REAL,
  * seats INTEGER
  
* Boats to Boat Lineups (Relational Table)
  * id INTEGER //boat
  * id INTEGER //boat lineup
  
* Rowers
  * id INTEGER PRIMARY KEY,
  * name TEXT,
  * position INTEGER,
  * weight REAL,
  
* Coxswains
  * id INTEGER PRIMARY KEY,
  * name TEXT,
  * weight REAL
  
* Erg Scores
  * id INTEGER PRIMARY KEY,
  * seconds REAL,
  * meters INT,
  * weight REAL
  
* Rower Erg Scores (Relational Table)
  * id INTEGER, //rower
  * id INTEGER //erg score
  
* Boat Workouts (Relational Table)
  * id INTEGER, //boat
  * id INTEGER, //workout
  
* Workouts
  * id INTEGER PRIMARY KEY,
  * date TEXT,
  * comments TEXT
  
* Pieces
  * id INTEGER PRIMARY KEY,
  * type TEXT,
  * meters INTEGER, 
  * time REAL, //in seconds
  * comments TEXT
  
* Workout to Pieces (Relational Table)
  * id INTEGER, //workout
  * id INTEGER, //piece
  
## Model-View-Controller:
### Model: 
Data will be taken in as .csv files from M800 GPS watches.

Data will also be taken from the database described above.

User inputted data coming from the controller will also be stored in the database.

### View:
6 Various scenes for viewing (4 scenes) and inputting (3 scenes) data.

### Controller:
Will use the Singleton design pattern to ensure that only one object is created.

Will store data in the database tables.

Will retrieve data from the database tables.
