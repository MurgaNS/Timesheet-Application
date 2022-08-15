# Timesheet

Timesheet zadatak za kandidate 

# Project specification 

The user logs in using an e-mail address and password, also user should be able to log out from the site. 

There are 2 types of users: admin and worker.

Allow the user to change their password and (export their data???).

ADMIN ***
Clients:
Allow the admin to have an overview of all clients, to create a new client by entering: client name, address, city, zip/postal code and country. Admin should be able to change already
created client and to delete them. Admin can filter clients by their client name and to search them by typing name in search field.

Projects:
Allow the admin to have an overview of all project, to create a new project by entering: project name, project description, to select client and to select lead.Admin should be
able to change already created project and to delete them. Admin can filter projects by project name and to search them by typing name in search field.

Categories:
Allow the admin to have an overview of all categories, to create a new category by entering: category name. Admin should be able to change already created category and to delete them.
Admin can filter categories by their name and to search them by typing name in search field.

Employees:
Allow the admin to have an overview of all employees, to invite an employee by entering: name, username, hours per week, email, status(active or inactive), role(admin or worker).
Admin should be able to change already created employee, to delete them and to change their password.

Reports: 
Allow the admin to have an overview of all reports and to filter them by: selecting an employee, client, project and category. Also, admin should be able to search reports by
quick date by week(this week, next week, last week), quick date by month(this month, next month, last month), start date and end date. 
Admin should be able to reset all filter options, to search and to search overtime.
When the search is finished, it should display some table with the data(date, employees, projects, categories, description and time). Bellow table should be number of all reports found.
After displaying all the requested data, enable the print of that report, create pdf and export to excel. 


WORKER ***
Timesheet: 
Allow the user or admin to see his own timesheet for month in the table with all days in current month. User or admin can switch between months. 
User or admin should be able to see how many hours he worked on which day of the month and see the total number of working hours for selected month.
when the user or admin clicks on the hours in a certain date, allow them to send report by selecting necessary fields(client, project, category, hours) and optional
fields(description and overtime). After filling fields, allow the user to save the changes and send report.
User or admin can switch left and right for the previous and next week, to select days in the selected week and to go back to monthly view.







