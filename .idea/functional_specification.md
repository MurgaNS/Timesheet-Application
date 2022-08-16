# Functional specification

## *Functional Requirements*

### Login
1. System should allow user to log in using an e-mail address and password.
2. System should allow user to log out from the site.

### Users
1. There are 2 types of users:
   - admin
   - worker.
2. System should allow user to change their password and export their data.


### Clients

1. System should allow the admin to access the list of all clients.
2. System should allow the admin to create a new client. Required fields are:
- *Client name*
- *Address*
- *City,zip/postal code*
- *Country.*

3. System should allow the admin to change already created client and to delete them.
4. System should allow admin to filter clients by clicking on the desired initial letter of the client name and to search them by typing their name in
   search field.


### Projects

1. System should allow the admin to access the list of all projects.

2. System should allow the admin to create a new project. Required fields are:

- *project name*
- *project description*
- *select client*
- *set the team leader*

3. System should allow admin to change already created project, including **project status(active, inactive, archive)** and
   to delete them.

4. System should allow admin to filter projects by clicking on the desired initial letter of the project name and to search them by typing project name in search field.


### Categories

1. System should allow the admin to access the list of all categories.

2. System should allow the admin to create a new category. Required fields are:
    - *category name*.

3. System should allow the admin to change already created category and to delete them.

4. System should allow admin to filter categories by clicking on the desired initial letter of the category name and to search them by typing category name in search field.


### Employees
1. System should allow the admin to access the list of all employees.

2. System should allow the admin to add a new employee. Fields he has to specify are:

- name,
- username,
- hours per week,
- email,
- status
    - *active*
    - *inactive*

- role
    - *admin*
    - *worker*


- **Side effect!!**
    - Admin enters all necessary data to add a new user except password.
    - The user will receive a link to the e-mail address specified by the administrator through which he can set his own password.

3. System should allow admin to:
- change already created employee including employee status and role,
- to delete them
- to change their password.


### Timesheet
1. System should allow users to see their own timesheet for month in the table with all days in current month.
2. System should allow users to switch between months.
3. System should allow users to see how many hours they worked on which day of the month.
4. System should allow users to see the total number of working hours for selected month.

### Timesheet days report
1. When users clicks on the hours number in a certain date, system should allow them to send report by selecting:

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


2. After filling fields, system should allow them to save changes and send report.
3. System should allow users to switch left and right for the previous and next week
4. System should allow users to select days in the chosen week.
5. System should allow users to go back to monthly view.


### Reports:
1. System should allow admin and team leader to have an overview of all reports and to filter them by:

- selecting an employee,
- client,
- project,
- category,
- quick date by week:
    - this week,
    - next week,
    - last week
- quick date by month:
    - this month,
    - next month,
    - last month

- start date,
- end date.

2. System should allow admin and team leader to:
- reset all filter options,
- search,
- search overtime.

3. When the search is finished, system should display some table with the report data.

| Date      | Employees | Projects | Categories | Description | Time |
  |-----------| ----------| ---------| ---------| ---------| ---------|
|     |      |


4. Bellow table should be number of all reports found.
5. After displaying all the requested data, system will show you options for:
   - print report,
   - create pdf,
   - export to excel.

### *Non-functional requirements*

- Implement restrictions and procedures for checking the validity of the data.

- Data about clients, projects and categories cannot be accessed by users who do not have the administrator role.

- As for the reporting data, it can be used by administrators and team leaders to review the necessary information of their teammates.





