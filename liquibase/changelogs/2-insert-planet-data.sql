--liquibase formatted sql

--changeset Mihaly Verhas:2
INSERT INTO planets (id, name, type, mass, radius, rotation_period, orbit_period, apoapsis, periapsis, parent) VALUES (1, 'Sol-A (G2-V)', 'STAR', 0, 5, 0, 0, 0, 0, NULL);
INSERT INTO planets (id, name, type, mass, radius, rotation_period, orbit_period, apoapsis, periapsis, parent) VALUES (2, 'Mercury', 'PLANET', 0, 2440, 0, 87.96, 0.466, 0.307, 1);
INSERT INTO planets (id, name, type, mass, radius, rotation_period, orbit_period, apoapsis, periapsis, parent) VALUES (3, 'Venus', 'PLANET', 0, 6051, 0, 224.70, 0.718, 0.728, 1);
INSERT INTO planets (id, name, type, mass, radius, rotation_period, orbit_period, apoapsis, periapsis, parent) VALUES (4, 'Earth', 'PLANET', 0, 6371, 0, 365.0, 1.017, 0.983, 1);
INSERT INTO planets (id, name, type, mass, radius, rotation_period, orbit_period, apoapsis, periapsis, parent) VALUES (5, 'Mars', 'PLANET', 0, 3889, 0, 686.97, 1.666, 1.382, 1);
INSERT INTO planets (id, name, type, mass, radius, rotation_period, orbit_period, apoapsis, periapsis, parent) VALUES (6, 'Jupiter', 'PLANET', 0, 69911, 0, 4332.59, 5.4588, 4.9501, 1);
INSERT INTO planets (id, name, type, mass, radius, rotation_period, orbit_period, apoapsis, periapsis, parent) VALUES (7, 'Saturn', 'PLANET', 0, 58232, 0, 10759.22, 9.041, 10.123, 1);
INSERT INTO planets (id, name, type, mass, radius, rotation_period, orbit_period, apoapsis, periapsis, parent) VALUES (8, 'Uranus', 'PLANET', 0, 25362, 0, 30688.5, 18.33, 20.11, 1);
INSERT INTO planets (id, name, type, mass, radius, rotation_period, orbit_period, apoapsis, periapsis, parent) VALUES (9, 'Neptune', 'PLANET', 0, 24622, 0, 60182, 29.81, 30.33, 1);
