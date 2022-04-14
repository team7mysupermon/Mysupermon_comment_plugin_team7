# Mysupermon Query Comment Library
This library was created as a project between Devaten and ITU.\
The project was supervised by Devaten CEO Mikko Larkela and created by team 'OurSuperMon' from ITU.\
The team consists of XXX.

## How to insert the library into your project
Will be updated when the library is uploaded to Maven.

## How to implement the library into your project
This section is there to explain where to make changes/additions in the code to use the library.

### If you have an existing project using NamedParamterJdbcTemplate
If you already have implemented NamedParameterJdbcTemplate, find all uses of NamedParameterJdbcTemplate and do the following:
1. Find the import of the NamedParameterJdbcTemplate and replace it with:
        import MySuperMon.NamedJDBC.MySuperMonNamedParameterJdbcTemplate
2. Find the part of the code where the NamedParameterJdbcTemplate object is created and replace it with MySuperMonNamedParameterJdbcTemplate