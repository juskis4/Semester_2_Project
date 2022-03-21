# Parking reservation system (Semester Project)
The system that lets users buy games online

## Abstract
In today's modern society a lot of people have cars and use them daily. It is inevitable
to have a problem where to store only an increasing amount of cars. The parking lots
are very often full during busy hours and there is usually no way to reserve the space
beforehand. This problem is more visible in free parking lots, where moderation is weak
or non-existent. To solve this problem it was chosen to make a simple program with a
reservation ability that would be easy to maintain. The main objective of this project is
to help manage small and free parking lots at as low cost as possible.

## Methodology
* Scrum
* Unified Software Development process

## Analysis
We noticed that the main problem with unsupervised parking lots is lack of moderation.
Car accidents which are unsupervised often lead to dead end and spot reservation is
only available for parking lots only. Seeking to help make free parking as convenient as
possible with the lowest cost of maintenance.


## Functional Requirements
**Critical Priority**
1. As a user, I want to be able to reserve a parking spot, such as no one would
take my place.
2. As a user, I want to be able to register my car such that I can park it.
3. As a user, I want to reserve a parking space for a limited period of time, so that
after I leave the parking lot, other users could reserve my parking space.
4. As a user, I want to be able to enter a parking space queue, so that a parking
space would be reserved for me, when there is a free one.
5. As a user, I want to be able to register/login in to the system, so that I do not
need to type in all the information every time I want to reserve a space.


**High Priority**

6. As a user, I want to see available parking spots, so that I would be able to
reserve it.
7. As a user, I want to see occupied parking spots, so that I would see if any spots
are left.
8. As a user, in case of an accident, I want to get information about who parked
near me, such that I would know who potentially did the damage.
9. As a user, I want to be able to undo my reservation, so that I would not occupy
an empty spot in case of not coming.
10. As a user, I want to register my information, such that system would know for
whom the parking space and a parked car belongs.


**Medium Priority**

11. As a user, I want to be able to see where my car is parked, so that I would not
have to worry about forgetting it.
12. As a user I want to see occupied parking spaces on the map, so I would know
where I cannot park.
13. As a user, I want to see the parking lot map, such that I would know where I can
park my car.


**Low Priority**

14. As a user, I want that the system would not display information about my car, or
me to other users, such that I could stay anonymous for other users.
15. As an administrator, I want to be able to change parking lot open hours, such
that clients could see when to leave or enter the parking lot.
16. As a user I want to see parking lot opening and closing times, so that I would
know when I can reserve my parking space.
17. As a user I want to see parking lot address, so that I would know where the
parking lot is.
18. As a user I want to see contacts, such that I would know who to contact if I will
have questions.
19. As a user, I want to be able to report users for abusing the parking lot, such that
they would get punished afterwards.

## Non-Functional Requirements
19. System must use database to store logs and reservations.
20. System must be developed with Java.
21. System must be client/server system.

## Design
The system is implemented using a client-server system, where the server provides
information or services, and the client requests them.
Furthermore, a design pattern was used for implementing the program, as MVVM and
Observer. By using the MVVM design pattern, viewmodel becomes entirely responsible for the
model, but nevertheless, it can be used for properties of the model or to bind to certain
objects in JavaFX. (Jeremy Likness, 2014) - https://www.wintellect.com/model-viewviewmodel-mvvm-explained/
Once the program is initiated, every view is created without accessing it.



## Conclusion
The system is developed for parking lot spaces reservation. It helps to solve the
problem of not knowing if there will be free parking spaces in the parking lot and the
problem when someone damages your car because this system keeps logs of vehicles
and their owner information. The parking lot reservation system was developed using
Java, JavaFX, datagrip. The UI is pretty simple and understandable. Furthermore,
there some restrictions, for example, that a user, that is not registered cannot reserve a
parking space. For this project patterns like MVVM, adapter, observer and server-client
were used. It made this system more advanced and the code became more structured
and easily readable. Overall, the system is working and completes its job. User can
create an account, log in to the system with it, see the layout of the parking lot, reserve
a parking space on what time and for the wanted duration. However, few requirements
were not implemented, for example, the system is importing reservation logs to the
database, instead of the reservation itself. In conclusion, the parking lot reservation
system could function fully and complete all of its functionalities, by importing
reservation information into the database. In this case, the system would be proper to
use it for VIAs parking lot
