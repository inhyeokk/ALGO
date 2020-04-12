-- 모든 레코드 조회하기
select * from animal_ins order by animal_id;

-- 역순 정렬하기
select name, datetime from animal_ins order by animal_id desc;

-- 아픈 동물 찾기
select animal_id, name from animal_ins where intake_condition = 'Sick';

-- 어린 동물 찾기
select animal_id, name from animal_ins where intake_condition != 'Aged';

-- 동물의 아이디와 이름
select animal_id, name from animal_ins order by animal_id;

-- 여러 기준으로 정렬하기 (order by 중첩)
select animal_id, name, datetime from animal_ins order by name, datetime desc;

-- 상위 n개 레코드
select name from animal_ins where datetime = (select min(datetime) from animal_ins);