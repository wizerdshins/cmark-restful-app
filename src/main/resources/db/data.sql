
create table if not exists roles
(
	id bigint not null
		constraint roles_pkey
			primary key,
	name varchar(255)
)
;

create table if not exists users
(
	id bigint not null
		constraint users_pkey
			primary key,
	login varchar(255),
	name varchar(255),
	password varchar(255)
)
;

create table if not exists user_roles
(
	user_id bigint not null
		constraint fkhfh9dx7w3ubf1co1vdev94g3f
			references users,
	role_id bigint not null
		constraint fkh8ciramu9cc9q3qcqiv4ue8a6
			references roles,
	constraint user_roles_pkey
		primary key (user_id, role_id)
)
;