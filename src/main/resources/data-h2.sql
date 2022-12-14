INSERT INTO MEDICATION (ID, NAME, IMAGE, WEIGHT, CODE)
VALUES
(42342342, 'med1', '', 40, '34h3j4ssd'),
(98942382, 'med2', '', 10, 'hc87ayd9sad'),
(25451, 'med3', '', 100, 'dafy9s8df'),
(983943, 'med4', '', 70, '9u89sdyf');

INSERT INTO DRONE (ID, SERIAL_NUMBER, MODEL, WEIGHT_LIMIT, BATTERY_CAPACITY, STATE)
VALUES
(281923, '34UHU2H3', 'LIGHTWEIGHT', 500, 70, 'LOADING'),
(182341, '0S9DAS8D9', 'MIDDLEWEIGHT', 500, 90, 'LOADED'),
(894751, '32J43J20S', 'CRUISERWEIGHT', 500, 100, 'DELIVERING'),
(918232, 'meJ32H4d4', 'HEAVYWEIGHT', 500, 16, 'RETURNING');

 INSERT INTO DRONE_MEDICATION (DRONE_ID , MEDICATIONS_ID)
 VALUES
  (894751,983943),
  (281923,42342342),
  (918232,25451);