-- member_seq가 이미 존재하면 DROP
DROP SEQUENCE IF EXISTS member_seq;

-- member_seq 새로 생성 (1씩 증가)
CREATE SEQUENCE member_seq START WITH 1 INCREMENT BY 1;

-- 혹시 서버 재시작 시 기존 데이터가 있다면 다음 ID로 맞춰줌
ALTER SEQUENCE member_seq RESTART WITH (SELECT COALESCE(MAX(member_id), 0) + 1 FROM member);
