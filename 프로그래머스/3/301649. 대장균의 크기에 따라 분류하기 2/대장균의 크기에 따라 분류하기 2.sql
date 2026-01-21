WITH x AS(
    SELECT 
        ID,
        SIZE_OF_COLONY,
        ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS RN,
        COUNT(*) OVER () AS total_count
    FROM ECOLI_DATA
)
SELECT x.ID , 
    CASE
        WHEN x.RN<=x.total_count/4 THEN 'CRITICAL'
        WHEN x.RN>x.total_count/4 AND x.RN<=x.total_count/4*2 THEN 'HIGH'
        WHEN x.RN>x.total_count/4*2 AND x.RN<=x.total_count/4*3 THEN 'MEDIUM'
        WHEN x.RN>x.total_count/4*3 AND x.RN<=x.total_count THEN 'LOW'
     END AS COLONY_NAME
FROM x
ORDER BY x.id ASC;