Seed code - Boilerplate for - Keep Note Assessment

Assessment Step Description
In this case study: Keep Note, we will create an Application which accepts Note Title, Note Content, and Note Status as input from the front end and displays the same along with the LocalDateTime of posting in a reverse chronological order (latest Note first).
Even though functionality-wise and the output of step-1 and step-2 are same,

In this application, we will use proper annotations like @Repository, @Autowired etc.,
In this application, we should not use "new"  keyword to create an instance.
We will use Hibernate.
No any XML file will be used.

Here we will have a Note class which will be acting as the data model for note table in the database. Please note that this class is annotated with @Entity annotation (The @Entity annotation marks the class as an entity bean, so it must have a no-argument constructor that is visible with an at least protected scope),
where Hibernate will scan all the packages for any Java objects annotated with the @Entity annotation.
If it finds any, then it will begin the process of looking through that particular Java object to recreate it as a table in your database.

Problem Statement
In this case study: Keep Note we will create an application that requires us to implement four functionalities. They are as follows:


1.Display the list of existing notes from the database.


2.Add a new Note.


3.Delete Note


4.Update/ Modify Note.

Expected solution
A form containing three text fields (Note Title, Note Content, Note status) and Add button, below to this will be a tabular column with the fields Note Title,  Note Content, Note status and LocalDateTime(This will be published in reverse chronological order).
When the user enters the Note Title, Note Content, Note status and clicks on Add button, it gets stored in the database and later renders in the tabular column.

Following are the broad tasks:

Create the application-context for the application.
Extend AbstractAnnotationConfigDispatcherServletInitializer class WebApplicationInitializer.
Create WebMvcConfig which implements WebMvcConfigurer.
CRUD (Notes)
Implement the NoteDAO interface and annotate with @Repository annotation in NoteDAOImpl.