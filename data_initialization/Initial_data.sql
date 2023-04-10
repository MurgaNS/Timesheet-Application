INSERT INTO category (`id`, `name`) VALUES ('1', 'category1name');
INSERT INTO country (`id`, `country_code`, `name`) VALUES ('1', '+381', 'Srbija');
INSERT INTO client (`id`, `name`, `address`, `city`, `postal_code`, `country_id`) VALUES ('1', 'client name', 'client adress', 'Belgrade', '11000', '1');
INSERT INTO employee (`id`, `name`, `username`, `password`, `hours_per_week`, `email`, `status`, `role`) VALUES ('1', 'john', 'john_username', 'test123', '40', 'john@gmail.com', 'active', 'worker');
INSERT INTO employee (`id`, `name`, `username`, `password`, `hours_per_week`, `email`, `status`, `role`) VALUES ('2', 'jane', 'jane_username', 'test123', '40', 'jane@gmail.com', 'active', 'worker');
INSERT INTO project (`id`, `name`, `description`, `client_id`, `status`) VALUES ('1', 'Project1', 'Desc project1', '1', 'active');
INSERT INTO work_log (`id`, `date`, `client_id`, `project_id`, `category_id`, `description`, `hours`, `overtime`) VALUES ('1', '2022-06-06', '1', '1', '1', 'worklog descr', '7', '1');
INSERT INTO project_employee (`project_id`, `employee_id`) VALUES ('1', '1');
INSERT INTO lead_employee(`project_id`, `employee_id`) VALUES ('1', '2');