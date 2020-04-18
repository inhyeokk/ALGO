-- 없어진 기록 찾기
select animal_id, name
from animal_outs as o
where (select animal_id from animal_ins where o.animal_id = animal_id) is null;

-- 있었는데요 없었습니다
select i.animal_id, i.name
from animal_ins as i, animal_outs as o
where i.animal_id = o.animal_id and i.datetime > o.datetime
order by i.datetime;

-- 오랜 기간 보호한 동물(1)
select name, datetime
from (select * 
        from animal_ins as i
        where (select animal_id from animal_outs where animal_id = i.animal_id) is null) as ii
order by datetime
limit 3;