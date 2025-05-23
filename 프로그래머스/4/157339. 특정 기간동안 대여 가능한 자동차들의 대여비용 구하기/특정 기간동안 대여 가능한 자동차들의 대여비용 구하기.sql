SELECT A.CAR_ID, A.CAR_TYPE, CAST(A.DAILY_FEE*30*(1-B.DISCOUNT_RATE*0.01)AS SIGNED) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS A JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS B
ON A.CAR_TYPE=B.CAR_TYPE
WHERE A.CAR_ID NOT IN (
    SELECT DISTINCT C.CAR_ID 
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS C 
    WHERE C.START_DATE<='2022-11-30' AND C.END_DATE>='2022-11-01'
)
AND A.CAR_TYPE IN('SUV', '세단')
AND B.DURATION_TYPE = '30일 이상'
AND A.DAILY_FEE*30*(1-B.DISCOUNT_RATE*0.01)>=500000
AND A.DAILY_FEE*30*(1-B.DISCOUNT_RATE*0.01)<=2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC;


    