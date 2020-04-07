CREATE TABLE to_do_list (
"id" SERIAL PRIMARY KEY,
"task" VARCHAR(400) NOT NULL,
"completed" BOOLEAN default FALSE,
"assignedOn" timestamp NOT NULL,
"dueBy" timestamp NOT NULL,
"whenCompleted" timestamp
);