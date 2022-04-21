# Mysupermon Query Comment Library
This library was created as a project between Devaten and ITU.\
The project was supervised by Devaten CEO Mikko Larkela and created by team 'OurSuperMon' from ITU.

## How to insert the library into your project
This section is here to explain how to add the library into your project.\
Depending on how you want to add the library, there are different subsections explaining how you add the library.
### With Maven
1. In the maven repository search for: Devaten MySuperMon Query Comments.
2. Find the latest version.
3. Choose Maven.
4. Copy the text.
5. Insert into your project's pom.xml file

### With Gradle


## How to implement the library into your project
This section is here to explain where to make changes/additions in the code to use the library.

### If the project is already using NamedParamterJdbcTemplate
Find all classes where NamedParameterJdbcTemplate is used and do the following:
1. Find the import of the NamedParameterJdbcTemplate and replace it with:\
        import MySuperMon.NamedJDBC.MySuperMonNamedParameterJdbcTemplate;
2. Find the part of the code where the NamedParameterJdbcTemplate object is created and replace it with:\
        var <name_of_object> = new MySuperMonNamedParameterJdbcTemplate(Same parameters as used previously);

### If the project is not using NamedParameterJdbcTemplate
The MySuperMonNamedParameterJdbcTemplate can be used just like NamedParameterJdbcTemplate, so use the NamedParameterJdbcTemplate's documentation to understand the different methods.\
Find all classes where queries are needed and do the following:
1. Import the MySuperMonNamedParameterJdbcTemplate.\
        import MySuperMon.NamedJDBC.MySuperMonNamedParameterJdbcTemplate;
2. Create a new instance of MySuperMonNamedParameterJdbcTemplate.
3. Use the object to query to the project's database.
