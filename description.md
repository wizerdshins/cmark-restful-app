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

Create new user (optionally with roles but not required).

> PUT /update{id}

Start editing the selected user and his roles (required).

> DELETE /delete{id}

Removes the selected user by ID.
