-- 루시와 엘라 찾기 in
-- https://programmers.co.kr/learn/courses/30/lessons/59046
select animal_id, name, sex_upon_intake
from animal_ins
where name in ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
order by animal_id;

-- 이름에 el이 들어가는 동물 찾기
-- https://programmers.co.kr/learn/courses/30/lessons/59047
select animal_id, name
from animal_ins
where name like '%el%' and animal_type = 'dog'
order by name;
