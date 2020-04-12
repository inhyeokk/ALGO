-- 최댓값 구하기
select max(datetime) as '시간' from animal_ins;

-- 최솟값 구하기
select min(datetime) as '시간' from animal_ins;

-- 동물 수 구하기
select count(*) as count from animal_ins;

-- 중복 제거하기
select count(distinct name) from animal_ins;