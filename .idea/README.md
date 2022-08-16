# Timesheet

Timesheet zadatak za kandidate

# Project specification

The user logs in using an e-mail address and password, also user should be able to log out from the site.

There are 2 types of users: admin, team leader and worker.

Allow the user to change their password and export their data.

ADMIN ***

Clients:
Allow the admin to have an overview of all clients, to create a new client by entering: client name, address, city,
zip/postal code and country. Admin should be able to change already
created client and to delete them. Admin can filter clients by clicking on the desired initial letter of the project name and to search them by typing their name in
search field.

Projects:
Allow the admin to have an overview of all project, to create a new project by entering: project name, project
description, select client, team leader. Admin should be able to change already created project, including project status(active, inactive, archive) and
to delete them. Admin can filter projects by clicking on the desired initial letter of the project name and to search them by typing name in search field.

Categories:
Allow the admin to have an overview of all categories, to create a new category by entering: category name. Admin should
be able to change already created category and to delete them.
Admin can find categories by clicking on the desired initial letter of the project name and to search them by typing name in search field.

Employees:
Allow the admin to have an overview of all employees, to create an employee by entering: name, username, hours per week,
email, status(active or inactive), role(admin or worker).
Admin should be able to change already created employee including employee status and role, to delete them and to change their password.
Admin doesn't have an option to set the password for new user. He can only enter the e-mail address where the link
will be sent and then the user will be able to set the desired password.


Team leader, worker and ADMIN***
Timesheet:
Allow the team leader,worker or admin to see his own timesheet for month in the table with all days in current month. They can switch between months.
They should be able to see how many hours they worked on which day of the month and see the total number of
working hours for selected month.
When they click on the hours number in a certain date, allow them to send report by selecting necessary fields(
client, project, category, hours) and optional fields(description and overtime). After filling fields, allow them to save the changes and send report.
They can switch left and right for the previous and next week, to select days in the selected week and to go back to monthly view.


Team leader and ADMIN***
Reports:
Allow the admin and team leader to have an overview of all reports and to filter them by: selecting an employee,
client, project and category. Also, to search reports by
quick date by week(this week, next week, last week), quick date by month(this month, next month, last month), start date
and end date.
Admin and team leader should be able to reset all filter options, to search and to search overtime.
When the search is finished, it should display some table with the report data(date, employees, projects, categories,
description and time). Bellow table should be number of all reports found.
After displaying all the requested data, create options for: print report, create pdf and export to excel.







