### Object Oriented Programming
In this exercise, we want to extend the university system of G01E01 by tutor groups and time slots for tutor groups, lectures and possibly other events. We will generalize a bit more, add more functionality and focus more on object-oriented programming principles like encapsulation, abstraction and polymorphism.

This exercise also serves as a test for yourself to see if you have the necessary programming experience to participate in this course without struggling.

#### General hints:

* All attributes should be private, except noted otherwise.
* All attributes should have a public getter, except noted otherwise.
* All the UML class diagrams below include types, visibility information, identifiers and constructors, so they belong into the object design phase. Please make sure to follow the structure defined in the UML class diagrams.
* UML class diagrams typically do not contain constructors, however, in this exercise, they are provided as a means of help for you which constructors you should implement. Do not add any other constructors than the ones shown in the UML class diagrams.
* More information on UML class diagrams on [UML Class Diagram Tutorial](https://www.visual-paradigm.com/guide/uml-unified-modeling-language/uml-class-diagram-tutorial/;WWWSESSIONID=46A786D44D4B5410DAC8977527C477A2.www1)
* ~ in the UML diagram stands for package private
* All files for Java classes have already been created in the exercise template. Adapt them as needed. Interfaces and Enums have to be created. Make sure to use the correct name in the Java file.

#### Part 1: Time Slots
To support tracking the lecture and tutor group times in the university system, we need to implement the following three classes using inheritance and abstraction. Implement the classes TimeSlot, FixedDateTimeSlot and WeeklyTimeSlot.

1. Implement TimeSlot       
A TimeSlot is just a time slot of a day with a start time and an end time.
2. Implement FixedDateTimeSlot      
A FixedDateTimeSlot is a TimeSlot which has a fix date. It represents a time slot at that specific date.
3. Implement WeeklyTimeSlot     
A WeeklyTimeSlot is a TimeSlot which has a weekday. It represents a time slot that is repeatedly on that specific day of the week.
4. Implement getDuration        
For the implementation of getDuration(), take a look at the class java.time.Duration and its methods.

<img src="images/ORP_P1.png" width = 500>
    
#### Part 2: Skill and StudyLevel
The university system should also be able to track whether students fulfill the prerequisites, of course. Therefore, we introduce the concepts of a skill and a study level. Create an interface Skill and an Enum StudyLevel.

1. Create Skill     
Skill represents a Skill that can be learned by a Student and that the Student can apply. The interface should have one abstract method that allows it to be used as a functional interface.
2. Create StudyLevel        
StudyLevel is the level of study, either bachelor or master.

<img src="images/ORP_P2.png" width = 150>

#### Part 3: Person, Student and Instructor
To display the instructor of courses and the participants of tutor groups (students), we introduce more concepts as classes. Implement the classes Person, Student and Instructor.
1. Implement Person   
Has name, age, and tumId for the purpose of the university system.
2. Implement Student    
A Student is a Person and has a matriculation number, a study level, a semester and a set of skills learned and acquired knowledge. Hint: you might need to initialize the sets. A student does not know anything at the beginning and has no skill.
3. Implement Instructor     
An Instructor is a Person and can teach.

<img src="images/ORP_P3.png" width = 500>

We also want to implement some functionality for these classes:

1. Let persons say something        
    Implement a method say(String) in Person, so that it prints (using System.out.println) the given String to the console in the following format: <Span style="color: #FF00A2" > name said: text </Span>  where name is the person's name and text the argument of the method.
2. Let instructors teach something    
    Implement a method teach(String) in Instructor, so that the Instructor then says:<Span style="color: #FF00A2" > Please learn "lecture content" </Span> where <lecture content> is the argument of the method. Hint: The teach method must not contain System.out.println.
3. Let students acquire knowledge  
    Implement acquireKnowledge(String) so that the String containing the knowledge is added to the student's knowledge set.
4. Let student learn skills    
    Implement learnSkill(Skill) so that the Skill is added to the student's skill set.
    
#### Part 4: Tutor Groups
Now, the real challenge begins. We want to implement virtual and local tutor groups to support university courses and all-online courses such as EIST.

Implement the classes TutorGroup, TutorGroupMeeting, VirtualTutorGroupMeeting and LocalTutorGroupMeeting.

1. Implement TutorGroup     
Has a set of students that participate. A TutorGroup has an id (e.g. fr03), a WeeklyTimeSlot for the normal meeting schedule, a tutor (who is a person) and a list of its meetings.

2. Implement TutorGroupMeeting    
A TutorGroupMeeting is associated with a tutor group and a skill that should be practiced. Upon creation, a TutorGroupMeeting is given a TutorGroup it belongs to. Make sure to let the TutorGroup itself know of that meeting as well. A TutorGroupMeeting can practice a skill, but how this is done depends on the type of meeting. Therefore, practice() is abstract.
3. Implement VirtualTutorGroupMeeting      
A VirtualTutorGroupMeeting is a TutorGroupMeeting and has a URL. Implement practice() as follows:
The tutor says Thank you for joining using url today. where url is the virtual meeting's URL.
Every participating student learns the skill that is planned to this TutorGroupMeeting
The tutor says See you next time!
4. Implement LocalTutorGroupMeeting      
A LocalTutorGroupMeeting is a TutorGroupMeeting and has a room. Implement practice() as follows:
The tutor says Thank you for coming to room today. where room is the local meeting's room.
Every participating student learns the skill that is planned to this TutorGroupMeeting
The tutor says See you next time!

<img src="images/ORP_P4.png" width = 800>








