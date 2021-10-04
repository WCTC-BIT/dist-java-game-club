insert into member (member_id, name, email)
values (1, 'Chrisjen Avasarala', 'cavasara@wctc.edu');

insert into member (member_id, name, email)
values (2, 'Naomi Nagata', 'nnagata@wctc.edu');

insert into member (member_id, name, email)
values (3, 'Camina Drummer', 'cdrummer@wctc.edu');

insert into member (member_id, name, email)
values (4, 'Fred Johnson', 'fjohnson@wctc.edu');

insert into member (member_id, name, email)
values (5, 'Alex Kamal', 'akamal@wctc.edu');

insert into member (member_id, name, email)
values (6, 'Amos Burton', 'aburton@wctc.edu');

insert into member (member_id, name, email)
values (7, 'Stacy Read', 'sread@wctc.edu');

insert into member (member_id, name, email)
values (8, 'Hello Kitty', 'hkitty@wctc.edu');

insert into event(event_id, title, event_date, host_id, location, description)
values (1, 'Halloween Werewolf', PARSEDATETIME('31 Oct 2023, 21:00', 'dd MMM yyyy, HH:mm'),
        3, 'Camina''s House: 123 Main St, Waukesha', 'Join us for a night of spooky social deduction.');

insert into event(event_id, title, event_date, host_id, location, description)
values (2, 'First Friday Game Night', PARSEDATETIME('03 Nov 2023, 17:30', 'dd MMM yyyy, HH:mm'),
        1, 'Pewaukee Campus, Room L-164', 'Monthly open game night. Bring your favorites to teach and play.');

insert into event(event_id, title, event_date, host_id, location, description)
values (3, 'First Friday Game Night', PARSEDATETIME('01 Dec 2023, 17:30', 'dd MMM yyyy, HH:mm'),
        1, 'Pewaukee Campus, Room L-164', 'Monthly open game night. Bring your favorites to teach and play.');

insert into event(event_id, title, event_date, host_id, location, description)
values (4, 'Pathfinder Society', PARSEDATETIME('14 Oct 2023, 12:00', 'dd MMM yyyy, HH:mm'),
        5, 'Waukesha Public Library', 'Every other week an amazing Pathfinder Society Adventure. Fun, dice, and friends.');

insert into event(event_id, title, event_date, host_id, location, description)
values (5, 'Pathfinder Society', PARSEDATETIME('28 Oct 2023, 12:00', 'dd MMM yyyy, HH:mm'),
        5, 'Waukesha Public Library', 'Every other week an amazing Pathfinder Society Adventure. Fun, dice, and friends.');

insert into event(event_id, title, event_date, host_id, location, description)
values (6, 'Pathfinder Society', PARSEDATETIME('11 Nov 2023, 12:00', 'dd MMM yyyy, HH:mm'),
        5, 'Waukesha Public Library', 'Every other week an amazing Pathfinder Society Adventure. Fun, dice, and friends.');

insert into event(event_id, title, event_date, host_id, location, description)
values (7, 'Pathfinder Society', PARSEDATETIME('25 Nov 2023, 12:00', 'dd MMM yyyy, HH:mm'),
        5, 'Waukesha Public Library', 'Every other week an amazing Pathfinder Society Adventure. Fun, dice, and friends.');

insert into event(event_id, title, event_date, host_id, location, description)
values (8, 'Friday Night Magic', PARSEDATETIME('20 Oct 2023, 18:30', 'dd MMM yyyy, HH:mm'),
        2, 'Naomi''s House: 900 10th St, Pewaukee', 'Theme: Casual Constructed Peasant');

insert into event(event_id, title, event_date, host_id, location, description)
values (9, 'Friday Night Magic', PARSEDATETIME('17 Nov 2023, 18:30', 'dd MMM yyyy, HH:mm'),
        2, 'Naomi''s House: 900 10th St, Pewaukee', 'Theme: Casual Constructed Singleton');

insert into event(event_id, title, event_date, host_id, location, description)
values (10, 'Friday Night Magic', PARSEDATETIME('15 Dec 2023, 18:30', 'dd MMM yyyy, HH:mm'),
        2, 'Naomi''s House: 900 10th St, Pewaukee', 'Theme: Casual Constructed Singleton');

insert into registration(event_id, member_id)
values (1, 3);
insert into registration(event_id, member_id)
values (1, 4);
insert into registration(event_id, member_id)
values (1, 6);
insert into registration(event_id, member_id)
values (2, 1);
insert into registration(event_id, member_id)
values (2, 2);
insert into registration(event_id, member_id)
values (2, 4);
insert into registration(event_id, member_id)
values (2, 5);
insert into registration(event_id, member_id)
values (2, 6);
insert into registration(event_id, member_id)
values (9, 1);
insert into registration(event_id, member_id)
values (9, 3);
insert into registration(event_id, member_id)
values (9, 4);
