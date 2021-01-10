create database player_info;

use player_info;

create table team_info
(
team_id int,
team_name varchar(255),
primary key (team_id)
);

create table match_info
(
id int auto_increment,
match_no int,
team_id int,
scores int,
wickets_fallen int,
primary key (id),
foreign key(team_id) references team_info (team_id)
);

create table player_records
(
sl int auto_increment,
p_id int,
p_name varchar(255),
p_role varchar(255),
scores int,
wickets int,
team_id int, 
primary key (sl),
foreign key (team_id) references team_info (team_id)
);

select * from team_info;
select * from match_info;
select * from player_records;

insert into team_info
values(101, "India");
insert into team_info
values(102, "Australia");
insert into team_info
values(103, "England");
insert into team_info
values(104, "New Zealand");
insert into team_info
values(105, "Pakistan");
insert into team_info
values(106, "West Indies");
insert into team_info
values(107, "Sri Lanka");
insert into team_info
values(108, "Bangladesh");

insert into match_info
values(1, 1, 101, "India", 280, 8);
insert into match_info
values(2, 1, 103, "England", 277, 10);
insert into match_info
values(3, 2, 102, "Australia", 310, 8);
insert into match_info
values(4, 2, 104, "New Zealand", 250, 10);
insert into match_info
values(5, 3, 105, "Pakistan", 250, 6);
insert into match_info
values(6, 3, 107, "Sri Lanka", 251, 7);
insert into match_info
values(7, 4, 106, "West Indies", 291, 7);
insert into match_info
values(8, 4, 108, "Bangladesh", 280, 8);
insert into match_info
values(9, 5, 101, "India", 380, 8);
insert into match_info
values(10, 5, 102, "Australia", 334, 10);
insert into match_info
values(11, 6, 103, "England", 313, 5);
insert into match_info
values(12, 6, 104, "New Zealand", 280, 8);

insert into player_records
values(1, 1, "Virat Kohli", "Batsman", 100, 0, 101);
insert into player_records
values(2, 23, "Rohit Sharma", "Batsman", 80, 0, 101);
insert into player_records
values(3, 11, "Jason Roy", "Batsman", 110, 0, 103);
insert into player_records
values(4, 13, "Eon Morgan", "Batsman", 60, 0, 103);
insert into player_records
values(5, 19, "Jasprit Bumrah", "Bowler", 0, 3, 101);
insert into player_records
values(6, 24, "Liam Plunket", "Bowler", 0, 4, 103);
insert into player_records
values(7, 9, "Steve Smith", "Batsman", 111, 1, 102);
insert into player_records
values(8, 18, "David Warner", "Batsman", 70, 0, 102);
insert into player_records
values(9, 1, "Virat Kohli", "Batsman", 100, 0, 101);
insert into player_records
values(10, 9, "Steve Smith", "Batsman", 100, 0, 102);
insert into player_records
values(11, 19, "Jasprit Bumrah", "Bowler", 0, 3, 101);
insert into player_records
values(12, 24, "Liam Plunket", "Bowler", 0, 2, 103);
insert into player_records
values(13, 25, "Pat Cummins", "Bowler", 11, 5, 102);
insert into player_records
values(14, 31, "Trent Boult", "Bowler", 0, 4, 104);
insert into player_records
values(15, 32, "Tim Southee", "Bowler", 28, 3, 104);
insert into player_records
values(16, 50, "T Dilshan", "Batsman", 44, 0, 107);
insert into player_records
values(17, 92, "Babar Azam", "Batsman", 51, 0, 105);

select p_id, p_name, sum(scores), t.team_name from player_records p inner join team_info t on t.team_id=p.team_id group by p_id order by sum(scores) desc limit 5;

select p_id, p_name, sum(wickets), t.team_name from player_records p inner join team_info t on t.team_id=p.team_id group by p_id order by sum(wickets) desc limit 5;

select t.team_id, t.team_name, avg(m.scores) as average from team_info t left join match_info m on t.team_id=m.team_id group by m.team_id;

update player_records set scores = scores+10 where team_id = (select team_id from match_info group by team_id order by avg(scores) limit 1);

DELIMITER $$

drop procedure if exists HighestScore$$
create procedure HighestScore(country VARCHAR(255), OUT highest_score INT)
begin
Select max(scores) into highest_score from match_info where team_name = country;
END$$

DELIMITER ;
CALL HighestScore('India',@highest_score);
SELECT @highest_score;
