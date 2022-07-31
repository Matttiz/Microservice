CREATE TYPE "season_status" AS ENUM (
  'summer',
  'winter'
);

CREATE TABLE "bus_stop" (
  "id" SERIAL PRIMARY KEY,
  "name" varchar NOT NULL,
  "number" int NOT NULL,
  UNIQUE ("name", "number")
);

CREATE TABLE "line" (
  "id" SERIAL PRIMARY KEY,
  "line" int NOT NULL,
  "start_line" int,
  "end_line" int,
  UNIQUE ("line", "start_line", "end_line")
);

CREATE TABLE "place" (
  "id" SERIAL PRIMARY KEY,
  "bus_stop_id" int,
  "latitude" float8,
  "longitude" float8,
  UNIQUE("bus_stop_id"),
  UNIQUE("latitude", "longitude")
);

CREATE TABLE "full_line" (
  "id" SERIAL PRIMARY KEY,
  "line_id" int,
  "bus_stop_id" int,
  "bus_stop_line_number" int NOT NULL,
  UNIQUE("line_id", "bus_stop_id", "bus_stop_line_number")
);

CREATE TABLE "service" (
  "id" SERIAL PRIMARY KEY,
  "service_number" int NOT NULL,
  "full_line_id" int,
  UNIQUE("service_number", "full_line_id")
);

CREATE TABLE "schedule" (
  "id" SERIAL PRIMARY KEY,
  "service_number" int,
  "time" varchar NOT NULL,
  "is_holiday" boolean NOT NULL,
  "bus_stop_id" int,
  "on_demand" boolean NOT NULL,
  "season" season_status DEFAULT 'summer'
);

ALTER TABLE "line" ADD FOREIGN KEY ("start_line") REFERENCES "bus_stop" ("id");
ALTER TABLE "line" ADD FOREIGN KEY ("end_line") REFERENCES "bus_stop" ("id");
ALTER TABLE "place" ADD FOREIGN KEY ("bus_stop_id") REFERENCES "bus_stop" ("id");
ALTER TABLE "full_line" ADD FOREIGN KEY ("line_id") REFERENCES "line" ("id");
ALTER TABLE "full_line" ADD FOREIGN KEY ("bus_stop_id") REFERENCES "bus_stop" ("id");
ALTER TABLE "service" ADD FOREIGN KEY ("full_line_id") REFERENCES "full_line" ("id");
ALTER TABLE "schedule" ADD FOREIGN KEY ("service_number") REFERENCES "service" ("id");
ALTER TABLE "schedule" ADD FOREIGN KEY ("bus_stop_id") REFERENCES "bus_stop" ("id");
