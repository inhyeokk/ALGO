-- 고양이와 개는 몇 마리 있을까
select animal_type, count(*) as count from animal_ins group by animal_type;

-- 동명 동물 수 찾기
-- https://programmers.co.kr/learn/courses/30/lessons/59041
select name, count(*) as count
from animal_ins
where name is not null
group by name
having count >= 2

-- 입양 시각 구하기(1)
select * 
from (select substring(datetime, 11, 3) as hour, count(*) as count from animal_outs group by(hour)) as a
where hour between 9 and 19;