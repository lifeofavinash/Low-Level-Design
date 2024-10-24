# Notes
1. Go from Top to Bottom, Movie -> Payment
2. This is very city specific
3. MovieBookingSystem will have list of theatre and list of movies and booking ability
4. For concurrency management of booking go with Optimistic Locking. User can read anytime, but while writing we put locks. (Use versioning for optimistic locking)

# Class Diagram
![My Image](https://github.com/lifeofavinash/Low-Level-Design/blob/master/BookMyShow/BookMyShow-Class-Diagram.png)
