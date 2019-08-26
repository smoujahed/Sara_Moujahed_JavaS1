use spring_security;
insert into users (username, password, enabled) values ('admin', '$2y$12$8BoDh/VbnE26ewLRhVYAju9hrp.W7eEeU/x/rJODlGKZ2kQ6c6kAy', true);    /*adminpass*/
insert into users (username, password, enabled) values ('manager', '$2y$12$/qWpqZ00Pjc9uiFVGoeKBOZY723IxzQE4qP7mZj8bMBIJjb3hEdVK', true);  /*managerpass*/
insert into users (username, password, enabled) values ('team', '$2y$12$kHn3j1tH2jhpjslEbgsYUOEv6cPhIVDeOwyARbJnMx0L6c0Oc6.9O', true);     /*teampass*/
insert into users (username, password, enabled) values ('employee', '$2y$12$zyNe.gAU2c1puxtoQVZ5KeTRbkSEMT0SETt66B8yXBhfYy7jANbRa', true); /*employeepass*/

insert into authorities (username, authority) values ('employee', 'ROLE_EMPLOYEE');
insert into authorities (username, authority) values ('team', 'ROLE_EMPLOYEE');
insert into authorities (username, authority) values ('team', 'ROLE_TEAM');
insert into authorities (username, authority) values ('manager', 'ROLE_EMPLOYEE');
insert into authorities (username, authority) values ('manager', 'ROLE_TEAM');
insert into authorities (username, authority) values ('manager', 'ROLE_MANAGER');
insert into authorities (username, authority) values ('admin', 'ROLE_EMPLOYEE');
insert into authorities (username, authority) values ('admin', 'ROLE_TEAM');
insert into authorities (username, authority) values ('admin', 'ROLE_MANAGER');
insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');
