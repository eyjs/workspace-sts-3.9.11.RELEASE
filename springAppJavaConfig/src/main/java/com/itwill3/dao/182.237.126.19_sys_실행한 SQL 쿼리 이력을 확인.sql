SELECT * FROM USER_USERS; 
SELECT USER FROM DUAL;
select * from v$session;
SELECT 
  last_active_time
  ,parsing_schema_name
  ,sql_text 
FROM v$sqlarea
WHERE 
  parsing_schema_name <> 'SYS'
  AND parsing_schema_name <> 'SYSMAN'
  AND parsing_schema_name <> 'DBSNMP'
  AND parsing_schema_name <> 'MDSYS'
  AND parsing_schema_name <> 'EXFSYS'
ORDER BY 
  last_active_time DESC;

desc X$DBGALERTEXT;

select originating_timestamp, message_text ,s.*
from X$DBGALERTEXT s
where originating_timestamp > sysdate - 7;
    
select * from V$SQL
         order by first_load_time desc;    
DESC V$SQL; 
      
      
select T1.hash_value, T1.first_load_time, T1.module, T1.sql_fulltext, T1.last_load_time,T1.*
  from (select *
          from V$SQL
         order by first_load_time desc) T1
 where parsing_schema_name like '%'
   and upper(sql_fulltext) not like upper('%V$SQL%')  --자기자신은 제외
   and sql_fulltext like '%'
 order by last_active_time desc
  