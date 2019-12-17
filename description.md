# RESTful CRUD Application
## Description of methods

### How to use this application:

> /panel

All requests start with this line.

> GET /list

Show all users (without roles)

> GET /{id}

Return user by ID (unclude his roles).

> POST /add

Create new user (optionally with roles but not required). Something like this:

> { "name":"userName", "login":"login", "password":"paSSw0rd", "roles:"\[{"id":1}]\}

You can input role ID only. 

> PUT /update{id}

Start editing the selected user and his roles (required). 

> {... "roles:"\[{"id":1, "name:admin"}]\} }

Roles: 1 - admin, 2 - programmer, 3 - user.

> DELETE /delete{id}

Removes the selected user by ID.
