# Timesheet

Timesheet zadatak za kandidate

# Project specification

### Functional Requirements

- The user logs in using an e-mail address and password, also user should be able to log out from the site.

- There are 2 types of users: admin and worker.

- Allow the user to change their password and export their data.


    Clients:

Allow the admin to have an overview of all clients, to create a new client by entering:
1. Client name
2. Address 
3. City,zip/postal code
4. Country.

- Admin should be able to change already
created client and to delete them. Admin can filter clients by clicking on the desired initial letter of the project name and to search them by typing their name in
search field.


    Projects:

Allow the admin to have an overview of all project, to create a new project by entering: 
1. Project name
2. Project description
3. Select client
4. Set the team leader

- Admin should be able to change already created project, including **project status(active, inactive, archive)** and
to delete them. Admin can filter projects by clicking on the desired initial letter of the project name and to search them by typing project name in search field.


    Categories:

- Allow the admin to have an overview of all categories, to create a new category by entering 
  - *category name*. 

- Admin should
be able to change already created category and to delete them.
Admin can find categories by clicking on the desired initial letter of the project name and to search them by typing name in search field.


    Employees:

Allow the admin to have an overview of all employees, to create an employee by entering: 
1. name, 
2. username, 
3. hours per week,
4. email, 
5. status
   1. *active*
   2. *inactive*
6. role
   1. *admin*
   2. *worker*

- Admin should be able to change already created employee including employee status and role, to delete them and to change their password.

- Admin doesn't have an option to set the password for new user. He can only enter the e-mail address where the link
  will be sent and then the user will be able to set the desired password.


    Timesheet:
Allow the users to see their own timesheet for month in the table with all days in current month. 
* They can switch between months.
* They should be able to see how many hours they worked on which day of the month and see the total number of
working hours for selected month.

- When users click on the hours number in a certain date, allow them to send report by selecting

  |necessary fields
  |:---
  |Client     
  |Project
  |Category
  |Hours

  and

  |optional fields
    |:---
  |Description
  |Overtime
  

- After filling fields, allow them to save the changes and send report.
- They can switch left and right for the previous and next week, to select days in the chosen week and to go back to monthly view.


    Reports:
- Allow the admin and team leader to have an overview of all reports and to filter them by:
1. selecting an employee,
2. client, 
3. project,
4. category,
5. quick date by week,
   1. this week, 
   2. next week, 
   3. last week
6. quick date by month,
   1. this month, 
   2. next month, 
   3. last month

7. start date,
8. end date.

- Admin and team leader should be able to reset all filter options, to search and to search overtime.
When the search is finished, it should display some table with the report data.

  | Date      | Employees | Projects | Categories | Description | Time |
  |-----------| ----------| ---------| ---------| ---------| ---------|
  |     |      |


- Bellow table should be number of all reports found.
- After displaying all the requested data, create options for: 
1. print report,
2. create pdf,
3. export to excel.

### Non-functional requirements

- Implement restrictions and procedures that will check when entering or changing data.

- Data about clients, projects and categories cannot be accessed by users who do not have the administrator role.

- As for the reporting data, it can be used by administrators and team leaders to review the necessary information of their teammates.





