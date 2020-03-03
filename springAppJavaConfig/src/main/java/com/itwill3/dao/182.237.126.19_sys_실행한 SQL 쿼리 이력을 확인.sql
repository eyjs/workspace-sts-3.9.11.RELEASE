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
